package com.phantom.util.algorithm;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * util
 * com.phantom.util.algorithm.MinHeap
 * 2017-01-19 11:44
 * 最小堆
 */
public class MinHeap {
    //堆的存储结构    数组
    private int[] data;
    //构造函数
    public MinHeap(int[] data){
        this.data = data;
        buildHeap(data);
    }

    /**
     * 将数组转换为最小堆
     * @param data
     */
    private void buildHeap(int[] data){
        //完全二叉树只有数组下标小于或等于 (data.length) / 2 - 1 的元素有孩子结点，遍历这些结点。
        //*比如上面的图中，数组有10个元素， (data.length) / 2 - 1的值为4，a[4]有孩子结点，但a[5]没有*
        for(int i=(data.length)/2-1;i>=0;i--){
            //对有孩子节点的元素堆化（heapify）
            heapify(i);
        }
    }

    /**
     * 堆化
     * @param i
     */
    private void heapify(int i){
        //获取左右节点的数组下标
        int l = left(i);
        int r = right(i);

        // 这是一个临时变量，表示 跟结点、左结点、右结点中最小的值的结点的下标
        int smallest = i;

        //存在左节点，且左节点的值小于根节点的值
        if(l < data.length && data[l] < data[i])
            smallest = l;

        //存在右节点，且右节点的值小于以上比较的较小值
        if(r < data.length && data[r] < data[smallest])
            smallest = r;

        //左右节点的值都大于根节点，直接返回，不做任何操作
        if(i == smallest)
            return;

        //交换根节点和左右节点中最小的那个值，把根节点的值替换下去
        swap(i,smallest);

        //由于替换后左右子树会被影响，所以要对受影响的子树再进行堆化（heapify）
        heapify(smallest);
    }

    /**
     * 获取右节点数组下标
     * @param i
     * @return
     */
    private int right(int i){
        return (i + 1) << 1;
    }

    /**
     * 获取左节点数组下标
     * @param i
     * @return
     */
    private int left(int i){
        return (( i+1 ) << 1) - 1;
    }

    /**
     * 交换元素位置
     * @param i
     * @param j
     */
    private void swap(int i,int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /**
     * 获取堆中最小元素，即跟元素
     * @return
     */
    public int getRoot(){
        return data[0];
    }

    /**
     * 替换跟元素，并重置堆
     * @param root
     */
    public void setRoot(int root){
        data[0] = root;
        heapify(0);
    }

    /**
     * 堆化后的数组
     * @return
     */
    public int[] getData(){
        return  this.data;
    }
}
