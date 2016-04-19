package Main.Moderation;

import Main.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.User;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;

import java.util.ArrayList;

/**
 * Created by matthew on 4/15/2016.
 */

public class Mute implements MessageCreateListener {
    public static ArrayList<String> test = new ArrayList();
    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        String[] args = message.getContent().split(" ");
        args[0] = args[0].replaceFirst(Settings.getCommandStart(), "");
        if(test.contains(message.getAuthor().getId())){
            if(args.length > 0) {
                message.delete();
                message.getAuthor().sendMessage("fagg");
            }
        }else{
        if(message.getContent().startsWith(Settings.getCommandStart())){
            if(args[0].equalsIgnoreCase("mute")) {
                if (message.getMentions().size() == 1) {
                    if (test.contains(message.getAuthor().getId())) {
                        test.remove(message.getMentions().get(0).getId());
                        message.reply("unmuted");
                        message.reply(message.getMentions().get(0).getId());

                    } else {
                        test.add(message.getMentions().get(0).getId());
                        message.reply("muted");
                    }
                 }
              }
            }
        }
    }
}
