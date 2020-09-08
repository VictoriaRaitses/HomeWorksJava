package telran;

import java.util.List;
import java.util.stream.Collectors;

public class AccountBlock {

    public List<Account> getBlockedAccounts(List<Account> accounts, long maxSum) {
        return accounts
                .stream()
                .filter(account -> account.getSum() >= maxSum)
                .map(account -> {
                    account.setLocked(true);
                    return account;
                })
                .collect(Collectors.toList());
    }

    public long getSumOfBlockedAccounts(List<Account> blockedAccount) {
        return blockedAccount
                .stream()
                .filter(account -> account.getLocked())
                .mapToLong(Account::getSum)
                .reduce(0, Long::sum);
    }
}
