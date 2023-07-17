package org.academiadecodigo.ScoringArea;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class ScoringArea {
    private int yInit;
    private int yFin;
    private final int width = 1000;
    private int height;
    private ScoringAreas scoringArea;
    private Rectangle scoreArea;

    public ScoringArea(ScoringAreas scoreAreas) {
        scoringArea = scoreAreas;

        switch (scoreAreas) {
            case TO_EARLY:
                height = 15;
                yInit = 885;
                break;
            case PERFECT:
                height = 45;
                yInit = 900;
                break;
            case TO_LATE:
                height = 15;
                yInit = 945;
                break;
        }

        yFin = yInit + height;
        scoreArea = new Rectangle(10, yInit, width, height);
    }

    public int getYInit() {
        return yInit;
    }

    public int getYFin() {
        return yFin - 1;
    }

    public int getHeight() {
        return height;
    }
}
