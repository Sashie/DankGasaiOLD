package Main.MiscCommands;

import Main.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;

/**
 * Created by matthew on 4/20/2016.
 */
public class bothelp implements MessageCreateListener {
    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if(message.getContent().startsWith(Settings.getCommandStart())){
            String[] args = message.getContent().split(" ");
            args[0] = args[0].replaceFirst(Settings.getCommandStart(), "");
            if(args[0].equalsIgnoreCase("bhelp")) {
                message.delete();
                if(args.length < 2){
                    message.getAuthor().sendMessage("Please specify a bot! The options are: GasaiD, Gasai, BooBot, Ducky");
                }
                if(args.length > 1 || args.length < 3){
                    if(args[1].equalsIgnoreCase("GasaiD")){
                        message.reply("To use Dank Gasai you must type -help in the chat!");
                    }else if(args[1].equalsIgnoreCase("Gasai")){
                        message.reply("To use Gasai you must type /!help in the chat!");
                    }else if(args[1].equalsIgnoreCase("BooBot")){
                        message.reply("To use BooBot you must type ~help in the chat!");
                    }else if(args[1].equalsIgnoreCase("Ducky")){
                        message.reply("To use Ducky you must type /help in the chat!");
                    }
                }
            }
        }
    }
}
