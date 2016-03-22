package com.company;

/**
 * Created by hongruzh on 3/21/16.
 */
public class numberofIsLand {
    private int[] sz;
    private int[] id;
    private int N, M;

    public int find(int p) {
        while (id[p] != p)//相当于祖先 每一个index所对应的值 都有一个祖先
            p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        if (sz[rootP] < sz[rootQ])  {sz[rootQ] += sz[rootP]; id[rootP] = id[rootQ];}
        else                        {sz[rootP] += sz[rootQ]; id[rootQ] = id[rootP];}

        //case(0,0)和case(1,0)的合并
        //union(0,4)  p=0的祖先 为0 q=4的祖先为4 此时此刻p的祖先要小于q 所以
        //     sz[4] = sz[q]=sz[q]+sz[p] = sz[0]+sz[4] = 2
        //     id[0] = id[4] id数组变成了{4，1，2，3，4，5}
        //
    }

    private boolean inside(int x, int y) {
        return (x >= 0 && y >= 0 && x < N && y < M);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length ==0) return 0;
        N = grid.length;
        M = grid[0].length;
        sz = new int[N*M];
        id = new int[N*M];
        /**
         *  char[][] island ={{'1','0','0','0'},{'1','0','0','1'}};
         *  id = {0,1,2,3,4,5};
         *  sz = {1,1,1,1,1,1};
         *  先分析 (0,0) (0,1) (0,2) (0,3)
         *        (1,0) (1,1) (1,2) (1,3)
         *
         *        case(0,0) temp = 0
         *           进入这个循环的前提前提就是该点的值为1
         *           这个看这个case的上下左右，并且判断是不是在合法的的grid里面 如果为一的话，就这2个元素合并
         *           注意union函数里面的index，如果是i改变的话union必须要加上M 或者减去M
         *           case(0,0)这个例子执行到if (inside(i+1, j) && grid[i+1][j] != '0') union(tmp, tmp + M);
         *           我们就可以合并这case(0,0)和case(1,0)的祖先
         *           union(0,4) 步骤见上面的函数
         *
         *        case(0,1) temp = 1
         *           因为case(0,1)==0 不进入循环
         *        case(0,2) temp = 2
         *           因为case(0,2)==0 不进入循环
         *        case(0,3) temp = 3
         *           因为case(0,3)==0 不进入循环
         *        case(1,0) temp = 4
         *           case(1,0)进入循环之后 在union(4,0)的函数中会跳出循环
         *        case(1,1) temp = 5
         *           case(1,1)不进入循环
         *
         *        case(1,2) temp = 6
         *        case(1,3) temp = 7
         *           进入循环之后 会
         *
         *
         * */

        for (int i = 0; i < N*M; i++) {
            id[i] = i;
            sz[i] = 1;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                if (grid[i][j] != '0') {
                    int tmp = i*M + j;
                    if (inside(i-1, j) && grid[i-1][j] != '0') union(tmp, tmp - M);
                    if (inside(i, j-1) && grid[i][j-1] != '0') union(tmp, tmp - 1);
                    if (inside(i+1, j) && grid[i+1][j] != '0') union(tmp, tmp + M);
                    if (inside(i, j+1) && grid[i][j+1] != '0') union(tmp, tmp + 1);
                }
        }
        int islands = 0, i = 0;
        while (i < N*M) {
            if (i == id[i] && grid[i/M][i%M] != '0') islands++;
            i++;
        }
        return islands;
    }
}
