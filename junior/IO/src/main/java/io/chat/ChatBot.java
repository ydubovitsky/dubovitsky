package io.chat;

import java.io.OutputStream;
import java.io.Reader;

public class ChatBot implements Bot {

    Logs logs;

    public ChatBot(Logs logs) {
        this.logs = logs;
    }

    @Override
    public Reader receiveMsg(Reader msg) {
        return null;
    }

}
