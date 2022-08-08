package workshop.model;

import java.util.List;

public record Account(int accountNumber, String accountHolderName, String accountType) {

    public static List<Account> getAccounts() {
        return List.of(
                new Account(1001, "Subodh Kumar", "Salary"),
                new Account(1002, "Harsh Sharma", "Current"),
                new Account(1003, "Parth Kumar", "Saving"),
                new Account(1004, "Nidhi Sharma", "Current"),
                new Account(1005, "Deeksha Kumari", "Saving"),
                new Account(1006, "Akash Kumar", "Saving"),
                new Account(1007, "Juli Kumari", "Current"),
                new Account(1008, "Deepak Kumar", "Saving"),
                new Account(1009, "Bindiaya Kumari", "Saving"),
                new Account(1010, "Munna", "Salary")
        );
    }
}
