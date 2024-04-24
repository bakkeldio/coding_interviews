class Solution:

      
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        graph = [[] for _ in range(n)]
        for edge in edges:
            a, b = edge
            graph[a].append(b)
            graph[b].append(a)

        visited = [False] * n
        num_components = 0

        for i in range(n):
            if not visited[i]:
                self.dfs(graph, visited, i)
                num_components += 1

        return num_components

    def dfs(self, graph, visited, node):
        visited[node] = True
        for neighbor in graph[node]:
            if not visited[neighbor]:
                self.dfs(graph, visited, neighbor)     
 