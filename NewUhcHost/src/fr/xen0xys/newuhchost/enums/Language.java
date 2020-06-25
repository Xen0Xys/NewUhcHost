package fr.xen0xys.newuhchost.enums;

import fr.xen0xys.newuhchost.Utils;

public enum Language {

    HOST(Utils.getTranslationString("host")),
    GAMEMODE_CHOICE(Utils.getTranslationString("gamemode_choice")),
    CREATE_HOST(Utils.getTranslationString("create_host"));

    private final String text;

    Language(String text){
        this.text = text;
    }

    public String getText(){
        return this.text;
    }
}
