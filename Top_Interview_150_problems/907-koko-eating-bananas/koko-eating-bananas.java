class Solution {


    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int time = eatAllBananas(piles, mid);
            if (time <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public int eatAllBananas(int[] piles, int speed){
      int time = 0;
        for (int pile : piles) {
            int tempTime = pile / speed;
            if (pile % speed != 0) {
                tempTime++;
            }
            time += tempTime;
        }
        return time;
    }
}