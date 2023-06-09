package franxx.code.test;

import franxx.code.test.generator.SimpleDisplayNameGenerator;
import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
// @DisplayName("Test Untuk Calculator Class")
public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before All");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After All");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Before each");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("After each");
    }

    @Test
    // @DisplayName("Test skenario sukses untuk method add(int, int)")
    public void testAddSuccess() {
        var result = calculator.add(10, 10);
        assertEquals(20, result);
//        if (result != 20) {
//            throw new RuntimeException("Test Gagal");
//        }
    }

    @Test
    public void testDivideSuccess() {
        var result = calculator.divide(100, 10);
        assertEquals(10, result);
    }

    @Test
    public void testDivideFailed() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
    }

    @Test
    @Disabled
    public void testComingSoon() {

    }

    @Test
    public void testAborted() {
        var profile = System.getenv("PROFILE");
        if (!"DEV".equals(profile)) {
            throw new TestAbortedException("Test di batalkan");
        }

        // unit test untuk dev
    }

    @Test
    public void testAssumption() {
        assumeTrue("DEV".equals(System.getenv("PROFILE")));

        // unit test untuk dev
    }
}
