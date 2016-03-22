package com.company;

/**
 * Created by hongruzh on 3/20/16.
 */
public class heapify {
    public void heapify(int[] A){
        int start = A.length/2;
        for(int i=start;i>=0;i--){
            siftDown(i,A);
        }
    }


    /**
     *         3
     *       2  1
     *     4  5
     *
     *     3   2   1   4   5
     *     0   1   2   3   4
     *
     * TreeNode 4 and TreeNode 5 does not need to compare with their children
     * so we can start from TreeNode 2
     *  as we know these TreeNodes was stored in an Array
     *  the index of 2 is is 1 so the
     *   left child is 2*+1
     *   right child is 2*+2
     *
     *   the next step we need to compare the value in this index
     *   there are two situations
     *
     *   first situation is if A[i]<A[2*i+1] && A[2*i+2]  we do not need to do any changes
     *   sceond situation is if A[i]>Min{A[2*i+1],A[2*i+2]}we should exchange the A[i] with the Min{A[2i+1],A[2*i+2]}
     * */

    public void siftDown(int k,int[] A){
        while(k<A.length){
            int smallest  = k;
            if(2*k+1<A.length&&A[smallest]>A[2*k+1]){
                smallest = 2*k+1;
            }
            if(2*k+2<A.length&&A[smallest]>A[2*k+2]){///还有就是 2k+2 2k+1这些值一定要放到前面 来判断
                smallest = 2*k+2;
            }
            //在这里直接判断了 A[index]和他的左孩子 右孩子 所在位置的值 所以,如果变化的话 改变smallest的index
            //但是这里没有变化的话 就说明 index所在位置的值要小于 他左孩子 右孩子 所在位置的值 所以这个时候 就要break
            if(smallest==k) break;

            int temp = A[smallest];
            A[smallest] = A[k];
            A[k] = temp;

            k = smallest;


        }
    }

    public void Swap(int[] A,int index1,int index2){
        int temp = A[index2];
        A[index2] = A[index1];
        A[index1] = temp;
    }



//////另外一种方法  网上的

    private void shiftDown(int ind, int[] A){
        int size = A.length;
        int left = ind*2+1;
        int right = ind*2+2;
        while (left<size || right<size){
            int leftVal = (left<size) ? A[left] : Integer.MAX_VALUE;
            int rightVal = (right<size) ? A[right] : Integer.MAX_VALUE;
            int next = (leftVal<=rightVal) ? left : right;
            if (A[ind]<A[next]) break;
            else {
                swap(A, ind,next);
                ind = next;
                left = ind*2+1;
                right = ind*2+2;
            }
        }
    }

    private void swap(int[] A, int x, int y){
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }

}
