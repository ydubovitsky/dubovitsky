package io.filter;

import java.io.File;

public class Main {
    static File in = new File("C:\\Users\\user\\IdeaProjects\\dubovitsky\\junior\\IO\\src\\main\\java\\io\\filter\\Main.java");
    static File out = new File("C:\\Users\\user\\IdeaProjects\\dubovitsky\\junior\\IO\\src\\main\\java\\io\\filter\\out.txt");

    public static void main(String[] args) {
        FileFilterWords fileFilterWords = new FileFilterWords(in, out);
        fileFilterWords.dropAbuses(new String[]{"user"});
    }
}
