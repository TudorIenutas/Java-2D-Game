package com.Tudor.game.tiles.blocks;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import com.Tudor.game.utils.Vector2f;
import com.Tudor.game.utils.AABB;
public abstract class Block {
    protected  int w;
    protected  int h;

    protected BufferedImage img;
    protected Vector2f pos;

    public Block(BufferedImage img, Vector2f pos, int w, int h){
        this.img = img;
        this.pos =pos;
        this.w = w;
        this.h =h;

    }
     public abstract  boolean update(AABB p);
    public abstract boolean isInside(AABB p);
    public Vector2f getPos() {return pos;}
    public void render(Graphics2D g ){
        g.drawImage(img, (int) pos.getWorldVar().x, (int) pos.getWorldVar().y,w,h,null);
    }

}
