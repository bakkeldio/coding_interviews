class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
 
        int start = 0;
        int currentGas = 0;
        int totalGas = 0;

        for (int i = 0; i < gas.length; i++) {
            currentGas += gas[i] - cost[i];
            totalGas += gas[i] - cost[i];

            if (currentGas < 0) {
                start = i + 1;
                currentGas = 0;
            }
        }

        if (totalGas >= 0) {
            return start;
        } else {
            return -1;
        }
    }
}