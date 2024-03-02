package bank;
import java.util.Scanner;

 public class main {
    public static void main(String[] args) {


            Scanner sc = new Scanner(System.in);
            bn bank = new bn();

            {
                boolean exitRequested = false;
                while (!exitRequested) {
                    System.out.println("Hello, press: " + "\n" +
                    "\r" + "1.Register" + "\n" +
                    "\r" + "2.Log in" + "\n" +
                    "\r" + "3.Exit");
                    int choice = Integer.parseInt(sc.next());

                    switch (choice) {
                        case 1:
                            bank.registerAccount();
                            break;
                        case 2:
                            bank.loginAccount();
                            break;
                        case 3:
                            exitRequested = true;
                            break;
                        default:
                            System.out.println("Wrong input");
                            break;
                    }
                }
            }
        }
    }
