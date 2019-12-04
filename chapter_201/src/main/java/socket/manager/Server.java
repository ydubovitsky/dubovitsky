package socket.manager;

import java.io.File;
import java.nio.file.Path;

public interface Server {

    /**
     * Перейти в корневой каталог
     * @return
     */
    Path getRootCatalog();

    /**
     * Перейти в подкаталог
     * @return
     */
    Path moveInnerCatalog(String name);


    /**
     * Перейти в корневой каталог
     * @return
     */
    Path moveParantDirectory();

    /**
     * Скачать файл с сервера
     * @param path - путь скачивания
     * @return - файл
     */
    File download(Path path);

    /**
     * Загрузить файл на сервер
     * @param file - какой файл загрузить
     * @return
     */
    File load(File file);
}
