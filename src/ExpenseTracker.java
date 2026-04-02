import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ExpenseTracker {
    private ArrayList<Expense> expenses;

    public ExpenseTracker() {
        expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public boolean removeExpenseById(int id){
        //  expenses.removeIf(e -> e.getId() == id);
        for (Expense e : expenses) {
            if (e.getId() == id) {
                expenses.remove(e);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Expense> getExpensesByCategory(String category){
        ArrayList<Expense> c = new ArrayList<>();
        for (Expense e : expenses){
            if (e.getCategory().equals(category)) {
                c.add(e);
            }
        }
        return c;
    }

    public Expense getExpenseById(int id){
        for (Expense e : expenses){
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public double getTotalPrice(){
        double sum = 0.0;
        for (Expense e : expenses){
            sum += e.getPrice();
        }
        return sum;
    }

    public ArrayList<Expense> getExpenses(){
        return this.expenses;
    }
}