package week3.assignment;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JobQueue {

    static class Worker {
        final int index;
        long freeAt = 0;

        public Worker(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

        public long getFreeAt() {
            return freeAt;
        }
    }

    static class Job {
        final int duration;
        int assignedWorker;
        long startTime;

        public Job(int duration){
            this.duration = duration;
        }
    }

    private PriorityQueue<Worker> queue;
    private int numWorkers;
    private Job[] jobs;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new Job[m];
        for (int i = 0; i < m; ++i) {
            Job job = new Job(in.nextInt());
            jobs[i] = job;
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            Job job = jobs[i];
            out.println(job.assignedWorker + " " + job.startTime);
        }
    }

    protected void assignJobs(Job[] jobs, int numWorkers) {
        queue = new PriorityQueue<>(numWorkers, Comparator.comparing(Worker::getFreeAt).thenComparing(Worker::getIndex));
        for (int i = 0; i < numWorkers; i++) {
            queue.add(new Worker(i));
        }

        for (int i = 0; i < jobs.length; i++) {
            Job job = jobs[i];
            Worker worker = queue.poll();
            job.startTime = worker.freeAt;
            job.assignedWorker = worker.index;
            worker.freeAt += job.duration;
            queue.add(worker);
        }
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs(jobs, numWorkers);
        writeResponse();
        out.close();
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}