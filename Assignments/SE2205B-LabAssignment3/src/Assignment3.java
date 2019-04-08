import java.util.LinkedList;

public class Assignment3
{
     int vertex = 6;

    public int breadthFirstPathSearch(int graph[][], int s, int d, int parent[])//Breadth first path traversal
    {
        int reached[] = new int[vertex];
        int count=0;
        
         while(count < vertex)
        {
            reached[count] = 0;
            count++;
        }

        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(s);
        reached[s] = 1;
        parent[s]=-1;

        while(q.size() != 0)
        {
            int temp = q.poll();

            int vtemp = 0;
            while(vtemp < vertex)
            {
                 if(reached[v]==0 && graph[temp][v] > 0)
                 {
                      q.add(v);
                      parent[v] = temp;
                      reached[v] = 1;
                 }
                       
                 vtemp++;
             }
//             for(int v=0; v < vertex; v++)
//             {
//                 if(reached[v]==0 && graph[temp][v] > 0)
//                 {
//                     q.add(v);
//                     parent[v] = temp;
//                     reached[v] = 1;
//                 }
//             }
        }

        if(reached[d] == 1)
        {
            System.out.println("T");
            return 1;

        }
        else
        {
            System.out.println("F");
            return 0;
        }
    }

    public int maximizeFlowNetwork(int graph[][], int s, int t)    //max flow
    {



        int resGraph[][] = new int[vertex][vertex];
        int a, b;
        for (a = 0; a < vertex; a++)
            for (b = 0; b < vertex; b++)
                resGraph[a][b] = graph[a][b];
        int maxFlow = 0;
        int parent[] = new int[vertex];




        while (breadthFirstPathSearch(resGraph, s, t, parent) == 1)
        {

            int pathFlow = Integer.MAX_VALUE;
             
             b=t;
             while(b != s)
             {
                  a = parent[b];
                  pathFlow = Math.min(pathFlow, resGraph[a][b]);
                  b=parent[b];
             }
           
             b=t;
             while(b != s)
             {
                  a = parent[b];
                  resGraph[a][b] =resGraph[a][b]- pathFlow;
                  resGraph[b][a] =resGraph[b][a]+ pathFlow;
                  b=parent[b];
             }
             
            maxFlow = maxFlow+ pathFlow;
        }


        return maxFlow;

    }

}
