package Main.MiscCommands;

import Main.Main;
import Main.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.entities.message.MessageBuilder;
import de.btobastian.javacord.listener.message.MessageCreateListener;

import java.util.Random;

/**
 * Created by matthew on 4/12/2016.
 */
public class Decide implements MessageCreateListener {
    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if(message.getContent().startsWith(Settings.getCommandStart())){
            String[] args = message.getContent().split(" ");
            args[0] = args[0].replaceFirst(Settings.getCommandStart(), "");
            Main.adminLogChannel.sendMessage(message.getAuthor().getName() + "(" + message.getChannelReceiver().getServer().getName() + ")" + "[" + message.getChannelReceiver().getName() + "]> " + message.getContent() );
            if(args[0].equalsIgnoreCase("decide")){
                message.delete();
                if(args.length >= 3) {
                    if (args[2].equalsIgnoreCase("or")) {
                        String firsthalf = args[1];
                        String secondhalf = args[3];
                        Random rand = new Random();
                        int randomNum = rand.nextInt(1 + 1) + 1;
                        switch (randomNum) {
                            case 1:
                                message.reply(Settings.getMsgStart() + "I'd say you should go with " + firsthalf);
                                break;
                            case 2:
                                message.reply(Settings.getMsgStart() + "Go with " + secondhalf);
                                break;
                        }
                    }
                }else{
                    MessageBuilder builder = new MessageBuilder();
                    builder.append(Settings.getMsgStart() + "__***ERROR!***__ **Please use the following syntax!**").appendNewLine();
                    builder.append("```").appendNewLine();
                    builder.append(Settings.getMsgStart() + " /!decide < this > < or > < this > ").appendNewLine();
                    builder.append(Settings.getMsgStart() + "< EXAMPLE: /!decide this or that >").appendNewLine();
                    builder.append("```").appendNewLine();
                    builder.append(Settings.getMsgStart() + "__***NOTE***__ **This example will randomly pick either the first or second word after the word or!**");
                    message.getAuthor().sendMessage(builder.build());

                }
            }
        }
    }
}
