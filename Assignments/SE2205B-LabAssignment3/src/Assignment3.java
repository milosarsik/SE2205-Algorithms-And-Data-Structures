import java.util.LinkedList;

public class Assignment3
{
    static final int vert = 6;

    public int breadthFirstPathSearch(int graph[][], int s, int d, int parent[])       //vertices s and d
    {
        int visited[] = new int[vert];

        for(int i = 0; i < vert; ++i)
        {
            visited[i] = 0;
        }

        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = 1;
        parent[s]=-1;

        while(queue.size() != 0)
        {
            int temp = queue.poll();

            for(int v=0; v < vert; v++)
            {
                if(visited[v]==0 && graph[temp][v] > 0)
                {
                    queue.add(v);
                    parent[v] = temp;
                    visited[v] = 1;
                }
            }
        }

        if(visited[d] == 1)
        {
            System.out.println("True");
            return 1;

        }
        else
        {
            System.out.println("False");
            return 0;
        }
    }

    public int maximizeFlowNetwork(int graph[][], int s, int t)     // computes maximum flow
    {
        int u, v;

        // Create a residual graph and fill the residual graph
        // with given capacities in the original graph as
        // residual capacities in residual graph

        // Residual graph where rGraph[i][j] indicates
        // residual capacity of edge from i to j (if there
        // is an edge. If rGraph[i][j] is 0, then there is
        // not)
        int rGraph[][] = new int[vert][vert];

        for (u = 0; u < vert; u++)
            for (v = 0; v < vert; v++)
                rGraph[u][v] = graph[u][v];

        // This array is filled by BFS and to store path
        int parent[] = new int[vert];

        int max_flow = 0;  // There is no flow initially

        // Augment the flow while tere is path from source
        // to sink
        while (breadthFirstPathSearch(rGraph, s, t, parent) == 1)
        {
            // Find minimum residual capacity of the edhes
            // along the path filled by BFS. Or we can say
            // find the maximum flow through the path found.
            int path_flow = Integer.MAX_VALUE;
            for (v=t; v!=s; v=parent[v])
            {
                u = parent[v];
                path_flow = Math.min(path_flow, rGraph[u][v]);
            }

            // update residual capacities of the edges and
            // reverse edges along the path
            for (v=t; v != s; v=parent[v])
            {
                u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
            }

            // Add path flow to overall flow
            max_flow += path_flow;
        }

        // Return the overall flow
        return max_flow;

    }

}
