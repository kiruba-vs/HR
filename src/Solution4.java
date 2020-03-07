import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

class Solution4 {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> total = new ArrayList<List<String>>();
            for (int pos = 0; pos < n; pos++) {
                List<String> a = new ArrayList<>();
                List<int[][]> solList= new ArrayList<int[][]>();
                int[][] opt = new int[n][n];
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < n; j++) {
                        opt[i][j] = 0;
                    }
                opt[0][pos] = 1;
                //opt = decide(solList, opt, n, 0, 0);


                int i=1;
                while(i<n){
                    int Qfound = 0;
                    int j=0;
                    while(j<n){
                        if(opt[i][j] == 1 || opt[i][j] == -1){
                            opt[i][j]=0; j++; continue;
                        }
                        if((colCheck(opt, i, j) == 1) && (LD(opt, i, j) == 1) && (RD(opt, i, j, n) == 1)){
                            opt[i][j] =1; Qfound=1;  break;
                        }
                        j++;
                    }
                    if(Qfound == 0)
                        i=i-1;
                    else
                        i++;
                    if(i==0){
                        opt = null;
                        break;

                    }
                }

                if(opt != null) {
                    for (int v = 0; v < n; v++) {
                        String row = new String();
                        for (int m = 0; m < n; m++) {
                            if (opt[v][m] == 1)
                                row = row.concat("Q");
                            else
                                row = row.concat(".");
                        }
                        a.add(row);
                    }
                }
                if((! a.isEmpty()) && (a != null))
                    total.add(a);
            }
            return total;

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