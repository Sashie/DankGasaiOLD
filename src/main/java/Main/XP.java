package Main;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;

import java.util.HashMap;


public class XP implements MessageCreateListener {
    HashMap xpHash = new HashMap<>();
    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        // COMING SOON \\
    }
}
