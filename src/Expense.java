public class Expense {
    private int id;
    private String title;
    private double price;
    private String category;
    private static int counter = 1;

    public Expense(String title, double price, String category) {
        this.id = counter;
        this.title = title;
        this.price = price;
        this.category = category;

        counter += 1;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory(){
        return category;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
