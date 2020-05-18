import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

    private static Stream<Arguments> provideStringsForPriorityQueue() {
        return Stream.of(
                Arguments.of("1, 22, 333", "1, 22, 333"),
                Arguments.of("22, 1, 333", "1, 22, 333"),
                Arguments.of("333, 1, 22", "1, 22, 333"),
                Arguments.of("333, 1, , 22", ", 1, 22, 333")
        );
    }
    @ParameterizedTest
    @MethodSource("provideStringsForPriorityQueue")
    void testWithArrayOfStrings(String input, String expected) {
        String[] inputParam = input.split("\\s*,\\s*");
        String[] expectedParam = expected.split("\\s*,\\s*");
        PriorityQueue<String> pqueueParam = new PriorityQueue<>(Arrays.asList(inputParam));
        for(String param : expectedParam){
            String queuePoll = pqueueParam.poll();
            assertEquals(param, queuePoll);
        }
    }

    @Test
    public void addElementIsNull() {
        PriorityQueue queue = new PriorityQueue();
        assertThrows(NullPointerException.class, () -> {
            queue.add(null);
        });
    }
    @Test
    public void constructorInitialCapacityIsZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PriorityQueue(0);
        });
    }
    @Test
    public void iteratorNextAEmptyQueue(){
        PriorityQueue queue = new PriorityQueue();
        assertThrows(java.util.NoSuchElementException.class, () -> {
            queue.iterator().next();
        });
    }
}
