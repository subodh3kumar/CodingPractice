package workshop.map;

import workshop.model.Account;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByMap {

    public static void main(String[] args) {

        List<Account> accounts = Account.getAccounts();
        //accounts.forEach(System.out::println);

        Map<String, List<Account>> accountTypeMap1 = accounts.stream().collect(Collectors.groupingBy(Account::accountType,
                Collectors.mapping(account -> account, Collectors.toList())));

        Map<String, List<Account>> accountTypeMap2 = accounts.stream().collect(Collectors.groupingBy(Account::accountType));

        Map<String, List<Account>> accountTypeMap3 = accounts.stream().collect(Collectors.groupingBy(GroupByMap::accountType));

        //System.out.println(accountTypeMap1);
        //System.out.println(accountTypeMap2);
        accountTypeMap3.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));
        List<Account> accounts1 = accountTypeMap3.get("Salary");
        accounts1.forEach(System.out::println);
    }

    private static String accountType(Account account) {
        return "Salary".equals(account.accountType()) ? "Salary" : "Other";
    }
}
