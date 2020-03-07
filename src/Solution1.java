import java.util.List;

class Solution1 {
    public List<List<String>> solveNQueens(int n) {
        List<int[][]> a = null;
        int[][]b = null;
        for(int pos=0;pos<n;pos++){
            int[][] opt = null;
            opt[pos][0]= 1;
            b = decide(opt, n, (pos+1), 0);

            a.add(pos, b);
        }
        List<List<String>> cdf =null;
        return cdf;
    }


    public int[][] decide(int[][] a, int n, int row, int col){

        for(int i=row; i<n; i++) {
            for (int j = 0; j < n; j++) {
                if ((colCheck(a, row, j) == 1) && (LD(a, row, j) == 1) && (RD(a, row, j, n) == 1)) {
                    a[row][j] = 1;
                    a = decide(a,n,i, j);
                }
            }
        }
        return a;
    }

    public int colCheck(int[][] a, int pos, int j){
        int x=1;

        for(int i=0; i<pos; i++){
            if(a[i][j] == 1)
                x=0;
        }
        return x;
    }

    public int LD(int[][] a, int pos, int j){
        int x=1;
        if(j==0)
            return x;

        for(int y=pos; y>=0; y--){
            if(a[pos--][j--] == 1)
                x=0;
            if(j==0)
                break;
        }

        return x;
    }

    public int RD(int[][] a, int pos, int j, int n){
        int x=1;
        if(j==(n-1))
            return 1;

        for(int y=pos; y>=0; y--){
            if(a[pos--][j++] == 1)
                x=0;
            if(j==(n-1))
                break;
        }
        return 1;
    }
}