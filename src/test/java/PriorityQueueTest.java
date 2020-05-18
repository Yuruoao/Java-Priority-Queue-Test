import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {
    @Test
    void testWithInt() {
        List<Integer> inputParam = Arrays.asList(5, 6, 2);
        int[] expectedParam = {2, 5, 6};
        PriorityQueue<Integer> pQueueParam = new PriorityQueue<>(inputParam);
        for(int param : expectedParam){
            int queuePoll = pQueueParam.poll();
            assertEquals(param, queuePoll);
        }
    }

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
        PriorityQueue<String> pQueueParam = new PriorityQueue<>(Arrays.asList(inputParam));
        for(String param : expectedParam){
            String queuePoll = pQueueParam.poll();
            assertEquals(param, queuePoll);
        }
    }

    @Test
    void addElementIsNull() {
        PriorityQueue queue = new PriorityQueue();
        assertThrows(NullPointerException.class, () -> {
            queue.add(null);
        });
    }
    @Test
    void constructorInitialCapacityIsZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PriorityQueue(0);
        });
    }
    @Test
    void iteratorNextAEmptyQueue(){
        PriorityQueue queue = new PriorityQueue();
        assertThrows(java.util.NoSuchElementException.class, () -> {
            queue.iterator().next();
        });
    }
}
