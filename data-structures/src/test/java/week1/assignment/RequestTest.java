package week1.assignment;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import utils.TestFiles;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class RequestTest {

    @TestFactory
    Collection<DynamicTest> shouldGetCorrectTimes() throws IOException {
        return TestFiles.loadFiles("packet_simulation")
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(e -> DynamicTest.dynamicTest(e.getKey(), () -> {
                    List<String> inputs = e.getValue().getInputs();
                    List<Integer> outputs = e.getValue().getOutputs().stream().map(Integer::parseInt).collect(Collectors.toList());

                    String input = inputs.stream().reduce("", (a, b) -> a + "\n" + b);
                    InputStream in = new ByteArrayInputStream(input.getBytes());
                    Scanner scanner = new Scanner(in);

                    int bufferMaxSize = scanner.nextInt();
                    Buffer buffer = new Buffer(bufferMaxSize);
                    long startTime = System.nanoTime();
                    List<Request> requests = ProcessPackages.ReadQueries(scanner);
                    List<Response> responses = ProcessPackages.ProcessRequests(requests, buffer);
                    long endTime = System.nanoTime();
                    System.out.println(e.getKey() + " " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + "ms");
                    assertIterableEquals(outputs, responses.stream().map(Response::getStartTime).collect(Collectors.toList()));
                }))
                .collect(Collectors.toList());
    }

}