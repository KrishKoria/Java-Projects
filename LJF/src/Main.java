import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();

        int[][] processes = new int[n][3];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter arrival time for process " + (i + 1) + ": ");
            processes[i][0] = i + 1;
            processes[i][1] = scanner.nextInt();
            System.out.print("Enter burst time for process " + (i + 1) + ": ");
            processes[i][2] = scanner.nextInt();
        }

        int[] completionTime = new int[n];
        int[] turnaroundTime = new int[n];
        int[] waitingTime = new int[n];

        int currentTime = 0;
        List<int[]> remainingProcesses = new ArrayList<>(Arrays.asList(processes));

        while (!remainingProcesses.isEmpty()) {
            int finalCurrentTime = currentTime;
            List<int[]> arrivedProcesses = remainingProcesses.stream()
                    .filter(p -> p[1] <= finalCurrentTime)
                    .toList();

            if (arrivedProcesses.isEmpty()) {
                currentTime++;
                continue;
            }

            int[] nextProcess = arrivedProcesses.stream()
                    .max(Comparator.comparingInt(p -> p[2]))
                    .orElse(null);

            currentTime += nextProcess[2];

            int processIndex = nextProcess[0] - 1;
            completionTime[processIndex] = currentTime;
            turnaroundTime[processIndex] = completionTime[processIndex] - nextProcess[1];
            waitingTime[processIndex] = turnaroundTime[processIndex] - nextProcess[2];

            remainingProcesses.remove(nextProcess);
        }

        System.out.println("ProcessID\tBurstTime\tArrivalTime\tWaitingTime\tTurnaroundTime\tCompletionTime");
        for (int i = 0; i < n; i++) {
            System.out.println(processes[i][0] + "\t\t\t" + processes[i][2] + "\t\t\t" + processes[i][1] + "\t\t\t" + waitingTime[i] + "\t\t\t" + turnaroundTime[i]+ "\t\t\t" + completionTime[i]);
        }
    }
}