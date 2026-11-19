import controller.CharacterController;
import entities.Character;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import repository.CharacterRepository;
import repository.Repository;
import view.CharacterView;

public class App {

    public static void main(String[] args) {

        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
             EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            Repository<Character> characterRepository = new CharacterRepository(entityManager);
            CharacterView view = new CharacterView(System.out);
            CharacterController controller = new CharacterController(characterRepository, view);

            controller.showAll();

        }
    }
}
