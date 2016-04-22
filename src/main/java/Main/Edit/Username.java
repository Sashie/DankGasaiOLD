package Main.Edit;

import Main.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;

/**
 * Created by matthew on 4/20/2016.
 */
public class Username implements MessageCreateListener {
    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if(message.getContent().startsWith(Settings.getCommandStart())){
            String[] args = message.getContent().split(" ");
            args[0] = args[0].replaceFirst(Settings.getCommandStart(), "");
            if(args[0].equalsIgnoreCase("setusername")){
                message.delete();
                if(args.length == 2){
                    message.reply(args[1] + "" + args[2]);
                    discordAPI.updateUsername(args[1] + "" + args[2]);
                }else if(args.length < 2){
                    discordAPI.updateUsername(args[1]);
                }


            }
        }
    }
}
