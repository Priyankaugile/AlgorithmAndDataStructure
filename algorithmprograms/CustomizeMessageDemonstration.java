package com.algorithmprograms;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomizeMessageDemonstration {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String message = "Hello <<name>>,\n We have your full name as <<full name>> in our system." +
                "\n your contact number is 91-xxxxxxxxxx." +
                "\nPlease,let us know in case of any clarification" +
                "\n Thank you BridgeLabz 01/01/2016.";

        System.out.println("Enter your first name: ");
        String firstName = input.next();

        System.out.println("Enter your last name: ");
        String lastName = input.next();

        System.out.println("Enter your phone number: ");
        String phoneNumber = input.next();



        String regex1 = "<<name>>";
        String regex2 = "<<full name>>";
        String regex3 = "xxxxxxxxxx";

        String replaceFirstName = firstName;
        String replaceFullName = firstName + " " + lastName;
        String replacePhone = phoneNumber;

        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);
        Pattern pattern3 = Pattern.compile(regex3);

        Matcher matches1 = pattern1.matcher(message);
        message = matches1.replaceAll(replaceFirstName);
        System.out.println("*******************************************************");
        System.out.println(message);

        Matcher matches2 = pattern2.matcher(message);
        message = matches2.replaceAll(replaceFullName);
        System.out.println("*******************************************************");
        System.out.println(message);

        Matcher matches3 = pattern3.matcher(message);
        message = matches3.replaceAll(replacePhone);
        System.out.println("*******************************************************");
        System.out.println(message);

        String[] messageArray = message.split(regex1 + " " + regex2 + " " +regex3);

        String number = "^[0-9]{1,}\\s[0-9]{3,}$";
        Pattern data = Pattern.compile(number);

        for(int i=0; i< messageArray.length; i++) {
            String message1 = messageArray[i].replace(" ", ".");
            Matcher matches4 = data.matcher(message1);
            if(matches4.matches()) {
                Date date = new Date();
                message1 = matches4.replaceAll(date.toString());
                messageArray[i] = message1;
            }
        }
    }
}
