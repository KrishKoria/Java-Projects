import java.util.*;

public class Main {
    public static void roundRobinScheduling(Process[] processes, int n, int quantum) {
        int currentTime = 0;
        Queue<Process> readyQueue = new LinkedList<>();

        int processed = 0;
        while (processed < n || !readyQueue.isEmpty()) {
            for (int i = processed; i < n; ++i) {
                if (processes[i].arrivalTime <= currentTime) {
                    readyQueue.add(processes[i]);
                    processed++;
                } else {
                    break;
                }
            }

            if (readyQueue.isEmpty()) {
                currentTime++;
                continue;
            }

            Process currentProcess = readyQueue.poll();

            if (currentProcess.remainingTime > quantum) {
                currentProcess.remainingTime -= quantum;
                currentTime += quantum;
                for (int i = processed; i < n; ++i) {
                    if (processes[i].arrivalTime <= currentTime) {
                        readyQueue.add(processes[i]);
                        processed++;
                    } else {
                        break;
                    }
                }
                readyQueue.add(currentProcess);
            } else {
                currentTime += currentProcess.remainingTime;
                currentProcess.completionTime = currentTime;
                currentProcess.turnaroundTime = currentProcess.completionTime - currentProcess.arrivalTime;
                currentProcess.waitingTime = currentProcess.turnaroundTime - currentProcess.burstTime;
            }
        }
    }

    public static void printTable(Process[] processes, int n) {
        System.out.println("Process ArrivalTime BurstTime CompletionTime WaitingTime TurnaroundTime");
        for (int i = 0; i < n; ++i) {
            System.out.println(processes[i].id + "\t\t\t  " + processes[i].arrivalTime + "\t\t\t" + processes[i].burstTime + "\t\t\t"
                    + processes[i].completionTime + "\t\t\t" + processes[i].waitingTime + "\t\t\t" + processes[i].turnaroundTime);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();
        System.out.print("Enter time quantum for Round Robin scheduling: ");
        int quantum = scanner.nextInt();
        Process[] processes = new Process[n];
        for (int i = 0; i < n; ++i) {
            processes[i] = new Process();
            processes[i].id = i + 1;
            System.out.println("Enter the arrival time and burst time of process " + (i + 1) + ": ");
            processes[i].arrivalTime = scanner.nextInt();
            processes[i].burstTime = scanner.nextInt();
            processes[i].remainingTime = processes[i].burstTime;
        }
        roundRobinScheduling(processes, n, quantum);

        printTable(processes, n);
    }
}