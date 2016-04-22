package Main.Searches;

import Main.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.User;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.entities.message.MessageBuilder;
import de.btobastian.javacord.listener.message.MessageCreateListener;

/**
 * Created by matthew on 4/18/2016.
 */
public class Youtube implements MessageCreateListener {
    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if(message.getContent().startsWith(Settings.getCommandStart())) {
            if (message.getAuthor() != discordAPI.getYourself()) {
                String[] args = message.getContent().split(" ");
                args[0] = args[0].replaceFirst(Settings.getCommandStart(), "");
                if (args[0].equalsIgnoreCase("youtube")) {
                    if (message.getMentions().size() == 1) {
                        message.delete();
                        String question = "";
                        User u = message.getMentions().get(0);
                        args[0] = "";
                        args[1] = "";
                        for (String s : args) {
                            if (s != "") {
                                question = question + s + "%20";
                            }
                        }
                        String rawr = question.substring(0, question.length() - 3) + "";
                        String url = "https://www.youtube.com/results?search_query=" + rawr;
                        MessageBuilder builder = new MessageBuilder();
                        builder.append(Settings.getMsgStart()).appendUser(u).append("! ").appendUser(message.getAuthor()).append(" thinks yo dumb ass might need this!").appendNewLine().append(url);
                        message.reply(builder.build());
                    } else {
                        message.delete();
                        MessageBuilder builder0 = new MessageBuilder();
                        builder0.append("__***ERROR!***__ **Please use the following syntax!**").appendNewLine();
                        builder0.append("```xml").appendNewLine();
                        builder0.append(" -youtube < person > < what to search youtube for > ").appendNewLine();
                        builder0.append("< EXAMPLE: -youtube @iblitzkriegi RAWR RAWR >").appendNewLine();
                        builder0.append("```").appendNewLine();
                        builder0.append("__***NOTE***__ ** Please note that this is a example, so replace the @iblitzkriegi with a user on your server!**");
                    }
                }
            }
        }
    }
}
