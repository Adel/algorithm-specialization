package week1.assignment;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class check_bracketsTest {

    @TestFactory
    Collection<DynamicTest> checkString() throws IOException {
        return loadFiles()
                .entrySet()
                .stream()
                .map(e -> DynamicTest.dynamicTest(e.getKey(), () -> assertEquals(e.getValue().output, check_brackets.checkString(e.getValue().input))))
                .collect(Collectors.toList());
    }

    private Map<String, TestEntry> loadFiles() throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        Map<String, TestEntry> map = new HashMap<>();


        try (Stream<Path> paths = Files.walk(Paths.get(classLoader.getResource("check_brackets").getPath()))) {
            paths
                    .filter(Files::isReadable)
                    .filter(Files::isRegularFile)
                    .forEach(path -> {
                        try (Stream<String> lines = Files.lines(path)) {
                            String name = path.getFileName().toString();
                            boolean answer = name.endsWith("a");
                            if (answer) {
                                name = name.substring(0, name.length() - 2);
                            }
                            TestEntry entry = map.getOrDefault(name, new TestEntry());
                            String line = lines.findFirst().get();
                            if (answer) {
                                entry.output = line;
                            } else {
                                entry.input = line;
                            }
                            map.put(name, entry);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
        return map;
    }

    static class TestEntry {
        String input;
        String output;
    }
}