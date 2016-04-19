package Main.Memes;

import Main.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.User;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.entities.message.MessageBuilder;
import de.btobastian.javacord.listener.message.MessageCreateListener;

/**
 * Created by matthew on 4/10/2016.
 */
public class Juststop implements MessageCreateListener{
    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if(message.getContent().startsWith(Settings.getCommandStart())){
            String[] args = message.getContent().split(" ");
            args[0] = args[0].replaceFirst(Settings.getCommandStart(), "");
            if(args[0].equalsIgnoreCase("juststop")){
                if(message.getMentions().size() > 0) {
                    if(args.length == 2) {
                        User u = message.getMentions().get(0);
                        message.delete();
                        MessageBuilder builder = new MessageBuilder();
                        builder.append(Settings.getMsgStart() + args[1] + ", " + message.getAuthor().getMentionTag() + " thinks it's time to stop.");
                        message.reply(builder.build());
                        message.replyFile(NewMemes.imageCache.get("juststop"));
                    }else{
                        message.delete();
                        message.getAuthor().sendMessage("You must specify a user. EXAMPLE: /!juststop @iBlitzkriegi");
                    }
                }else{
                    message.delete();
                    message.getAuthor().sendMessage("You must specify a user!");
                }

            }

        }
    }
}
