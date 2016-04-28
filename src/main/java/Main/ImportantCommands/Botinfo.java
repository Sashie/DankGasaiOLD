package Main.ImportantCommands;

import Main.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.entities.message.MessageBuilder;
import de.btobastian.javacord.listener.message.MessageCreateListener;

public class Botinfo implements MessageCreateListener{
    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if (message.getContent().startsWith(Settings.getCommandStart())) {
            String[] args = message.getContent().split(" ");
            args[0] = args[0].replaceFirst(Settings.getCommandStart(), "");
            if (args[0].equalsIgnoreCase("botinfo")) {
                message.delete();
                MessageBuilder builder = new MessageBuilder();
                builder.append("```xml").appendNewLine().appendNewLine();
                builder.append(Settings.getMsgStart() + "Current name is: < " + discordAPI.getYourself().getName() + " >").appendNewLine();
                builder.append(Settings.getMsgStart() + "Favorite song is: < Afrojack - Ten Feet Tall (Lyric Video) ft. Wrabel >").appendNewLine();
                builder.append(Settings.getMsgStart() + "Current game is < " + Settings.getGame() + " >").appendNewLine();
                builder.append(Settings.getMsgStart() + "Current version: < " + Settings.getVersion() + " >").appendNewLine();
                builder.append(Settings.getMsgStart() + "Developed in < Javacord >").appendNewLine();
                builder.append(Settings.getMsgStart() + "Author is: < iBlitzkriegi >").appendNewLine();
                builder.append(Settings.getMsgStart() + "Servers joined < " + discordAPI.getServers().size() + " >").appendNewLine();
                builder.append(Settings.getMsgStart() + "Current profile pic: < " + discordAPI.getYourself().getAvatarUrl() + " >").appendNewLine();
                builder.append(Settings.getMsgStart() + "Website < http://bit.ly/1NK0wZJ > (Created by @Gatt)").appendNewLine();
                builder.append(Settings.getMsgStart() + "Github < http://bit.ly/1WkXbXC >").appendNewLine();
                builder.append(Settings.getMsgStart() + "My server: < https://discord.gg/0wbasQaCb35XuhlN >").appendNewLine();
                builder.append("~~~~Links and images will now load below this line~~~~").appendNewLine();
                builder.append("```");
                message.reply(Settings.getMsgStart() + "I have PM'd you my info, " + message.getAuthor().getMentionTag());
                message.getAuthor().sendMessage(builder.build());
            }
        }
    }
}
