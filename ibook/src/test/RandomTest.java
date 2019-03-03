import org.junit.Test;

import java.util.Random;

public class RandomTest {
    @Test
    public void test() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int i1 = random.nextInt(100);
            System.out.println(i1);
        }
    }
}
