import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> total = new ArrayList<List<String>>();
        for (int pos = 0; pos < n; pos++) {
            int[][] opt = new int[n][n];
            List<String> a = new ArrayList<>();

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    opt[i][j] = 0;
                }
            opt[0][pos] = 1;
            if(n==1){
                a.add("Q");
                total.add(a);
                return total;
            }
            else{
                int i=1;
                while(i<n){
                    int Qfound = 0;
                    int j=0;
                    while(j<n){
                        if(opt[i][j] == 1){
                            opt[i][j]=0; j++; continue;
                        }
                        if((colCheck(opt, i, j) == 1) && (D(opt, i, j, n) == 1)){
                            opt[i][j] =1; Qfound=1;
                        }
                        if(Qfound == 1) {
                            if (i == (n - 1)) {
                                a = new ArrayList<>();
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
                                total.add(a);
                                Qfound = 0;
                            } else
                                break;
                        }
                        j++;
                    }
                    if(Qfound == 0) {
                        for(int u=0;u<n;u++)
                            opt[i][u]=0;
                        i = i - 1;
                    }
                    else
                        i++;
                    if(i==0){
                        opt = null;
                        break;

                    }
                }
            }
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

    public int D(int[][] a, int row, int col, int n){
        int x=1, LD=1, RD=1;
        int Lcol = col, Rcol=col, Lrow=row, Rrow=row;

        for(int y=row-1; y>=0; y--){
            if(Rcol<(n-1) && (a[--Rrow][++Rcol] == 1)) {
                RD = 0; break;
            }
            if(Lcol>0 && (a[--Lrow][--Lcol] == 1)) {
                LD = 0; break;
            }
        }
        if(LD ==0 || RD == 0)
            x=0;
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