import java.util.*;

class Process {
    int id;
    int arrivalTime;
    int burstTime;
    int completionTime;
    int turnaroundTime;
    int waitingTime;
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();
        Process[] processes = new Process[n];
        Map<Integer, Integer> tempBurstTime = new HashMap<>();
        for (int i = 0; i < n; i++) {
            processes[i] = new Process();
            processes[i].id = i;
            System.out.println("Enter the arrival time and burst time of process " + (i + 1) + ": ");
            processes[i].arrivalTime = scanner.nextInt();
            processes[i].burstTime = scanner.nextInt();
            tempBurstTime.put(processes[i].id, processes[i].burstTime);
        }
        Arrays.sort(processes, (a, b) -> {
            if (a.arrivalTime == b.arrivalTime) {
                return Integer.compare(a.burstTime, b.burstTime);
            }
            return Integer.compare(a.arrivalTime, b.arrivalTime);
        });
        int time = processes[0].arrivalTime;
        int count = 0;
        int j;
        while (count < n) {
            time += 1;
            if (processes[count].arrivalTime < time) {
                processes[count].burstTime--;
            }
            if (processes[count].burstTime == 0) {
                processes[count].completionTime = time;
                count++;
            }
            j = count;
            for (int i = count + 1; i < n; i++) {
                if (time >= processes[i].arrivalTime) {
                    j++;
                }
            }
            if (j != count) {
                int ans = processes[count].burstTime;
                for (int l = count; l <= j; l++) {
                    if (ans < processes[l].burstTime) {
                        ans = processes[l].burstTime;
                    }
                }
                if (ans != processes[count].burstTime) {
                    Arrays.sort(processes, count, j + 1, (a, b) -> {
                        if (a.burstTime == b.burstTime) {
                            return Integer.compare(a.arrivalTime, b.arrivalTime);
                        }
                        return Integer.compare(b.burstTime, a.burstTime);
                    });
                }
            }
        }
        for (int i = 0; i < n; i++) {
            processes[i].turnaroundTime = processes[i].completionTime - processes[i].arrivalTime;
            processes[i].waitingTime = processes[i].turnaroundTime - tempBurstTime.get(processes[i].id);
        }
        Arrays.sort(processes, Comparator.comparingInt(a -> a.arrivalTime));
        System.out.println("Process ArrivalTime BurstTime CompletionTime TurnaroundTime WaitingTime");
        for (int i = 0; i < n; i++) {
            System.out.println("p" + processes[i].id + "\t\t\t" + processes[i].arrivalTime + "\t\t\t" + tempBurstTime.get(processes[i].id) + "\t\t\t" + processes[i].completionTime + "\t\t\t" + processes[i].turnaroundTime + "\t\t\t" + processes[i].waitingTime);
        }
    }
}

