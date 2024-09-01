package com.example.maggiepoint;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SecurePreferences {

    private static final String TOKEN_KEY = "auth_token";

    public static void saveToken(Context context, String token) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(TOKEN_KEY, token);
        editor.apply();
    }

    public static String getToken(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(TOKEN_KEY, null);
    }

    public static void clearToken(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.remove(TOKEN_KEY);
        editor.apply();
    }
}
