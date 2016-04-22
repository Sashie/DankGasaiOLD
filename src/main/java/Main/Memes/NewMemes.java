package Main.Memes;

import Main.Main;
import Main.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.entities.message.MessageBuilder;
import de.btobastian.javacord.listener.message.MessageCreateListener;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by matthew on 4/13/2016.
 */
public class NewMemes implements MessageCreateListener{
    public static HashMap<String, File> imageCache = new HashMap<>();
    public static HashMap<String, String> gifCache = new HashMap<>();
    public synchronized void cacheImage(String url, String extension, String name){
        try {
            if (extension.equalsIgnoreCase("gif")){
                gifCache.put(name, url);
                return;
            }
            File imgf = new File(name + "." + extension);
            BufferedImage img = ImageIO.read(new URL(url));
            ImageIO.write(img, extension, imgf);
            imageCache.put(name, imgf);

        }catch (IOException e){
            MessageBuilder builder = new MessageBuilder();
            builder.append("(OH NO! SOMETHING HAPPENED. PRINTING STACK TRACE!)").appendNewLine().append("```" + e.getLocalizedMessage() + "```");
            Main.adminLogChannel.sendMessage(builder.build());
        }
    }
    public synchronized void cacheImages(){
        cacheImage("http://i.imgur.com/urSk0Ki.jpg", "jpg", "ohwhale");
        cacheImage("http://i.imgur.com/dAQFYXR.jpg", "jpg", "hitler");
        cacheImage("http://i.imgur.com/Mdx02ZD.jpg", "jpg", "juststop");
        cacheImage("http://i.imgur.com/tNFu7ny.jpg", "jpg", "lowhale");
        cacheImage("http://i.imgur.com/5v0zNLz.png", "png", "triggered");
        cacheImage("http://i.imgur.com/7B0LOwo.jpg", "jpg", "salty");
        cacheImage("http://i.imgur.com/ir9djYo.jpg", "jpg", "banter");
        cacheImage("http://i.imgur.com/oI2zYZq.png", "png", "facepalm");
        cacheImage("http://i.imgur.com/Kr1FTJ6.jpg", "jpg", "questionmark");
        cacheImage("http://i.imgur.com/uQvNaYi.jpg", "jpg", "bye");

        // Random memes \\
        cacheImage("http://i.imgur.com/zvbc5Fx.jpg", "jpg", "christians");
        cacheImage("http://i.imgur.com/ukKUzHv.jpg", "jpg", "bachelors");
        cacheImage("http://i.imgur.com/UYdYElM.jpg", "jpg", "nomom");
        cacheImage("http://i.imgur.com/bbJEJeB.png", "png", "legitme");
        cacheImage("http://i.imgur.com/8DkYqX7.gif", "gif", "ohboy");

        // Gifs \\
        cacheImage("http://bit.ly/22xKWHr", "gif", "dinnertime");
        cacheImage("http://imgur.com/LVuY8k9", "gif", "shocked");

    }



    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
    }
}
