class Solution(object):
    

    def countSubarrays(self, nums, k):
        max_val = max(nums)
        n = len(nums)
        count = 0
        start = 0
        freq = 0

        for end in range(n):
            if nums[end] == max_val:
                freq += 1

            while freq >= k:
                count += n - end
                if nums[start] == max_val:
                    freq -= 1
                start += 1

        return count