package com.example.kamacoder.righthandedstring;

/**
 * @author wzw
 * @date 2024/10/4 15:32
 * @description

 */
public class RightHandedAtring {
    public static void main(String[] args) {
        //String result = RightHandedAtring1(2, "abcdefg");
        String result = RightHandedAtring2(2, "abcdefg");
        System.out.println(result);
    }

    public static String RightHandedAtring1(int k,String s){
        StringBuilder sb = new StringBuilder();
        int cur = s.length()-k;
        for(int i = cur;i< s.length();i++){
            sb.append(s.charAt(i));
        }
        for(int i=0;i<s.length()-k;i++){
            sb.append(s.charAt(i));
        }
        return String.valueOf(sb);
    }


    public static String RightHandedAtring2(int k,String s){
        char[] charArray = s.toCharArray();
        reverseString(charArray,0,charArray.length-1);
        reverseString(charArray,0,k-1);
        reverseString(charArray,k,charArray.length-1);
        return new String(charArray);
    }

    public static void reverseString(char[] ch,int start,int end){
        while (start < end){
            ch[start] ^= ch[end];
            ch[end] ^= ch[start];
            ch[start] ^=ch[end];
            start++;
            end--;
        }
    }

}
