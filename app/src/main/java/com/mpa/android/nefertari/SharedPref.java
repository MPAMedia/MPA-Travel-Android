package com.mpa.android.nefertari;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    private String lang;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    public SharedPref(Context context){
        pref = context.getSharedPreferences("MyPref", 0); // 0 - for private mode
    }

    public String getLang() {
        lang = pref.getString("lang", "_en");
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
        editor = pref.edit();
        editor.putString("lang", lang); // Storing integer
        editor.apply();
    }

    public void clear(){
        editor = pref.edit();
        editor.clear();
        editor.apply();
    }
}
