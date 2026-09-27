package com.studentdirectory.data_structure;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList; 
import java.util.HashMap;
import java.util.HashSet;

public class SlidingWindow
{
    //Length of longest substring without repeating characters
    /*Input: s = "abcabcbb"
    Output: 3*/
    public static int lengthOfLongestSubstring(String s) {
        char[] characters = s.toCharArray();
        HashSet<Character> set = new HashSet<Character>();
        int left = 0;
        int maxLength = 0;
        for(int right=0;right<characters.length;right++)
        {
            while(set.contains(characters[right]))
            {
                set.remove(characters[left]);
                left++;
            }
            set.add(characters[right]);
            maxLength=(maxLength>(right-left+1)?maxLength:(right-left+1));
        }
        return maxLength;
    }

    //Maximum sum of distinct subarrays with length k
    /*Input: nums = [1,5,4,2,9,9,9], k = 3
    Output: 15*/
    public long maximumSubarraySum(int[] nums, int k) {
        long maxTotal = 0;
        long max = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        int left = 0;
        for(int right=0;right<nums.length;right++)
        {
            while(set.contains(nums[right]))
            {
                set.remove(nums[left]);
                maxTotal=maxTotal-nums[left];
                left++;
            }

            set.add(nums[right]);
            maxTotal=maxTotal+nums[right];

            if(right-left+1 > k)
            {
                set.remove(nums[left]);
                maxTotal=maxTotal-nums[left];
                left++;
            }

            if(right-left+1 == k)
            {
                max=max>maxTotal?max:maxTotal;
            }
        }
        return max;
    }

    public static void main(String[] args)
    {
        String s = "abcabcbb";
        SlidingWindow sw = new SlidingWindow();
        System.out.println("Length of longest substring without repeating characters = "+sw.lengthOfLongestSubstring(s));

        int[] arr = new int[]{1,5,4,2,9,9,9};
        int k = 3;
        System.out.println("Maximum sum of distinct subarrays with length k = "+sw.maximumSubarraySum(arr,k));
    }

}

