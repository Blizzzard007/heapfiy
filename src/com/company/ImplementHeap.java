package com.company;

/**
 * Created by hongruzh on 3/20/16.
 * heap 是complete tree heap里面的i的children分别是i*2+1 和i*2+2
 * i的parent 是 (i-1)/2
 * heap的基本思路 give you array,a heap containing those values can be built by simply "sifting" each
 * internal node down to its proper location
 *
 * 1.start with the last internal node
 * 2.swap the current internal ode with its small child,if necessary
 * 3.then follow the swapped node down
 * 4.continue untill all internal nodes are done
 */
public class ImplementHeap {
    private int[] nodes;
    private int size;
    private boolean isMaxHeap;

    public ImplementHeap(int[] A,boolean isMax){
      nodes = new int[A.length];
        size = A.length;
        isMaxHeap = isMax;
        for(int i=0;i<A.length;i++) nodes[i] = A[i];
        int start = A.length/2;
        for(int i= start;i>=0;i++){
            i++;
        }

            //shiftDown(i);
    }

    public void getNodesValue(int[] A){
        for(int i=0;i<nodes.length;i++) A[i]=nodes[i];
    }

    public boolean isEmpty(){
        if(size==0) return true;
        else return false;
    }
    public int getHeapRootValue(){
        return nodes[0];
    }
    public void swap(int x,int y){
        int temp = nodes[x];
        nodes[x] = nodes[y];
        nodes[y] = temp;
    }

}
