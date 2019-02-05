package io.scanner;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Сканирование файловой системы.
 */
public class Search {

    /**
     * Тестовый метод
     * @param args
     */
    public static void main(String[] args) {
        Search dirList = new Search();
        ArrayList<String> list = new ArrayList<>();
        list.add("java");
        list.add(".iml");
        list.add("xml");
        dirList.recursionSearch("C:\\Users\\user\\IdeaProjects\\dubovitsky\\junior\\", list);
    }

    /**
     * Рекурсивный поиск по каталогу файлов с определенным расширением.
     * @param dir - Каталог в которм происходит поиск
     * @param list - расширение искомых файлов
     */
    public void recursionSearch(String dir, List<String> list) {
        try(DirectoryStream<Path> str = Files.newDirectoryStream(Paths.get(dir))) {
            for (Path p : str) {
                if (Files.isDirectory(p)) {
                    recursionSearch(p.toString(), list);
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        if (p.toString().endsWith(list.get(i))) {
                            System.out.println(p.toString());
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
