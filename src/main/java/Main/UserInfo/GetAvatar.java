package Main.UserInfo;

import Main.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.User;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;

/**
 * Created by matthew on 4/16/2016.
 */
public class GetAvatar implements MessageCreateListener {
    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if(message.getContent().startsWith(Settings.getCommandStart())){
            String[] args = message.getContent().split(" ");
            args[0] = args[0].replaceFirst(Settings.getCommandStart(), "");
            if(args[0].equalsIgnoreCase("getavatar")){
                message.delete();
                if(message.getMentions().size() == 1){
                    User u = message.getMentions().get(0);
                    message.reply(u.getName() + "'s current avatar is: " + u.getAvatarUrl());
                }
            }
        }
    }
}
