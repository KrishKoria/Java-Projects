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

        Process[] processes = new Process[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter arrival time and burst time for process " + (i + 1) + ":");
            int arrivalTime = scanner.nextInt();
            int burstTime = scanner.nextInt();
            processes[i] = new Process(i + 1, arrivalTime, burstTime);
        }

        Arrays.sort(processes, Comparator.comparingInt(p -> p.arrivalTime));

        PriorityQueue<Process> queue = new PriorityQueue<>();
        int currentTime = processes[0].arrivalTime;
        int i = 0;

        while (i < n || !queue.isEmpty()) {
            while (i < n && processes[i].arrivalTime <= currentTime) {
                queue.add(processes[i]);
                i++;
            }

            if (!queue.isEmpty()) {
                Process current = queue.poll();
                current.remainingBurstTime--;
                currentTime++;

                if (current.remainingBurstTime == 0) {
                    current.completionTime = currentTime;
                    current.turnaroundTime = current.completionTime - current.arrivalTime;
                    current.waitingTime = current.turnaroundTime - current.burstTime;
                } else {
                    queue.add(current);
                }
            } else {
                currentTime = processes[i].arrivalTime;
            }
        }

        System.out.println("ID\tArrivalTime\tBurstTime\tCompletionTime\tTurnaroundTime\tWaitingTime");
        for (Process p : processes) {
            System.out.println(p.id + "\t\t\t" + p.arrivalTime + "\t\t\t" + p.burstTime + "\t\t\t" + p.completionTime + "\t\t\t" + p.turnaroundTime + "\t\t\t" + p.waitingTime);
        }
    }
}