package easy;

/**
 * Created by novas on 2016/11/1.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
         int[] temp=new int[m+n];
         int i=0;
         int j=0;
         int loc=0;
        while(i<m&&j<n)
        {
            if(nums1[i]<nums2[j])
            {
                temp[loc]=nums1[i];
                i++;
                loc++;
            }
            else
            {
                temp[loc]=nums2[j];
                j++;
                loc++;
            }
        }
        if(i==m)
        {
            System.arraycopy(nums2[j],j,temp,loc,n-j);
        }
        if(j==n)
        {
            System.arraycopy(nums1[i],i,temp,loc,n-i);
        }
        System.arraycopy(temp,0,nums1,0,m+n);

    }
}
