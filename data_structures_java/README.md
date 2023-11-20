# 31github
Arrays
Array is a collection of elements stored at contiquous memory locations.
Why does array accessing takes O(1) time or constant time. Because elements are stored in contiguous memory blocks and when we accessing let's say index 4 in int[] array, then to get this value first we need to find an address of that value. So here is the formula to find the address:
base address(address of index 0) + index number * size of the elements(4 bytes if it is int). So like this we accessing the element in O(1) time because we don't have to iterate over the array.
