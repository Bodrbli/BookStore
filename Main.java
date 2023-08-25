import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Book book;
        BookStore bookStore = new BookStore();
        Scanner scanner = new Scanner(System.in);;

        // Логин и пароль для входа
        String login = "admin";
        String password = "password";

        // Вход в приложение
        System.out.print("Введите логин: ");
        String enteredLogin = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String enteredPassword = scanner.nextLine();

        if (enteredLogin.equals(login) && enteredPassword.equals(password)) {
            // Вывод главного меню
            System.out.println("МЕНЮ:\n" +
                    "1. Добавить книгу\n" +
                    "2. Удалить книгу\n" +
                    "3. Редактировать параметры книги\n" +
                    "4. Продать книгу\n" +
                    "5. Включить книгу в акцию\n" +
                    "6. Отложить книгу для покупателя\n" +
                    "7. Поиск книги\n" +
                    "8. Просмотреть список новинок\n" +
                    "9. Просмотреть список самых продаваемых книг\n" +
                    "10. Просмотреть список популярных авторов\n" +
                    "11. Просмотреть список популярных жанров\n" +
                    "0. Выход\n");

            int choice;
            do {
                System.out.print("Выберите действие: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Чтение символа новой строки после считывания числа

                switch (choice) {
                    case 1:
                        // Добавление книги
                        System.out.print("Введите название книги: ");
                        String title = scanner.nextLine();
                        book = bookStore.getBookFields(title);
                        if (book != null) {
                            bookStore.addBook(book);
                        }
                        break;
                    case 2:
                        // Удаление книги
                        System.out.print("Введите название книги: ");
                        title = scanner.nextLine();
                        bookStore.removeBook(title);
                        break;
                    case 3:
                        // Редактирование параметров книги
                        System.out.print("Введите название книги: ");
                        title = scanner.nextLine();
                        bookStore.editBook(title);
                        break;
                    case 4:
                        // Продажа книги
                        System.out.print("Введите название книги: ");
                        title = scanner.nextLine();
                        bookStore.sellBook(title);
                        break;
                    case 5:
                        // Включение книги в акцию
                        // ...
                        break;
                    case 6:
                        // Отложить книгу для покупателя
                        // ...
                        break;
                    case 7:
                        // Поиск книги
                        // ...
                        break;
                    case 8:
                        // Просмотр списка новинок
                        // ...
                        break;
                    case 9:
                        // Просмотр списка самых продаваемых книг
                        // ...
                        break;
                    case 10:
                        // Просмотр списка популярных авторов
                        // ...
                        break;
                    case 11:
                        // Просмотр списка популярных жанров
                        // ...
                        break;
                    case 0:
                        // Выход из приложения
                        System.out.println("Выход из приложения.");
                        break;
                    default:
                        System.out.println("Неверный выбор. Попробуйте снова.");
                }
            } while (choice != 0);
        } else {
            System.out.println("Неверный логин или пароль.");
        }
    }
}