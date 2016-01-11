package _2Friday;

import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Bank bank = new Bank();

    public static void main(String[] args) {
        String command = sc.nextLine();
        while (!command.equals("exit")) {
            if (command.equals("create_account")) {
                createAccount();
            } else if (command.equals("list_accounts")) {
                listAccounts();
            } else {
                System.out.print("Account ID: ");
                String accountId = sc.nextLine();
                BankAccount account = bank.get(accountId);

                if (account == null) {
                    System.err.println("An account with this ID doesn't exist.");
                    command = sc.nextLine();
                    continue;
                }

                if (command.equals("show_history")) {
                    showHistory(account);
                } else if (command.equals("add_money")) {
                    addMoney(account);
                } else if (command.equals("withdraw_money")) {
                    withdrawMoney(account);
                } else if (command.equals("transfer_money")) {
                    transferMoney(account);
                } else if (command.equals("calculate_amount")) {
                    calculateAmount(account);
                }
            }

            command = sc.nextLine();
        }
    }

    static private void createAccount() {
        System.out.print("First name: ");
        String firstName = sc.nextLine();

        System.out.print("Last name: ");
        String lastName = sc.nextLine();

        System.out.print("Birthdate (dd.MM.yyyy): ");
        String birthdate = sc.nextLine();

        System.out.print("Starting balance: ");
        String balance = sc.nextLine();

        System.out.print("Interest (in percent): ");
        String interest = sc.nextLine();

        System.out.print("Interest type (simple or complex): ");
        String interestType = sc.nextLine();

        try {
            BankAccount account = new BankAccount(firstName, lastName, birthdate,
                    balance, interest, interestType);
            bank.set(account);
            System.out.println(String.format("Account ID %s successfully created!", account.getId()));
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid numeric value entered.");
        } catch (NameCannotBeEmptyException e) {
            System.err.println("Error: Empty name field.");
        } catch (NoSuchInterestTypeException e) {
            System.err.println("Error: Invalid interest type. Please use \"simple\" or \"complex\"");
        } catch (DateTimeParseException e) {
            System.err.println("Error: Invalid birthdate.");
        }
    }

    static void showHistory(BankAccount account) {
        String[] history = account.getHistory();

        for (int i = history.length - 1; i >= 0; i--) {
            if (history[i] == null) {
                continue;
            }
            System.out.println(history[i]);
        }
    }

    static void addMoney(BankAccount account) {
        System.out.print("Amount: ");
        String amount = sc.nextLine();

        try {
            account.add(amount);
            System.out.println(String.format("%s successfully added to account ID %s", amount, account.getId()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    static void withdrawMoney(BankAccount account) {
        System.out.print("Amount: ");
        String amount = sc.nextLine();

        try {
            account.withdraw(amount);
            System.out.println(String.format("%s successfully withdrawn from account ID %s", amount, account.getId()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (InsufficientFundsException e) {
            System.err.println(String.format("Error: Insufficient funds. Balance: %s", account.getBalance()));
        }
    }

    static void transferMoney(BankAccount origin) {
        System.out.print("Recipient ID: ");
        String destinationId = sc.nextLine();

        System.out.print("Amount: ");
        String amount = sc.nextLine();

        try {
            bank.transfer(origin.getId(), destinationId, amount);
            System.out.println(String.format("%s successfully transferred from account ID %s to account ID %s",
                                             amount, origin.getId(), destinationId));
        } catch (InsufficientFundsException e) {
            System.err.println(String.format("Error: Insufficient funds. Balance: %s", origin.getBalance()));
        }
    }

    static void calculateAmount(BankAccount account) {
        System.out.print("Months: ");
        String months = sc.nextLine();

        double amount = account.calculateAmount(months);
        System.out.println(String.format("Resulting amount: %d", amount));
    }

    static void printHorizontalRule() {
        for (int i = 0; i < 80; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    static void printAccount(BankAccount account) {
        System.out.println("Account ID: " + account.getId());
        System.out.println("First name: " + account.getFirstName());
        System.out.println("Last name: " + account.getLastName());
        System.out.println("Age: " + account.getOwnerAge());
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Interest: " + account.getInterest() + "% (" + account.getInterestType() + ")");
    }

    static void listAccounts() {
        Iterator it = bank.m_accounts.entrySet().iterator();

        if (it.hasNext()) {
            printHorizontalRule();
        } else {
            System.out.println("No accounts.");
        }

        while (it.hasNext()) {
            Map.Entry<String, BankAccount> pair = (Map.Entry) it.next();
            BankAccount account = pair.getValue();

            printAccount(account);

            printHorizontalRule();
        }
    }
}
