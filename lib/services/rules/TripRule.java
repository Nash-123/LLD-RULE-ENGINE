import java.util.List;
import java.util.Optional;

import java.util.List;
import java.util.Optional;

public interface TripRule {
    Optional<Violation> check(List<Expense> e);
}
