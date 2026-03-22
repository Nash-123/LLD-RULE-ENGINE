import java.util.List;

public class ExpenseUtils {
    public static boolean areAllExpensesBelongToSameTrip(List<Expense> expenses){
       return expenses.stream().allMatch(e -> e.getTripId().equals(expenses.get(0).getTripId()));
        
    //    if(expenses.isEmpty()) return true;

    //    for(Expense exp : expenses){
    //         if(!exp.getTripId().equals(expenses.get(0).getTripId)){
    //             return false;
    //         }
    //    }
    //    return true;
    }
}