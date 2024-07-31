public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2)); // 输出 2.0

        int[] nums1_2 = {1, 2};
        int[] nums2_2 = {3, 4};
        System.out.println(solution.findMedianSortedArrays(nums1_2, nums2_2)); // 输出 2.5

        int[] nums1_3 = {};
        int[] nums2_3 = {1};
        System.out.println(solution.findMedianSortedArrays(nums1_3, nums2_3)); // 输出 1.0

        int[] nums1_4 = {2};
        int[] nums2_4 = {};
        System.out.println(solution.findMedianSortedArrays(nums1_4, nums2_4)); // 输出 2.0
       
        int[] nums1_5 = {1};
        int[] nums2_5 = {2, 3, 4, 5, 6, 7, 8};
        System.out.println(solution.findMedianSortedArrays(nums1_5, nums2_5)); // 输出 4.5
   
        int[] nums1_6 = {2, 3, 4, 5};
        int[] nums2_6 = {1};
        System.out.println(solution.findMedianSortedArrays(nums1_6, nums2_6)); // 输出 3.0
   
    }
}
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if((m + n) % 2 == 0){
            int q1 = (m + n) / 2;
            int q2 = (m + n) / 2 + 1;
            System.out.println(getKth(nums1, nums2, q1));
            System.out.println(getKth(nums1, nums2, q2));
            return (getKth(nums1, nums2, q1) + getKth(nums1, nums2, q2)) * 0.5;
        }else{
            int q1 = (m + n) / 2 + 1;
            int q2 = (m + n) / 2 + 1;
            return (getKth(nums1, nums2, q1) + getKth(nums1, nums2, q2)) * 0.5;
        }
    }
    private int getKth(int[] nums1, int[] nums2, int q){
        //k：还需要去掉的数量
        int k = q;
        //nums1的已去位置
        int k1 = -1;
        //nums2的已去位置
        int k2 = -1;
        if(nums1.length == 0){
            return nums2[q - 1];
        }else if(nums2.length == 0){
            return nums1[q - 1];
        }else{
            while(k > 0){
                if(k % 2 == 0){
                    k = k / 2;
                    if((k1 + k <= nums1.length - 1) && (k2 + k <= nums2.length - 1)){
                        if(nums1[k1 + k] > nums2[k2 + k]){
                            k2 = k2 + k;
                        }else if(nums1[k1 + k] < nums2[k2 + k]){
                            k1 = k1 + k;
                        }else{
                            k1 = k1 + k;
                            k2 = k2 + k;
                            k = 0;
                        }
                    }else if((k1 + k <= nums1.length - 1) && (k2 + k > nums2.length - 1) && (k2 < nums2.length - 1)){
                        if(nums2[nums2.length - 1] < nums1[k1 + k]){
                            k = k + k - (nums2.length - k2 - 1);
                            k2 = nums2.length - 1;
                        }else{
                            k1 = k1 + k;
                        }
                    }else if((k2 + k <= nums2.length - 1) && (k1 + k > nums1.length - 1) && (k1 < nums1.length - 1)){
                        if(nums1[nums1.length - 1] < nums2[k2 + k]){
                            k = k + k - (nums1.length - k1 - 1);
                            k1 = nums1.length - 1;
                        }else{
                            k2 = k2 + k;
                        }
                    }else if(k1 == nums1.length - 1){
                        k2 = k2 + k;
                    }else if(k2 == nums2.length - 1){
                        k1 = k1 + k;
                    }
                }else if(k % 2 != 0 && k != 1){
                    k = k / 2;
                    if((k1 + k <= nums1.length - 1) && (k2 + k <= nums2.length - 1)){
                        if(nums1[k1 + k] > nums2[k2 + k]){
                            k2 = k2 + k;
                            k = k + 1;
                        }else if(nums1[k1 + k] < nums2[k2 + k]){
                            k1 = k1 + k;
                            k = k + 1;
                        }else{
                            k1 = k1 + k;
                            k2 = k2 + k;
                            k = 1;
                        }
                    }else if((k1 + k <= nums1.length - 1) && (k2 + k > nums2.length - 1) && (k2 < nums2.length - 1)){
                        if(nums2[nums2.length - 1] < nums1[k1 + k]){
                            k = k + k - (nums2.length - k2 - 2);
                            k2 = nums2.length - 1;
                        }else{
                            k1 = k1 + k;
                            k = k + 1;
                        }
                    }else if((k2 + k <= nums2.length - 1) && (k1 + k > nums1.length - 1) && (k1 < nums1.length - 1)){
                        if(nums1[nums1.length - 1] < nums2[k2 + k]){
                            k = k + k - (nums1.length - k1 - 2);
                            k1 = nums1.length - 1;
                        }else{
                            k2 = k2 + k;
                            k = k + 1;
                        }                  
                    }else if(k1 == nums1.length - 1){
                        k2 = k2 + k;
                        k = k + 1;
                    }else if(k2 == nums2.length - 1){
                        k1 = k1 + k;
                        k = k + 1;
                    }
                }else if(k == 1){
                    if((k1 + k <= nums1.length - 1) && (k2 + k <= nums2.length - 1)){
                        if(nums1[k1 + 1] > nums2[k2 + 1]){
                            k2 = k2 + 1;
                            k = 0;
                        }else{
                            k1 = k1 + 1;
                            k = 0;
                        }
                    }else if((k1 + k <= nums1.length - 1) && (k2 + k > nums2.length - 1)){
                        k1 = k1 + 1;
                        k = 0;
                    }else if((k2 + k <= nums2.length - 1) && (k1 + k > nums1.length - 1)){
                        k2 = k2 + 1;
                        k = 0;
                    }
                }
            }
            if((k1 != -1) && (k2 != -1)){
                if((nums1[k1] > nums2[k2])){
                    return nums1[k1];
                }else{
                    return nums2[k2];
                }
            }else if(k1 != -1){
                return nums1[k1];
            }else{
                return nums2[k2];
            }
        }
    }
}