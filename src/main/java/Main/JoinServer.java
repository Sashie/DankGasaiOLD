package Main;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.Server;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.entities.message.MessageBuilder;
import de.btobastian.javacord.listener.message.MessageCreateListener;

import java.util.concurrent.ExecutionException;

/**
 * Created by matthew on 4/18/2016.
 */
public class JoinServer implements MessageCreateListener {
    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if (message.getContent().startsWith(Settings.getCommandStart())) {
            String[] args = message.getContent().split(" ");
            MessageBuilder builder = new MessageBuilder();
            args[0] = args[0].replaceFirst(Settings.getCommandStart(), "");
            if (args[0].equalsIgnoreCase("joinserver")) {
                message.delete();
                    String msg = message.getContent();
                    String invite = msg.replace(Settings.getCommandStart() + "joinserver ", "");
                    Server server = null;
                    try {
                        server = discordAPI.parseInvite(invite).get().acceptInvite().get();
                    } catch (InterruptedException | ExecutionException e) {
                        if (discordAPI.getServers().contains(server)) {
                            message.reply(Settings.getMsgStart() + "Joining server from invite " + invite);
                            message.reply(Settings.getMsgStart() + "Found server from invte " + invite + "..." + server.getName());
                        } else {
                            builder = new MessageBuilder();
                            builder.append(Settings.getMsgStart() + "Could not join server from invite " + invite);
                            message.reply(builder.build());
                        }
                        return;

                    }
                    return;
                }
            }
        }
    }
