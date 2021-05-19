package class01.practice;

/**
 * @author zhy
 * @since 2021/5/18 16:46
 */
public class BSAwesome {
    public static int getPartMin(int[] arr){
        if(arr == null && arr.length == 0){
            return -1;
        }

        if(arr.length == 1 || arr[0] < arr[1]){
            return 0;
        }

        if(arr[arr.length - 1] < arr[arr.length - 2]){
            return arr.length - 1;
        }
        int right = 0;
        int left = arr.length - 1;
        int mid = 0;
        while (left < right){
            mid = (right + left) / 2;
            if(arr[mid] > arr[mid - 1]){
                right = mid - 1;
            }
            else if(arr[mid] > arr[mid + 1]){
                left = mid + 1;
            }
            return mid;
        }
        return left;
    }
}
