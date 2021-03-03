import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

class HomeWorkTest {
    static HomeWork hw;

    @BeforeAll
    static void init() {
        hw = new HomeWork();
    }

    private static Stream<Arguments> extractTestData() {
        List<Arguments> data = new LinkedList<>();
        data.add(Arguments.arguments(new int[] {1, 2, 4, 4, 2, 3, 4, 1, 7}, 4, new int[] {1, 7}));
        data.add(Arguments.arguments(new int[] {1, 2, 3, 5, 2, 3, 2, 1, 7}, 5, new int[] {2, 3, 2, 1, 7}));
        data.add(Arguments.arguments(new int[] {1, 2, 3, 5, 2, 3, 2, 1, 7}, 5, new int[] {2, 3}));
        data.add(Arguments.arguments(new int[] {1, 2, 5, 4, 5, 3, 4, 1, 7}, 5, new int[] {3, 4, 1, 7}));
        data.add(Arguments.arguments(new int[] {1, 2, 3, 5, 2, 3, 2, 1, 7}, 5, new int[] {2, 3, 2, 1, 6}));
        return data.stream();
    }

    @MethodSource("extractTestData")
    @ParameterizedTest
    void extractTest(int[] a, int afterWhat, int[] r) {
        Assertions.assertArrayEquals(r, hw.extract(a, afterWhat));
    }

    private static Stream<Arguments> containTestData() {
        List<Arguments> data = new LinkedList<>();
        data.add(Arguments.arguments(new int[] {1, 1, 1, 4, 4, 1, 4, 4}, 1, 4, true));
        data.add(Arguments.arguments(new int[] {1, 1, 1, 1, 1, 1}, 1, 4, false));
        data.add(Arguments.arguments(new int[] {4, 4, 4, 4}, 1, 4, false));
        data.add(Arguments.arguments(new int[] {1, 4, 4, 1, 1, 4, 3}, 1, 4, false));
        data.add(Arguments.arguments(new int[] {1, 5, 1, 5, 1, 1, 5}, 1, 5, true));
        return data.stream();
    }

    @MethodSource("containTestData")
    @ParameterizedTest
    void containTest(int[] a, int firstValue, int secondValue, boolean res) {
        Assertions.assertEquals(res, hw.contain(a, firstValue, secondValue));
    }
}