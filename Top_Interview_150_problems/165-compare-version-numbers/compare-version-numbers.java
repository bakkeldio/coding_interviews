class Solution {
    public int compareVersion(String version1, String version2) {
        

        String[] vs1 = version1.split("[.]", 0);

        String[] vs2 = version2.split("[.]", 0);

        int maxL = Math.max(vs1.length, vs2.length);

        int currV1 = 0;
        int currV2 = 0;
        for (int i = 0; i < maxL; i++) {
            if (vs1.length <= i) {
                currV1 = 0;
            } else {
                currV1 = Integer.parseInt(vs1[i]);
            }

            if (vs2.length <= i) {
                currV2 = 0;
            } else {
                currV2 = Integer.parseInt(vs2[i]);
            }

            if (currV1 < currV2) {
                return -1;
            } else if (currV1 > currV2){
                return 1;
            }
        }
        return 0;
    }
}