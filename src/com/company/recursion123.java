package com.company;

/**
 * Created by hongruzh on 3/21/16.
 */
public class recursion123 {
    StringBuilder sb = new StringBuilder();//这是用了全局变量
    public String input123(int s){
        //base case
        if(s==0) return sb.toString();

            sb.append(s%10);
            s = s/10;
        return input123(s);
    }

    public String input(int s){
        String str = "";
        if(s==0) return str;
        str=s%10+"";
        s = s/10;
        str=str+input(s);
        return str;

    }
}
