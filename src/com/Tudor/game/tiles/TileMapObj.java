package com.Tudor.game.tiles;

import com.Tudor.game.graphics.Sprite;
import com.Tudor.game.utils.Vector2f;
import com.Tudor.game.tiles.blocks.HoleBlock;
import com.Tudor.game.tiles.blocks.ObjBlock;
import com.Tudor.game.tiles.blocks.Block; // Added import for Block
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class TileMapObj extends TileMap {
    public static HashMap<String, Block> tmo_blocks;

    // Corrected constructor name to match the class name
    public TileMapObj(String data, Sprite sprite, int width, int height, int tileWidth, int tileHeight, int tileColumns) {
        Block tempBlock;
        tmo_blocks = new HashMap<String, Block>();

        String[] block = data.split(",");
        for (int i = 0; i < (width * height); i++) {
            int temp = Integer.parseInt(block[i].replaceAll("\\s+", ""));
            if(temp != 0) {
                if(temp == 172) {
                    // TODO: find edge and connect them to form one polygon
                    tempBlock = new HoleBlock(sprite.getSprite((int) ((temp - 1) % tileColumns), (int) ((temp - 1) / tileColumns) ), new Vector2f((int) (i % width) * tileWidth, (int) (i / height) * tileHeight), tileWidth, tileHeight);
                } else {
                    tempBlock = new ObjBlock(sprite.getSprite((int) ((temp - 1) % tileColumns), (int) ((temp - 1) / tileColumns) ), new Vector2f((int) (i % width) * tileWidth, (int) (i / height) * tileHeight), tileWidth, tileHeight);
                }
                // Corrected key construction for HashMap
                tmo_blocks.put(String.valueOf(i % width) + "," + String.valueOf(i / height), tempBlock);
            }
        }
    }

    public void render(Graphics2D g) {
        // Corrected iteration over values of HashMap
        for (Block block : tmo_blocks.values()) {
            block.render(g);
        }
    }
}
