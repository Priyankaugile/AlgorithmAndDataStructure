package com.unorderedlist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LinkedListMain {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        ReadWriteData readWriteData = new ReadWriteData();
        ArrayList<String> dataArray = ReadWriteData.readFile();

        //convert the arraylist into array to pass it to the generic class
        String[] array = new String[dataArray.size()];
        array = dataArray.toArray(array);

        LinkedListUnorderedImplementation<String> unorderedImplementation = new LinkedListUnorderedImplementation<>(array);
        unorderedImplementation.insertBefore();
        unorderedImplementation.insertEnd();
        unorderedImplementation.insertAt();
        System.out.print("List after insertion in the linked list: ");
        unorderedImplementation.display();

        System.out.println();
        //Take input from the user to search for the word
        System.out.print("Enter the word you want to search from the file: ");
        String value = input.next();

        System.out.println("Element found " +unorderedImplementation.search(value));
        if(unorderedImplementation.search(value))
            unorderedImplementation.deleteNode(value);
        else
            unorderedImplementation.appendAtEnd(value);

        System.out.print("New list:\n");
        ArrayList<String> data = unorderedImplementation.display();

        ReadWriteData.writeFile(data);
    }
}
