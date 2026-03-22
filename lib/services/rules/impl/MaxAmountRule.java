import java.util.Optional;

public class MaxAmountRule implements ExpenseRule {

    private final Double maxAmount;

    public MaxAmountRule(Double _maxAmount) {
        this.maxAmount = _maxAmount;
    }

    @Override
    public Optional<Violation> check(Expense e) {
        if (e.getAmountUsd() > maxAmount) {
            return Optional.of(Violation.of("Maximum amount of expense " + e.getExpenseType() + " exceeds ${}"
                    .replace("{}", maxAmount.toString()) + " with expense id: " + e.getExpenseId()));
        }

        return Optional.empty();
    }
}
