package jdbc.optimization;

import jdbc.optimization.entities.Entry;
import jdbc.optimization.jaxb.JAXBParser;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;

public class StoreXML {

    @Autowired
    private JAXBParser jaxbParser;

    @Autowired
    private File file;

    public StoreXML() {

    }

    /**
     * Constructor
     * @param target - Файл куда будет сохраняться данные.
     */
    public StoreXML(File target) {
        this.file = target;
    }

    /**
     * Cохраняет данные из list в файл target.
     * @param list
     */
    public void save(List<Integer> list) throws Exception {
        Entry entry = new Entry(list);
        jaxbParser.saveObject(file, entry);
    }
}
