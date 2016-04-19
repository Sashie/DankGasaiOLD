package Main.MiscCommands;

import Main.Memes.NewMemes;
import Main.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.User;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.entities.message.MessageBuilder;
import de.btobastian.javacord.listener.message.MessageCreateListener;

/**
 * Created by matthew on 4/15/2016.
 */
public class Getinfo implements MessageCreateListener {
    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if (message.getContent().startsWith(Settings.getCommandStart())) {
            String[] args = message.getContent().split(" ");
            args[0] = args[0].replaceFirst(Settings.getCommandStart(), "");
            if (args[0].equalsIgnoreCase("getinfo")) {
                message.delete();
                if(message.getMentions().size() == 1){

                    User u = message.getMentions().get(0);
                    User s = message.getAuthor();

                    message.reply("I have sent you that users information, " + message.getAuthor().getMentionTag() + " ya lil stalker.");
                    MessageBuilder builder = new MessageBuilder();
                    builder.append("```xml").appendNewLine();
                    builder.append(Settings.getMsgStart() + "<Name> = < " + u.getName() + " >").appendNewLine();
                    builder.append(Settings.getMsgStart() + "<FriendID> = < " + u.getDiscriminator() + " >").appendNewLine();
                    builder.append(Settings.getMsgStart() + "<ID> = < " + u.getId() + " >").appendNewLine();
                    if(u.getGame() == null){
                        builder.append(Settings.getMsgStart() + "<CurrentlyPlaying> = < " + "none" + " >").appendNewLine();
                        builder.append(Settings.getMsgStart() + "<AvatarURL> = < " + u.getAvatarUrl() + " >").appendNewLine();
                        builder.append("```");
                        s.sendMessage(builder.build());
                    }else {
                        builder.append(Settings.getMsgStart() + "<CurrentlyPlaying> = < " + u.getGame() + " >").appendNewLine();
                        builder.append(Settings.getMsgStart() + "<AvatarURL> = < " + u.getAvatarUrl() + " >").appendNewLine();
                        builder.append("```");
                        s.sendMessage(builder.build());
                    }
                }
            }
        }
    }
}