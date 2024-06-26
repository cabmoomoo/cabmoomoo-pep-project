package Service;

import java.util.List;

import DAO.AccountDAO;
import Model.Account;

public class AccountService {
    
    private AccountDAO accountDAO;

    public AccountService() {
        this.accountDAO = new AccountDAO();
    }

    public List<Account> getAllAccounts() {
        return this.accountDAO.getAllAccounts();
    }

    public Account insertAccount(Account account) {
        if (account.username == null || account.username.isBlank()) {
            return null;
        }
        if (account.password == null || account.password.length() < 4) {
            return null;
        }
        List<Account> allAccounts = this.getAllAccounts();
        for (Account existingAccount : allAccounts) {
            if (account.username == existingAccount.username) {
                return null;
            }
        }
        return this.accountDAO.insertAccount(account);
    }

    public Account verifyLogin(Account account) {
        List<Account> allAccounts = this.getAllAccounts();
        for (Account existingAccount : allAccounts) {
            if (existingAccount.username.equals(account.username)) {
                if (existingAccount.password.equals(account.password)) {
                    return existingAccount;
                }
            }
        }
        return null;
    }

    public Account getAccountByID(int accountID) {
        return this.accountDAO.getAccountByID(accountID);
    }

}
