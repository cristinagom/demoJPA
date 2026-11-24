package controller;

import entities.Character;
import repository.Repository;
import view.CharacterView;

import java.util.Objects;

public class CharacterController {
    private final Repository<Character> characterRepository;
    private final CharacterView view;

    public CharacterController(Repository<Character> characterRepository, CharacterView view) {
        this.characterRepository = characterRepository;
        this.view = view;
    }

    public void showAll() {
        view.showAll(characterRepository.findAll());
    }
}
