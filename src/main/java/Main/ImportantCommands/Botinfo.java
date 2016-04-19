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
                botinfo.add(Settings.getMsgStart() + "My current name is: < " + discordAPI.getYourself().getName() + " >");
                botinfo.add(Settings.getMsgStart() + "My current game is < " + Settings.getGame() + " >");
                botinfo.add(Settings.getMsgStart() + "My current version: < " + Settings.getVersion() + " >");
                botinfo.add(Settings.getMsgStart() + "My current profile pic: < " + discordAPI.getYourself().getAvatarUrl() + " >");
                botinfo.add(Settings.getMsgStart() + "My favorite song is: < Afrojack - Ten Feet Tall (Lyric Video) ft. Wrabel >");
                message.delete();
                MessageBuilder builder = new MessageBuilder();
                message.reply(Settings.getMsgStart() + "I have PM'd you my info, " + message.getAuthor().getMentionTag());
                builder = new MessageBuilder();
                builder.append("```xml").appendNewLine();
                for(String command : botinfo){
                    builder.append(Settings.getMsgStart() + command).appendNewLine();
                }
                builder.append("```");
                message.getAuthor().sendMessage(builder.build());

            }
        }
    }
}
