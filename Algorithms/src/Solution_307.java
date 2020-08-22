public class Solution_307 {
    public static class NumArray{
        private interface Merger<E> {
            E merge(E a, E b);
        }

        public class SegmentTree<E> implements Merger<E> {
            private E[] data;
            private E[] tree;
            private Merger<E> merger;

            public SegmentTree(E[] arr, Merger<E> merger){
                data = (E[])new Object[arr.length];
                for (int i = 0; i < arr.length; i++)
                    data[i] = arr[i];
                this.merger = merger;
                tree = (E[])new Object[4 * arr.length];
                buildSegmentTree(0, 0, data.length - 1);
            }

            // 在treeIndex的位置创建表示区间[l...r]的线段树
            private void buildSegmentTree(int treeIndex, int l, int r){
                if(l == r){
                    tree[treeIndex] = data[l];
                    return;
                }
                int leftTreeIndex = leftChild(treeIndex);
                int rightTreeIndex = rightChild(treeIndex);
                int mid = l + (r - l) / 2;
                buildSegmentTree(leftTreeIndex, l, mid);  // 创建左子树的线段树
                buildSegmentTree(rightTreeIndex, mid + 1, r);  // 创建右子树的线段树

                tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
            }


            // 返回CBT的数组表示中，index所表示的元素的左孩子的索引
            private int leftChild(int index){
                return index * 2 + 1;
            }

            // 返回CBT的数组表示中，index所表示的元素的右孩子的索引
            private int rightChild(int index){
                return index * 2 + 2;
            }

            // 返回[queryL, queryR]的值
            public E query(int queryL, int queryR){
                if(queryL < 0 || queryL >= data.length
                        || queryR < 0 || queryR >= data.length || queryL > queryR){
                    throw new IllegalArgumentException("Index is illegal.");
                }
                return query(0, 0, data.length - 1, queryL, queryR);
            }

            // 在以treeIndex为根的线段树[l...r]的范围里，搜索区间[queryL, queryR]
            private E query(int treeIndex, int l, int r, int queryL, int queryR){
                if(l == queryL && r == queryR){
                    return tree[treeIndex];
                }
                int mid = l + (r - l) / 2;
                int leftTreeIndex = leftChild(treeIndex);
                int rightTreeIndex = rightChild(treeIndex);

                if(queryL >= mid + 1){
                    return query(rightTreeIndex, mid + 1, r, queryL, queryR);
                }else if(queryR <= mid){
                    return query(leftTreeIndex, l, mid, queryL, queryR);
                }else {
                    return merger.merge(query(leftTreeIndex, l, mid, queryL, mid),
                            query(rightTreeIndex, mid + 1, r, mid + 1, queryR));
                }
            }

            // 将index位置的值更新为e
            public void set(int index, E e){
                if(index < 0 || index >= data.length)
                    throw new IllegalArgumentException("Index is illegal.");
                data[index] = e;
                set(0, 0, data.length - 1, index, e);
            }

            // 在以treeIndex为根的线段树中更新index位置的值为e
            private void set(int treeIndex, int l, int r, int index, E e){
                if(l == r){
                    tree[treeIndex] = e;
                    return;
                }
                int mid = l + (r - l) / 2;
                int leftTreeIndex = leftChild(treeIndex);
                int rightTreeIndex = rightChild(treeIndex);
                if(index <= mid){
                    set(leftTreeIndex, l, mid, index, e);
                }else{
                    set(rightTreeIndex, mid + 1, r, index, e);
                }
                // 更新总和
                tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
            }

            @Override
            public E merge(E a, E b) {
                return null;
            }
        }

        private SegmentTree<Integer> segTree;

        public NumArray(int[] nums){
            if(nums.length != 0){
                Integer[] data = new Integer[nums.length];
                for(int i = 0; i < nums.length; i++){
                    data[i] = nums[i];
                }
                segTree = new SegmentTree<>(data, (a, b) -> a + b);
            }
        }

        public void update(int i, int val){
            if(segTree == null)
                throw new IllegalArgumentException("Error");
            segTree.set(i, val);
        }

        public int sumRange(int i, int j){
            if(segTree == null)
                throw new IllegalArgumentException("Error");
            return segTree.query(i, j);
        }
    }
}
