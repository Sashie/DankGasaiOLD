package Main.Memes;

import Main.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.Channel;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;

/**
 * Created by matthew on 4/18/2016.
 */
public class Banter implements MessageCreateListener {
    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if (message.getContent().startsWith(Settings.getCommandStart())) {
            String[] args = message.getContent().split(" ");
            args[0] = args[0].replaceFirst(Settings.getCommandStart(), "");
            if (args[0].equalsIgnoreCase("banter")) {
                Channel c = message.getChannelReceiver();
                c.sendFile(NewMemes.imageCache.get("banter"), Settings.getMsgStart() +  message.getAuthor().getMentionTag() + " is loving this banter!");
            }
        }
    }
}
