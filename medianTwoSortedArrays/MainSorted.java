package medianTwoSortedArrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainSorted {
    public static void main(String[] args) {
        int[] nums1={1,3};
        int[] nums2={2};
        MedianSolution medianSolution = new MedianSolution();
        medianSolution.findMedianSortedArrays(nums1,nums2);
    }
}

class MedianSolution{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int firstLength=nums1.length;
        int secondLength= nums2.length;
        int[] temp=new int[firstLength+secondLength];
        System.arraycopy(nums1,0,temp,0,firstLength);
        System.arraycopy(nums2,0,temp,firstLength,secondLength);
        Arrays.sort(temp);

        double result1=0;
        double result2=0;
        double median=0;
        if(temp.length==1) {
            median= Array.getDouble(temp,0);
        } else if(temp.length==2) {
            result1=Array.getDouble(temp,0);
            result2=Array.getDouble(temp,1);
            median=(result1+result2)/2;
        } else if(temp.length>2) {
            if(temp.length%2==0) {
                int mid1=(firstLength+secondLength)/2;
                int mid2=mid1-1;
                result1=Array.getDouble(temp,mid1);
                result2=Array.getDouble(temp,mid2);
                median=(result1+result2)/2;
            }else{
                int mid=(firstLength+secondLength)/2;
                result1=Array.getDouble(temp,mid);
                median=result1;
            }
        }
        return median;
    }
}
