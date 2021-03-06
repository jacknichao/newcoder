/**
 * Created by Administrator on 2016/7/19.
 * 题目描述
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，
 * 请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回
 */
public class RebuildBinTree {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if(pre==null||in==null){
            return null;
        }
        //空间换时间，两次遍历之后，找到元素在中序中的未知索引
        int maxVaue=Integer.MIN_VALUE;
        for(int n:in){
            if(n>maxVaue) maxVaue=n;
        }
        int[] indexArr=new int[maxVaue+1];
        for(int i=0;i<in.length;i++){
            indexArr[in[i]]=i;

        }

        return construct(pre,0,pre.length-1,in,0,in.length-1,indexArr);

    }

    public  TreeNode construct(int[] pre, int pl, int pr, int[] in , int il, int ir, int[] indexArr){
        if(pl>pr){
            return null;
        }

        TreeNode root =new TreeNode(pre[pl]);
        int index=indexArr[pre[pl]];

        root.left=construct(pre,pl+1,pl+index-il,in,il,index-1,indexArr);
        root.right=construct(pre,pl+index-il+1,pr,in,index+1,ir,indexArr);

        return root;
    }







    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
