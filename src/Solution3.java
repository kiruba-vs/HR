import java.util.ArrayList;
import java.util.List;

class Solution3 {

    public static void main(String[] args) {
        Solution3 asd = new Solution3();
        System.out.println(asd.solveNQueens(8));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> total = new ArrayList<List<String>>();


        int[][] opt = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                opt[i][j] = 0;
            }
        decide(opt, n, 0, 0);

        return total;

    }

    public void decide(int[][] a, int n, int row, int col){

        List<int[][]> tot = new ArrayList<int[][]>();
        int i= row;
        int j= col;

        while(i<n){
            int tmp[][] = a;
            j=0;
            int motion = 1;
            int Qfound=0;
            while(j<n){
                if(tmp[i][j] == 1){
                    tmp[i][j] =0;motion = -1; continue;
                }
                if((colCheck(tmp, i, j) == 1) && (LD(tmp, i, j) == 1) && (RD(tmp, i, j, n) == 1)){
                    tmp[i][j] =1;
                    i++;
                    if(i== n-1){
                        tot.add(tmp);
/*                        for(int z=0;z<n;z++) {
                         for (int z1 = 0; z1 < n; z1++)
                                    System.out.print(tmp[z][z1] + " ");
                                System.out.println("\n");
                            }*/

                            //break;
                    }
                    else
                        decide(tmp,n, i+1, 0);
                }

                j++;
            }
                i--;motion=1;

        }



    }



    public int colCheck(int[][] a, int row, int col){
        int x=1;
        if(row == 0)
            return x;

        for(int i=row-1; i>=0; i--){
            if(a[i][col] == 1) {
                x = 0; break;
            }
        }
        return x;
    }

    public int LD(int[][] a, int row, int col){
        int x=1;
        if(col==0)
            return x;

        for(int y=row-1; y>=0; y--){
            if(a[--row][--col] == 1) {
                x = 0; break;
            }
            if(col==0 || row == 0)
                break;
        }

        return x;
    }

    public int RD(int[][] a, int row, int col, int n){
        int x=1;
        if(col==(n-1))
            return 1;

        for(int y=row-1; y>=0; y--){
            if(a[--row][++col] == 1) {
                x = 0; break;
            }
            if(col==(n-1))
                break;
        }
        return x;
    }
}