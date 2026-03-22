
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // 2 Main Service layers one is Model: Expense.java And ANother RuleEngine.java

        List<Expense> expenses = new ArrayList<>();

        expenses.add(new Expense("1", "Trip1", 10.0, ExpenseType.restaurant));
        expenses.add(new Expense("2", "Trip1", 20.0, ExpenseType.restaurant));
        expenses.add(new Expense("3", "Trip1", 100.0, ExpenseType.restaurant));

        // This is the controller
        RuleEngineRunner ruleEngineRunner = new RuleEngineRunner(new SimpleRuleEngine());

        ruleEngineRunner.run(expenses);
    }
}
