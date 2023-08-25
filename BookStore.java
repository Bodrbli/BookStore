import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

class BookStore {
    private Map<String, Book> books;

    public BookStore() {
        books = new HashMap<>();
    }

    public Map<String, Book> getBooks() {
        return books;
    }

    public void setBooks(Map<String, Book> books) {
        this.books = books;
    }

    public Book getBookFields(String title) {
        Scanner scanner = new Scanner(System.in);
        Book book = null;
        if (!books.containsKey(title)) {
            try {
                System.out.println("Введите имя автора: ");
                String author = scanner.nextLine();
                System.out.println("Введите название издательства: ");
                String publisher = scanner.nextLine();
                System.out.println("Введите количество страниц: ");
                int pageCount = Integer.parseInt(scanner.nextLine());
                System.out.println("Введите жанр книги: ");
                String genre = scanner.nextLine();
                System.out.println("Введите год издания: ");
                int year = scanner.nextInt();
                System.out.println("Введите себестоимость книги: ");
                double costPrice = scanner.nextDouble();
                System.out.println("Введите цену для продажи: ");
                double sellingPrice = scanner.nextDouble();
                System.out.println("Является ли книга продолжением? (да/нет): ");
                boolean isContinuation = scanner.hasNext("да") ? true : false;
                book = new Book(title, author, publisher, pageCount, genre, year, costPrice, sellingPrice, isContinuation);
            }catch (InputMismatchException e) {
                System.out.println("Вы ввели некорректные данные.");
            }
            return book;
        } else {
            System.out.println("Книга с таким названием уже существует в библиотеке.");
            return null;
        }
    }
    public void addBook(Book book) {
        books.put(book.getTitle(), book);
    }

    public void removeBook(String title) {
        if (books.containsKey(title)) {
            books.remove(title);
            System.out.println("Книга успешно удалена из магазина.");
        } else {
            System.out.println("Книга не найдена в магазине.");
        }
    }

    public void editBook(String title) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        if (books.containsKey(title)) {
            Book book = books.get(title);
            System.out.println("Введите параметр который вы хотите изменить: ");
            System.out.println(book.toString());
            try {
                String edit = reader.readLine();
                if (edit.equals("Автор")) {
                    System.out.println("Введите автора: ");
                    String newAuthor = reader.readLine();
                    book.setAuthor(newAuthor);
                } else if (edit.equals("Издательство")) {
                    System.out.println("Введите издательство: ");
                    String newPublisher = reader.readLine();
                    book.setPublisher(newPublisher);
                } else if (edit.equals("Количество страниц")) {
                    System.out.println("Введите количество страниц: ");
                    int newPageCount = Integer.parseInt(reader.readLine());
                    book.setPageCount(newPageCount);
                } else if (edit.equals("Жанр")) {
                    System.out.println("Введите жанр: ");
                    String newGenre = reader.readLine();
                    book.setGenre(newGenre);
                } else if (edit.equals("Год издания")) {
                    System.out.println("Введите год: ");
                    int newYear = Integer.parseInt(reader.readLine());
                    book.setYear(newYear);
                } else if (edit.equals("Себестоимость")) {
                    System.out.println("Введите себестоимость: ");
                    double newCostPrice = Double.parseDouble(reader.readLine());
                    book.setCostPrice(newCostPrice);
                } else if (edit.equals("Цена продажи")) {
                    System.out.println("Введите цену продажи: ");
                    double newSellPrice = Double.parseDouble(reader.readLine());
                    book.setCostPrice(newSellPrice);
                } else if (edit.equals("Продолжение")) {
                    System.out.println("Книга является продолжением?: ");
                    boolean newIsContinue = reader.readLine().equals("Да")? true: false;
                    book.setContinuation(newIsContinue);
                }
            } catch (Exception e) {
                System.out.println("Вы ввели неверные данные.");
            }
            reader.close();
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