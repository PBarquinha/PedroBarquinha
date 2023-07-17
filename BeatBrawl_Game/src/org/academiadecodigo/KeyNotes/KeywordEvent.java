package org.academiadecodigo.KeyNotes;

import org.academiadecodigo.ScoringArea.ScoringArea;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeywordEvent implements KeyboardHandler {
    private Keyboard keyboard;
    public static int SCORE;
    public static int COMBO;
    private Text text;

    CollisionDetector collisionDetector;

    public KeywordEvent() {
        text = new Text(800,500,"Perfetc !!");
        this.text.grow(69,40);
        this.text.setColor(Color.GREEN);
        keyboard = new Keyboard(this);
        addKeyboard();
    }

    public void addKeyboard() {
        KeyboardEvent keyA = new KeyboardEvent();
        keyA.setKey(KeyboardEvent.KEY_A);
        keyA.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyA);

        KeyboardEvent keyS = new KeyboardEvent();
        keyS.setKey(KeyboardEvent.KEY_S);
        keyS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyS);

        KeyboardEvent keyD = new KeyboardEvent();
        keyD.setKey(KeyboardEvent.KEY_D);
        keyD.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyD);

        KeyboardEvent keyF = new KeyboardEvent();
        keyF.setKey(KeyboardEvent.KEY_F);
        keyF.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyF);

        KeyboardEvent keyG = new KeyboardEvent();
        keyG.setKey(KeyboardEvent.KEY_G);
        keyG.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyG);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int keyPressed = keyboardEvent.getKey();
        if (keyPressed == KeyboardEvent.KEY_A) {
            handleKeyANote();
        } else if (keyPressed == KeyboardEvent.KEY_S) {
            handleKeySNote();
        } else if (keyPressed == KeyboardEvent.KEY_D) {
            handleKeyDNote();
        } else if (keyPressed == KeyboardEvent.KEY_F) {
            handleKeyFNote();
        } else if (keyPressed == KeyboardEvent.KEY_G) {
            handleKeyGNote();
        }
    }

    private void handleKeyANote() {
        CollisionDetector c = new CollisionDetector();
        int test = c.isNoteAWithinScoringArea();
        switch (test) {
            case 0:
                System.out.println("you hit too early!");
                COMBO = 0;
                SCORE += 2;
                break;
            case 1:
                System.out.println("you hit Perfect");
                COMBO++;
                SCORE = SCORE + COMBO * 10;
                //textPerfect();
                break;
            case 2:
                System.out.println("You hit too late!");
                COMBO = 0;
                SCORE += 2;
                break;
            case -1:
                System.out.println("you missed!");
                COMBO = 0;
                SCORE -= 2;
                System.out.println("==== SCORE ==== " + SCORE);
        }
    }

    private void handleKeySNote() {
        CollisionDetector c = new CollisionDetector();
        int test = c.isNoteSWithinScoringArea();
        switch (test) {
            case 0:
                System.out.println("you hit too early!");
                COMBO = 0;
                SCORE += 2;
                break;
            case 1:
                System.out.println("you hit Perfect");
                COMBO++;
                SCORE = SCORE + COMBO * 10;
                //textPerfect();
                break;
            case 2:
                System.out.println("You hit too late!");
                COMBO = 0;
                SCORE += 2;
                break;
            case -1:
                System.out.println("you missed!");
                COMBO = 0;
                SCORE -= 2;
                System.out.println("==== SCORE ==== " + SCORE);
        }
    }

    private void handleKeyDNote() {
        CollisionDetector c = new CollisionDetector();
        int test = c.isNoteDWithinScoringArea();
        switch (test) {
            case 0:
                System.out.println("you hit too early!");
                COMBO = 0;
                SCORE += 2;
                break;
            case 1:
                System.out.println("you hit Perfect");
                COMBO++;
                SCORE = SCORE + COMBO * 10;
                //textPerfect();
                break;
            case 2:
                System.out.println("You hit too late!");
                COMBO = 0;
                SCORE += 2;
                break;
            case -1:
                System.out.println("you missed!");
                COMBO = 0;
                SCORE -= 2;
                System.out.println("==== SCORE ==== " + SCORE);
        }
    }

    private void handleKeyFNote() {
        CollisionDetector c = new CollisionDetector();
        int test = c.isNoteFWithinScoringArea();
        switch (test) {
            case 0:
                System.out.println("you hit too early!");
                COMBO = 0;
                SCORE += 2;
                break;
            case 1:
                System.out.println("you hit Perfect");
                COMBO++;
                SCORE = SCORE + COMBO * 10;
                //textPerfect();
                break;
            case 2:
                System.out.println("You hit too late!");
                COMBO = 0;
                SCORE += 2;
                break;
            case -1:
                System.out.println("you missed!");
                COMBO = 0;
                SCORE -= 2;
                System.out.println("==== SCORE ==== " + SCORE);
        }
    }

    private void handleKeyGNote() {
        CollisionDetector c = new CollisionDetector();
        int test = c.isNoteGWithinScoringArea();
        switch (test) {
            case 0:
                System.out.println("you hit too early!");
                COMBO = 0;
                SCORE += 2;
                break;
            case 1:
                System.out.println("you hit Perfect");
                COMBO++;
                SCORE = SCORE + COMBO * 10;
                //textPerfect();
                break;
            case 2:
                System.out.println("You hit too late!");
                COMBO = 0;
                SCORE += 2;
                break;
            case -1:
                System.out.println("you missed!");
                COMBO = 0;
                SCORE -= 2;
                System.out.println("==== SCORE ==== " + SCORE);
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        // Método vazio, não precisamos implementá-lo neste caso
    }
/*    public void textPerfect() {
        this.text.draw();
        new Thread(() -> {
            try {
                Thread.sleep(1000); // Delay for 2 seconds (adjust as needed)
                textHide();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void textHide() {
        text.delete();
    }*/
}
