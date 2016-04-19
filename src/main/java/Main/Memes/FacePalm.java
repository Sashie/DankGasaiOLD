package Main.Memes;

import Main.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.entities.message.MessageBuilder;
import de.btobastian.javacord.listener.message.MessageCreateListener;

/**
 * Created by matthew on 4/18/2016.
 */
public class FacePalm implements MessageCreateListener {
    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if(message.getContent().startsWith(Settings.getCommandStart())){
            String[] args = message.getContent().split(" ");
            args[0] = args[0].replaceFirst(Settings.getCommandStart(), "");
            if(args[0].equalsIgnoreCase("facepalm")){
                message.delete();
                MessageBuilder builder = new MessageBuilder();
                if(message.getMentions().size() == 1){
                    builder.append(message.getMentions().get(0).getMentionTag() + " stop! You are making " + message.getAuthor().getMentionTag() + " facepalm!").appendNewLine();
                    message.reply(builder.build());
                    message.replyFile(NewMemes.imageCache.get("facepalm"));
                }else{
                    message.delete();
                    MessageBuilder builder0 = new MessageBuilder();
                    builder0.append("__***ERROR!***__ **Please use the following syntax!**").appendNewLine();
                    builder0.append("```xml").appendNewLine();
                    builder0.append(" -facepalm < person >").appendNewLine();
                    builder0.append("< EXAMPLE: -facepalm @iblitzkriegi >").appendNewLine();
                    builder0.append("```").appendNewLine();
                    builder0.append("__***NOTE***__ ** Please note that this is a example, so replace the @iblitzkriegi with a user on your server!**");
                    message.getAuthor().sendMessage(builder.build());
                }
            }
        }
    }
}
