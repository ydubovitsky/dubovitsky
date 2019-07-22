package jdbc.optimization;

import jdbc.optimization.entities.Entry;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;

public class StoreXML {

    @Autowired
    private JAXBParser jaxbParser;

    private File file;

    public StoreXML() {

    }

    public JAXBParser getJaxbParser() {
        return jaxbParser;
    }

    public void setJaxbParser(JAXBParser jaxbParser) {
        this.jaxbParser = jaxbParser;
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
