package Main.MiscCommands;

import Main.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;

import java.util.Random;

/**
 * Created by matthew on 4/12/2016.
 */
public class Flip implements MessageCreateListener {
    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if(message.getAuthor() != discordAPI.getYourself()){
            if(message.getContent().startsWith(Settings.getCommandStart())){
                String[] args = message.getContent().split(" ");
                args[0] = args[0].replaceFirst(Settings.getCommandStart(), "");
                if(args[0].equalsIgnoreCase("flip")){
                    if(args.length == 2){
                        if(args[1].equalsIgnoreCase("tails")){
                            message.delete();
                            Random rand = new Random();
                            int randomNum = rand.nextInt(1 + 1) + 1;
                            switch(randomNum){
                                case 1:
                                    message.reply(Settings.getMsgStart() + message.getAuthor().getMentionTag() + " has flipped a coin and bets tails will win! But the coin landed on heads! You suck " + message.getAuthor().getMentionTag());
                                    break;
                                case 2:
                                    message.reply(Settings.getMsgStart() + message.getAuthor().getMentionTag() + " has flipped a coin and bets tails will win! And he was right! The coin has landed on tails! Good job, " + message.getAuthor().getMentionTag());
                                    break;
                            }
                        }else if(args[1].equalsIgnoreCase("heads")){
                            message.delete();
                            Random rand = new Random();
                            int randomNum = rand.nextInt(1 + 1) + 1;
                            switch(randomNum){
                                case 1:
                                    message.reply(Settings.getMsgStart() + message.getAuthor().getMentionTag() + " has flipped a coin and bets heads will win! But the coin landed on tails! You suck " + message.getAuthor().getMentionTag());
                                    break;
                                case 2:
                                    message.reply(Settings.getMsgStart() + message.getAuthor().getMentionTag() + " has flipped a coin and bets heads will win! And he was right! The coin has landed on heads! Good job, " + message.getAuthor().getMentionTag());
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }
}
