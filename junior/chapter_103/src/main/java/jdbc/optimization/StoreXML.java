package jdbc.optimization;

import jdbc.optimization.entity.Entity;
import jdbc.optimization.entity.Entry;
import jdbc.optimization.parser.Parser;

import java.io.File;
import java.util.List;

public class StoreXML {

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
    void save(List<Entry.Field> e) throws Exception{
        parser.saveObject(this.file, e);
    }
}
