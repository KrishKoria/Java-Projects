public class Process {
    public int id;
    public int arrivalTime;
    public int burstTime;
    public int priority;

    public int remainingTime;

    public int completionTime;

    public int waitingTime;
    public int turnAroundTime;

}













































//#include<iostream>
//#include<limits>
//#include<iomanip>
//#include<algorithm>
//using namespace std;
//
//class Process {
//    public:
//    string processName;
//    int arrivalTime;
//    int burstTime;
//    int priority;
//
//    int remainingTime;
//
//    int completionTime;
//
//    int waitingTime;
//    int turnAroundTime;
//
//    void initialize() {
//        remainingTime = burstTime;
//    }
//};
//
//bool compareArrival(const Process &a, const Process &b) {
//    return a.arrivalTime < b.arrivalTime;
//}
//
//int main() {
//    int numOfProcesses;
//    cout << "Enter no. of processes: ";
//    cin >> numOfProcesses;
//
//    Process processes[numOfProcesses];
//
//    for (int n = 0; n < numOfProcesses; n++) {
//        cout << "\nEnter Process Name for " << (n + 1) << ": ";
//        cin >> processes[n].processName;
//        cout << "Enter Arrival Time for Process " << (n + 1) << ": ";
//        cin >> processes[n].arrivalTime;
//        cout << "Enter Burst Time for Process " << (n + 1) << ": ";
//        cin >> processes[n].burstTime;
//        cout << "Enter Priority for Process " << (n + 1) << ": ";
//        cin >> processes[n].priority;
//
//        processes[n].initialize();
//    }
//
//    sort(processes, processes + numOfProcesses, compareArrival);
//
//    cout << "\n\n";
//    cout << setw(15) << "Process";
//    cout << setw(15) << "Arrival Time";
//    cout << setw(15) << "Burst Time";
//    cout << setw(15) << "Priority";
//    cout << setw(15) << "Completion Time";
//    cout << setw(15) << "Waiting Time";
//    cout << setw(15) << "Turnaround Time" << endl;
//
//    int currentTime = 0;
//
//    while (true) {
//        int currentHighestPriorityIndex = -1;
//        int currentHighestPriority = numeric_limits<int>::max();
//        bool isAllCompleted = true;
//
//        for (int i = 0; i < numOfProcesses; i++) {
//            if (processes[i].remainingTime > 0) {
//                isAllCompleted = false;
//                if (processes[i].arrivalTime <= currentTime) {
//                    if (processes[i].priority < currentHighestPriority) {
//                        currentHighestPriority = processes[i].priority;
//                        currentHighestPriorityIndex = i;
//                    }
//                }
//            }
//        }
//
//        if (isAllCompleted) {
//            break;
//        }
//
//        processes[currentHighestPriorityIndex].remainingTime--;
//        currentTime++;
//
//        if (processes[currentHighestPriorityIndex].remainingTime == 0) {
//            processes[currentHighestPriorityIndex].completionTime = currentTime;
//            processes[currentHighestPriorityIndex].turnAroundTime = processes[currentHighestPriorityIndex].completionTime - processes[currentHighestPriorityIndex].arrivalTime;
//            processes[currentHighestPriorityIndex].waitingTime = processes[currentHighestPriorityIndex].turnAroundTime - processes[currentHighestPriorityIndex].burstTime;
//        }
//    }
//
//    int sumCompletionTime = 0;
//    int sumWaitingTime = 0;
//    int sumTurnAroundTime = 0;
//
//    for (int n = 0; n < numOfProcesses; n++) {
//        cout << setw(15) << processes[n].processName;
//        cout << setw(15) << processes[n].arrivalTime;
//        cout << setw(15) << processes[n].burstTime;
//        cout << setw(15) << processes[n].priority;
//        cout << setw(15) << processes[n].completionTime;
//        cout << setw(15) << processes[n].waitingTime;
//        cout << setw(15) << processes[n].turnAroundTime << endl;
//
//        sumCompletionTime += processes[n].completionTime;
//        sumWaitingTime += processes[n].waitingTime;
//        sumTurnAroundTime += processes[n].turnAroundTime;
//    }
//
//    cout << "\n\nAverage Completion Time for " << (numOfProcesses) << " Processes: " << (float) sumCompletionTime / numOfProcesses;
//    cout << "\n\nAverage Waiting Time for " << (numOfProcesses) << " Processes: " << (float) sumWaitingTime / numOfProcesses;
//    cout << "\n\nAverage Turn Around Time for " << (numOfProcesses) << " Processes: " << (float) sumTurnAroundTime / numOfProcesses;
//
//    return 0;
//}