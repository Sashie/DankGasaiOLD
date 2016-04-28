package Main.ImportantCommands;

import Main.Main;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.entities.message.MessageBuilder;
import Main.Settings;
import de.btobastian.javacord.listener.message.MessageCreateListener;

public class Help implements MessageCreateListener{

    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if (message.getContent().startsWith(Settings.getCommandStart())) {
            String[] args = message.getContent().split(" ");
            args[0] = args[0].replaceFirst(Settings.getCommandStart(), "");
            if (args[0].equalsIgnoreCase("help")) {
                message.delete();
                MessageBuilder builder = new MessageBuilder();
                message.reply(Settings.getMsgStart() + " I've PM'd you my command list, " + message.getAuthor().getMentionTag());
                builder.append("```xml").appendNewLine();
                for (String command : Main.commands) {
                    builder.append(Settings.getMsgStart() + command).appendNewLine();
                }
                builder.append("```");
                message.getAuthor().sendMessage(builder.build());
            }
        }
    }
}