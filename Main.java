import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Main class
 */
// FREE CODE HERE
public class Main {
    public static void main(String[] args) throws IOException {

       /** MISSION POWER GRID OPTIMIZATION BELOW **/

        System.out.println("##MISSION POWER GRID OPTIMIZATION##");
        // TODO: Your code goes here
        // You are expected to read the file given as the first command-line argument to read 
        // the energy demands arriving per hour. Then, use this data to instantiate a 
        // PowerGridOptimization object. You need to call getOptimalPowerGridSolutionDP() method
        // of your PowerGridOptimization object to get the solution, and finally print it to STDOUT.
        String powerGridInputFile = args[0];
        ArrayList<Integer> energyDemandsArrivingPerHour = readEnergyDemands(powerGridInputFile);
        PowerGridOptimization powerGridOptimization = new PowerGridOptimization(energyDemandsArrivingPerHour);
        OptimalPowerGridSolution optimalPowerGridSolution = powerGridOptimization.getOptimalPowerGridSolutionDP();
        System.out.println("The maximum number of satisfied demands: " + optimalPowerGridSolution.getmaxNumberOfSatisfiedDemands());
        System.out.println("Hours to discharge batteries for max efficiency: " + optimalPowerGridSolution.getHoursToDischargeBatteriesForMaxEfficiency());


        System.out.println("##MISSION POWER GRID OPTIMIZATION COMPLETED##");


        /** MISSION ECO-MAINTENANCE BELOW **/

        System.out.println("##MISSION ECO-MAINTENANCE##");
        // TODO: Your code goes here
        // You are expected to read the file given as the second command-line argument to read
        // the number of available ESVs, the capacity of each available ESV, and the energy requirements 
        // of the maintenance tasks. Then, use this data to instantiate an OptimalESVDeploymentGP object.
        // You need to call getMinNumESVsToDeploy(int maxNumberOfAvailableESVs, int maxESVCapacity) method
        // of your OptimalESVDeploymentGP object to get the solution, and finally print it to STDOUT.
        String ecoMaintenanceInputFile = args[1];
        ArrayList<Integer> maintenanceTaskEnergyDemands = readMaintenanceTasks(ecoMaintenanceInputFile);
        OptimalESVDeploymentGP optimalESVDeploymentGP = new OptimalESVDeploymentGP(maintenanceTaskEnergyDemands);
        int maxNumberOfAvailableESVs = maintenanceTaskEnergyDemands.remove(0);
        int maxESVCapacity = maintenanceTaskEnergyDemands.remove(0);
        int minNumESVsToDeploy = optimalESVDeploymentGP.getMinNumESVsToDeploy(maxNumberOfAvailableESVs, maxESVCapacity);
        if (minNumESVsToDeploy == -1) {
            System.out.println("Warning: Mission Eco-Maintenance Failed.");
        } else {
            ArrayList<ArrayList<Integer>> maintenanceTasksAssignedToESVs = optimalESVDeploymentGP.getMaintenanceTasksAssignedToESVs();
            System.out.println("The minimum number of ESVs to deploy: " + minNumESVsToDeploy);
            for (int i = 0; i < maintenanceTasksAssignedToESVs.size(); i++) {
                System.out.println("ESV " + (i + 1) + " tasks: " + maintenanceTasksAssignedToESVs.get(i));
            }
        }

        System.out.println("##MISSION ECO-MAINTENANCE COMPLETED##");
    }
    private static ArrayList<Integer> readEnergyDemands(String filename) throws IOException {
        ArrayList<Integer> energyDemands = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            String[] parts = line.split(" ");
            for (String part : parts) {
                energyDemands.add(Integer.parseInt(part));
            }
        }
        return energyDemands;
    }

    private static ArrayList<Integer> readMaintenanceTasks(String filename) throws IOException {
        ArrayList<Integer> maintenanceTasks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            String[] parts = line.split(" ");
            for (String part : parts) {
                maintenanceTasks.add(Integer.parseInt(part));
            }
        }
        return maintenanceTasks;
    }
}
