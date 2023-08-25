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

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public boolean isContinuation() {
        return isContinuation;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setContinuation(boolean continuation) {
        isContinuation = continuation;
    }

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
