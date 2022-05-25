package com.yuu6.everyday;


import java.util.*;

/**
 * 字符串解密
 *
 * @Author: yuu6
 * @Date: 2022/05/24/上午8:50
 */
public class DecodeString {

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> tempStack = new Stack<>();
        for (Character c: s.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c) || c.equals('[')){
                stack.push(c);
            }else if (c.equals(']')){
                Character tempChar = stack.pop();
                while(tempChar != '['){
                    tempStack.push(tempChar);
                    tempChar = stack.pop();
                }
                StringBuilder stringBuilder = new StringBuilder();
                while(!stack.empty() && Character.isDigit(stack.peek())){
                    stringBuilder.append(stack.pop());
                }
                Integer num = Integer.parseInt(stringBuilder.reverse().toString());

                List<Character> tempList = new ArrayList<Character>();
                while(!tempStack.empty()){
                    tempList.add(tempStack.pop());
                }
                for (int i = 0; i < num; i++) {
                    for (int j = 0; j < tempList.size(); j++) {
                        stack.push(tempList.get(j));
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        String res = decodeString.decodeString("10[a]2[bc]");
        System.out.println(res);
    }
}
