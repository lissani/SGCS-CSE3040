import java.util.HashMap;
import java.util.Map;
public class BankManager {
    private Map<String, BankAccount> accounts = new HashMap<>();
    public int num = 0;

    public void addAccount(BankAccount account) throws DuplicateAccountException {
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        for (BankAccount existingAccount : accounts.values()) {
            if (existingAccount.getAccountNumber().equals(account.getAccountNumber())) {
                throw new DuplicateAccountException("Account number already exists");
            }
        }
        num ++;
        String accountName = "account"+num;
        accounts.put(accountName, account);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    public BankAccount findAccount(String accountNumber) throws AccountNotFoundException {
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        BankAccount searchAccount = null;
        for(BankAccount account : accounts.values()){
            if(account.getAccountNumber().equals(accountNumber)){
                searchAccount = account;
            }
        }
        if(searchAccount == null){
            throw new AccountNotFoundException("Account not found");
        }
        return searchAccount;
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        BankAccount searchAccount = findAccount(accountNumber);
        searchAccount.deposit(amount);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    public void withdraw(String accountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException {
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        BankAccount searchAccount = findAccount(accountNumber);
        searchAccount.withdraw(amount);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    public void printAllAccounts() {
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        for(Map.Entry<String, BankAccount> entry : accounts.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue().getAccountNumber());
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////

    }
}
