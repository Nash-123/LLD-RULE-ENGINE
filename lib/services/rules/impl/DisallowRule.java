
import java.util.Optional;

public class DisallowRule implements ExpenseRule {

    @Override
    public Optional<Violation> check(Expense e) {
        return Optional.of(Violation.of("Expense Type " + e.getExpenseType() + " and id: "
                + e.getExpenseId() + " is not allowed"));
    }
}