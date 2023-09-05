import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) throws IOException {
        Book book;
        BookStore bookStore = new BookStore();
        UserAccount userAccount = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Вход в приложение
        while (userAccount == null) {
            System.out.print("Введите логин: ");
            String enteredLogin = reader.readLine();
            System.out.print("Введите пароль: ");
            String enteredPassword = reader.readLine();
            try {
                userAccount = UserAccount.Accounts.findUser(enteredLogin, enteredPassword);
            }catch (NoSuchElementException e) {
                System.out.println("Неверные имя пользователя или пароль!");
            }
        }


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
                choice = Integer.parseInt(reader.readLine());

                switch (choice) {
                    case 1:
                        // Добавление книги
                        System.out.print("Введите название книги: ");
                        String title = reader.readLine();
                        book = bookStore.getBookFields(title);
                        if (book != null) {
                            bookStore.addBook(book);
                        }
                        break;
                    case 2:
                        // Удаление книги
                        System.out.print("Введите название книги: ");
                        title = reader.readLine();
                        bookStore.removeBook(title);
                        break;
                    case 3:
                        // Редактирование параметров книги
                        System.out.print("Введите название книги: ");
                        title = reader.readLine();
                        bookStore.editBook(title);
                        break;
                    case 4:
                        // Продажа книги
                        System.out.print("Введите название книги: ");
                        title = reader.readLine();
                        bookStore.sellBook(title);
                        break;
                    case 5:
                        // Включение книги в акцию
                        System.out.print("Введите название книги: ");
                        title = reader.readLine();
                        bookStore.addBookToStock(title);
                        break;
                    case 6:
                        // Отложить книгу для покупателя
                        System.out.print("Введите название книги: ");
                        title = reader.readLine();
                        bookStore.addToWaitingList(title);
                        break;
                    case 7:
                        // Поиск книги
                        bookStore.searchBook();
                        break;
                    case 8:
                        // Просмотр списка новинок
                        bookStore.listOfNewBook();
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
    }
}