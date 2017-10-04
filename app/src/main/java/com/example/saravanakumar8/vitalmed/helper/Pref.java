package com.example.saravanakumar8.vitalmed.helper;

import android.content.SharedPreferences;

/**
 * Created by saravanakumar8 on 9/12/2017.
 */

public class Pref {
    private static final String PRE_ACCOUNT_ID = "account_id";
    private static final String PRE_ACCOUNT_USERCODE = "account_usercode";

    private static final String PRE_FIREBASE_TOKEN = "furebase_id";
    private static final String PRE_IMAGE = "image";
    private static final String PRE_ACCOUNT_USERNAME = "account_username";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String USERID = "userId";
    private static final String GROUPID = "groupId";
    private static SharedPreferences preferences = AppController.sharedpreferences;
    private static SharedPreferences.Editor editor;


    public static void setAccountId(int account_id) {
        editor = preferences.edit();
        editor.putInt(PRE_ACCOUNT_ID, account_id);
        editor.commit();
    }

    public static int getAccountId() {
        return preferences.getInt(PRE_ACCOUNT_ID, 0);
    }

    static String getPreAccountUsercode() {
        return preferences.getString(PRE_ACCOUNT_USERCODE, null);
    }

    public static void logoutUser() {


    }


    public static void setdevicetoken(String token) {

        editor = preferences.edit();
        editor.putString(PRE_FIREBASE_TOKEN, token);
        editor.commit();

    }

    public static void setimageurl(String image) {

        editor = preferences.edit();
        editor.putString(PRE_IMAGE, image);
        editor.commit();

    }

    public static void setaccount_username(String username) {

        editor = preferences.edit();
        editor.putString(PRE_ACCOUNT_USERNAME, username);
        editor.commit();

    }

    public static String getaccount_username() {

        return preferences.getString(PRE_ACCOUNT_USERNAME, null);

    }


    public static String getimageurl() {

        return preferences.getString(PRE_IMAGE, null);

    }


    static String getfirbasetoken() {

        return preferences.getString(PRE_FIREBASE_TOKEN, null);

    }

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static String getUSERID() {
        return USERID;
    }

    public static String getGROUPID() {
        return GROUPID;
    }

    public static void savelogin(String uname, String upass, String userid, String groupid) {
        editor = preferences.edit();
        editor.putString(USERNAME, uname);
        editor.putString(PASSWORD, upass);
        editor.putString(USERID, userid);
        editor.putString(GROUPID, groupid);
        editor.commit();
    }

    public static void clearlogin(){
        editor = preferences.edit();
        editor.clear();
        editor.commit();
    }
}
