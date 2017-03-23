package hackerrank.algos;

import java.util.Scanner;

public class EvenTree {
    
    /*
     * Given a tree, reduce the tree into a forest with maximum trees such that each tree in the forest has even
     * vertices. You can assume that the given tree will always be reducible to a forest of even vertices tree. First
     * two inputs are the number of vertices and the number of edges. The next pair of inputs represent each the 
     * vertices that for an edge of the tree.
     */
    
    int[][]grid;
    int vertices;
    int edges;
    
    public EvenTree(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        grid = new int[2][vertices+1];
        for(int i=1; i<=vertices; i++)
            grid[1][i] = 1;
    }
    
    public void addEdge(int u, int v) {
        grid[0][u] = v;
        
        int next = grid[0][u];
        int carryOver = grid[1][u];
        while(next != 0) {
            grid[1][next] += carryOver;
            next = grid[0][next];
        }
    }
    
    public void prettyPrint() {
        for(int j=0; j<3; j++) {
            for(int i=1; i<=vertices; i++)
                if(j==0)
                    System.out.print(i + " ");
                else
                    System.out.print(grid[j-1][i] + " ");
            System.out.println();
        }
    }
    
    public int reduce() {
        int count = 0;
        for(int i=vertices; i > 1; i--) {
            if(grid[1][i] % 2 == 0) {
                count++;
                int next = grid[0][i];
                while(next != 0) {
                    grid[0][i] = 0;
                    grid[1][next] -= grid[1][i];
                    next = grid[0][next];
                }
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int vertices = in.nextInt();
        int edges = in.nextInt();

        EvenTree tree = new EvenTree(vertices, edges);
        
        for(int i=0; i<edges; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            tree.addEdge(u, v);
        }
        in.close();

        tree.prettyPrint();
        int removed = tree.reduce();
        tree.prettyPrint();
        
        System.out.println("Removed edges : " + removed);
    }
}
