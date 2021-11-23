package com.leetcode.structure.d01_03;

/**
 * 2、求最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 例：
 *     输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 *     输出：6
 *     解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 *
 *     「方法二」相较于「方法一」来说，时间复杂度相同，但是因为使用了递归，并且维护了四个信息的结构体，运行的时间略长，
 *     空间复杂度也不如方法一优秀，而且难以理解。那么这种方法存在的意义是什么呢？
 *
 *     对于这道题而言，确实是如此的。但是仔细观察「方法二」，它不仅可以解决区间 [0,n−1]，还可以用于解决任意的子区间 [l,r] 的问题。
 *     如果我们把 [0,n−1] 分治下去出现的所有子区间的信息都用堆式存储的方式记忆化下来，
 *     即建成一颗真正的树之后，我们就可以在 O(logn) 的时间内求到任意区间内的答案，
 *     我们甚至可以修改序列中的值，做一些简单的维护，之后仍然可以在 O(logn) 的时间内求到任意区间内的答案，
 *     对于大规模查询的情况下，这种方法的优势便体现了出来。这棵树就是上文提及的一种神奇的数据结构——线段树。
 *
 * @author kar
 * @create 2021-11-20 14:07
 */
public class MaximumSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1};
        System.out.println(new MaximumSubArray().maxSubArray(nums));
    }

    /**
     *  方法一： 动态规划
     * 思路和算法
     *  假设 nums 数组的长度是 n，下标从 0 到 n-1。
     *  我们用 f(i) 代表以第 i 个数结尾的「连续子数组的最大和」，只需要求出每个位置的 f(i)，然后返回 f 数组中的最大值即可。
     *
     *  用一个 f 数组来保存 f(i) 的值，用一个循环求出所有 f(i)。
     *  考虑到 f(i) 只和 f(i−1) 相关，于是我们可以只用一个变量 pre 来维护对于当前 f(i) 的 f(i−1) 的值是多少，从而让空间复杂度降低到 O(1)，
     *  这有点类似「滚动数组」的思想。
     *
     * 复杂度
     *      时间复杂度：O(n)，其中 n 为 nums 数组的长度。我们只需要遍历一遍数组即可求得答案。
     *      空间复杂度：O(1)。我们只需要常数空间存放若干变量。
     *
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int pre = 0, max = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(max, pre);
        }
        return max;
    }

    /**
     * 方法二：分治
     *
     * 思路和算法
     *
     *     这个分治方法类似于「线段树求解最长公共上升子序列问题」的 pushUp 操作。
     *     也许读者还没有接触过线段树，没有关系，方法二的内容假设你没有任何线段树的基础。
     *     当然，如果读者有兴趣的话，推荐阅读线段树区间合并法解决多次询问的「区间最长连续上升序列问题」和「区间最大子段和问题」，还是非常有趣的。
     *
     *     我们定义一个操作 get(a, l, r) 表示查询 a 序列 [l,r] 区间内的最大子段和，
     *     那么最终我们要求的答案就是 get(nums, 0, nums.size() - 1)。
     *     如何分治实现这个操作呢？对于一个区间 [l,r]，我们取 m = (r+l)/2，对区间 [l,m] 和 [m+1,r] 分治求解。
     *     当递归逐层深入直到区间长度缩小为 1 的时候，递归「开始回升」。
     *     这个时候我们考虑如何通过 [l,m] 区间的信息 和 [m+1,r] 区间的信息合并成区间 [l,r] 的信息。
     *
     *     最关键的两个问题是：
     *      1 我们要维护区间的哪些信息呢？
     *      2 我们如何合并这些信息呢？
     *
     * 对于一个区间 [l,r][l,r]，我们可以维护四个量：
     *     lSum 表示 [l,r] 内以 l 为左端点的最大子段和
     *     rSum 表示 [l,r] 内以 r 为右端点的最大子段和
     *     mSum 表示 [l,r] 内的最大子段和
     *     iSum 表示 [l,r] 的区间和
     *
     *     以下简称 [l,m] 为 [l,r] 的「左子区间」，[m+1,r] 为 [l,r] 的「右子区间」。
     *     我们考虑如何维护这些量呢（如何通过左右子区间的信息合并得到 [l,r] 的信息）？
     *     对于长度为 1 的区间  [i,i]，四个量的值都和 nums[i] 相等。
     *     对于长度大于 1 的区间：
     * 	1. 首先最好维护的是 iSum，区间 [l,r] 的 iSum 就等于「左子区间」的 iSum 加上「右子区间」的 iSum。
     * 	2. 对于[l,r] 的 lSum，存在两种可能，它要么等于「左子区间」的 lSum，要么等于「左子区间」的 iSum 加上「右子区间」的 lSum，二者取大。
     * 	3. 对于 [l,r] 的 rSum，同理，它要么等于「右子区间」的 rSum，要么等于「右子区间」的 iSum 加上「左子区间」的 rSum，二者取大。
     * 	4. 当计算好上面的三个量之后，就很好计算 [l,r] 的 mSum 了。我们可以考虑 [l,r] 的 mSum 对应的区间是否跨越 m——它可能不跨越 m，
     *      也就是说 [l,r] 的 mSum 可能是「左子区间」的  mSum 和 「右子区间」的 mSum 中的一个；
     *      它也可能跨越 m，可能是「左子区间」的 rSum 和 「右子区间」的 lSum 求和。三者取大。
     *
     * 这样问题就得到了解决。
     *
     * @param nums
     * @return
     */

    public int maxSubArray(int[] nums) {
        return getInfo(nums,0,nums.length-1).mSum;
    }

    class Status {
        // 分别表示左子区间的和、右子区间的和、中间子区间的和、整个区间的和
        int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    // 拆分区间并计算各个区间的和
    private Status getInfo(int[] arr, int lIndex, int rIndex) {
        if (lIndex == rIndex) {
            return new Status(arr[lIndex], arr[lIndex], arr[lIndex], arr[lIndex]);
        }
        int m = (rIndex + lIndex) >> 1;
        Status lSta = getInfo(arr, lIndex, m);
        Status rSta = getInfo(arr, m+1, rIndex);
        return pushUp(lSta, rSta);
    }

    // 计算各个子区间的最大子段和
    private Status pushUp(Status lSta, Status rSta) {
        int lSum = Math.max(lSta.lSum, lSta.iSum + rSta.lSum);
        int mSum = Math.max(Math.max(lSta.mSum, rSta.mSum), lSta.rSum + rSta.lSum);
        int rSum = Math.max(rSta.rSum, lSta.rSum + rSta.iSum);
        int iSum = lSta.iSum + rSta.iSum;
        return new Status(lSum, rSum, mSum, iSum);
    }
}

