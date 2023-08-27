import java.util.Scanner;

class Account {
    protected String u_id;
    protected String u_p;
    Scanner sc = new Scanner(System.in);

    void createAcc() {
        System.out.println("Enter username:");
        u_id = sc.nextLine();
        System.out.println("Enter Password:");
        u_p = sc.nextLine();
        System.out.println(" Congratulation ! Account has been created sucessfully");
    }
}

class LoginAcc extends Account {
    private String id;
    private String p;

    void login() {
        do {
            System.out.println("Enter username:");
            id = sc.nextLine();
            if (u_id.equals(id)) {
                do {
                    System.out.println("Enter Password:");
                    p = sc.nextLine();
                    if (p.equals(u_p)) {
                        System.out.println("Login successful !");
                    } else {
                        System.out.println("Wrong Password ! Please Enter correct password");
                    }

                } while (p.equals(u_p) == false);
            } else {
                System.out.println("Wrong Password ! Please Enter correct password");
            }
        } while (u_id.equals(id) == false);

    }
}

class Deposit {
    int amount;
    int balance = 10000;
    int prevtransaction = 0;
    String Transactionhistory = "";
    Scanner scn = new Scanner(System.in);

    void Display() {
        System.out.println("Enter amount deposit:");
        amount = scn.nextInt();
        if (amount != 0) {
            prevtransaction++;
            balance = balance + amount;
            prevtransaction = amount;
            String str = amount + "rs deposited\n";
            Transactionhistory = Transactionhistory.concat(str);
            System.out.println("Amount is Successfully Deposited !");
        }
    }
}

class Withdraw extends Deposit {

    void cash() {
        System.out.println("Enter amount to withdraw:");
        amount = scn.nextInt();
        if (balance > amount) {
            if (amount <= 5000) {
                prevtransaction++;
                balance = balance - amount;
                prevtransaction = prevtransaction - amount;
                System.out.println("Amount withdraw successfully !");
                String str = amount + "rs withdrawed\n";
                Transactionhistory = Transactionhistory.concat(str);
            } else {
                System.out.println("Sorry !.........limit is 5000");
            }
        } else {
            System.out.println("Insufficient amount to withdraw !");
        }
    }
}

class Transfer extends Withdraw {
    void forward() {
        int bank_acc;
        int ac;
        int r_accbalance = 0;
        System.out.println("Enter amount to transfer: ");
        amount = scn.nextInt();
        if (balance < amount) {
            System.out.println("balance is not sufficient !");
        } else {
            
            this.balance = this.balance - amount;
            r_accbalance += amount;
            System.out.println("Your account balance becomes $ " + this.balance);
            
            String str = amount + " Rs transfered";
            Transactionhistory = Transactionhistory.concat(str);
        }

    }
}

class CheckBalance extends Transfer {
    void check() {
        System.out.println("\n available balance::" + balance + " Rs");
    }

}

class TransactionHistory extends CheckBalance {
    void history() {
        if (prevtransaction == 0) {
            System.out.println("\nEmpty");
        } else {

            System.out.println("\n" + Transactionhistory);
        }
    }
}

class AtmInterface {
    public static void main(String[] args) {
        System.out.println("WELCOME TO OUR BANK");
        LoginAcc l = new LoginAcc();
        l.createAcc();
        System.out.println("WELCOME BACK TO OUR BANK");
        
        l.login();

        int ch;
        Scanner scn = new Scanner(System.in);
        TransactionHistory t = new TransactionHistory();
        while (true) {
            System.out.println("\n");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Cash Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.println("Enter your Choice:");
            
            ch = scn.nextInt();
            switch (ch) {
                case 1:

                   t.history();
                    break;

                case 2:
                    t.cash();
                     break;

                case 3:

                    t.Display();
                    break;

                case 4:

                    t.forward();
                    break;

                case 5:
                    System.out.println("Thank you !");
                    System.exit(ch);
                    break;

                default:
                    System.out.println("Enter valid choice!");
            }

        }

    }

}


   
