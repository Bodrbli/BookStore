import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class BookStore {
    private static Map<String, Book> books;
    static {
        books = new HashMap<>();
        books.put("Книга джунглей", new Book("Книга джунглей", "Киплинг", "Macmillan Publishers", 358, "повесть", 1894, 284.45, 350, false));
        books.put("Вторая книга джунглей", new Book("Вторая книга джунглей", "Киплинг", "Macmillan Publishers", 405, "роман", 1895, 275.15, 350, true));
        books.put("Белый клык", new Book("Белый клык", "Лондон", "Macmillan and Company", 378, "повесть", 1906, 239.40, 330, false));
        books.put("Мартин Иден", new Book("Мартин Иден", "Лондон", "Macmillan Publishers", 417, "драма", 1909, 217.35, 300, false));
        books.put("Клан Кречета", new Book("Клан Кречета", "Торстон", "Армада", 345, "фантастика", 1995, 265.05, 300, false));
    }
    public BookStore() {

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

    public void editBook(String title) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        if (books.containsKey(title)) {
            Book book = books.get(title);
            System.out.println("Введите параметр который вы хотите изменить: ");
            System.out.println(book.toString());
            try {
                String edit = reader.readLine();
                if (edit.equals("Название")) {
                    System.out.println("Введите название: ");
                    String newTitle = reader.readLine();
                    book.setTitle(newTitle);
                    books.put(newTitle, books.remove(title));
                } else if (edit.equals("Автор")) {
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
                    boolean newIsContinue = reader.readLine().equals("Да");
                    book.setContinuation(newIsContinue);
                } else {
                    System.out.println("Вы ввели неверные данные.");
                }
            } catch (NumberFormatException | IOException a) {
                System.out.println("Вы ввели неверные данные.");
            }
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
    public void searchBook() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Выберите параметр поиска:\n" +
                            "1. По названию книги\n" +
                            "2. По автору\n" +
                            "3. По жанру");
        try {

        int choice = Integer.parseInt(reader.readLine());

        switch (choice) {
            case 1 -> {
                System.out.println("Введите название книги:");
                String title = reader.readLine();
                if (books.containsKey(title)) {
                    System.out.println(books.get(title).toString());
                } else {
                    System.out.println("Книга не найдена.");
                }
            }
            case 2 -> {
                System.out.println("Введите имя автора:");
                String author = reader.readLine();
                List<Book> authorSortBook = books.values().stream().filter(x -> x.getAuthor().equalsIgnoreCase(author)).toList();
                for (Book b : authorSortBook) {
                    System.out.println(b.getTitle());
                }
            }
            case 3 -> {
                System.out.println("Введите жанр:");
                String genre = reader.readLine();
                List<Book> genreSortBook = books.values().stream().filter(x -> x.getGenre().equalsIgnoreCase(genre)).toList();
                for (Book b : genreSortBook) {
                    System.out.println(b.getTitle() + " " + b.getAuthor() + " " + b.getGenre());
                }
            }
            default -> System.out.println("Неверный выбор, попробуйте снова.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void listOfNewBook() {
        int year = 2023;
        List<Book> newBook = books.values().stream().filter( x -> x.getYear()==year).toList();
        for (Book b : newBook) {
            System.out.println(b.toString());
        }
    }
    public void addBookToStock(String title) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Book book = books.get(title);

        int discount = 0;

        try {
            System.out.println("Введите размер скидки:");
            discount = Integer.parseInt(reader.readLine());

        } catch (IOException e) {
            throw new RuntimeException();
        }
        BookStock bookStock = new BookStock(discount);
        bookStock.setBookPrice(book, discount);
        bookStock.getStockBook().add(book);
        System.out.println("Книга добавлена в акцию.");
        System.out.println(bookStock);
    }
    public String addToWaitingList(String title){
        Book book = books.get(title);
        if (book != null) {
            WaitingList.waitingForSell.add(book);
            return "Книга ожидает клиента.";
        }
        return "Книга отсутствует";
    }


    public static class WaitingList {
        private static ArrayList<Book> waitingForSell = new ArrayList<>();

        public static ArrayList<Book> getWaitingForSell() {
            return waitingForSell;
        }
    }
    // Остальные методы для функциональностей приложения
    // ...
}