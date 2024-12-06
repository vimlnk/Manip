package app;

import java.util.List;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        userRepository.addUser(new User(1, "Оля", "olya@example.com"));
        userRepository.addUser(new User(2, "Іван", "ivan@example.com"));
        userRepository.addUser(new User(3, "Марія", "maria@example.com"));

        int searchId = 1;
        userRepository.findUserById(searchId).ifPresentOrElse(
                user -> System.out.println("Знайдено користувача: " + user),
                () -> System.out.println("Користувача з id=" + searchId + " не знайдено")
        );


        String searchEmail = "ivan@example.com";
        userRepository.findUserByEmail(searchEmail).ifPresentOrElse(
                user -> System.out.println("Знайдено користувача: " + user),
                () -> System.out.println("Користувача з email=" + searchEmail + " не знайдено")
        );

        userRepository.findAllUsers().ifPresentOrElse(
                users -> {
                    System.out.println("Знайдено користувачів: " + users.size());
                    users.forEach(System.out::println);
                },
                () -> System.out.println("Список користувачів порожній")
        );

    }
}