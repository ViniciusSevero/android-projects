package com.example.viniciussevero.prenac2;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vinicius Severo on 11/05/2017.
 */

public class Util {
    private static SharedPreferences pref;

    public static void gravarCaves(Context context, String prefName, HashMap<String,String> map){
        pref = context.getSharedPreferences(prefName,Context.MODE_PRIVATE);
        SharedPreferences.Editor e = pref.edit();
        //pegar cada registro (entrada) do HashMap
        for(Map.Entry<String,String> item : map.entrySet()){
            e.putString(item.getKey(),item.getValue());
        }
        e.commit();
    }
    public static void excluirChaves(Context context, String prefName, HashMap<String,String> map) {
        pref = context.getSharedPreferences(prefName,Context.MODE_PRIVATE);
        SharedPreferences.Editor e = pref.edit();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            e.remove(entry.getKey());
        }
        e.commit();
    }
    public static String retornaValor(Context context, String prefName,String key){
        pref = context.getSharedPreferences(prefName,Context.MODE_PRIVATE);
        return pref.getString(key,null); // se não achar retona null
    }

    public static boolean verificarChave(Context context, String prefName, String key){
        pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        return pref.contains(key);
    }
}
