package org.academiadecodigo;

import org.academiadecodigo.Difficulty.Difficulty;
import org.academiadecodigo.Difficulty.DifficultyRandomizer;
import org.academiadecodigo.KeyNotes.KeywordEvent;
import org.academiadecodigo.KeyNotes.Notes;
import org.academiadecodigo.KeyNotes.NoteFactory;
import org.academiadecodigo.KeyNotes.StringName;
import org.academiadecodigo.Menus.MainMenu;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import org.academiadecodigo.ScoringArea.ScoringArea;
import org.academiadecodigo.ScoringArea.ScoringAreas;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

import java.io.File;

public class Game {
    private Notes notes2;
    private int i = 0;
    private Text scoreText = new Text(770,230,"" + KeywordEvent.SCORE);
    private boolean isRestart = false;
    private Clip clip;
    private MainMenu menu;
    private KeywordEvent keywordEvent;
    public static Notes[] notes;

    private NoteFactory noteFactory;

    private int delay;
    private DifficultyRandomizer difficultyRandomizer;
    private Difficulty selectedDifficulty;

    public Game() {
        scoreText.grow(20,40);
        scoreText.setColor(Color.GREEN);

        this.menu = new MainMenu();
        this.noteFactory = new NoteFactory();
        this.delay = 30;
        this.difficultyRandomizer = new DifficultyRandomizer();
        this.selectedDifficulty = Difficulty.HARD;
        this.keywordEvent = new KeywordEvent();

        gameInit();
    }

    public void gameInit() {
        StringName[] factoryNotes = difficultyRandomizer.randomizeDifficulty(selectedDifficulty);
        notes = noteFactory.noteFactory(factoryNotes);

        start();
    }

    public void start() {
        while (true) {
            moveAllNotes();
            pause(1);
            // Commented out code related to the menu
        }
    }

    public void moveAllNotes() {
        if (menu.isGameStart()) {
            if (isRestart == true){
                menu.hideGameOverMenu();
            }

            menu.drawGameBackground();
            for (Notes notes : notes) {
                notes.drawKeys();
            }

            scoreText.draw();

            toxicityMusic();
            long endTime = System.currentTimeMillis() + (247100); // duraçao da musica mais o delay de inicio.
            while (System.currentTimeMillis() < endTime) {
                for (Notes note : notes) {

                    note.move();
                    scoreText.setText( "" + KeywordEvent.SCORE);

                    if (note.getLastY() > 980) {
                        note.nowYouSeeMeNowYouDont();
                    }
                }
            }
            i=1;
            toxicityMusic();
            isRestart = true;
            menu.hideGameOverMenu();
            KeywordEvent.SCORE = 0;


            for (int j = 0; j < notes.length; j++) {
                notes[j].nowYouSeeMeNowYouDont();
            }

            menu.setGameStart(false);
        } else {
            menu.paintGameOver();
            restart();
        }
    }

    public void restart() {
        notes = null;
        // Rest of the code to reset other game components
        difficultyRandomizer = new DifficultyRandomizer();
        noteFactory = new NoteFactory();
        //scoringArea = new ScoringArea(ScoringAreas.TO_EARLY);
        //scoringArea = new ScoringArea(ScoringAreas.PERFECT);
        //scoringArea = new ScoringArea(ScoringAreas.TO_LATE);
        selectedDifficulty = Difficulty.HARD;

        pause(1000); // Pause for 1 second to prevent immediate restart
        gameInit(); // Restart the game from gameInit()
    }

    public void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void toxicityMusic(){
        try {
            try {
                if (i == 0) {
                    Thread musicThread = new Thread(() -> {
                        try {
                            Thread.sleep(4100); // Delay before starting the music (adjust the delay as needed)
                            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Resources/System Of A Down - Toxicity (online-audio-converter.com).wav"));
                            this.clip = AudioSystem.getClip();
                            this.clip.open(audioInputStream);
                            this.clip.start();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                    musicThread.start();
                    return;
                } else if (i == 1) {
                    clip.close();
                    i = 0;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


} catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
