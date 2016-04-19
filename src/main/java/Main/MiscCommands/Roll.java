package Main.MiscCommands;

import Main.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;

import java.util.Random;

/**
 * Created by matthew on 4/12/2016.
 */
public class Roll implements MessageCreateListener {
    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if(message.getAuthor() != discordAPI.getYourself()){
            if(message.getContent().startsWith(Settings.getCommandStart())){
                String[] args = message.getContent().split(" ");
                args[0] = args[0].replaceFirst(Settings.getCommandStart(), "");
                if(args[0].equalsIgnoreCase("roll")){
                    if(args.length == 1){
                        message.delete();
                        Random rand = new Random();
                        int randomNum = rand.nextInt(1 + 99) + 1;
                        message.reply(Settings.getMsgStart() + message.getAuthor().getMentionTag() +  ", went for a roll and got " + randomNum);
                    }
                }
            }
        }
    }
}
