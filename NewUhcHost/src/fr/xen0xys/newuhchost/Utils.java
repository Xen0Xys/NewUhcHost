package fr.xen0xys.newuhchost;

public class Utils {
    public static String getTranslationString(String value){
        TranslateLoader handler = new TranslateLoader(NewUhcHost.getInstance()); // 'this' must be replaced with a JavaPlugin reference when used from any other classes.
        return handler.getCaption(value);
    }
}
