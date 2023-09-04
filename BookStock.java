import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookStock {
    private int discount;
    private List<Book> stockBook = new ArrayList<>();

    public BookStock(int discount) {

        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public List<Book> getStockBook() {
        return stockBook;
    }

    public void setStockBook(List<Book> stockBook) {
        this.stockBook = stockBook;
    }
    public void setBookPrice(Book book, int discount){
        try {
            book.setSellingPrice(book.getSellingPrice() - (book.getSellingPrice() * discount / 100));
        }catch (NullPointerException e){
            System.out.println("Книга не выбрана.");
        }
    }

    @Override
    public String toString() {
        return "Акция {" +
                "скидка = " + discount +
                ", книги = \n" + Arrays.toString(stockBook.toArray()) +
                '}';
    }
}
