package Main;

import Main.Edit.Game;
import Main.Edit.Username;
import Main.ImportantCommands.*;
import Main.Memes.*;
import Main.MiscCommands.*;
import Main.Moderation.JoinServer;
import Main.Moderation.Kicking;
import Main.Moderation.Shutdown;
import Main.Searches.Google;
import Main.Searches.SKU;
import Main.Searches.Youtube;
import Main.UserInfo.GetAvatar;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.Javacord;
import de.btobastian.javacord.entities.Channel;
import de.btobastian.javacord.entities.Server;
import de.btobastian.javacord.entities.User;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class Main {
    public static ArrayList<String> commands = new ArrayList();
    public static ArrayList<String> classes = new ArrayList();
    public static Channel adminLogChannel;

    public static String dankemail, dankpassword;


    public static long startupTime;

    public static void main(String[] args) {
        if(args.length != 2){
            System.out.println("Must use username and password");
            System.exit(0);
        }
        // Connection to Discord chat bot account \\
        dankemail = args[0];
        dankpassword = args[1];
        final DiscordAPI api = Javacord.getApi(dankemail, dankpassword);
        api.connectBlocking();
        api.registerListener(new MessageCreateListener() {
            @Override
            public void onMessageCreate(DiscordAPI discordAPI, Message message) {
                if(message.getContent().startsWith(Settings.getCommandStart() + "snatch")){
                    message.delete();
                    if(message.getMentions().size() == 1){
                        copyAvatar(message.getMentions().get(0));
                        message.reply(message.getMentions().get(0).getMentionTag() + "'s profile picture is now my profile picture.");
                    }
                }else if(message.isPrivateMessage() && (message.getAuthor() != discordAPI.getYourself())){
                    List<String> replies = new ArrayList<>();
                    replies.add("You are dumb kid");
                    replies.add("I know you are but what am I!");
                    replies.add("Could you restate the question please?");
                    replies.add("Hmmm, Have we met before?");
                    replies.add("That's what your mom said last night");
                    replies.add("Oh yeah. Well you're a poopy pants");
                    replies.add("Kys, I mean.... Clean your shoes..");
                    replies.add("R000000D");
                    replies.add("I don't understand");

                    String reply = "";
                    Random random = new Random();
                    reply = replies.get(random.nextInt(replies.size()));
                    message.reply(reply);
                }
            }
            public void copyAvatar(User user){
                try{
                    BufferedImage avatar = user.getAvatar().get();
                    Exception ex = api.updateAvatar(avatar).get();
                    if(ex != null){
                        ex.printStackTrace();;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

            }
        });


        for (Server s : api.getServers()){
            System.out.println("Server = " + s.getName());
            if (s.getName().equalsIgnoreCase("DankGasai Logchannel")){
                for (Channel c : s.getChannels()){
                    if (c.getName().equalsIgnoreCase("logchannel")){
                        adminLogChannel = c;
                        c.sendMessage("Dank Gasai has been enabled!");

                    }
                }
                break;
            }
        }

        Date date = new Date();
        startupTime = date.getTime();
        // Memes \\
        commands.add("~ <Memes> ~");
        commands.add(" <hitler> - Doctors hate him!");
        commands.add("<triggered> - Triggered!");
        commands.add("<ohwhale> - Oh whale!");
        commands.add("<lowhale> - L0WHALE");
        commands.add("<salty> - Tell someone they are salty asf. Specify a user!");
        commands.add("<juststop> - Just stop, tell someone their stupidity is hurting. SPECIFY A USER IN COMMAND");
        commands.add("<banter> - Oh how you love your banter");
        commands.add("<ohboy> - Oh boy..");
        commands.add("<shocked> - Woah..That did not just happen!");
        commands.add("<facepalm> - Specify a user to facepalm over..");
        commands.add("<bye> - Cya!");
        commands.add("<???> - ???");
        commands.add("<randommeme> - Get a random meme from my memebank!");
        // Commands \\
        commands.add("~ < Misc-Commands > ~");
        commands.add("< help >  - Seriously??");
        commands.add("< ddos > - ddos some kid");
        commands.add("< clear chat > - Clear chat! WIP");
        commands.add("< botinfo > - Get the bots info..Stalker..");
        commands.add(" < shutdown > - Blitz only kthnx ");
        commands.add("< lmgtfy > - Google something for someone that doesn't know how to.");
        commands.add("< roll > - Roll a random number between 1 and 100");
        commands.add("< sku |docs|forums| [user] (Thing to search > - Search the SKU forums for a answer");
        commands.add("< youtube [user] (What to search) > - Search youtube");
        commands.add("< mentions [|on|off] - Toggle PMS for messages! Resets on restart! >");
        commands.add("< 1v1 > - Go against another user! ");
        commands.add("< uptime > - See how long I've been awake.");
        commands.add("< penis > - Find the penis size of a user");
        commands.add("< decide > - Have memebot pick between two words!");
        commands.add("< version > - Find my current version :)");
        commands.add("< flip [|heads|tails] > - Flip a coin and hope for the best!");
        commands.add("- <Moderation>  -");
        commands.add("<kick> - Kick a specific user for a one worded reason! (One word says it all)");
        commands.add("<username> - Set the bots username WIP");
        commands.add("<shutdown> - Shuts the bot down, wont work for now.");
        commands.add("<joinserver> - Have GasaiD join a server with a invite! -joinserver <invite url>");
        commands.add("<leaveserver> - Have Gasai leave the server you're in.");
//        commands.add("<game> - Set the game Gasai is playing. WIP");

        // System startup feedback \\

        System.out.println("Loading settings for Memebot version " + Settings.getVersion());
        System.out.println("Successfully logged in!");
        System.out.println("Setting game to: " +  Settings.getGame());
        api.setGame(Settings.getGame());
        api.updateUsername("Dank Gasai");
        System.out.println("-= Parsing all current classes to Main class =-");
        // Counting up classes \\
        classes.add("Main");
        System.out.println("Main class loaded!");
        classes.add("Hitler");
        System.out.println("Hitler.java successfully registered!");
        classes.add("lowhale");
        System.out.println("lowhale.java successfully registered!");
        classes.add("ohwhale");
        System.out.println("OhWhale.java successfully registered!");
        classes.add("triggered");
        System.out.println("Triggered.java successfully registered!");
        classes.add("PMR");
        System.out.println("PMR.java successfully registered!");
        classes.add("mentions");
        System.out.println("mentions.java successfully registered!");
        classes.add("kicking");
        System.out.println("kicking.java successfully registered!");
        classes.add("settings");
        System.out.println("Settings.java successfully registered!");
        classes.add("botinfo");
        System.out.println("Botinfo.java successfully registered!");
        classes.add("help");
        System.out.println("Help.java successfully registered!");
        classes.add("uptime");
        System.out.println("Uptime.java successfully registered!");
        classes.add("Clearchat");
        System.out.println("Clearchat.java successfully registered!");
        classes.add("Roll");
        System.out.println("roll.java successfully registered");
        classes.add("ddos");
        System.out.println("ddos.java successfully registered!");
        classes.add("version");
        System.out.println("version.java successfully registered!");
        classes.add("sku");
        System.out.println("SKU.java successfully registered");
        classes.add("google");
        System.out.println("Google.java successfully registered!");
        classes.add("onevone");
        System.out.println("onevone.java successfully registered!");
        classes.add("RandomMemes");
        System.out.println("RandomMemes.java successfully registered");
        classes.add("penissize");
        System.out.println("penissize.java has successfully registered!");
        classes.add("decide");
        System.out.println("decide.java successfully registered!");
        classes.add("version");
        System.out.println("version.java successfully registered!");
        classes.add("flip");
        System.out.println("flip.java successfully registered!");
        classes.add("salty");
        System.out.println("Salty.java successfully registered!");
        classes.add("NewMemes");
        System.out.println("NewMemes.java successfully registered!");
        classes.add("Getinfo");
        System.out.println("Getinfo.java successfully registered!");
        classes.add("Juststop");
        System.out.println("Juststop.java has been successfully registered!");
        classes.add("xp");
        System.out.println("xp.java successfully registered!");
        classes.add("Mute");
        System.out.println("mute.java successfully registered!");
        classes.add("Rawr");
        System.out.println("rawr.java successfully registered!");
        classes.add("getavatar");
        System.out.println("getavatar.java successfully registered!");
        commands.add("youtube");
        System.out.println("youtube.java successfully registered!");
        classes.add("shocked");
        System.out.println("shocked.java successfully registered!");
        classes.add("banter");
        System.out.println("banter.java successfully registered!");
        classes.add("facepalm");
        System.out.println("facepalm.java successfully registered!");
        classes.add("questionmark");
        System.out.println("questionmark.java successfully registered!");
        classes.add("username");
        System.out.println("username.java successfully registered!");
        classes.add("game");
        System.out.println("game.java successfully registered!");
        classes.add("joinserver");
        System.out.println("joinserver.java successfully registered!");
        classes.add("game");
        System.out.println("game.java successfully registered!");
        classes.add("shutdown");
        System.out.println("shutdown.java successfully registered!");
        classes.add("bye");
        System.out.println("bye.java successfully registered!");
        System.out.println("getavatar.java successfully registered!");
        System.out.println("Successfully parsed all classes, " + classes.size() + " were found!");
        System.out.println("Counting up commands.");
        System.out.println("There were " + commands.size() + " commands found!");
        System.out.println("Memebot has successfully be started! Type -help in a server with me to begin!");
        api.registerListener(new Banter());
        api.registerListener(new Shocked());
        api.registerListener(new GetAvatar());
        api.registerListener(new Hitler());
        api.registerListener(new Rawr());
        api.registerListener(new XP());
        api.registerListener(new Juststop());
        api.registerListener(new Getinfo());
        api.registerListener(new NewMemes());
        NewMemes newmemes = new NewMemes();
        newmemes.cacheImages();
        api.registerListener(newmemes);
        api.registerListener(new Salty());
        api.registerListener(new Flip());
        api.registerListener(new penissize());
        api.registerListener(new Decide());
        api.registerListener(new RandomMemes());
        api.registerListener(new onevone());
        api.registerListener(new Google());
        api.registerListener(new lowhale());
        api.registerListener(new SKU());
        api.registerListener(new Version());
        api.registerListener(new ddos());
        api.registerListener(new Roll());
        api.registerListener(new Clearchat());
        api.registerListener(new Uptime());
        api.registerListener(new Youtube());
        api.registerListener(new OhWhale());
        api.registerListener(new Triggered());
        api.registerListener(new Help());
        api.registerListener(new Botinfo());
        api.registerListener(new Kicking());
        api.registerListener(new Mentions());
        api.registerListener(new FacePalm());
        api.registerListener(new JoinServer());
        api.registerListener(new Shutdown());
        api.registerListener(new Username());
        api.registerListener(new Game());
        api.registerListener(new questionmark());
        api.registerListener(new Bye());
        api.registerListener(new bothelp());
        api.registerListener(new OhBoy());

    }

}

