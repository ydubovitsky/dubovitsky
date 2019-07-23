package jdbc.optimization;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URISyntaxException;

class ConvertXSQTTest {

    File xml;
    File xsl;
    File out;
    ConvertXSQT convertXSQT;

    @BeforeEach
    void init() throws URISyntaxException {
        xml = new File(this.getClass().getResource("/jdbc/optimization/test/in.xml").toURI());
        xsl = new File(this.getClass().getResource("/jdbc/optimization/test/format.xsl").toURI());
        out = new File(this.getClass().getResource("/jdbc/optimization/test/out.xml").toURI());
    }

    @Test
    void convert() {
        convertXSQT = new ConvertXSQT();
        convertXSQT.convert(xml, out, xsl);
    }
}