package jdbc.optimization;

import jdbc.optimization.entities.Entry;
import jdbc.optimization.jaxb.JAXBParser;
import jdbc.optimization.jaxb.JAXBParserImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.net.URISyntaxException;
import java.util.List;

class JAXBParserImplTest {

    JAXBParser parser;
    Entry expected;

    @BeforeEach
    void init() {
        parser = new JAXBParserImpl();
        List<Integer> fields = List.of(
                new Integer(12345),
                new Integer(98765),
                new Integer(11111)
        );
        expected = new Entry(fields);
    }

    @Test
    void getObject() throws URISyntaxException, JAXBException {
        Entry actual = (Entry) parser.getObject(
                new File(parser.getClass().getResource("/jdbc/optimization/xml/getObject.xml").toURI()),
                Entry.class);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void saveObject() throws Exception{
        parser.saveObject(
                File.createTempFile("testing", ".xml"),
                expected);
    }
}