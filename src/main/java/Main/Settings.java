package Main;

/**
 * Created by matthew on 4/10/2016.
 */
public class Settings {

    private static Settings sts = new Settings();

    private static String commandStart = "-";
    private static String msgStart = "~ ";
    private static String email = "##";
    private static String password = "";
    private static String game = "with urmom.com";
    private static String version = "Alpha 0.1.8";

    public static String getGame()
    {
        return game;
    }

    public static String getEmail()
    {
        return email;
    }

    public static String getPassword(){

        return password;
    }

    public static String getCommandStart()
    {
        return commandStart;
    }

    public static String getMsgStart(){

        return msgStart;
    }

    public static String getVersion(){

        return version;
    }


}
