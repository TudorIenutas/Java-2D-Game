package com.Tudor.game.states;

import com.Tudor.game.GamePanel;
import com.Tudor.game.entity.Enemy;
import com.Tudor.game.entity.Entity;
import com.Tudor.game.entity.Player;
import com.Tudor.game.graphics.Font;
import com.Tudor.game.graphics.Sprite;
import com.Tudor.game.tiles.TileManager;
import com.Tudor.game.utils.KeyHandler;
import com.Tudor.game.utils.MouseHandler;
import com.Tudor.game.utils.Vector2f;
import java.awt.Graphics2D;


public class PlayState extends GameState {



    private Font font ;
    private Player player;
    private Enemy enemy;
    private TileManager tm;

    public static Vector2f map;

    public PlayState(GameStateManager gsm){
        super(gsm);
        map = new Vector2f();
        Vector2f.setWorldVar(map.x, map.y);
        tm = new TileManager("tile/tilemap.xml");
        font = new Font( "font/font.png", 10 , 10);
        enemy = new Enemy(new Sprite("entity/littlegirl.png", 48,48),new Vector2f(0 + (GamePanel.width /2) - 32+150,0 + (GamePanel.height /2)-32+150) , 64);
        player = new Player(new Sprite("entity/linkFormatted.png"), new Vector2f(0 + (GamePanel.width /2) - 32,0 + (GamePanel.height /2)-32), 64);
    }



    public void update (){

        Vector2f.setWorldVar(map.x,map.y);
             player.update();
             enemy.update(player.getBounds());
    }
    public void input(MouseHandler mouse, KeyHandler key ) {
        player.input(mouse,key);


    }

    public void render(Graphics2D g){
        tm.render(g);
        Sprite.drawArray(g, font, GamePanel.oldFrameCount + " FPS" , new Vector2f(GamePanel.width - 200, 32), 32, 32, 24, 0);
        player.render(g);
        enemy.render(g);
    }

}
