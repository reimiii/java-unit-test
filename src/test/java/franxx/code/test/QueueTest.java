package franxx.code.test;

import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.Queue;

@DisplayName("A Queue")
public class QueueTest {
    private Queue<String> queue;

    @Nested
    @DisplayName("when new")
    public class WhenNew {
        @BeforeEach
        void beforeEach() {
            queue = new LinkedList<>();
        }

        @Test
        @DisplayName("when offer, size mush be 1")
        void add() {
            queue.offer("Hilmi");
            Assertions.assertEquals(1, queue.size());
        }

        @Test
        @DisplayName("when offer 2 data, size mush be 2")
        void offerMoreData() {
            queue.offer("Hilmi");
            queue.offer("AM");
            Assertions.assertEquals(2, queue.size());
        }
    }
}
