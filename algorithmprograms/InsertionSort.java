package com.algorithmprograms;

public class InsertionSort {
    public static void main(String[] args){
        System.out.println("Sorted array");
        String[] arr ={"E","D","C","G","A","B","O","Z","N","P"};
        int count = 0;
        String[] sortedArray = sortSub(arr, arr.length);
        for (String s : sortedArray) {
            System.out.println(s);


        }
    }

    public static String[] sortSub(String[] array, int n){
        String temp;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(array[i].compareToIgnoreCase(array[j])>0){
                    temp = array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
        return array;
    }
}
