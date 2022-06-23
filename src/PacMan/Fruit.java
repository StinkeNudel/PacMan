package PacMan;

import Input.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Fruit {
    BufferedImage image;
    private final int x, y;
    private final int size = 32;
    public final int type; // 0: Cherry | 1: Strawberry | 2: Orange | 3: Apple | 4: Melon | 5: Galaxian | 6: Bell | 7: Key

    public Fruit(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
        switch (type) {
            case 0 -> image = ImageLoader.loadImage("/cherry.png");
            case 1 -> image = ImageLoader.loadImage("/strawberry.png");
            case 2 -> image = ImageLoader.loadImage("/orange.png");
            case 3 -> image = ImageLoader.loadImage("/apple.png");
            case 4 -> image = ImageLoader.loadImage("/melon.png");
            case 5 -> image = ImageLoader.loadImage("/galaxian.png");
            case 6 -> image = ImageLoader.loadImage("/bell.png");
            case 7 -> image = ImageLoader.loadImage("/key.png");


        }
    }

    public int getScore(){
        return switch (type) {
            default -> 0;
            case 0 -> 100;
            case 1 -> 300;
            case 2 -> 500;
            case 3 -> 700;
            case 4 -> 1000;
            case 5 -> 2000;
            case 6 -> 3000;
            case 7 -> 5000;
        };
    }

    public void render(Graphics g) {
        g.drawImage(image, x, y, size, size, null);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, size, size);
    }
}