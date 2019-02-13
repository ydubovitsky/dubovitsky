package io.chat;

import java.io.InputStream;

public class UserOne implements User {

    @Override
    public InputStream sendMsg() {
        return System.in;
    }
}
