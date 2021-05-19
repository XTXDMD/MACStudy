package class01.practice;

import java.util.Arrays;

/**
 * @author zhy
 * @since 2021/5/18 15:03
 */
public class BubbleSort {
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for(int i = 0; i < testTime; i++){
            int[] arr = generateRandomArray(maxSize,maxValue);
            int[] arr1 = copyArray(arr);
            bubbleSort(arr);
            Arrays.sort(arr1);
            if(!isEqual(arr,arr1)){
                succeed = false;
                printArray(arr);
                printArray(arr1);
                return;
            }
        }
        System.out.println(succeed ? "Nice!" : "fucking dogshit!");
    }

    public static void bubbleSort(int[] arr){
        if(arr == null && arr.length < 2){
            return;
        }

        for (int i = arr.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j + 1]){
                    swap(arr,j,j+1);
                }
            }
        }


    }

    private static void swap(int[] arr, int k,int l){
//        arr[k] = arr[k] ^ arr[l];
//        arr[l] = arr[k] ^ arr[l];
//        arr[k] = arr[k] ^ arr[l];
        int a = arr[k];
        arr[k] = arr[l];
        arr[l] = a;
    }

    private static int[] generateRandomArray(int maxSize,int maxValue){
        int[] arr =  new int[maxSize];
        for (int i = 0; i < maxValue; i++){
            arr[i]  =(int)((Math.random() * maxValue) + 1 - (Math.random() * maxValue));
        }
        return arr;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}
