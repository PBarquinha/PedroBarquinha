package org.academiadecodigo.Difficulty;

import org.academiadecodigo.KeyNotes.StringGenerator;
import org.academiadecodigo.KeyNotes.StringName;

import java.util.Arrays;

public class DifficultyRandomizer {
    private StringGenerator stringGenerator;
    private StringName[] generatedStrings;
    public int counter = 0;

    public DifficultyRandomizer() {
        this.stringGenerator = stringGenerator;
    }

    public StringName[] randomizeDifficulty(Difficulty difficulty) {
        generatedStrings = new StringName[1000];

        switch (difficulty) {
            case HARD:
                StringName[] hardStrings = difficulty.getStrings();
                // Perform actions for hard difficulty using hardStrings
                System.out.println("Hard difficulty selected. Strings: " + Arrays.toString(hardStrings));
                stringGenerator = new StringGenerator();
                while (counter < 1000) {
                    generatedStrings[counter] = stringGenerator.hardGenerator();
                    counter++;
                }
                break;
            default:
                // Handle any other cases not covered by the enum
                System.out.println("Invalid difficulty selected.");
                break;
        }
        return generatedStrings;
    }
}
