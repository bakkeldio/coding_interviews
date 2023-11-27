class Solution {
    public int candy(int[] ratings) {

        int minCandy = ratings.length;

        int[] candies = new int[ratings.length];

        candies[0] = 1;

        for (int i = 1; i <ratings.length; i++){
            if (ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        for (int j = ratings.length - 2; j >= 0; j--){
            if (ratings[j] > ratings[j+1]){
                candies[j] = Math.max(candies[j], candies[j+1] + 1);
            } 
        }
        int total = 0;

        for (int candy : candies){
            total += candy;
        }
        return total;
    }
}