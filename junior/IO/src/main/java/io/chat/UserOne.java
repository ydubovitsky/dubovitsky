package io.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class UserOne implements User {

    @Override
    public Reader sendMsg() {

        // Создаеем буфферизированный поток ввода из консоли
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br;
    }

    public static void main(String[] args) throws IOException {
        UserOne u = new UserOne();
        BufferedReader br = (BufferedReader)u.sendMsg();
        String str;
        while (!((str = br.readLine()).equals("hello"))) {
            System.out.println(str);
        }
    }
}
