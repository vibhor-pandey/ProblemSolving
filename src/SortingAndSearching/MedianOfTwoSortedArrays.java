package SortingAndSearching;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;
        boolean isEvenLength = (nums1Len + nums2Len) % 2 == 0;

        int nums1Pointer = 0;
        int nums2Pointer = 0;
        int count = 0;
        int m1 = 0, m2 = 0;
        while(count <= (nums1Len + nums2Len) / 2) {

            if(isEvenLength) {
                m2 = m1;
            }
            if(nums1Pointer != nums1Len && nums2Pointer != nums2Len) {
                if(nums1[nums1Pointer] < nums2[nums2Pointer]) {
                    m1 = nums1[nums1Pointer++];
                } else {
                    m1 = nums2[nums2Pointer++];
                }
            } else if(nums1Pointer < nums1Len) {
                m1 = nums1[nums1Pointer++];
            } else {
                m1 = nums2[nums2Pointer++];
            }
            count++;
        }

        return isEvenLength ? (double)(m1 + m2) / 2 : m1;
    }
}
