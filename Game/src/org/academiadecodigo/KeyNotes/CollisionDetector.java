package org.academiadecodigo.KeyNotes;

import org.academiadecodigo.Game;
import org.academiadecodigo.KeyNotes.Notes;
import org.academiadecodigo.ScoringArea.ScoringArea;
import org.academiadecodigo.ScoringArea.ScoringAreas;

import java.util.Random;

public class CollisionDetector {


    public int isNoteAWithinScoringArea() {
        for (Notes n : Game.notes) {

            if (n.getLastY() >= 855 && n.getLastY() <= 899 && n.getX() == 130) {
                n.hide();
                return 0;
            }
            if (n.getLastY() >= 900 && (n.getLastY() + 30) <= 945 && n.getX() == 130) {
                n.hide();
                return 1;
            }
            if (n.getLastY() >= 916 && n.getLastY() <= 960 && n.getX() == 130) {
                n.hide();
                return 2;
            }
        }

        return -1;
    }

    public int isNoteSWithinScoringArea() {
        for (Notes n : Game.notes) {

            if (n.getLastY() >= 855 && n.getLastY() <= 899 && n.getX() == 235) {
                n.hide();
                return 0;
            }
            if (n.getLastY() >= 900 && (n.getLastY() + 30) <= 945 && n.getX() == 235) {
                n.hide();
                return 1;
            }
            if (n.getLastY() >= 916 && n.getLastY() <= 960 && n.getX() == 235) {
                n.hide();
                return 2;
            }
        }
        return -1;
    }

    public int isNoteDWithinScoringArea() {
        for (Notes n : Game.notes) {

            if (n.getLastY() >= 855 && n.getLastY() <= 899 && n.getX() == 340) {
                n.hide();
                return 0;
            }
            if (n.getLastY() >= 900 && (n.getLastY() + 30) <= 945 && n.getX() == 340) {
                n.hide();
                return 1;
            }
            if (n.getLastY() >= 916 && n.getLastY() <= 960 && n.getX() == 340) {
                n.hide();
                return 2;
            }
        }
        return -1;
    }

    public int isNoteFWithinScoringArea() {
        for (Notes n : Game.notes) {

            if (n.getLastY() >= 855 && n.getLastY() <= 899 && n.getX() == 445) {
                n.hide();
                return 0;
            }
            if (n.getLastY() >= 900 && (n.getLastY() + 30) <= 945 && n.getX() == 445) {
                n.hide();
                return 1;
            }
            if (n.getLastY() >= 916 && n.getLastY() <= 960 && n.getX() == 445) {
                n.hide();
                return 2;
            }
        }
        return -1;
    }

    public int isNoteGWithinScoringArea() {
        for (Notes n : Game.notes) {

            if (n.getLastY() >= 855 && n.getLastY() <= 899 && n.getX() == 550) {
                n.hide();
                return 0;
            }
            if (n.getLastY() >= 900 && (n.getLastY() + 30) <= 945 && n.getX() == 550) {
                n.hide();
                return 1;
            }
            if (n.getLastY() >= 916 && n.getLastY() <= 960 && n.getX() == 550) {
                n.hide();
                return 2;
            }
        }
        return -1;
    }
}