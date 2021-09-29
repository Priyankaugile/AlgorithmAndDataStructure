package com.unorderedlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ReadWriteData {
    static String filePath = "C:\\Users\\HP\\Desktop\\BdzJAVA\\AlgorithmPrograms\\src\\com\\unorderedlist\\data.txt";

    public static ArrayList<String> readFile() {
        ArrayList<String> dataArray = new ArrayList<>();
        String data = " ";

        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()){
                data = myReader.nextLine().replaceAll(",", data);
                String[] data1 = data.split("\\W+");
                Collections.addAll(dataArray, data1);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return dataArray;
    }

    public static void writeFile(ArrayList<String> data) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(data.toString());
        fw.flush();
    }
}
