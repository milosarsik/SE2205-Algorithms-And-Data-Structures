public class Main {

    public static void main(String[] args)
    {
        System.out.println("HELLO");
        // Let us create a graph shown in the above example
        int graph[][] =new int[][] { {0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0}
        };
        Assignment3 m = new Assignment3();

        //THIS SHOULD PRINT OUT 23

        System.out.println("The maximum possible flow is " +
                m.maximizeFlowNetwork(graph, 0, 5));
    }
}
