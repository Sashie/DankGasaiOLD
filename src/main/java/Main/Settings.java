package Main;

/**
 * Created by matthew on 4/10/2016.
 */
public class Settings {

    private static Settings sts = new Settings();

    private static String commandStart = "-";
    private static String msgStart = "~ ";
    private static String game = "with myself.";
    private static String version = "Alpha 0.2.3";

    public static String getGame()
    {
        return game;
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
