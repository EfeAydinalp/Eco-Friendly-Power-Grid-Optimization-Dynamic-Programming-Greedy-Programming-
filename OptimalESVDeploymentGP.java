import java.util.ArrayList;
import java.util.Collections;

/**
 * This class accomplishes Mission Eco-Maintenance
 */
public class OptimalESVDeploymentGP
{
    private ArrayList<Integer> maintenanceTaskEnergyDemands;

    /*
     * Should include tasks assigned to ESVs.
     * For the sample input:
     * 8 100
     * 20 50 40 70 10 30 80 100 10
     * 
     * The list should look like this:
     * [[100], [80, 20], [70, 30], [50, 40, 10], [10]]
     * 
     * It is expected to be filled after getMinNumESVsToDeploy() is called.
     */
    private ArrayList<ArrayList<Integer>> maintenanceTasksAssignedToESVs = new ArrayList<>();

    ArrayList<ArrayList<Integer>> getMaintenanceTasksAssignedToESVs() {
        return maintenanceTasksAssignedToESVs;
    }

    public OptimalESVDeploymentGP(ArrayList<Integer> maintenanceTaskEnergyDemands) {
        this.maintenanceTaskEnergyDemands = maintenanceTaskEnergyDemands;
    }

    public ArrayList<Integer> getMaintenanceTaskEnergyDemands() {
        return maintenanceTaskEnergyDemands;
    }

    /**
     *
     * @param maxNumberOfAvailableESVs the maximum number of available ESVs to be deployed
     * @param maxESVCapacity the maximum capacity of ESVs
     * @return the minimum number of ESVs required using first fit approach over reversely sorted items.
     * Must return -1 if all tasks can't be satisfied by the available ESVs
     */
    public int getMinNumESVsToDeploy(int maxNumberOfAvailableESVs, int maxESVCapacity)
    {
        // TODO: Your code goes here
        Collections.sort(maintenanceTaskEnergyDemands, Collections.reverseOrder());
        int[] remainingCapacity = new int[maxNumberOfAvailableESVs];
        for (int i = 0; i < maxNumberOfAvailableESVs; i++) {
            remainingCapacity[i] = maxESVCapacity;
        }

        int numESVs = 0;
        for (int taskEnergyDemand : maintenanceTaskEnergyDemands) {
            boolean taskAssigned = false;
            for (int i = 0; i <= numESVs; i++) { // Modified condition from i < numESVs + 1 to i <= numESVs
                if (taskEnergyDemand <= remainingCapacity[i]) {
                    remainingCapacity[i] -= taskEnergyDemand;
                    taskAssigned = true;
                    if (maintenanceTasksAssignedToESVs.size() <= i) {
                        maintenanceTasksAssignedToESVs.add(new ArrayList<>());
                    }
                    maintenanceTasksAssignedToESVs.get(i).add(taskEnergyDemand);
                    break;
                }
            }
            if (!taskAssigned) {
                numESVs++;
                if (numESVs >= maxNumberOfAvailableESVs) {
                    return -1; // Not enough ESVs to complete all tasks
                }
                remainingCapacity[numESVs] -= taskEnergyDemand;
                ArrayList<Integer> newESVTasks = new ArrayList<>();
                newESVTasks.add(taskEnergyDemand);
                maintenanceTasksAssignedToESVs.add(newESVTasks);
            }
        }

        return numESVs + 1;
    }
}