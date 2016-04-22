package Main.ImportantCommands;

import Main.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.entities.message.MessageBuilder;
import de.btobastian.javacord.listener.message.MessageCreateListener;

import java.util.ArrayList;


public class Botinfo implements MessageCreateListener {
    public static ArrayList<String> botinfo = new ArrayList();
    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if(message.getContent().startsWith(Settings.getCommandStart())){
            String[] args = message.getContent().split(" ");
            args[0] = args[0].replaceFirst(Settings.getCommandStart(), "");
            if(args[0].equalsIgnoreCase("botinfo")){
                message.delete();
                MessageBuilder builder = new MessageBuilder();
                builder.append("```xml").appendNewLine().appendNewLine();
                builder.append(Settings.getMsgStart() + "Current name is: < " + discordAPI.getYourself().getName() + " >").appendNewLine();
                builder.append(Settings.getMsgStart() + "Favorite song is: < Afrojack - Ten Feet Tall (Lyric Video) ft. Wrabel >").appendNewLine();
                builder.append(Settings.getMsgStart() + "Current game is < " + Settings.getGame() + " >").appendNewLine();
                builder.append(Settings.getMsgStart() + "Current version: < " + Settings.getVersion() + " >").appendNewLine();
                builder.append(Settings.getMsgStart() + "Favorite song is: < Afrojack - Ten Feet Tall (Lyric Video) ft. Wrabel >").appendNewLine();
                builder.append(Settings.getMsgStart() + "Developed in < Javacord >").appendNewLine();
                builder.append(Settings.getMsgStart() + "Author is: < iBlitzkriegi >").appendNewLine();
                builder.append(Settings.getMsgStart() + "Servers joined < " + discordAPI.getServers().size() + " >").appendNewLine();
                builder.append(Settings.getMsgStart() + "Current profile pic: < " + discordAPI.getYourself().getAvatarUrl() + " >").appendNewLine();
                builder.append("```");
                message.reply(Settings.getMsgStart() + "I have PM'd you my info, " + message.getAuthor().getMentionTag());
                message.getAuthor().sendMessage(builder.build());

            }
        }
    }
}
