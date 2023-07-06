package org.academiadecodigo.KeyNotes;

public class StringGenerator {

    public StringName hardGenerator() {
        int randomNumber = (int) (Math.random() * 20) + 1;
        StringName generatedString;

        if (randomNumber <= 4) {
            generatedString = StringName.A_STRING;
        } else if (randomNumber <= 8) {
            generatedString = StringName.S_STRING;
        } else if (randomNumber <= 12) {
            generatedString = StringName.F_STRING;
        } else if (randomNumber <= 16) {
            generatedString = StringName.D_STRING;
        } else {
            generatedString = StringName.G_STRING;
        }

        System.out.println("String " + generatedString + " Generated");
        return generatedString;
    }
}
