package Main.Memes;

import Main.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;

import java.util.Random;

/**
 * Created by matthew on 4/14/2016.
 */
public class RandomMemes implements MessageCreateListener {
    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if(message.getContent().startsWith(Settings.getCommandStart())){
            String[] args = message.getContent().split(" ");
            args[0] = args[0].replaceFirst(Settings.getCommandStart(), "");
            if(args[0].equalsIgnoreCase("randommeme")){
                Random rand = new Random();
                int randomNum = rand.nextInt(1 + 4) + 1;
                message.reply(Settings.getMsgStart() + "Here is a random meme just for you, " + message.getAuthor().getMentionTag());
                message.delete();
                switch(randomNum){
                    case 1:
                        message.replyFile(NewMemes.imageCache.get("nomom"));
                        break;
                    case 2:
                        message.replyFile(NewMemes.imageCache.get("bachelors"));
                        break;
                    case 3:
                        message.replyFile(NewMemes.imageCache.get("christians"));
                        break;
                    case 4:
                        message.reply(NewMemes.gifCache.get("dinnertime"));
                        break;
                    case 5:
                        message.replyFile(NewMemes.imageCache.get("legitme"));
                        break;

                }

            }
        }
    }
}
