package telran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountBlockTest {
    AccountBlock accountBlock;
    List<Account> accountList;

    @BeforeEach
    public void init() {
        accountBlock = new AccountBlock();
        accountList = new ArrayList<>();
    }


    @Test
    public void testGetBlockedAccounts_emptyAccountsList_emptyList() {
        assertEquals(accountList, accountBlock.getBlockedAccounts(accountList, 1000));
    }

    @Test
    public void testGetBlockedAccounts_oneAccount_notBlocked() {
        Account account = new Account("V300", 5l, false);
        accountList.add(account);
        List<Account> expected = new ArrayList<>();
        assertEquals(expected, accountBlock.getBlockedAccounts(accountList, 1000));
    }

    @Test
    public void testGetBlockedAccounts_oneAccount_blocked() {
        Account account = new Account("V300", 5000l, false);
        accountList.add(account);

        assertEquals(accountList, accountBlock.getBlockedAccounts(accountList, 1000));
    }

    @Test
    public void testGetBlockedAccounts_add5Accounts_blocked3Accounts() {
        Account account1 = new Account("A124", 30000l, false);
        Account account2 = new Account("D12", 1001l, false);
        Account account3 = new Account("V300", 5l, false);
        Account account4 = new Account("B10", 46l, false);
        Account account5 = new Account("Q145", 2000l, false);

        accountList = Arrays.asList(account1, account2, account3, account4, account5);
        List<Account> expected = Arrays.asList(account1, account2, account5);

        assertEquals(expected, accountBlock.getBlockedAccounts(accountList, 1000));
    }

    @Test
    public void testGetSumOfBlockedAccounts_emptyList_0() {
        assertEquals(0, accountBlock.getSumOfBlockedAccounts(accountList));
    }


    @Test
    public void testGetSumOfBlockedAccounts_oneNotBlockedAccount_0() {
        Account account = new Account("V300", 5l, false);
        accountList.add(account);

        assertEquals(0, accountBlock.getSumOfBlockedAccounts(accountList));
    }


    @Test
    public void testGetSumOfBlockedAccounts_oneBlockedAccount_1010() {
        Account account = new Account("V300", 1010l, true);
        accountList.add(account);

        assertEquals(1010, accountBlock.getSumOfBlockedAccounts(accountList));
    }

    @Test
    public void testGetSumOfBlockedAccounts_9000() {
        Account account1 = new Account("A124", 3000l, true);
        Account account2 = new Account("D12", 2000l, true);
        Account account3 = new Account("V300", 5l, false);
        Account account4 = new Account("B10", 46l, false);
        Account account5 = new Account("Q145", 4000l, true);

        accountList = Arrays.asList(account1, account2, account3, account4, account5);

        assertEquals(9000, accountBlock.getSumOfBlockedAccounts(accountList));
    }

}