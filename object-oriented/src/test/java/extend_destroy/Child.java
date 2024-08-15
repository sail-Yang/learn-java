package extend_destroy;

/**
 * @author yangfan
 * @version 1.0
 * @description: TODO
 * @date 2024/8/15 9:39
 */
public class Child extends Base{
    private long sum;

    @Override
    public void add(int number) {
        super.add(number);
        sum += number;
    }

    @Override
    public void addAll(int[] numbers) {
        super.addAll(numbers);
        for(int i=0;i<numbers.length;i++){
            sum += numbers[i];
        }
    }

    public long getSum() {
        return sum;
    }
}
