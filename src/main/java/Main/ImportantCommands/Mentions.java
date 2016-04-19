package Main.ImportantCommands;

import Main.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.User;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;

import java.util.ArrayList;

/**
 * Created by matthew on 4/11/2016.
 */
public class Mentions implements MessageCreateListener {
    public static ArrayList<String> rawr = new ArrayList();
// Complete recode done here \\
    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if(message.getContent().startsWith(Settings.getCommandStart())){
            String[] args = message.getContent().split(" ");
            args[0] = args[0].replaceFirst(Settings.getCommandStart(), "");
            if(args[0].equalsIgnoreCase("mentions")){
                if(args[1].equalsIgnoreCase("on")){
                    if(rawr.contains(message.getAuthor().getMentionTag())){
                        message.reply(Settings.getMsgStart() + "You are already getting a PM for every message I see that mention you, " + message.getAuthor().getMentionTag() + "!");


                    }else{
                        message.delete();
                        message.reply(Settings.getMsgStart() + "For now on when I see a message that mentions you I will PM you that message if you are offline, " + message.getAuthor().getMentionTag());
                        rawr.add(message.getAuthor().getMentionTag());
                    }
                }else if(args[1].equalsIgnoreCase("off")){
                    if(rawr.contains(message.getAuthor().getMentionTag())){
                        rawr.remove(message.getAuthor().getMentionTag());
                        message.delete();
                        message.reply(Settings.getMsgStart() + "I will no longer mention you when I see a message about you, " + message.getAuthor().getMentionTag());
                    }else{
                        message.reply(Settings.getMsgStart() + "You already have PM for Mentions set to off, " + message.getAuthor().getMentionTag());
                    }
                }
            }
        }else{
            String u = message.getMentions().get(0).getMentionTag();
            User t = message.getMentions().get(0);
            if(message.getMentions().size() > 0){
                if(message.getAuthor() != discordAPI.getYourself()){
                    if(rawr.contains(u)){
                        t.sendMessage(Settings.getMsgStart() + message.getAuthor().getName() + " tagged you in " + message.getChannelReceiver().getServer().getName() + " and said: " + message.getContent());
                    }
                }
            }
        }
    }
}