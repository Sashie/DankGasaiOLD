package Main.MiscCommands;

import Main.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.User;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;


public class ddos implements MessageCreateListener{


    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if(message.getContent().startsWith(Settings.getCommandStart())){
            String[] args = message.getContent().split(" ");
            args[0] = args[0].replaceFirst(Settings.getCommandStart(), "");
            if(args[0].equalsIgnoreCase("ddos")){
                if (message.getMentions().get(0) != null) {
                    User u = message.getMentions().get(0);
                    message.delete();
                    message.reply(Settings.getMsgStart() + args[1] + "! You are getting DDOSed by " + message.getAuthor().getMentionTag() + ", .. Prob cause ur bad kid.");
                }else{
                    message.reply(Settings.getMsgStart() + args[0] + " Is kewl");
                }
            }
        }
    }
}
