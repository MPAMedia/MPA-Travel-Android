package com.mpa.android.nefertari.data;

import com.google.firebase.auth.FirebaseUser;

import com.mpa.android.nefertari.model.User;

/**
 * Created by phamngocthanh on 7/29/17.
 */

public class AppState {
    public static FirebaseUser currentFireUser;
    public static User currentBpackUser;

    public static String email_address;
    public static String first_name;
    public static String last_name;
    public static String photo_url;
}
