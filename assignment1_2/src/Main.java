public class Main {
    public static void main(String[] args) {
        BankManager manager = new BankManager();

        try {
            // 새로운 계좌 생성 및 추가
            BankAccount account1 = new SavingsAccount("1001", 500.0, 0.02);
            BankAccount account2 = new CheckingAccount("1002", 1000.0, 300.0);

            // 계좌 추가
            manager.addAccount(account1);
            manager.addAccount(account2);

            BankAccount account3 = new CheckingAccount("1002", 700.0, 300.0);

            // 중복 계좌 추가 시도
            try {
                manager.addAccount(account3); // 중복 계좌 추가
            } catch (DuplicateAccountException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // 입금 테스트
            try {
                manager.deposit("1001", 200.0);
                System.out.println("Deposit successful. New balance: " + account1.getBalance());
            } catch (AccountNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // 출금 테스트 (잔액 충분)
            try {
                manager.withdraw("1001", 100.0);
                System.out.println("Withdrawal successful. New balance: " + account1.getBalance());
            } catch (AccountNotFoundException | InsufficientBalanceException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // 출금 테스트 (잔액 부족 시도)
            try {
                manager.withdraw("1001", 1000.0); // 잔액 부족
            } catch (AccountNotFoundException | InsufficientBalanceException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // 오버드래프트 테스트 (허용 한도 내)
            try {
                manager.withdraw("1002", 1200.0); // 허용된 오버드래프트 한도 내
                System.out.println("Overdraft withdrawal successful. New balance: " + account2.getBalance());
            } catch (AccountNotFoundException | InsufficientBalanceException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // 오버드래프트 한도 초과 테스트
            try {
                manager.withdraw("1002", 200.0); // 오버드래프트 한도 초과
            } catch (AccountNotFoundException | InsufficientBalanceException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // 존재하지 않는 계좌 조회
            try {
                BankAccount nonExistentAccount = manager.findAccount("9999");
                System.out.println("Found account: " + nonExistentAccount);
            } catch (AccountNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // 모든 계좌 출력
            System.out.println("All accounts:");
            manager.printAllAccounts();

        } catch (DuplicateAccountException e) {
            System.out.println("Error while adding account: " + e.getMessage());
        }
    }
}
