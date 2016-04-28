package Main.Moderation;

import Main.Main;
import Main.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;

/**
 * Created by matthew on 4/19/2016.
 */
public class Shutdown implements MessageCreateListener {
    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if(message.getContent().startsWith(Settings.getCommandStart())){
            String[] args = message.getContent().split(" ");
            args[0] = args[0].replaceFirst(Settings.getCommandStart(), "");
            if(args[0].equalsIgnoreCase("shutdown")){
                if(message.getAuthor().getId().equals("98208218022428672")){
                    message.delete();
                    Main.delayForFiveSeconds();
                    message.reply("If.....If you say so master..");
                    Main.delayForFiveSeconds();
                    Main.adminLogChannel.sendMessage("Dank Gasai shutting down :L");
                    Main.delayForFiveSeconds();
                    System.exit(0);
                }
            }
        }
    }
}
