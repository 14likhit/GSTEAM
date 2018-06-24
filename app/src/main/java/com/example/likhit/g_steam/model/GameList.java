package com.example.likhit.g_steam.model;

public class GameList {
    private String game;
    private String thumbailurl;

    public GameList() {
    }

    public GameList(String game, String thumbailurl) {
        this.game = game;
        this.thumbailurl = thumbailurl;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getThumbailurl() {
        return thumbailurl;
    }

    public void setThumbailurl(String thumbailurl) {
        this.thumbailurl = thumbailurl;
    }
}
