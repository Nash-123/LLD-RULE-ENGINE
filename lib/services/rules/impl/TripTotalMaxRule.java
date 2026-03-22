import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TripTotalMaxRule implements TripRule {

    private final Double tripTotalMax;

    TripTotalMaxRule(Double _tripTotalMax) {
        this.tripTotalMax = _tripTotalMax;
    }

    @Override
    public Optional<Violation> check(List<Expense> expenses) {

        // For now we're expecting all expenses to belong to same trip
        // What if we take inputs of expenses belonging to different trip_id

        if (!ExpenseUtils.areAllExpensesBelongToSameTrip(expenses)) {
            return Optional.of(Violation.of("All Expenses don't belong to same trip"));
        }

        // Double totalExpense = expenses.stream()
        // .collect(
        // Collectors.groupingBy(Expense::getTripId,
        // Collectors.summarizingDouble(Expense::getAmountUsd)));

        double totalExpense = expenses.stream().mapToDouble(Expense::getAmountUsd).sum();

        if (totalExpense > tripTotalMax) {
            return Optional.of(Violation
                    .of("Total Expense of the Trip with id" + expenses.get(0).getTripId()
                            + " has exceeded the expense limit"));
        }

        return Optional.empty();
    }
}
