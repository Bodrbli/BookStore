import java.util.HashMap;
import java.util.Map;

class BookStore {
    private Map<String, Book> books;

    public BookStore() {
        books = new HashMap<>();
    }

    public void addBook(Book book) {

    }

    public void removeBook(String title) {
        if (books.containsKey(title)) {
            books.remove(title);
            System.out.println("Книга успешно удалена из магазина.");
        } else {
            System.out.println("Книга не найдена в магазине.");
        }
    }

    public void editBook(String title) {
        if (books.containsKey(title)) {
            // Здесь можно реализовать логику редактирования параметров книги
            System.out.println("Параметры книги успешно отредактированы.");
        } else {
            System.out.println("Книга не найдена в магазине.");
        }
    }

    public void sellBook(String title) {
        if (books.containsKey(title)) {
            books.remove(title);
            System.out.println("Книга успешно продана.");
        } else {
            System.out.println("Книга не найдена в магазине.");
        }
    }

    // Остальные методы для функциональностей приложения
    // ...
}