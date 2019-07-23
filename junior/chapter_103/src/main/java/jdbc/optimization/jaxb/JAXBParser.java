package jdbc.optimization.jaxb;

import javax.xml.bind.JAXBException;
import java.io.File;

/**
 * This interface must implements all jaxb-parsers;
 */
public interface JAXBParser {

    /**
     * This method read object into .xml
     * @param file - input xml file
     * @param c - object for writing into .xml
     * @return
     * @throws JAXBException
     */
    Object getObject(File file, Class c) throws JAXBException;

    /**
     * This method save all @annotated fields of object to .xml
     * @param file - output .xml file
     * @param o - object to write
     * @throws JAXBException
     */
    void saveObject(File file, Object o) throws JAXBException;
}
