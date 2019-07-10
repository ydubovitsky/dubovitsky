package jdbc.optimization;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Генерация XML из данных базы. Описывается класс StoreXML
 */
public class StoreXML {

    private File target;

    /**
     * Constructor
     * @param target - Файл куда будет сохраняться данные.
     */
    StoreXML(File target) {
        this.target = target;
    }

    /**
     * сохраняет данные из list в файл target.
     * @param list
     */
    void save(List<Map.Entry> list) {

    }
}
