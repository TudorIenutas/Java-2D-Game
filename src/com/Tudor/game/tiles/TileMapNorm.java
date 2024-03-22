package com.Tudor.game.tiles;
import java.awt.Graphics2D;
import java.awt.*;
import java.util.ArrayList;
import com.Tudor.game.tiles.blocks.NormBlock;
import com.Tudor.game.graphics.Sprite;
import com.Tudor.game.utils.Vector2f;
import com.Tudor.game.tiles.blocks.Block;

public class TileMapNorm extends TileMap {
    private ArrayList<Block> blocks;

    public TileMapNorm(String data, Sprite sprite, int width, int height, int tileWidth, int tileHeight, int tileColumns) {
        blocks = new ArrayList<Block>();

        String[] block = data.split(",");
        for (int i = 0; i < (width * height); i++) {
            int temp = Integer.parseInt(block[i].replaceAll("\\s+", ""));
            if (temp != 0) {
                // Corrected instantiation and arguments passing
                blocks.add(new NormBlock(sprite.getSprite((int) ((temp - 1) % tileColumns), (int) ((temp - 1) / tileColumns) ), new Vector2f((int) (i % width) * tileWidth, (int) (i / height) * tileHeight), tileWidth, tileHeight));
            }
        }
    }

    public void render(Graphics2D g) {
        for (int i = 0; i < blocks.size(); i++) {
            blocks.get(i).render(g);
        }
    }
}
