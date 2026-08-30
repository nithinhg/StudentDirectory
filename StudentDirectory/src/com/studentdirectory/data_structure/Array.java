package com.studentdirectory.data_structure;

public class Array
{
    public static int maxArea(int[] height) {
        //mininum of 2 integers = min
        //difference between 2 indices = diff 
        //volume of water = min * diff
        //Keep track of volume of water in every iteration and compare with new diff
        int left = 0;
        int right = height.length-1;
        int minimum = 1000000;
        int diff = 0;
        int maxWaterVolume = 0;
        int max = 0;
        while (left<right)
        {
            if(height[left]<=height[right])
            {
                minimum=height[left];
                diff=right-left;
                left++;
            }
            else
            {
                minimum=height[right];
                diff=right-left;
                right--;
            }
            maxWaterVolume=minimum*diff;
            if(maxWaterVolume>max)
            {
                max=maxWaterVolume;
            }
        }
        return max;
    }

    public static void main(String str[])
    {
        int[] waterArray = {1,8,6,2,5,4,8,3,7};
        System.out.println("Maximum wanter volume = "+maxArea(waterArray));
    }
}