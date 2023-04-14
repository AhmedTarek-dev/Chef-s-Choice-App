package com.example.chefschoice.Register;

import android.content.Context;
import android.content.SharedPreferences;

public class AppSharedPref {
    public static SharedPreferences getSharedPref(Context context) {
        return context.getSharedPreferences("Register", Context.MODE_PRIVATE);
    }

    public static void writeToSharedPref(Context context, String name, String email,String phone) {
        getSharedPref(context).edit().putString("name", name).apply();
        getSharedPref(context).edit().putString("email", email).apply();
        getSharedPref(context).edit().putString("phone", phone).apply();
    }

    public static boolean isUserLogin(Context context) {
        return getSharedPref(context).contains("name");
    }
    public static String getName(Context context) {
        return getSharedPref(context).getString("name","");
    }
    public static String getemail(Context context) {
        return getSharedPref(context).getString("email","");
    }
    public static String getphone(Context context) {
        return getSharedPref(context).getString("phone","");
    }
}
