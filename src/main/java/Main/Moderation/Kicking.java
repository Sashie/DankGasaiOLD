package Main.Moderation;

import Main.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.User;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;

/**
 * Created by matthew on 4/14/2016.
 */
public class Kicking implements MessageCreateListener {
    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if(message.getContent().startsWith(Settings.getCommandStart())){
            String[] args = message.getContent().split(" ");
            args[0] = args[0].replace(Settings.getCommandStart(), "");
            if(args[0].equalsIgnoreCase("kick")){
                message.delete();
                if(args.length == 3){
                    if(message.getMentions().size() == 1){
                        message.getMentions().get(0).sendMessage("You have been kicked by " + message.getAuthor().getName() + " from " + message.getChannelReceiver().getServer().getName() + " for: " + args[2]);
                        message.getChannelReceiver().getServer().kickUser(message.getMentions().get(0).getId());
                        message.reply(message.getMentions().get(0).getName() +  " has been kicked for " + args[2]);
                    }else{
                        message.getAuthor().sendMessage("You must specify a user!");
                    }
                }else{
                    message.getAuthor().sendMessage("You must specify a user and a reason! ");
                }
            }
        }
    }
}
