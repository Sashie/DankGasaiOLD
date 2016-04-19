package Main.MiscCommands;

import Main.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.entities.message.MessageBuilder;
import de.btobastian.javacord.listener.message.MessageCreateListener;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by matthew on 4/10/2016.
 */
public class onevone implements MessageCreateListener{
    @Override
    //private ArrayList<Player> sc = new ArrayList<Player>();
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if(message.getContent().startsWith(Settings.getCommandStart())){
            String[] args = message.getContent().split(" ");
            args[0] = args[0].replaceFirst(Settings.getCommandStart(), "");
            if(args[0].equalsIgnoreCase("1v1")){
                if(message.getMentions().size() > 0){
                    message.delete();
                    String firsthalf = message.getAuthor().getMentionTag();
                    String secondhalf = args[1];
                    Random rand = new Random();
                    int randomNum = rand.nextInt(0 + 2) +1;
                    MessageBuilder builder = new MessageBuilder();
                    switch(randomNum){
                        case 1:
                            builder.append(Settings.getMsgStart() + firsthalf + " went up against  " + secondhalf + " in a 1v1!").appendNewLine();
                            builder.append(Settings.getMsgStart() + "And the winner was... " + firsthalf);
                            message.reply(builder.build());
                            break;
                        case 2:
                            builder.append(firsthalf + " went up against  " + secondhalf + " in a 1v1!").appendNewLine();
                            builder.append(Settings.getMsgStart() + "And the winner was... " + secondhalf);
                            message.reply(builder.build());
                            break;
                    }
                }else{
                    message.delete();
                    message.getAuthor().sendMessage(Settings.getMsgStart() + "ERROR! Incorrect usage! Please specify a user!");
                }
            }
        }
    }
}
