package com.studentdirectory.data_structure;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List; 

public class Array
{
    public static boolean linearSearch(int item,int[] arr)
    {
        for(int i:arr)
        {
            if(i==item)
            {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(int item,int[] arr)
    {
        //1,2,3,4,5
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length-1;
        int mid;

        while(left < right)
        {
            mid = left + (right-left)/2;
            if (arr[mid] == item)
            {
                return true;
            }
            if (item < arr[mid])
            {
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }
        }
        return false;
    }

    public static void quickSort(int[] arr,int low, int high)
    {
        if(low >= high)
        {
            return;
        }
        int pivotIndex = partition(arr,low,high);

        quickSort(arr,low,pivotIndex-1);
        quickSort(arr,pivotIndex+1,high);
    }

    public static int partition(int[] arr,int low, int high)
    {
        int pivot = arr[high];
        int i = low;

        for(int j=low;j<high;j++)
        {
            if(arr[j]<pivot)
            {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }

        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i;
    }

    public static int maxArea(int[] height) {
        //mininum of 2 integers = min
        //difference between 2 indices = diff 
        //volume of water = min * diff
        //Keep track of volume of water in every iteration and compare with new diff
        int left = 0;
        int right = height.length-1;
        int minimum;
        int diff;
        int maxWaterVolume;
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

    /*
     * Complete the 'mergeHighDefinitionIntervals' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY intervals as parameter.
     */

    public static List<List<Integer>> mergeHighDefinitionIntervals(List<List<Integer>> intervals) {
    intervals.sort((a,b) -> Integer.compare(a.get(0), b.get(0)));
    List<List<Integer>> result = new ArrayList<>();
    
    for(int i=0;i<intervals.size();i++)
    {
        if(i!=0)
        {
            if(intervals.get(i).get(0) <= result.get(result.size()-1).get(1))
            {
                if(intervals.get(i).get(1) >= result.get(result.size()-1).get(1))
                {
                    result.get(result.size()-1).set(1, intervals.get(i).get(1));
                }
            }
            else
            {
                result.add(intervals.get(i));
            }
        }
        else
        {
            result.add(intervals.get(i));
        }
    }
    return result;
    }

    public static void main(String str[])
    {
        // int[] array = {1,8,6,2,5,4,9,3,7};

        // //Linear Search
        // System.out.println("Item found in an array = "+linearSearch(8,array));
        // System.out.println("Item found in an array = "+linearSearch(0,array));
        // System.out.println();

        // //Binary Search
        // System.out.println("Item found in an array = "+binarySearch(8,array));
        // System.out.println("Item found in an array = "+binarySearch(0,array));
        // System.out.println();

        // //Quick Sort
        // quickSort(array,0,8);
        // System.out.println("Quick Sorted Array is ...");
        // for(int i:array)
        // {
        //     System.out.print(i+" ");
        // }
        // System.out.println();
        // System.out.println();

        // // MAX volume of water
        // System.out.println("Maximum wanter volume = "+maxArea(array));
        // System.out.println();

        // //Earliest Moment When Everyone Become Friends
        // int[][] matrix = {
        //     {1, 0, 1},
        //     {2, 1, 2},
        //     {3, 0, 2},
        //     {4, 2, 3}
        // };
        // System.out.println("Earliest Time Everyone Became Friends = "+earliestAcq(matrix,4));
        // System.out.println();


        //Merge and Sort Intervals
        //Input
        //intervals = [[1, 3], [2, 6], [8, 10], [15, 18]]
        //Output
        //[[1, 6], [8, 10], [15, 18]]
        List<List<Integer>> intervals = new ArrayList<>(
        Arrays.asList(
            Arrays.asList(1, 3),
            Arrays.asList(2, 6),
            Arrays.asList(8, 10),
            Arrays.asList(15, 18)
        ));
        List<List<Integer>> result = mergeHighDefinitionIntervals(intervals);
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}