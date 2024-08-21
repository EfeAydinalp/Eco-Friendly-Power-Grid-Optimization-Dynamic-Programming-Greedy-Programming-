import java.util.ArrayList;

/**
 * This class accomplishes Mission POWER GRID OPTIMIZATION
 */
public class PowerGridOptimization {
    private ArrayList<Integer> amountOfEnergyDemandsArrivingPerHour;

    public PowerGridOptimization(ArrayList<Integer> amountOfEnergyDemandsArrivingPerHour){
        this.amountOfEnergyDemandsArrivingPerHour = amountOfEnergyDemandsArrivingPerHour;
    }

    public ArrayList<Integer> getAmountOfEnergyDemandsArrivingPerHour() {
        return amountOfEnergyDemandsArrivingPerHour;
    }
    /**
     *     Function to implement the given dynamic programming algorithm
     *     SOL(0) <- 0
     *     HOURS(0) <- [ ]
     *     For{j <- 1...N}
     *         SOL(j) <- max_{0<=i<j} [ (SOL(i) + min[ E(j), P(j − i) ] ]
     *         HOURS(j) <- [HOURS(i), j]
     *     EndFor
     *
     * @return OptimalPowerGridSolution
     */
    public OptimalPowerGridSolution getOptimalPowerGridSolutionDP(){
        // TODO: YOUR CODE HERE
        int N = amountOfEnergyDemandsArrivingPerHour.size();
        int[] S = new int[N + 1];
        ArrayList<Integer>[] Hours = new ArrayList[N + 1];

        S[0] = 0;
        Hours[0] = new ArrayList<>();

        for (int j = 1; j <= N; j++) {
            int maxEnergy = 0;
            int bestH = -1;
            for (int i = 1; i < j; i++) {
                int energy = S[i] + Math.min(amountOfEnergyDemandsArrivingPerHour.get(j - 1), getEnergy(i, j));
                if (energy > maxEnergy) {
                    maxEnergy = energy;
                    bestH = i;
                }
            }
            S[j] = maxEnergy;
            if (bestH != -1) {
                Hours[j] = new ArrayList<>(Hours[bestH]);
            } else {
                Hours[j] = new ArrayList<>();
            }
            Hours[j].add(j);
        }

        return new OptimalPowerGridSolution(S[N], Hours[N]);
    }

    private int getEnergy(int i, int j) {
        int chargingTime = j - i;
        return chargingTime * chargingTime;
    }
}
