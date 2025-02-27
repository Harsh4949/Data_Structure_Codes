package Backtracking;

public class MouseMaze {
    
    public static void findPath(int [][]maze,int [][]solution,int x,int y,int m,int n){

        //base case 

        if (x<0||y<0||x==m||y==n||maze[x][y]==0) {
            return;
        }

        if (x==m-1 && y==n-1) {

            solution[x][y]=1;   //mark last destination
            printBord(solution);
            // solution[x][y]=0;   // if other path exits then unmark not major issue if not write
            return;
        }

        //recursion

        maze[x][y]=0;
        solution[x][y]=1;

        findPath(maze, solution, x+1, y,m,n);   //down
        findPath(maze, solution, x, y-1,m,n);   //up
        findPath(maze, solution, x, y+1,m,n);   //right
        findPath(maze, solution, x-1, y,m,n);   //left

        //backtrack
        
        maze[x][y]=1;
        solution[x][y]=0;
      
    }

    public static void printBord(int[][] args) {
        
        System.out.println("--------------Rat Path----------------");

        for(int i=0;i<args.length;i++){
            for(int j=0;j<args[0].length;j++){
                System.out.print(args[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int maze[][] = { { 1, 0, 0, 0 }, 
                         { 1, 1, 0, 1 }, 
                         { 0, 1, 1, 0 }, 
                         { 1, 1, 1, 1 }
                         }; 

        int solution[][]=new int[maze.length][maze[0].length];     
        
        findPath(maze, solution, 0, 0,maze.length,maze[0].length);


    }
}
