package com.example.likhit.g_steam.network;

import com.example.likhit.g_steam.model.GameList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONParse {

    //Declare the arrays of fields you require
    public static String names;
    public static String urls;
    private JSONObject games = null;


    List<GameList> Games ;


    private JSONObject json;

    public JSONParse(JSONObject json){

        this.json = json;
    }

    public void parseJSON(){
        JSONObject jsonObject=null;

        try {

            games =  json;


            names = games.getString("name");//new String[games.length()];
            urls = games.getString("header_image");//new String[games.length()];
            Games = new ArrayList<GameList>();



           /* for(int i=0;i< games.length();i++){
                GameList game_object =  new GameList();

                jsonObject = games.getJSONObject()

                names[i] = games.getString("name");
                urls[i] = games.getString("header_image");

                game_object.setGame(names[i]);
                game_object.setThumbailurl(urls[i]);
                Games.add(game_object);

            }*/
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public List<GameList> getGames()
    {
        //function to return the final populated list
        return Games;
    }
}
