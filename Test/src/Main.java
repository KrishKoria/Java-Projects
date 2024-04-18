import java.util.*;

class Process implements Comparable<Process> {
    int id, arrivalTime, burstTime, remainingBurstTime, completionTime, turnaroundTime, waitingTime;

    Process(int id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingBurstTime = burstTime;
    }

    @Override
    public int compareTo(Process p) {
        return this.remainingBurstTime - p.remainingBurstTime;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of processes:");
        int n = scanner.nextInt();

        PriorityQueue<Process> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter arrival time and burst time for process " + (i + 1) + ":");
            int arrivalTime = scanner.nextInt();
            int burstTime = scanner.nextInt();
            queue.add(new Process(i + 1, arrivalTime, burstTime));
        }

        int currentTime = 0;
        while (!queue.isEmpty()) {
            Process current = queue.poll();
            current.remainingBurstTime--;
            currentTime++;

            if (current.remainingBurstTime == 0) {
                current.completionTime = currentTime;
                current.turnaroundTime = current.completionTime - current.arrivalTime;
                current.waitingTime = current.turnaroundTime - current.burstTime;
                System.out.println("Process " + current.id + " completed at time " + current.completionTime + " with turnaround time " + current.turnaroundTime + " and waiting time " + current.waitingTime);
            } else {
                queue.add(current);
            }
        }
    }
}