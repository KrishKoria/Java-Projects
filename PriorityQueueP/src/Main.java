import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MAX_PRIORITY = Integer.MAX_VALUE;
        System.out.print("Enter the number of processes: ");
        int numOfProcesses = scanner.nextInt();
        Process[] processes = new Process[numOfProcesses];
        for (int i = 0; i < numOfProcesses; ++i) {
            processes[i] = new Process();
            processes[i].id = i + 1;
            System.out.println("Enter the arrival time, burst time and priority of process " + (i + 1) + ": ");
            processes[i].arrivalTime = scanner.nextInt();
            processes[i].burstTime = scanner.nextInt();
            processes[i].priority = scanner.nextInt();
            processes[i].remainingTime = processes[i].burstTime;
        }
        Arrays.sort(processes, Comparator.comparingInt(a -> a.arrivalTime));
        int currentTime = 0;

        while (true) {
            int currentHighestPriorityIndex = -1;
            int currentHighestPriority = MAX_PRIORITY;
            boolean isAllCompleted = true;

            for (int i = 0; i < numOfProcesses; i++) {
                if (processes[i].remainingTime > 0) {
                    isAllCompleted = false;
                    if (processes[i].arrivalTime <= currentTime) {
                        if (processes[i].priority < currentHighestPriority) {
                            currentHighestPriority = processes[i].priority;
                            currentHighestPriorityIndex = i;
                        }
                    }
                }
            }

            if (isAllCompleted) {
                break;
            }

            if (currentHighestPriorityIndex != -1) {
                processes[currentHighestPriorityIndex].remainingTime--;
                currentTime++;

                if (processes[currentHighestPriorityIndex].remainingTime == 0) {
                    processes[currentHighestPriorityIndex].completionTime = currentTime;
                    processes[currentHighestPriorityIndex].turnAroundTime = processes[currentHighestPriorityIndex].completionTime - processes[currentHighestPriorityIndex].arrivalTime;
                    processes[currentHighestPriorityIndex].waitingTime = processes[currentHighestPriorityIndex].turnAroundTime - processes[currentHighestPriorityIndex].burstTime;
                }
            } else {
                currentTime++;
            }
        }

        System.out.println("Process ArrivalTime BurstTime Priority CompletionTime WaitingTime TurnaroundTime");
        for (int i = 0; i < numOfProcesses; i++) {
            System.out.println(processes[i].id + "\t\t\t  " + processes[i].arrivalTime + "\t\t\t" + processes[i].burstTime + "\t\t\t"
                    + processes[i].priority + "\t\t\t" + processes[i].completionTime + "\t\t\t" + processes[i].waitingTime + "\t\t\t" + processes[i].turnAroundTime);
        }
    }

}