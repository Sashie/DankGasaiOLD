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
//import space.gatt.JavacordCommander.JavacordCommander;

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

    private static boolean running = false;

    public static long startupTime;

    public static void main(String[] args) {

        if(args.length != 1){
            System.out.println("Must enter a token");
            System.exit(0);
        }
        dankemail = args[0];
        // Connection to Discord chat bot account \\

        delayForFiveSeconds();
        final DiscordAPI api = Javacord.getApi(dankemail, true);
        delayForFiveSeconds();
//        JavacordCommander jcc = new JavacordCommander(api);
        delayForFiveSeconds();
//        jcc.enableSnooper("Main");
        delayForFiveSeconds();
        api.connectBlocking();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        api.registerListener(new MessageCreateListener() {
            @Override
            public void onMessageCreate(DiscordAPI discordAPI, Message message) {
                if(message.getContent().startsWith(Settings.getCommandStart())){
                    adminLogChannel.sendMessage(message.getAuthor().getName() + "(" + message.getChannelReceiver().getServer().getName() + ")" + "[" + message.getChannelReceiver().getName() + "]" + ">" + message.getContent());
                }
                if (message.getContent().startsWith(Settings.getCommandStart() + "snatch")) {
                    message.delete();
                    if (message.getMentions().size() == 1) {
                        copyAvatar(message.getMentions().get(0));
                        message.reply(message.getMentions().get(0).getMentionTag() + "'s profile picture is now my profile picture.");
                    }
                } else if (message.isPrivateMessage() && (message.getAuthor() != discordAPI.getYourself())) {
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

                    Random random = new Random();
                    String reply = replies.get(random.nextInt(replies.size()));
                    message.reply(reply);
                }
            }

            public void copyAvatar(User user) {
                try {
                    BufferedImage avatar = user.getAvatar().get();
                    Exception ex = api.updateAvatar(avatar).get();
                    if (ex != null) {
                        ex.printStackTrace();
                        ;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

            }
        });


        for (Server s : api.getServers()) {
            System.out.println("Server = " + s.getName());
            if (s.getName().equalsIgnoreCase("DankGasai Logchannel")) {
                for (Channel c : s.getChannels()) {
                    if (c.getName().equalsIgnoreCase("logchannel")) {
                        adminLogChannel = c;
                        c.sendMessage("Dank Gasai has been enabled!");

                    }
                }
                break;
            }
        }

//        space.gatt.JavacordCommander.Settings.setMsgStarter(Settings.getMsgStart());
//        space.gatt.JavacordCommander.Settings.setCommandStarter(Settings.getCommandStart());
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
        commands.add("< version > - Find my current version :)");
        commands.add("< flip [|heads|tails] > - Flip a coin and hope for the best!");
        commands.add("- <Moderation>  -");
        commands.add("<kick> - Kick a specific user for a one worded reason! (One word says it all)");
        commands.add("<username> - Set the bots username WIP");
        commands.add("<shutdown> - Shuts the bot down, wont work for now.");
        commands.add("<joinserver> - Have GasaiD join a server with a invite! -joinserver <invite url>");
        commands.add("<leaveserver> - Have Gasai leave the server you're in.");

        // Registers so bot starts up right away \\
        api.registerListener(new Banter());
        api.registerListener(new Shocked());
        api.registerListener(new GetAvatar());
        api.registerListener(new Hitler());
        api.registerListener(new Rawr());
        api.registerListener(new XP());
        api.registerListener(new Juststop());
        api.registerListener(new Getinfo());
        api.registerListener(new Salty());
        api.registerListener(new Flip());
        api.registerListener(new penissize());
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
        api.registerListener(new Botinfo());
        api.registerListener(new OhBoy());
        api.registerListener(new Help());
        api.registerListener(new NewMemes());
        NewMemes newmemes = new NewMemes();
        newmemes.cacheImages();
        api.registerListener(newmemes);

        // System startup feedback \\
        System.out.println("Successfully logged in!");
        System.out.println("Setting game to: " + Settings.getGame());
        api.setGame(Settings.getGame());
        api.updateUsername("Dank Gasai");
        System.out.println("-= Parsing all current classes to Main class =-");
        // Counting up classes \\
        classes.add("Main");
        System.out.println("Main class loaded!");
        delayForFiveSeconds();
        classes.add("Hitler");
        System.out.println("Hitler.java successfully registered!");
        classes.add("lowhale");
        delayForFiveSeconds();
        System.out.println("lowhale.java successfully registered!");
        classes.add("ohwhale");
        delayForFiveSeconds();
        System.out.println("OhWhale.java successfully registered!");
        classes.add("triggered");
        delayForFiveSeconds();
        System.out.println("Triggered.java successfully registered!");
        classes.add("PMR");
        delayForFiveSeconds();
        System.out.println("PMR.java successfully registered!");
        classes.add("mentions");
        delayForFiveSeconds();
        System.out.println("mentions.java successfully registered!");
        classes.add("kicking");
        delayForFiveSeconds();
        System.out.println("kicking.java successfully registered!");
        classes.add("settings");
        delayForFiveSeconds();
        System.out.println("Settings.java successfully registered!");
        classes.add("botinfo");
        delayForFiveSeconds();
        System.out.println("Botinfo.java successfully registered!");
        classes.add("help");
        delayForFiveSeconds();
        System.out.println("Help.java successfully registered!");
        classes.add("uptime");
        delayForFiveSeconds();
        System.out.println("Uptime.java successfully registered!");
        classes.add("Clearchat");
        delayForFiveSeconds();
        System.out.println("Clearchat.java successfully registered!");
        classes.add("Roll");
        delayForFiveSeconds();
        System.out.println("roll.java successfully registered");
        classes.add("ddos");
        delayForFiveSeconds();
        System.out.println("ddos.java successfully registered!");
        classes.add("version");
        delayForFiveSeconds();
        System.out.println("version.java successfully registered!");
        classes.add("sku");
        delayForFiveSeconds();
        System.out.println("SKU.java successfully registered");
        classes.add("google");
        delayForFiveSeconds();
        System.out.println("Google.java successfully registered!");
        classes.add("onevone");
        delayForFiveSeconds();
        System.out.println("onevone.java successfully registered!");
        classes.add("RandomMemes");
        delayForFiveSeconds();
        System.out.println("RandomMemes.java successfully registered");
        classes.add("penissize");
        delayForFiveSeconds();
        System.out.println("penissize.java has successfully registered!");
        classes.add("version");
        delayForFiveSeconds();
        System.out.println("version.java successfully registered!");
        classes.add("flip");
        delayForFiveSeconds();
        System.out.println("flip.java successfully registered!");
        classes.add("salty");
        delayForFiveSeconds();
        System.out.println("Salty.java successfully registered!");
        classes.add("NewMemes");
        delayForFiveSeconds();
        System.out.println("NewMemes.java successfully registered!");
        classes.add("Getinfo");
        delayForFiveSeconds();
        System.out.println("Getinfo.java successfully registered!");
        classes.add("Juststop");
        delayForFiveSeconds();
        System.out.println("Juststop.java has been successfully registered!");
        classes.add("xp");
        delayForFiveSeconds();
        System.out.println("xp.java successfully registered!");
        classes.add("Mute");
        delayForFiveSeconds();
        System.out.println("mute.java successfully registered!");
        classes.add("Rawr");
        delayForFiveSeconds();
        System.out.println("rawr.java successfully registered!");
        classes.add("getavatar");
        delayForFiveSeconds();
        System.out.println("getavatar.java successfully registered!");
        commands.add("youtube");
        delayForFiveSeconds();
        System.out.println("youtube.java successfully registered!");
        classes.add("shocked");
        delayForFiveSeconds();
        System.out.println("shocked.java successfully registered!");
        classes.add("banter");
        delayForFiveSeconds();
        System.out.println("banter.java successfully registered!");
        classes.add("facepalm");
        delayForFiveSeconds();
        System.out.println("facepalm.java successfully registered!");
        classes.add("questionmark");
        System.out.println("questionmark.java successfully registered!");
        classes.add("username");
        delayForFiveSeconds();
        System.out.println("username.java successfully registered!");
        classes.add("game");
        delayForFiveSeconds();
        System.out.println("game.java successfully registered!");
        classes.add("joinserver");
        delayForFiveSeconds();
        System.out.println("joinserver.java successfully registered!");
        classes.add("game");
        delayForFiveSeconds();
        System.out.println("game.java successfully registered!");
        classes.add("shutdown");
        delayForFiveSeconds();
        System.out.println("shutdown.java successfully registered!");
        classes.add("bye");
        delayForFiveSeconds();
        System.out.println("bye.java successfully registered!");
        delayForFiveSeconds();
        System.out.println("Counting up classes.");
        delayForFiveSeconds();
        System.out.println("There were " + classes.size() + " classes found!");
        delayForFiveSeconds();
        System.out.println("Counting up commands.");
        delayForFiveSeconds();
        System.out.println("There were " + commands.size() + " commands found!");
        delayForFiveSeconds();
        System.out.println("Memebot has successfully be started! Type -help in a server with me to begin!");


    }
    public static void delayForFiveSeconds(){

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}