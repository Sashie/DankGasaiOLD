package Main.Searches;

import Main.Main;
import Main.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.User;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.entities.message.MessageBuilder;
import de.btobastian.javacord.listener.message.MessageCreateListener;

public class SKU implements MessageCreateListener{
    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if(message.getContent().startsWith(Settings.getCommandStart())){
            String[] args = message.getContent().split(" ");
            args[0] = args[0].replaceFirst(Settings.getCommandStart(), "");
            MessageBuilder builder;
            if(args[0].equalsIgnoreCase("sku")) {
                if (message.getAuthor() != discordAPI.getYourself()) {
                    if (args.length > 3) {
                        if (args[1].equals("forums")) {
                            if (message.getMentions().size() > 0) {
                                message.delete();
                                String question = "";
                                User u = message.getMentions().get(0);
                                args[1] = "";
                                args[2] = "";
                                for (String s : args) {
                                    if (s != "") {
                                        question = question + s + "+";
                                        question = question.replaceAll("sku", "");
                                    }
                                }
                                String rawr = question.substring(0, question.length()-1) +"";
                                String url = "https://forums.skunity.com/search?q=" + rawr;
                                builder = new MessageBuilder();
                                builder.append("» ").appendUser(u).append("! ").appendUser(message.getAuthor()).append(" thinks yo dumb azz might need this!").appendNewLine().append(url);
                                message.reply(builder.build());

                            } else {
                                message.delete();
                                MessageBuilder builder0 = new MessageBuilder();
                                builder0.append("__***ERROR!***__ **Please use the following syntax!**").appendNewLine();
                                builder0.append("```xml").appendNewLine();
                                builder0.append(" -sku < forums > < person > < what to search for on the SKU docs > ").appendNewLine();
                                builder0.append("< EXAMPLE: -sku forums @iblitzkriegi RAWR RAWR >").appendNewLine();
                                builder0.append("```").appendNewLine();
                                builder0.append("__***NOTE***__ ** Please note that this is a example, so replace the @iblitzkriegi with a user on your server!**");
                                message.getAuthor().sendMessage(builder0.build());
                            }
                        } else if (args[1].equalsIgnoreCase("docs")) {
                            if (args[1].equalsIgnoreCase("docs")) {
                                if (message.getMentions().size() > 0) {
                                    message.delete();
                                    String question = "";
                                    User u = message.getMentions().get(0);
                                    args[1] = "";
                                    args[2] = "";
                                    for (String s : args) {
                                        if (s != "") {
                                            question = question + s + "+";
                                            question = question.replaceAll("sku", "");
                                        }
                                    }
                                    String rawr = question.substring(0, question.length()-1) +"";
                                    String url = "https://skunity.com/search?search=" + rawr;
                                    builder = new MessageBuilder();
                                    builder.append(Settings.getMsgStart()).appendUser(u).append("! ").appendUser(message.getAuthor()).append(" thinks this might help!").appendNewLine().append(url);
                                    message.reply(builder.build());

                                } else {
                                    message.delete();
                                    MessageBuilder builder1 = new MessageBuilder();
                                    builder1.append("__***ERROR!***__ **Please use the following syntax!**").appendNewLine();
                                    builder1.append("```xml").appendNewLine();
                                    builder1.append(" /!sku < docs > < person > < what to search for on the SKU docs > ").appendNewLine();
                                    builder1.append("< EXAMPLE: /!sku docs @iblitzkriegi RAWR RAWR >").appendNewLine();
                                    builder1.append("```").appendNewLine();
                                    builder1.append("__***NOTE***__ ** Please note that this is a example, so replace the @iblitzkriegi with a user on your server!***");
                                    message.getAuthor().sendMessage(builder1.build());
                                }
                            }
                        }
                    } else {
                        message.delete();
                        MessageBuilder builder2 = new MessageBuilder();
                        builder2.append("__***ERROR!***__ **Please use the following syntax!**").appendNewLine();
                        builder2.append("```xml").appendNewLine();
                        builder2.append(" /!sku < docs > < person > < what to search for on the SKU docs > ").appendNewLine();
                        builder2.append("< EXAMPLE: /!sku docs @iblitzkriegi RAWR RAWR >").appendNewLine();
                        builder2.append("```").appendNewLine();
                        builder2.append("__***NOTE***__ ** Please note that this is a example, so replace the @iblitzkriegi with a user on your server!***");
                        message.getAuthor().sendMessage(builder2.build());
                    }
                }
            }
        }
    }

}

