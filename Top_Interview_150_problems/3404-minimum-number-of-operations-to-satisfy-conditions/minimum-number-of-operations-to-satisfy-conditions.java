class Solution {
    

    /*
    public int columnSize;
    public int rowSize;
    public int dp[][];
    public int minimumOperations(int[][] grid) {
        int answer = Integer.MAX_VALUE;

        // For the first column we don't have any previous col
        // So, we can try for all the digits from 0 -> 9

        columnSize = grid[0].length;
        rowSize = grid.length;
        dp = new int[columnSize][10];

        for (int arr[] : dp) Arrays.fill(arr, -1);
        for (int i = 0; i <= 9; i++) answer = Math.min(answer, helper(0, i, grid));

        return answer;
    }

    // This is a helper method that will return the minimum cost of replacing 
    // all of it's elements with the currentDigit
    // And will further call itself for the next column
    // This will work as a DP 
    // The call to the next col will give the min cost IF the currenDigit is fixed
    public int helper(int currentColumn, int currentDigit, int[][] grid) {
        // Base case 
        if (currentColumn >= columnSize) return 0;

        if (dp[currentColumn][currentDigit] != -1) return dp[currentColumn][currentDigit];

        //current col cost
        int cost = 0;

        // Increase cost if and only if the digit !== currentDigit
        // This is the cost to change all the elements of that col
        for (int i = 0; i < rowSize; i++) if (grid[i][currentColumn] != currentDigit) cost++;

        // Gives the cost of next col plus this col
        int minCost = Integer.MAX_VALUE;

        // Now we will solve for the next col with digits 0 - 9 
        // But will not consider currentDigit 
        for (int i = 0; i <= 9; i++) if (i != currentDigit) minCost = Math.min(minCost, cost + helper(currentColumn + 1, i, grid));

        return dp[currentColumn][currentDigit] = minCost;
    }

    **/

    public int minimumOperations(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[n + 1][10]; // DP table: dp[col][digit]

        // Base Case: The first column can have any digit.
        for (int i = 0; i < m; i++) {
            dp[0][grid[i][0]] = 0; 
        }

        // Fill up the dp table
        for (int col = 1; col <= n; col++) {
            for (int curDigit = 0; curDigit <= 9; curDigit++) {
                int cost = 0;

                // Calculate the cost of changing all elements to curDigit in the current column
                for (int row = 0; row < m; row++) {
                    if (grid[row][col - 1] != curDigit) {
                        cost++;  
                    }
                }

                // Iterate over possible digits in the previous column to figure out minimum cost
                int minCost = Integer.MAX_VALUE;
                for (int prevDigit = 0; prevDigit <= 9; prevDigit++) {
                    if (prevDigit != curDigit) {
                        minCost = Math.min(minCost, dp[col - 1][prevDigit] + cost);
                    }
                }

                dp[col][curDigit] = minCost;
            } 
        }

        // Find the minimum in the last column (consider all possible digits)
        int minOperations = Integer.MAX_VALUE;
        for (int digit = 0; digit <= 9; digit++) {
            minOperations = Math.min(minOperations, dp[n][digit]);
        }

        return minOperations;
    }
}