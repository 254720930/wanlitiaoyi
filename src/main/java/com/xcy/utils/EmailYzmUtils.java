package com.xcy.utils;

import java.util.Random;

public class EmailYzmUtils {
    private static String yzm = "";

    private static String allyzm = "abcdefghigkmnpqrstuvwxyzABCDEFGHIGKLMNPQRSTUVWXYZ23456789";
    public static String getYzm(){
        char[] yzmArr = allyzm.toCharArray();
        for (int i = 0; i < 6; i++){
            Random random = new Random();
            yzm = yzm + yzmArr[random.nextInt(yzmArr.length)];
        }
        return yzm;
    }

    public static void main(String[] args){
        String yzm = getYzm();
        System.out.println(yzm);
    }
}
