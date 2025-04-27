package com.example.kamacoder.replacenumber;

/**
 * @author wzw
 * @date 2024/10/4 11:14
 * @description

 */
public class ReplackNumber {
    public static void main(String[] args) {
        String s = replackNumber2("j119kfun72k9et9izrpw9bsxhah55ovorf5ffzuyd4zir4gjdf");
        System.out.println(s);

    }


    public static String replackNumber(String s) {
        String str = new String("number");
        StringBuilder sbr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                sbr.append(s.charAt(i));
            } else {
                sbr.append("number");
            }
        }
        return String.valueOf(sbr);
    }

    public static String replackNumber2(String s) {
        int newLen = s.length();
        for(int i=0;i < s.length();i++){
            if(s.charAt(i)>='0' && s.charAt(i) <= '9'){
                newLen+=5;
            }
        }
        char[] arr = new char[newLen];
        int cur = newLen-1;
        for(int i=s.length()-1;i >=0;i--){
            if(s.charAt(i)>='0' && s.charAt(i) <= '9'){
                arr[cur--]= 'r';
                arr[cur--]= 'e';
                arr[cur--]= 'b';
                arr[cur--]= 'm';
                arr[cur--]= 'u';
                arr[cur--]= 'n';
            }else{
                arr[cur--] = s.charAt(i);
            }
        }
        return  new String(arr);
    }
}
