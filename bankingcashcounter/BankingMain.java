package com.bankingcashcounter;

import java.util.ArrayList;
import java.util.Scanner;

public class BankingMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PersonInformation person1 = new PersonInformation("Immanuvel", 12345, 10000);
        PersonInformation person2 = new PersonInformation("Jeeva", 67890, 12000);
        PersonInformation person3 = new PersonInformation("Surya", 24680, 14000);

        ArrayList<PersonInformation> personInfos = new ArrayList<>();
        personInfos.add(person1);
        personInfos.add(person2);
        personInfos.add(person3);

        String[] personNumber = new String[personInfos.size()];
        for(int i=0; i<personNumber.length; i++)
            personNumber[i] = Long.toString(personInfos.get(i).getAccountNumber());

        Queue queue = new Queue(personNumber.length);

        for (String s : personNumber) queue.enqueue(s);

        for(int i = 0; i < personNumber.length; i++) {
            boolean flag = true;
            System.out.println("\nPerson" + +(i+1));
            System.out.println("Press 1 to withdraw money :");
            System.out.println("Press 2 to deposit money :");
            int choice = input.nextInt();

            switch(choice) {
                case 1:
                    while (flag) {
                        System.out.print("Enter your account number: ");
                        String accNumber = input.next();
                        if (personNumber[i].equals(accNumber)) {
                            long balance = personInfos.get(i).getTotalBalance();
                            System.out.println("Balance = "+balance);
                            System.out.print("Enter the amount you want to withdraw: ");
                            long amount = input.nextLong();
                            personInfos.get(i).setTotalBalance(balance - amount);
                            System.out.println("Current Balance = "+personInfos.get(i).getTotalBalance());
                            queue.dequeue();
                            flag = false;
                        }
                        else
                            flag = true;
                    }
                    break;
                case 2:
                    while (flag) {
                        System.out.print("Enter your account number: ");
                        String accountNumber = input.next();
                        if (personNumber[i].equals(accountNumber)) {
                            long balance = personInfos.get(i).getTotalBalance();
                            System.out.println("Balance = "+balance);
                            System.out.print("Enter the amount you want to deposit: ");
                            long amount = input.nextLong();
                            personInfos.get(i).setTotalBalance(balance + amount);
                            System.out.println("Current Balance = "+personInfos.get(i).getTotalBalance());
                            queue.dequeue();
                            flag = false;
                        }
                    }
                    break;
            }
        }

        if(queue.isEmpty())
            System.out.println("\nQueue is empty. Arithmetic Expression is balanced.");
        else
            System.out.println("\nQueue is not empty. Arithmetic Expression is not balanced.");
    }
}
