public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        // Fill in the interest calculation and deposit logic
        // Answer:
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        setBalance(getBalance() + interestRate*getBalance());
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
    }
}
