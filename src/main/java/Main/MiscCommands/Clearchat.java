package Main.MiscCommands;

import Main.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.entities.message.MessageBuilder;
import de.btobastian.javacord.listener.message.MessageCreateListener;

/**
 * Created by matthew on 4/9/2016.
 */

public class Clearchat implements MessageCreateListener {
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if(message.getContent().startsWith(Settings.getCommandStart())){
            String[] args = message.getContent().split(" ");
            args[0] = args[0].replaceFirst(Settings.getCommandStart(), "");
            if(args[0].equalsIgnoreCase("clearchat")){
                message.delete();
                MessageBuilder builder = new MessageBuilder();
                builder.append("").appendNewLine().append("").appendNewLine().append("").appendNewLine().append("").appendNewLine().append("").appendNewLine().append("").appendNewLine().append("").appendNewLine().append("").appendNewLine().append("").appendNewLine().append("").appendNewLine().append("").appendNewLine().append("").appendNewLine().append("").appendNewLine().append("").appendNewLine().append("");
                message.reply(builder.build());

            }
        }
    }
}
