package org.academiadecodigo.KeyNotes;

public class NoteFactory {

    public Notes[] noteFactory(StringName[] arrayStrings) {
        Notes[] arrNotes = new Notes[arrayStrings.length];
        int newY = -11;
        for (int i = 0; i < arrNotes.length; i++) {
            if (i != 0) {
                // Handle the first element separately
                double random = Math.random();
                if (random > 0.8) {
                    newY -= 35;
                } else {
                    newY -= 200;
                    if (random < 0.3) {
                        System.out.println("===================" + random + " " + i);
                        newY -= 100;
                    }
                }
                arrNotes[i] = new Notes(arrayStrings[i], newY);
            }
            arrNotes[i] = new Notes(arrayStrings[i], newY);
        }
        return arrNotes;
    }
}

