package Main.Memes;

import Main.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.entities.message.MessageBuilder;
import de.btobastian.javacord.listener.message.MessageCreateListener;

/**
 * Created by matthew on 4/10/2016.
 */
public class Triggered implements MessageCreateListener{
    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if(message.getContent().startsWith(Settings.getCommandStart())){
            String[] args = message.getContent().split(" ");
            args[0] = args[0].replaceFirst(Settings.getCommandStart(), "");
            if(args[0].equalsIgnoreCase("triggered")){
                message.delete();
                MessageBuilder builder = new MessageBuilder();
                builder.append(Settings.getMsgStart() + message.getAuthor().getMentionTag() + " is triggered!").appendNewLine();
                message.reply(builder.build());
                message.replyFile(NewMemes.imageCache.get("triggered"));


            }
        }

    }
}
