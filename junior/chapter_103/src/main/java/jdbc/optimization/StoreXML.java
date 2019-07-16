package jdbc.optimization;

import jdbc.optimization.parser.Parser;

import java.io.File;

public class StoreXML<E> {

    private File file;
    private Parser parser;

    /**
     * target - Файл куда будет сохраняться данные.
     * @param target
     */
    StoreXML(File target, Parser parser) {
        this.file = target;
        this.parser = parser;
    }

    /**
     * Cохраняет данные из list в файл target.
     * @param e
     */
    void save(E e) throws Exception{
        parser.saveObject(this.file, e);
    }
}
