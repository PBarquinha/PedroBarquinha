package org.academiadecodigo.KeyNotes;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Notes {
    private int x;
    private int y;
    private final int height = 30;
    private final int width = 100;
    private Rectangle block;
    private int currentPosition;
    private int lastY;
    private Picture background;
    private Picture keys;

    public Notes(StringName key, int y) {
        this.x = calculateXForKey(key);
        this.lastY = y;
        this.currentPosition = lastY;
        //this.block = new Rectangle(x, y, width, height);
        //chooseColorNote(key);
       chooseColorNote(key);


    }

    public void chooseColorNote(StringName key) {

        switch (key) {
            case A_STRING:
                keys = new Picture(130,lastY,"Resources/BotaoA_Rev0.png");
                break;
            case S_STRING:
                keys = new Picture(235,lastY,"Resources/BotaoS_Rev0.png");
                break;
            case D_STRING:
                keys = new Picture(340,lastY,"Resources/BotaoD_Rev0.png");
                break;
            case F_STRING:
                keys = new Picture(445,lastY,"Resources/BotaoF_Rev0.png");
                break;
            case G_STRING:
                keys = new Picture(550,lastY,"Resources/BotaoG_Rev0.png");
                break;
            default:
                throw new IllegalArgumentException("Invalid key: " + key);
        }
    }

    public void backgroundDraw(){
        background.draw();
    }

    public void draw() {
        block.draw();
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void move() {
        keys.translate(0, 5);
        lastY += 5;
    }

    public void nowYouSeeMeNowYouDont() {
       keys.delete();
    }

    public void hide() {
        lastY = 10000;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Rectangle getBlock() {
        return block;
    }

    public int getLastY() {
        return lastY;
    }
    public void drawKeys(){
        keys.draw();
    }

    private int calculateXForKey(StringName key) {

        switch (key) {
            case A_STRING:

                return 130;
            case S_STRING:

                return 235;
            case D_STRING:

                return 340;
            case F_STRING:

                return 445;
            case G_STRING:

                return 550;
            default:
                throw new IllegalArgumentException("Invalid key: " + key);
        }
    }
}
