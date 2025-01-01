public class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, double initialBalance, double overdraftLimit) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        // Fill in the overdraft check and withdraw logic
        // Answer:
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        if(getBalance()-amount < overdraftLimit*(-1)) {
            throw new InsufficientBalanceException("Insufficient balance [overdraft limit exceeded]");
        }
        setBalance(getBalance()-amount);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
    }
}
