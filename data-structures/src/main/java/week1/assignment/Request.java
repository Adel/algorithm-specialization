package week1.assignment;

import java.io.IOException;
import java.util.*;

class Request {
    public final int arrivalTime;
    public final int processTime;

    public Request(int arrivalTime, int processTime) {
        this.arrivalTime = arrivalTime;
        this.processTime = processTime;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        Buffer buffer = new Buffer(scanner.nextInt());
        List<Request> requests = ProcessPackages.ReadQueries(scanner);
        List<Response> responses = ProcessPackages.ProcessRequests(requests, buffer);
        responses.stream().map(r -> r.dropped?-1:r.getStartTime()).forEach(System.out::println);
    }

}

class Response {
    public final boolean dropped;
    public final int startTime;

    private Response(boolean dropped, int startTime) {
        this.dropped = dropped;
        this.startTime = startTime;
    }

    public int getStartTime() {
        return startTime;
    }

    static Response createProcessedResponse(int startTime) {
        return new Response(false, startTime);
    }

    static Response droppedResponse() {
        return new Response(true, -1);
    }
}

class Buffer {
    private int maxSize;
    private Deque<Integer> finishTimes;

    public Buffer(int size) {
        this.maxSize = size;
        this.finishTimes = new ArrayDeque<>();
    }

    public Response Process(Request request) {
        //remove processed requests
        while (finishTimes.size() > 0 && finishTimes.peekFirst() <= request.arrivalTime) {
            finishTimes.removeFirst();
        }
        if (this.finishTimes.size() == maxSize) {
            return Response.droppedResponse();
        } else {
            // if buffer is empty, start processing immediately
            int startTime = finishTimes.size() == 0 ? request.arrivalTime : finishTimes.getLast();
            finishTimes.addLast(startTime + request.processTime);
            return Response.createProcessedResponse(startTime);
        }
    }
}

class ProcessPackages {
    static List<Request> ReadQueries(Scanner scanner) throws IOException {
        int requests_count = scanner.nextInt();
        List<Request> requests = new ArrayList<>();
        for (int i = 0; i < requests_count; ++i) {
            int arrival_time = scanner.nextInt();
            int process_time = scanner.nextInt();
            requests.add(new Request(arrival_time, process_time));
        }
        return requests;
    }

    static List<Response> ProcessRequests(List<Request> requests, Buffer buffer) {
        List<Response> responses = new ArrayList<>();
        for (int i = 0; i < requests.size(); ++i) {
            responses.add(buffer.Process(requests.get(i)));
        }
        return responses;
    }
}
