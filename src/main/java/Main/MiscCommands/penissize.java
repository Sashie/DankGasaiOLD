package Main.MiscCommands;

import Main.Main;
import Main.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by matthew on 4/10/2016.
 */
public class penissize implements MessageCreateListener {
    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if (message.getContent().startsWith(Settings.getCommandStart())) {
            String[] args = message.getContent().split(" ");
            args[0] = args[0].replaceFirst(Settings.getCommandStart(), "");
            if (args[0].equalsIgnoreCase("penis")) {
                if(message.getAuthor() != discordAPI.getYourself()) {
                    // Add something dumb here \\
                    Main.adminLogChannel.sendMessage(message.getAuthor().getName() + "(" + message.getChannelReceiver().getServer().getName() + ")" + "[" + message.getChannelReceiver().getName() + "]> " + message.getContent());
                    if (message.getMentions().size() > 0) {
                        message.delete();
                        Random rand = new Random();
                        int randomNum = rand.nextInt(1 + 14) + 1;
                        String str = new String(new char[randomNum]).replace("\0", "=");
                        message.reply(Settings.getMsgStart() + args[1] + "'s penis size is " + "8" + str + "D");
                    }
                }
            }
        }
    }
}
