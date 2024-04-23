class Solution:
    
    def largestIsland(self, grid):
        directions = [(0, 1), (1, 0), (-1, 0), (0, -1)]
        n = len(grid)

        island_id = 2
        island_size = {}

        def dfs(r, c):
            if r < 0 or c < 0 or r >= n or c >= n or grid[r][c] != 1:
                return 0
            grid[r][c] = island_id
            size = 1
            for dr, dc in directions:
                size += dfs(r + dr, c + dc)
            return size

    # First pass: DFS to mark and count the size of each island
        for r in range(n):
            for c in range(n):
                if grid[r][c] == 1:
                    island_size[island_id] = dfs(r, c)
                    island_id += 1

    # Second pass: Check the largest possible island by changing one cell
        max_island_size = max(island_size.values() or [0])
        for r in range(n):
            for c in range(n):
                if grid[r][c] == 0:
                    seen = set()
                    island_size_after_change = 1
                    for dr, dc in directions:
                        nr, nc = r + dr, c + dc
                        if 0 <= nr < n and 0 <= nc < n and grid[nr][nc] > 1 and grid[nr][nc] not in seen:
                            island_size_after_change += island_size[grid[nr][nc]]
                            seen.add(grid[nr][nc])
                    max_island_size = max(max_island_size, island_size_after_change)

        return max_island_size
