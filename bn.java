package bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bn{
private final List<Acount> bankAccounts;
Scanner sc=new Scanner(System.in);

public bn() {
        bankAccounts = new ArrayList<>();
        }

public Acount isAccountExist(int accountID, String phoneNumber) {
        for (Acount account : bankAccounts) {
        if (account.getID() == accountID && account.getPhoneNumber().equals(phoneNumber)) {
        return account;
        }
        }
        System.out.println("One of the details is incorrect");
        return null;
        }

//overload method -
public Acount isAccountExist(String phoneNumber) {
        for (Acount account : bankAccounts) {
        if (account.getPhoneNumber().equals(phoneNumber)) {
        return account;
        }
        }
        System.out.println("One of the details is incorrect");
        return null;
        }

public void registerAccount() {
        System.out.println("First name?");
        String firstName = sc.next();
        System.out.println("Last name?");
        String lastName = sc.next();
        System.out.println("Phone number?");
        String phoneNumber = sc.next();
        if (isPhoneNumberCorrect(phoneNumber)) {
        bankAccounts.add(new Acount(firstName, lastName, phoneNumber));
        System.out.println("You have created account successfully!" + "\n" +
        "Your account ID is: " + bankAccounts.get(bankAccounts.size() - 1).getID());

        }
        }

public void loginAccount() {
        System.out.println("Please enter your ID:");
        int accountID = sc.nextInt();
        System.out.println("Please enter your phone number:");
        String phoneNumber = sc.next();
        System.out.println("1. check balance\n2.deposit\n3.withdrawal\n4.the phone number of the account you want to transfer to\n5.exit");
        if (isPhoneNumberCorrect(phoneNumber)) {
        Acount selectedAccount = isAccountExist(accountID, phoneNumber);
        boolean exitRequested = false;
        while (!exitRequested) {
        int choice = Integer.parseInt(sc.next());

        switch (choice) {
        case 1:
        System.out.println(selectedAccount.toString());
                System.out.println("1. check balance\n2.deposit\n3.withdrawal\n4.the phone number of the account you want to transfer to\n5.exit");
        break;
        case 2:
        System.out.println("Please enter deposit amount:");
        double depositAmount = sc.nextDouble();
        selectedAccount.depositMoney(depositAmount);
                System.out.println("1. check balance\n2.deposit\n3.withdrawal\n4.the phone number of the account you want to transfer to\n5.exit");
        break;
        case 3:
        System.out.println("Please enter withdrawal amount:");
        double withdrawalAmount = sc.nextDouble();
        selectedAccount.withdrawal(withdrawalAmount);
                System.out.println("1. check balance\n2.deposit\n3.withdrawal\n4.the phone number of the account you want to transfer to\n5.exit");
        break;
        case 4:
        System.out.println("Please enter the phone number of the account you want to transfer to: ");
        String accountPhoneNumber = sc.next();
        if (isPhoneNumberCorrect(accountPhoneNumber)) {
        Acount accountToTransfer = isAccountExist(accountPhoneNumber);
        System.out.println("Enter the amount of money you would like to transfer:");
        double moneyToTransfer = sc.nextDouble();
        selectedAccount.moneyTransfer(selectedAccount, accountToTransfer, moneyToTransfer);
                System.out.println("1. check balance\n2.deposit\n3.withdrawal\n4.the phone number of the account you want to transfer to\n5.exit");
        break;
        }
        case 5:
        exitRequested = true;
                System.out.println("1.Register" + "\n" +
                        "\r" + "2.Log in" + "\n" +
                        "\r" + "3.Exit");
        break;
default:
        System.out.println("Wrong input");
        break;
        }
        }
        }
        }

public static boolean isPhoneNumberCorrect(String phoneNumber){
        if(phoneNumber.length() != 10){
        System.out.println("Phone number must be 10 digits.");
        return false;

        } else {
        return true;
        }
        }}

