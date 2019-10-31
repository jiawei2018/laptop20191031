package amazonOA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class criticalConnection {
    /*
    1192. Critical Connections in a Network

There are n servers numbered from 0 to n-1 connected
by undirected server-to-server connections forming a network
where connections[i] = [a, b] represents a connection between servers a and b.
Any server can reach any other server directly or indirectly through the network.
A critical connection is a connection that, if removed,
will make some server unable to reach some other server.
Return all critical connections in the network in any order.[notice here is ANY ORDER]
    * */
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {


        //must use list<>[] to rep graph, if use map<node, list<nei>> will TLE
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        //build graoh with adjascent list
        for(List<Integer> edge :connections) {
            graph[edge.get(0)].add(edge.get(1));
            graph[edge.get(1)].add(edge.get(0));
        }

        List<List<Integer>> results = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int[] timeStamp = new int[n];

        // -1 means node 0's parents does not exist
        find(graph, -1, 0, visited, results, timeStamp);
        return results;
    }

    int timer = 0;

    public void find(List<Integer>[] graph, int parent, int node,
                     boolean[] visited, List<List<Integer>> results, int[] timeStamp) {
        visited[node] = true;
        timeStamp[node] = timer++;
        int cur = timeStamp[node];

        for(int nei : graph[node]) {
            if(nei == parent) continue;

            if(!visited[nei]) {
                find(graph, node, nei, visited, results, timeStamp);
            }

            //update current's smallest reachable node's id
            timeStamp[node] = Math.min(timeStamp[node], timeStamp[nei]);
            if(cur < timeStamp[nei]) {
                results.add(Arrays.asList(node, nei));
            }
        }
    }



}
