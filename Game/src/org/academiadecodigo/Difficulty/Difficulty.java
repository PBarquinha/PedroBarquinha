package org.academiadecodigo.Difficulty;

import org.academiadecodigo.KeyNotes.StringName;

public enum Difficulty {
    EASY(new StringName[]{StringName.A_STRING, StringName.S_STRING, StringName.D_STRING}),
    MEDIUM(new StringName[]{StringName.A_STRING, StringName.S_STRING, StringName.D_STRING, StringName.F_STRING}),
    HARD(new StringName[]{StringName.A_STRING, StringName.S_STRING, StringName.D_STRING, StringName.F_STRING, StringName.G_STRING});

    private final StringName[] strings;

    Difficulty(StringName[] strings) {
        this.strings = strings;
    }

    public StringName[] getStrings() {
        return strings;
    }
}
