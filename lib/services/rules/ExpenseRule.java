import java.util.Optional;

public interface ExpenseRule {
    public Optional<Violation> check(Expense expense);
}
