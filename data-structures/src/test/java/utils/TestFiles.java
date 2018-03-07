package utils;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestFiles {
    public static Map<String, TestEntry> loadFiles(String folder) throws IOException {
        ClassLoader classLoader = TestFiles.class.getClassLoader();
        Map<String, TestEntry> map = new HashMap<>();


        try (Stream<Path> paths = Files.walk(Paths.get(classLoader.getResource(folder).getPath()))) {
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
                            if (answer) {
                                entry.output = lines.findFirst().get();
                            } else {
                                entry.inputs.addAll(lines.collect(Collectors.toList()));
                            }
                            map.put(name, entry);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
        return map;
    }

    public static class TestEntry {
        private List<String> inputs = new ArrayList<>();
        private String output;

        public List<String> getInputs() {
            return inputs;
        }

        public void setInputs(List<String> inputs) {
            this.inputs = inputs;
        }

        public String getOutput() {
            return output;
        }

        public void setOutput(String output) {
            this.output = output;
        }
    }
}
