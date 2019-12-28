package com.mpa.android.nefertari;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mpa.android.nefertari.R;

import java.util.Locale;

import com.mpa.android.nefertari.activity.home.HomeActivity;

public class SettingsActivity extends AppCompatActivity {
    Spinner spinnerctrl;
    Locale myLocale;
    TextView topbarTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        topbarTitle = findViewById(R.id.topbarTitle);
        topbarTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        topbarTitle.setText("Settings");



        String[] test=new String[]{"Choose language","English","French","Italian","Dutch","Russian","Arabic","French Switzerland","Dutch Switzerland","Italian Switzerland"};
        ArrayAdapter<String> gameKindArray= new ArrayAdapter(SettingsActivity.this,android.R.layout.simple_spinner_item, test);
        gameKindArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerctrl = findViewById(R.id.spinner2);
        spinnerctrl.setAdapter(gameKindArray);
        spinnerctrl.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view,int pos, long id) {
                switch (pos){
                    case 1 :
                        Toast.makeText(SettingsActivity.this, "You have selected English", Toast.LENGTH_SHORT).show();
                        setLocale("en");
                        break;
                    case 2 :
                        Toast.makeText(SettingsActivity.this, "You have selected French", Toast.LENGTH_SHORT).show();
                        setLocale("fr");
                        break;
                    case 3 :
                        Toast.makeText(SettingsActivity.this, "You have selected Italian", Toast.LENGTH_SHORT).show();
                        setLocale("it");
                        break;
                    case 4 :
                        Toast.makeText(SettingsActivity.this, "You have selected Dutch", Toast.LENGTH_SHORT).show();
                        setLocale("nl");
                        break;
                    case 5 :
                        Toast.makeText(SettingsActivity.this, "You have selected Russian", Toast.LENGTH_SHORT).show();
                        setLocale("ru");
                        break;
                    case 6 :
                        Toast.makeText(SettingsActivity.this, "You have selected Arabic", Toast.LENGTH_SHORT).show();
                        setLocale("ar");
                        break;
                    case 7 :
                        Toast.makeText(SettingsActivity.this, "You have selected French Switzerland", Toast.LENGTH_SHORT).show();
                        setLocale("aa");
                        break;
                    case 8 :
                        Toast.makeText(SettingsActivity.this, "You have selected Dutch Switzerland", Toast.LENGTH_SHORT).show();
                        setLocale("ab");
                        break;
                    case 9 :
                        Toast.makeText(SettingsActivity.this, "You have selected Dutch Italian Switzerland", Toast.LENGTH_SHORT).show();
                        setLocale("gsw-rFR");
                        break;
                    default:
                        break;
                }
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }

        });
    }

    public void setLocale(String lang) {
        SharedPref sharedPref = new SharedPref(getApplicationContext());
        switch (lang){
            case "aa":
                Log.e("ChangeLocale","swiss_fr");
                sharedPref.setLang("_swiss_fr");
                Uts.getInstance().lang_prefix("_swiss_fr");
                break;
            case "ab":
                Log.e("ChangeLocale","_swiss_it");
                sharedPref.setLang("_swiss_it");
                Uts.getInstance().lang_prefix("_swiss_it");
                break;
            case "gsw-rFR":
                Log.e("ChangeLocale","_swiss_nl");
                sharedPref.setLang("_swiss_nl");
                Uts.getInstance().lang_prefix("_swiss_nl");
                break;
            default:
                Log.e("ChangeLocale",lang);
                sharedPref.setLang("_"+lang);
                Uts.getInstance().lang_prefix("_"+lang);
                break;
        }
        Log.e("ChangeLocale",lang);
//        sharedPref.setLang("_"+lang);
//        Uts.getInstance().lang_prefix("_"+lang);

        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, HomeActivity.class);
        startActivity(refresh);
    }
}

