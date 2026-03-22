import java.util.HashMap;
import java.util.List;

// Business Logic
// Evaluate and give output
public interface RuleEngine {
    public List<Violation> evaluate(List<Expense> expenses,
            List<ExpenseRule> expenseRulesList,
            List<TripRule> tripRulesList,
            HashMap<ExpenseType, List<ExpenseRule>> registryMap);
}