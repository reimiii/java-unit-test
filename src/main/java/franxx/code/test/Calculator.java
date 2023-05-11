package franxx.code.test;

public class Calculator {
    public Integer divide(Integer f, Integer s) {
        if (s == 0) {
            throw new IllegalArgumentException("Cannot divide by 0");
        } else {
            return f / s;
        }
    }

    public Integer add(Integer f, Integer s) {
        return f + s;
    }
}
