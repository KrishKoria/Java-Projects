import java.util.*;

public class Main {
    public static void priorityScheduling(Process[] processes) {
        PriorityQueue<Process> processQueue = new PriorityQueue<>((p1, p2) -> {
            if (p1.priority == p2.priority) {
                return p1.arrivalTime - p2.arrivalTime;
            } else {
                return p2.priority - p1.priority;
            }
        });

        processQueue.addAll(Arrays.asList(processes));

        int currentTime = 0;
        while (!processQueue.isEmpty()) {
            Process process = processQueue.peek();
            if (process.arrivalTime <= currentTime) {
                process = processQueue.poll();
                currentTime += process.burstTime;
                process.completionTime = currentTime;
                process.turnaroundTime = process.completionTime - process.arrivalTime;
                process.waitingTime = process.turnaroundTime - process.burstTime;
            } else {
                currentTime++;
            }
        }
    }
    public static void printTable(Process[] processes, int n) {
        System.out.println("Process ArrivalTime BurstTime Priority CompletionTime WaitingTime TurnaroundTime");
        for (int i = 0; i < n; ++i) {
            System.out.println(processes[i].id + "\t\t\t  " + processes[i].arrivalTime + "\t\t\t" + processes[i].burstTime + "\t\t\t"
                    + processes[i].priority + "\t\t\t" + processes[i].completionTime + "\t\t\t" + processes[i].waitingTime + "\t\t\t" + processes[i].turnaroundTime);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();
        Process[] processes = new Process[n];
        for (int i = 0; i < n; ++i) {
            processes[i] = new Process();
            processes[i].id = i + 1;
            System.out.println("Enter the arrival time, burst time and priority of process " + (i + 1) + ": ");
            processes[i].arrivalTime = scanner.nextInt();
            processes[i].burstTime = scanner.nextInt();
            processes[i].priority = scanner.nextInt();
        }
        priorityScheduling(processes);

        printTable(processes, n);
    }
}