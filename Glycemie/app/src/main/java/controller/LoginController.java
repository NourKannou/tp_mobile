package controller;

import android.content.Context;
import android.content.SharedPreferences;

import model.User;

public class LoginController {
    private static  LoginController instance = null;
    private static final String PREF_NAME = "MyPrefs";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static User user;

    public static LoginController getinstance(Context context){
        if (LoginController.instance == null)
        {return LoginController.instance = new LoginController();}
        recapUser(context);
        return LoginController.instance;
    }

    // Méthode pour enregistrer les informations de connexion dans SharedPreferences
    public static void CreateUser(Context context, String username, String password) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_PASSWORD, password);
        editor.apply();
    }

    // Méthode pour récupérer les informations de connexion depuis SharedPreferences
    public static User getSavedCredentials(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String username = sharedPreferences.getString(KEY_USERNAME, null);
        String password = sharedPreferences.getString(KEY_PASSWORD, null);

        if (username != null && password != null) {
            return new User(username, password);
        } else {
            return null;
        }
    }

    // Méthode pour effacer les informations de connexion enregistrées
    public static void clearSavedCredentials(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(KEY_USERNAME);
        editor.remove(KEY_PASSWORD);
        editor.apply();
    }
    public static void recapUser(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String username = sharedPreferences.getString(KEY_USERNAME, null);
        String password = sharedPreferences.getString(KEY_PASSWORD, null);

        if (username != null && password != null) {
            User user = new User(username, password);
        }
    }
    public String getUserName() {
        return user.getUsername();
    }

    public String getPassword() {
        return user.getPassword();
    }
}

