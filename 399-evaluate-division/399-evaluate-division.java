// https://leetcode.com/problems/evaluate-division/discuss/3543665/Java-Simple-Solution-Hash-and-DFS-Recursion

class Solution {
     public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for(int i = 0, len = values.length; i < len; i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            if (!graph.containsKey(a)) {
                graph.put(a, new HashMap<>());
            }
            graph.get(a).put(b, values[i]);

            if (!graph.containsKey(b)) {
                graph.put(b, new HashMap<>());
            }
                graph.get(b).put(a, 1 / values[i]);
        }

        int lenValues = queries.size();
        double[] answer = new double[lenValues];
        for(int i = 0; i < lenValues; i++) {
            answer[i] = dfs(graph, queries.get(i).get(0), queries.get(i).get(1), 1, new HashSet<>());
        }
        return answer;
    }
    double dfs(Map<String, Map<String, Double>> graph, String cur, String end, double answer, Set<String> visited) {
        if (!graph.containsKey(cur)) return -1.0;
        if (cur.equals(end)) return answer;
        visited.add(cur);
        for (String str :  graph.get(cur).keySet()) {
            if (!visited.contains(str)) {
                double check = dfs(graph, str, end, answer *  graph.get(cur).get(str), visited);
                if (check != -1.0) {
                    return check;
                }
            }
        }
        return -1.0;
    }
}