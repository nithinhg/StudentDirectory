package com.studentdirectory.data_structure;
import java.util.Arrays;

public class Array
{
    // MAX volume of water
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

    //Earliest Moment When Everyone Become Friends
    public static int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[0], b[0]));
        int count = n;
        for(int[] log:logs)
        {
            int time = log[0];
            int person1 = log[1];
            int person2 = log[2];
            
            if(person1 != person2)
            {
                logs = update(logs,person1,person2);
                count--;
                if(count == 1)
                {
                    return time;
                }
            }
        }
        return -1;
    }
    public static int[][] update(int[][] logs,int person1, int person2)
    {
        for(int[] log:logs)
        {
            if(log[1]==person1)
            {
                log[1]=person2;
            }
            if(log[2]==person1)
            {
                log[2]=person2;
            }
        }
        return logs;
    }

    public static void main(String str[])
    {
        int[] waterArray = {1,8,6,2,5,4,8,3,7};
        System.out.println("Maximum wanter volume = "+maxArea(waterArray));

        int[][] matrix = {
            {1, 0, 1},
            {2, 1, 2},
            {3, 0, 2},
            {4, 2, 3}
        };
        System.out.println("Earliest Time Everyone Became Friends = "+earliestAcq(matrix,4));
    }
}