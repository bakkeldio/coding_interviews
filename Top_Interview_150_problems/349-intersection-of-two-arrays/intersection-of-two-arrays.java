class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0; 
        int j = 0;
        Set<Integer> intersectionSet = new HashSet<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else { // nums1[i] == nums2[j]
                intersectionSet.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] result = new int[intersectionSet.size()];
        int index = 0;
        for (int num : intersectionSet) {
            result[index++] = num;
        }
        return result;
    }
}