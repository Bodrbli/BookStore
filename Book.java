class Book {
    private String title;
    private String author;
    private String publisher;
    private int pageCount;
    private String genre;
    private int year;
    private double costPrice;
    private double sellingPrice;
    private boolean isContinuation;

    // Конструктор
    public Book(String title, String author, String publisher,
                int pageCount, String genre, int year,
                double costPrice, double sellingPrice,
                boolean isContinuation) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pageCount = pageCount;
        this.genre = genre;
        this.year = year;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.isContinuation = isContinuation;
    }

    // Геттеры и сеттеры
    // ...

    // Переопределение метода toString() для удобного вывода информации о книге
    @Override
    public String toString() {
        return "Название: " + title +
                "\nАвтор: " + author +
                "\nИздательство: " + publisher +
                "\nКоличество страниц: " + pageCount +
                "\nЖанр: " + genre +
                "\nГод издания: " + year +
                "\nСебестоимость: " + costPrice +
                "\nЦена продажи: " + sellingPrice +
                "\nПродолжение: " + (isContinuation ? "Да" : "Нет") +
                "\n";
    }
}
