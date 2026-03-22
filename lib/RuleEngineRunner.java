import java.util.HashMap;
import java.util.List;

// This is the controller layer -> Service

public class RuleEngineRunner {
    private final RuleEngine ruleEngine;

    public RuleEngineRunner(RuleEngine _ruleEngine) {
        this.ruleEngine = _ruleEngine;
    }

    public void run(List<Expense> expenses) {

        System.out.println("Running RuleEngineRunner with expenses: " + expenses);

        List<ExpenseRule> expenseRulesList = RuleRegistry.getAllExpenseRuleRegistry();
        List<TripRule> tripRulesList = RuleRegistry.getAllTripRuleRegistry();
        HashMap<ExpenseType, List<ExpenseRule>> registryMap = RuleRegistry.getExpenseRuleRegistry();

        System.out.println(
                "Loaded " + expenseRulesList.size() + " expense rules and " + tripRulesList.size() + " trip rules.");

        List<Violation> violationsList = new SimpleRuleEngine().evaluate(expenses, expenseRulesList,
                tripRulesList, registryMap);

        System.out.println("Number of violations found: " + violationsList.size());
        violationsList.forEach(v -> System.out.println(v.getMessage()));
    }

}
