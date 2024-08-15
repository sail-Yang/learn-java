package extend_destroy;

/**
 * @author yangfan
 * @version 1.0
 * @description: 用组合而不是继承
 * @date 2024/8/15 9:46
 */
public class ChildComposition {
    private Base base;
    private long sum;
    public ChildComposition() {
        base = new Base();
    }
    public void add(int number) {
        base.add(number);
        sum += number;
    }

    public void addAll(int[] numbers) {
        base.addAll(numbers);
        for(int i=0;i<numbers.length;i++) {
            sum += numbers[i];
        }
    }

    public long getSum() {
        return sum;
    }
}
