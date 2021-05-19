package class02.parctice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhy
 * @since 2021/5/18 17:03
 */
public class EvenTimesOddTimes {
    public static int[] arr = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5};

    public static int oddTimesNum(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        return eor;
    }

    public static Map<String, Integer> TwoOddTimsNum(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        //eor = a ^ b
        //a ！= b;
        //假设a,b在第x位上一定有一个是1另一个为零
        int rightOne = eor & (~eor + 1);//取 a ^ b 最右边的1
        int _eor = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                _eor ^= arr[i];
            }
        }
        int a = eor ^ _eor;
        int b = _eor;
        HashMap<String, Integer> nums = new HashMap<>();
        nums.put("a", a);
        nums.put("b", b);
        return nums;
    }

    public static int bitCounts(int num) {
        int count = 0;
        while (num != 0) {
            int rightOne = num & (-num);
            num ^= rightOne;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Map<String, Integer> stringIntegerMap = TwoOddTimsNum(arr);
        System.out.println(stringIntegerMap);
    }
}
