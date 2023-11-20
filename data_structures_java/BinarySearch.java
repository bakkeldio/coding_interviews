public int binarySearch(int[] array, int high, int low, int target) {
    if (high < low) {
      return -1;
    }

    int mid = (high + low) / 2;

    if (array[mid] == target) {
      return mid;
    }
    if (array[mid] < target) {
        return binarySearch(array, high, mid + 1, target); 
    } 
    return binarySearch(array, mid - 1, low, target);
}
