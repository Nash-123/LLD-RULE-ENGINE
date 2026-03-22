
import java.util.HashMap;
import java.util.List;

// Just a config file that will ensure which all Expense are following which all rules
public class RuleRegistry {
    public static HashMap<ExpenseType, List<ExpenseRule>> getExpenseRuleRegistry() {
        HashMap<ExpenseType, List<ExpenseRule>> registryMap = new HashMap<>();

        registryMap.put(ExpenseType.airfare, List.of(
                new DisallowRule(),
                new MaxAmountRule(75.0)));

        registryMap.put(ExpenseType.entertainment, List.of(
                new DisallowRule()));

        registryMap.put(ExpenseType.restaurant, List.of(
                new MaxAmountRule(75.0)));

        return registryMap;
    }

    public static List<ExpenseRule> getAllExpenseRuleRegistry() {
        return List.of(
                new MaxAmountRule(250.0));
    }

    public static List<TripRule> getAllTripRuleRegistry() {
        return List.of(
                new TripTotalMaxRule(1000.0));
    }
}

// {
// "getExpenseRuleRegistry": [
// {
// "ExpenseType": "airfare",
// "Rules": [
// {
// "RuleType": "DisallowRule",
// "MaxAmountRule": 75.0
// }
// ]
// }
// ]
// }

/*
 * 
 * // Represent above like a yaml config
 * 
 * // getExpenseRuleRegistry:
 * // - ExpenseType: "airfare"
 * // Rules:
 * // - RuleType: "DisallowRule"
 * // - ExpenseType: "entertainment"
 * // Rules:
 * // - RuleType: "DisallowRule"
 * // - ExpenseType: "restaurant"
 * // Rules:
 * // - RuleType: "MaxAmountRule"
 * // MaxAmount: 75.0
 * //
 */