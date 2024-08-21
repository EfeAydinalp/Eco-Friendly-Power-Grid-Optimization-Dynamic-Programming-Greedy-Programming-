

## Project: Eco-Friendly Power Grid Optimization & ESV Deployment

### Overview

This project is part of the **BBM204 Software Practicum II** course at Hacettepe University. The goal is to solve two interconnected problems that focus on optimizing eco-friendly infrastructure in the city of Ankara.

1. **Eco-Friendly Power Grid Optimization**: Optimize the usage of battery banks to meet the energy demands of the city using dynamic programming.
2. **Optimal ESV Deployment for Eco-Maintenance**: Deploy Electric Service Vehicles (ESVs) efficiently to handle maintenance tasks using a greedy algorithm.

### Project Goals

- **Power Grid Optimization**:
  - Maximize the use of stored energy in battery banks to satisfy city-wide power demands.
  - Implement a dynamic programming solution to determine optimal discharge times.
  
- **ESV Deployment**:
  - Minimize the number of ESVs required to complete all maintenance tasks.
  - Use a greedy algorithm to assign tasks to ESVs based on their energy capacities.

### Technologies Used

- **Programming Language**: Java (OpenJDK 11)
- **Concepts**: Dynamic Programming, Greedy Algorithms, File I/O, Recursion

### Setup Instructions

1. **Clone the repository**:
    ```bash
    git clone https://github.com/yourusername/eco-infrastructure-optimization.git
    cd eco-infrastructure-optimization
    ```

2. **Compile the Java files**:
    ```bash
    javac *.java
    ```

3. **Run the Power Grid Optimization program**:
    ```bash
    java PowerGridOptimization <path_to_demandSchedule.dat>
    ```

4. **Run the ESV Deployment program**:
    ```bash
    java ESVDeployment <path_to_ESVMaintenance.dat>
    ```

### Usage Examples

#### Power Grid Optimization
- **Input**: `demandSchedule.dat` (Example: `2 6 10 1 3`)
- **Output**:
    ```plaintext
    ##MISSION POWER GRID OPTIMIZATION##
    The total number of demanded gigawatts: 22
    Maximum number of satisfied gigawatts: 12
    Hours at which the battery bank should be discharged: 3, 5
    The number of unsatisfied gigawatts: 10
    ##MISSION POWER GRID OPTIMIZATION COMPLETED##
    ```

#### ESV Deployment
- **Input**: `ESVMaintenance.dat` (Example: `8 100 \n 20 50 40 70 10 30 80 100 10`)
- **Output**:
    ```plaintext
    ##MISSION ECO-MAINTENANCE##
    Minimum number of ESVs required: 4
    Maintenance tasks assigned to ESVs: [[70, 30], [50, 40], [80, 20], [100, 10, 10]]
    ##MISSION ECO-MAINTENANCE COMPLETED##
    ```

### File Structure

- `PowerGridOptimization.java`: Contains the implementation for optimizing the power grid.
- `ESVDeployment.java`: Contains the implementation for optimizing ESV deployment.
- `README.md`: This file, providing an overview and usage instructions.
- `demandSchedule.dat`: Example data file for Power Grid Optimization.
- `ESVMaintenance.dat`: Example data file for ESV Deployment.


