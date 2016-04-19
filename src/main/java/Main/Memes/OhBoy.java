package Main.Memes;

import Main.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.entities.message.MessageBuilder;
import de.btobastian.javacord.listener.message.MessageCreateListener;

/**
 * Created by matthew on 4/19/2016.
 */
public class OhBoy implements MessageCreateListener {
    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if (message.getContent().startsWith(Settings.getCommandStart())) {
            String[] args = message.getContent().split(" ");
            args[0] = args[0].replaceFirst(Settings.getCommandStart(), "");
            if (args[0].equalsIgnoreCase("ohboy")) {
                MessageBuilder builder = new MessageBuilder();
                builder.append("Oh boy, " + message.getAuthor().getMentionTag()).appendNewLine().append(NewMemes.gifCache.get("ohboy"));
                message.reply(builder.build());

            }
        }
    }
}