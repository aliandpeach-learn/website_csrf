package com.yk.servlet;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        System.out.println((int) '中');
        System.out.println('中');

        System.out.println((char) 20013);
        char m = (char) ('中' + '国' + '国' + '国');
        System.out.println((char) 65537);

        System.out.println(Integer.toBinaryString(140 << 34));

        System.out.println((140 << 2));

        int n = 18;
        System.out.println(n + "的二进制是:" + Integer.toBinaryString(n));
        System.out.println(n + "的八进制是:" + Integer.toOctalString(n));
        System.out.println(n + "的十六进制是:" + Integer.toHexString(n));
        System.out.println(n + "的三进制是:" + Integer.toString(n, 3));


        System.out.println("==========十进制776转换到其它进制：==========");
        int sjz = 776;
        System.out.println("十进制转二进制： " + Integer.toBinaryString(sjz));
        System.out.println("十进制转八进制： " + Integer.toOctalString(sjz));
        System.out.println("十进制转十六进制： " + Integer.toHexString(sjz));


        System.out.println("==========八进制1410转换到其它进制：==========");
        String bjz = "1410";
        System.out.println("八进制转十进制: " + Integer.valueOf(bjz, 8));
        System.out.println("八进制转二进制: " + Integer.toBinaryString(Integer.valueOf(bjz, 8))); //八进制转十进制，十进制转二进制
        System.out.println("八进制转十六进制: " + Integer.toHexString(Integer.valueOf(bjz, 8))); //八进制转十进制，十进制转十六进制


        System.out.println("==========十六进制308转换到其它进制：==========");
        String sljz = "308";
        System.out.println("十六进制转十进制: " + Integer.valueOf(sljz, 16));
        System.out.println("十六进制转二进制: " + Integer.toBinaryString(Integer.valueOf(sljz, 16))); //十六进制转十进制，十进制转二进制
        System.out.println("十六进制转八进制: " + Integer.toOctalString(Integer.valueOf(sljz, 16))); //十六进制转十进制，十进制转八进制


        System.out.println("==========二进制1100001000转换到其它进制：==========");
        String ejz = "1100001000";
        System.out.println("二进制转十进制: " + Integer.valueOf(ejz, 2));
        System.out.println("二进制转八进制: " + Integer.toOctalString(Integer.valueOf(ejz, 2))); //二进制转十进制，十进制转八进制
        System.out.println("二进制转十六进制: " + Integer.toHexString(Integer.valueOf(ejz, 2))); //二进制转十进制，十进制转十六进制
    }

    /**
     * number   要转换的数
     * from     原数的进制
     * to       要转换成的进制
     */
    private static String change(String number, int from, int to) {
        return new BigInteger(number, from).toString(to);
    }
}
