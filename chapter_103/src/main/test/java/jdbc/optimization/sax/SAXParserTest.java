package jdbc.optimization.sax;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URISyntaxException;

class SAXParserTest {

    File file;
    SAXParser parser;

    @BeforeEach
    void setUp() throws URISyntaxException {
        file = new File(this.getClass().getResource("/jdbc/optimization/xml/getObject.xml").toURI());
        parser = new SAXParser("field", file);
    }

    @Test
    void starting() throws Exception{
        parser.starting();
    }
}