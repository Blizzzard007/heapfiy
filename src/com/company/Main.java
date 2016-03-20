package com.company;

public class Main {

    public static void main(String[] args) {
        int[] A = {3,2,1,4,5};
        heapify hh = new heapify();
        hh.heapify(A);
	// write your code here
    }
}
/**
 *
 * 二叉树的度定义：度其实就是二叉树中的 连接节点与节点之间的线
 * in this case，In a tree,we have n TreeNode,then we will
 * have (n-1) degree
 * 根据这个性质，我们就可以判断一个具备n个节点的完全二叉树，其叶子节点有多少个
 * 关于节点和度数之间的关系有很多公式： 度为0的节点数 为度为2的节点数加一
 * n0 = n2 + 1
 * 这个公式推理如下
 * k 总度数
 * k+1 总节点数
 * n0 度为0的节点
 * n1 度为1的节点
 * n2 度为2的节点
 * 根据二叉树中度和节点守恒的原理 可以列一组方程
 * k = n2*2+n1
 * k+1 = n2+n1+n0；
 * 二个式子相减 得到n0 = n2+1
 *
 *
 *
 * 分析：假设二叉树中叶子节点个数 为n0，度为1的节点个数为n1，度为2的节点个数为n2，n代表书里面的节点个数
 *
 *     所以 n0+n1+n2 = n
 *     对于二叉树 有 n0 = n2+1
 *     消掉n2 得到 n = 2n0+n1-1
 *     由于二叉树当中度为1的只有0个或者一个二种情况，所以将0和1代入上面公式整理后得到的
 *     是n0 = (n+1) /2或者n0 = n/2
 *
 * */