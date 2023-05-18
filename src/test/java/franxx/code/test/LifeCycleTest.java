package franxx.code.test;

import org.junit.jupiter.api.Test;

public class LifeCycleTest {
    private String temp;

    @Test
    void testA() {
        temp = "Hilmi";
    }

    @Test
    void testB() {
        System.out.println(temp);
    }
}
