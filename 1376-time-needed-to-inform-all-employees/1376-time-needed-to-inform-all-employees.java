// https://leetcode.com/problems/time-needed-to-inform-all-employees/discuss/532560/JavaC%2B%2BPython-DFS

class Solution {
     public int numOfMinutes(final int n, final int headID, final int[] manager, final int[] informTime) {
        final Map<Integer, List<Integer>> graph = new HashMap<>();
        int total = 0;
        for (int i = 0; i < manager.length; i++) {
            int j = manager[i];
            if (!graph.containsKey(j))
                graph.put(j, new ArrayList<>());
            graph.get(j).add(i);
        }
        return dfs(graph, informTime, headID);
    }

    private int dfs(final Map<Integer, List<Integer>> graph, final int[] informTime, final int cur) {
        int max = 0;
        if (!graph.containsKey(cur))
            return max;
        for (int i = 0; i < graph.get(cur).size(); i++)
            max = Math.max(max, dfs(graph, informTime, graph.get(cur).get(i)));
        return max + informTime[cur];
    }
}

/*

Queue<Integer> queue = new LinkedList<Integer>();
		ArrayList<Integer> traversal = new ArrayList<Integer>();
		boolean[] isVisited = new boolean[adjList.length];
		if(adjList.length == 0) {
			return traversal;
		}
		queue.add(0);
		isVisited[0] = true;
		for(int i = 0; i < adjList.length; i++) {
			int node = queue.poll();
			traversal.add(node);
			for(int j = 0; j < adjList[node].size(); j++) {
				if(isVisited[adjList[node].get(j)]) {
					continue;
				}
				queue.add(adjList[node].get(j));
				isVisited[adjList[node].get(j)] = true;
			}
		}


*/


/*
0 - {}
1 - {}
2 - {0,1,2,3,4,5}


  ArrayList<Integer>[] edgesToAdjList(intn, int[][] edges) {
		ArrayList<Integer>[] adjList = newArrayList[n];
		for(inti = 0; i < n; i++) {
			adjList[i] = newArrayList<Integer>();
		}
		for(inti = 0; i < edges.length; i++) {
			adjList[edges[i][0]].add(edges[i][1]);
			if(edges[i][0] == edges[i][1]) {
				continue;
			}
			adjList[edges[i][1]].add(edges[i][0]);
		}
		returnadjList;
    }




*/