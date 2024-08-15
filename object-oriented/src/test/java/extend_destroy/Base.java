package extend_destroy;

/**
 * @author yangfan
 * @version 1.0
 * @description: TODO
 * @date 2024/8/15 9:39
 */
public class Base {
    private static final int MAX_NUM = 100;
    private int[] arr = new int[MAX_NUM];
    private int count;

    public void add(int number) {
        if (count < MAX_NUM) {
            arr[count] = number;
            count++;
        }
    }

    public void addAll(int[] numbers){
        for (int number : numbers) {
            add(number);
        }
    }
}

