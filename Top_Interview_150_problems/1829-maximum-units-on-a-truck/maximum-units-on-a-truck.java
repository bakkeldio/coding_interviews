class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        
        for (int[] boxType: boxTypes){
            q.add(boxType);
        }
        
        int units = 0;
        
        while(q.size() > 0) {
            int[] box = q.remove();

            int boxCount = Math.min(truckSize, box[0]);

            units += boxCount * box[1];

            truckSize -= boxCount;

            if (truckSize == 0){
                break;
            }      
             
        }
        return units;
    }
}