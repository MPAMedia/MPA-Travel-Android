package com.mpa.android.nefertari;

public class Uts {

    private static Uts instance;

    public static Uts getInstance() {
        if (instance == null)
            instance = new Uts();
        return instance;
    }

    private Uts() {
    }


    private int intValue;

    public int Uts() {
        return intValue;
    }

    public void Uts(int intValue) {
        this.intValue = intValue;
    }
    private String lang_prefix;

    public String lang_prefix(){
        return lang_prefix;
    }
    public void lang_prefix (String lang_prefix) {
        this.lang_prefix = lang_prefix;
    }
}