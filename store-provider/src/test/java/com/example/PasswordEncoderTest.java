package com.example;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Scanner;

public class PasswordEncoderTest {
    public static void main(String[] args) {
        //创建解析器
        PasswordEncoder pw=new BCryptPasswordEncoder();
        //对密码加密
        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("请输入密码");
            String code=sc.nextLine();
            if (code.equals("q")) break;
            String encode=pw.encode(code);

            System.out.println(encode);
            //判断原字符和加密后内容是否匹配
            boolean matches=pw.matches(code, encode);
            System.out.println("=================" +matches);
            System.out.println("输入q退出!");
        }
    }
}
