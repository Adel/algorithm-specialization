package week1.assignment;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import utils.TestFiles;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class check_bracketsTest {

    @TestFactory
    Collection<DynamicTest> checkString() throws IOException {
        return TestFiles.loadFiles("check_brackets")
                .entrySet()
                .stream()
                .map(e -> DynamicTest.dynamicTest(e.getKey(), () -> assertEquals(e.getValue().getOutput(), check_brackets.checkString(e.getValue().getInput()))))
                .collect(Collectors.toList());
    }

}