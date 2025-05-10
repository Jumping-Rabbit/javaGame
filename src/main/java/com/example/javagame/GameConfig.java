package com.example.javagame;

import java.util.HashMap;

public class GameConfig {
    static void makeGameData(){
        HashMap<Object, Object> game = new HashMap<>();

        HashMap<Object, Object> player = new HashMap<>();
        HashMap<Object, Object> map = new HashMap<>();
        HashMap<Object, Object> units = new HashMap<>();
        HashMap<Object, Object> settings = new HashMap<>();

        HashMap<Object, Object> weapons = new HashMap<>();
        HashMap<Object, Object> bullets = new HashMap<>();
        HashMap<Object, Object> objects = new HashMap<>();
        HashMap<Object, Object> teamates = new HashMap<>();
        HashMap<Object, Object> enemies = new HashMap<>();

        player.put("weapons",weapons);
        player.put("bullets",bullets);
        map.put("objects",objects);
        units.put("teamates",teamates);
        units.put("enemies",enemies);
        game.put("player",player);
        game.put("map",map);
        game.put("units", units);
        System.out.println(game);
    }
}
