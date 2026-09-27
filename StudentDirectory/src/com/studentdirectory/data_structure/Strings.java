package com.studentdirectory.data_structure;

public class Strings
{
    /*Input: s = "A man, a plan, a canal: Panama"
    Output: true
    Explanation: "amanaplanacanalpanama" is a palindrome.*/
    public boolean isPalindrome(String s) {
        String trimmedString = s.trim()
        .toLowerCase()
        .replaceAll("[^a-z0-9]", "");
        boolean isPalindrome = true;
        int left = 0;
        int right = trimmedString.length()-1;
        while(left < right)
        {
            if(trimmedString.charAt(left)==trimmedString.charAt(right))
            {
                isPalindrome = true;
            }
            else
            {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }
        return isPalindrome;
    }

    public static void main(String[] args)
    {
        String s = "A man, a plan, a canal: Panama";
        Strings str = new Strings();
        if(str.isPalindrome(s))
        {
            System.out.println("Is Palindrome");
        }
        else
        {
            System.out.println("IS NOT Palindrome");
        }
    }
}