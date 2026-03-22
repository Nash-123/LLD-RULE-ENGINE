import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class SimpleRuleEngine implements RuleEngine {
    @Override
    public List<Violation> evaluate(List<Expense> expenses,
            List<ExpenseRule> expenseRulesList,
            List<TripRule> tripRulesList,
            HashMap<ExpenseType, List<ExpenseRule>> registryMap) {

        List<Violation> violationsList = new ArrayList<>();

        // 1. Check all expenses against all expense rules
        for (Expense expense : expenses) {

            List<ExpenseRule> rules = registryMap.getOrDefault(expense.getExpenseType(), List.of());

            checkExpenseAgainstRules(expense, rules, violationsList);
            checkExpenseAgainstRules(expense, expenseRulesList, violationsList);
        }

        // 2. For every trip rule
        for (TripRule trip : tripRulesList) {
            Optional<Violation> tripViolation = trip.check(expenses);
            if (tripViolation.isPresent()) {
                violationsList.add(tripViolation.get());
            }
        }

        return violationsList;
    }

    private void checkExpenseAgainstRules(Expense expense, List<ExpenseRule> rules, List<Violation> violationsList) {
        for (ExpenseRule rule : rules) {
            Optional<Violation> violation = rule.check(expense);
            if (violation.isPresent()) {
                violationsList.add(violation.get());
            }
        }
    }
}