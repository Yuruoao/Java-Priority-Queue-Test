import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {
/*
    PriorityQueue test_queue;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
*/

    @ParameterizedTest
    @ValueSource(strings = {"1, 22, 333", "1, 333, 22", "22, 1, 333, 4444", ", 22, 333, 1", "4444, 333, 1, 22", "333, 22, 1"})
    void testWithArrayOfStrings(String arg) {
        String[] arrayParam = arg.split("\\s*,\\s*");
        PriorityQueue<String> pqueueParam = new PriorityQueue<>(Arrays.asList(arrayParam));
        //Arrays.sort(arrayParam);
        for(String param : arrayParam){
            String queuePoll = pqueueParam.poll();
            assertEquals(queuePoll, param);
        }

    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceeds() {
        PriorityQueue queue = new PriorityQueue();
        Exception exception_add = assertThrows(NullPointerException.class, () -> {
            queue.add(null);
        });
        Exception exception_constructor = assertThrows(IllegalArgumentException.class, () -> {
            new PriorityQueue(0);
        });
        Exception exception_iterator_next = assertThrows(java.util.NoSuchElementException.class, () -> {
            queue.iterator().next();
        });
    }
}