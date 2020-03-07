import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

class Solution2 {

    public static void main(String[] args) {
        Solution2 asd = new Solution2();
        System.out.println(asd.solveNQueens(8));
    }

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
                opt = decide(solList, opt, n, 0, 0);


              /*  int i=1;
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
                }*/
          /*for(int z=0;z<n;z++) {
            for (int z1 = 0; z1 < n; z1++)
                System.out.print(opt[z][z1] + " ");
            System.out.println();
        }*/



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


    public int[][] decide(List<int[][]> solList,int[][] g, int n, int row, int col){
        int i=1;

        int[][] d = g;
        while(i<n){
            int Qfound = 0;
            int j=0;
            while(j<n){
                if(d[i][j] == 1 || d[i][j] == -1){
                    d[i][j]=0; j++; continue;
                }
                if((colCheck(d, i, j) == 1) && (LD(d, i, j) == 1) && (RD(d, i, j, n) == 1)){
                    d[i][j] =1; Qfound=1;
                    if(i <n-1)
                        break;

                }
                j++;
            }
            if(Qfound == 0){
                i=i-1;
            }
            else
                i++;
            if(i==0) {
                d = null;break;
            }
            if(i==n && Qfound == 1){
                solList.add(d);
                int w=n-1;
             while(w<n){
                 int e=0, rQfound=0;
                 while(e<n){
                     if(d[w][e] == 1){
                         d[w][e] =0; continue;
                     }
                     if((colCheck(d, w, e) == 1) && (LD(d, w, e) == 1) && (RD(d, w, e, n) == 1)){
                         d[w][e] =1; rQfound=1;  break;
                     }
                     e++;
                 }
                 if(rQfound == 1)
                     w++;
                 else
                     w--;
                 if(w==0) {
                     d = null;break;
                 }
                 if(w==n && rQfound == 1) {
                     solList.add(d);
                 }
             }
            }

        }

        ListIterator<int[][]> lIt = solList.listIterator();
        while(lIt.hasNext()){
            int[][] tmp = lIt.next();
            for(int t=0; t<n; t++)
                for(int u=0; t<n;t++){
                    System.out.print(tmp[u][t]);

                }
                System.out.println();
        }

        return d;


        /*for(int z=0;z<n;z++) {
            for (int z1 = 0; z1 < n; z1++)
                System.out.print(d[z][z1] + " ");
            System.out.println();
        }*/

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