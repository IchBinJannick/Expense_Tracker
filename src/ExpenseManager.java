import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseManager {
    private ExpenseTracker tracker;
    private Scanner scanner;
    boolean running = true;

    public ExpenseManager(){
        tracker = new ExpenseTracker();
        scanner = new Scanner(System.in);
    }

    public void start(){
        while (running) {
            showMenu();
        }
    }

    public void showMenu(){
        System.out.println("Decide: Add new Expense(1) | Delete Expense(2) \n" +
                "| Show All Expenses(3) | Close(4)");
        int number = scanner.nextInt();
        scanner.nextLine(); // Puffer
        switch(number) {
            case 1:
                promptAdd();
                break;
            case 2:
                promptDel();
                break;
            case 3:
                promptAll();
                break;
            case 4:
                promptClose();
                break;
        }
    }

    public void promptAdd(){
        try {
            System.out.println("Enter: \"Title, Price, Category\"");
            String expenseString = scanner.nextLine();
            String[] a = expenseString.split(",");
            Expense expense = new Expense(a[0], Double.parseDouble(a[1]), a[2]);
            tracker.addExpense(expense);
        }
        catch (NumberFormatException e) {
            System.out.println("Error: The price must be a number! e.g. 12.5");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error: Use the format; \"Title, Price, Category \"");
        }
        catch (Exception e){
            System.out.println("Unexpected Error:" + e.getMessage());
        }
    }

    public void promptDel(){
        System.out.println("Enter expense ID, that you want to delete");
        int expenseId = scanner.nextInt();
        scanner.nextLine();

        boolean success = tracker.removeExpenseById(expenseId);
        if (success) {
            System.out.println("Expense successfully deleted!");
        } else {
            System.out.println("Expense with such ID not found.");
        }
    }

    public void promptAll(){
        ArrayList<Expense> expenses = tracker.getExpenses();

        for (Expense e : expenses) {
            System.out.println(e.toString());
        }
    }

    public void promptClose(){
        System.out.println("Do you really want to Close? (Y/N)");
        String answer = scanner.nextLine().toUpperCase();
        if (answer.equals("Y")) {
            running = false;
        }
    }
}
