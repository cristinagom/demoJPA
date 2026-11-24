package view;

import entities.Character;

import java.io.PrintStream;
import java.util.List;
import java.util.Objects;

public class CharacterView {
    private final PrintStream output;

    public CharacterView(PrintStream output) {
        this.output = output;
    }

    public void showAll(List<Character> characters) {
        output.printf("%-30s %s%n", "CHARACTER", "HOMEWORLD");
        for (Character character : characters) {
            output.printf("%-30s %s%n", character.getName(), character.getPlanet().getName());
        }
        if (characters.isEmpty()) {
            output.println("No characters found.");
        }
    }
}
