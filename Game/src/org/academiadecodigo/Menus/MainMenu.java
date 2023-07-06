package org.academiadecodigo.Menus;

import org.academiadecodigo.Game;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MainMenu implements KeyboardHandler {

    private Rectangle startButton;
    private Picture background;
    private Picture gameOver;
    private Rectangle exitGameButton;
    private boolean gameStart;
    private Picture gameBackground;

    public boolean isGameStart() {
        return gameStart;
    }

    public void setGameStart(boolean gameStart) {
        this.gameStart = gameStart;
    }

    public MainMenu() {
        initialize();
        setupKeyboard();
        paintMainMenu();
        waitForEnterKey();
    }

    public void initialize() {
        background = new Picture(10, 10, "Resources/TelaInicial_Rev0.png");
        gameOver = new Picture(10, 10, "Resources/TelaGameOver_Rev0.png");
        gameBackground = new Picture(10,10,"Resources/TelaJogo_Rev2.png");

        startButton = new Rectangle(400, 400, 150, 100);
        exitGameButton = new Rectangle(30, 900, 100, 20);
        gameStart = false;
    }

    public void hideGameOverMenu(){
        gameOver.delete();
    }

    public void drawGameBackground(){
        gameBackground.draw();
    }
    public void hideGameBackground(){
        gameBackground.delete();
    }
    public void paintMainMenu() {
        background.draw();

    }

    public void paintGameOver() {
        gameOver.draw();
    }

    public void openStartGame() {
        gameStart = true;
        clearScreen();
    }

    public void clearScreen() {
        background.delete();
        startButton.delete();
        exitGameButton.delete();
    }

    public void returnMainMenu() {
        gameStart = false;
        paintMainMenu();
    }

    public void setupKeyboard() {
        Keyboard keyboard = new Keyboard(this);

        // Difficulty menu: space bar
        KeyboardEvent spaceKeyPressed = new KeyboardEvent();
        spaceKeyPressed.setKey(KeyboardEvent.KEY_SPACE);
        spaceKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(spaceKeyPressed);

        // Close Game
        KeyboardEvent escKeyPressed = new KeyboardEvent();
        escKeyPressed.setKey(KeyboardEvent.KEY_0);
        escKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(escKeyPressed);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            if (!gameStart) {
                openStartGame();
            }
        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_0) {
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    public void waitForEnterKey() {
        while (!gameStart) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
