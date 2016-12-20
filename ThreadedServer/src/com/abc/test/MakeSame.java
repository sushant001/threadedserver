/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.test;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author SushantKumar
 */
public class MakeSame {
    
    static boolean check(String s1, String s2, int k) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        
        for(char c : s1.toCharArray()) {
            st1.push(c);
        }
        for(char c : s2.toCharArray()) {
            st2.push(c);
        }
        
        while(!st1.isEmpty() && !st2.isEmpty()) {
            char c1 = st1.pop();
            char c2 = st2.pop();
            if(c1!=c2) {
                k-=2;
            }
        }
        System.out.println(k);
        return k==0;
    }
    
    static String makeEqual(String s,String d) {
        return s+d;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner("hackerhappy hackerrank 9");
        String s = in.next();
        String t = in.next();
        int k = in.nextInt();
        
        int l1 = s.length();
        int l2 = t.length();
        
        if(l1>l2) {
            s = s.substring(0,l2);
            k-=l1-l2;
        } else {
            t = t.substring(0,l1);
            k-=l2-l1;
        }
        if(check(s,t,k)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
    
}
