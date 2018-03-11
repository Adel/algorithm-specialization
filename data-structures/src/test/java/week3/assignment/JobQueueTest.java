package week3.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static week3.assignment.JobQueue.Job;

class JobQueueTest {

    @Test
    void shouldAssignJobsCorrectly() {
        JobQueue jobQueue = new JobQueue();
        Job[] jobs = {new Job(1), new Job(2), new Job(3), new Job(4), new Job(5)};

        jobQueue.assignJobs(jobs, 2);
        long[] startTimes = {0, 0, 1, 2, 4};
        int[] assignedWorkers = {0, 1, 0, 1, 0};
        for (int i = 0; i < startTimes.length; i++) {
            assertEquals(startTimes[i], jobs[i].startTime);
            assertEquals(assignedWorkers[i], jobs[i].assignedWorker);
        }
    }

    @Test
    void shouldAssignJobsCorrectly2() {
        JobQueue jobQueue = new JobQueue();
        Job[] jobs = new Job[20];
        for (int i = 0; i < 20; i++) {
            jobs[i] = new Job(1);
        }

        jobQueue.assignJobs(jobs, 4);
        int[] assignedWorkers = {0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3};
        long[] startTimes = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4};
        for (int i = 0; i < startTimes.length; i++) {
            assertEquals(startTimes[i], jobs[i].startTime);
            assertEquals(assignedWorkers[i], jobs[i].assignedWorker);

        }
    }
}