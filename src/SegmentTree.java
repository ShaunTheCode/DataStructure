import javax.swing.text.Segment;

/**
 *
 * @author wxy
 * @date 2021/07/09 15:47
 * @since 1.0
 */
public class SegmentTree
{
    // 构造的代码及注释
    public SegmentTreeNode build(int[] a) {
        // write your code here
        return buildhelper(0, a.length - 1, a);
    }

    public SegmentTreeNode buildhelper(int left, int right, int[] a){
        if(left > right){
            return null;
        }
        // 根据节点区间的左边界的序列值为节点赋初值
        SegmentTreeNode root = new SegmentTreeNode(left, right, a[left]);
        if(left == right){
            // 如果左边界和右边界相等,节点左边界的序列值就是线段树节点的节点值
            return root;
        }
        // 划分当前区间的左右区间
        int mid = (left + right) / 2;
        root.left = buildhelper(left, mid, a);
        root.right = buildhelper(mid + 1, right, a);
        // 根据节点区间的左右区间的节点值得到当前节点的节点值
        root.max = Math.max(root.left.max, root.right.max);
        return root;
    }


    public static void main(String[] args)
    {
        SegmentTree segmentTree=new SegmentTree();
        segmentTree.build(new int[]{1,4,3,0});
    }

}


// 节点区间定义
// [start, end] 代表节点的区间范围
// max 是节点在(start,end)区间上的最大值
// left , right 是当前节点区间划分之后的左右节点区间
class SegmentTreeNode {
    public int start, end, max;
    public SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end, int max) {
        this.start = start;
        this.end = end;
        this.max = max;
        this.left = this.right = null;
    }
}