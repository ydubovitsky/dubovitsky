package jdbc.optimization.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAXParser {

    private String element;
    private File file;

    public SAXParser(String element, File file) {
        this.element = element;
        this.file = file;
    }

    public void starting() throws ParserConfigurationException, SAXException, IOException {
        // Создание фабрики и образца парсера
        SAXParserFactory factory = SAXParserFactory.newInstance();
        javax.xml.parsers.SAXParser parser = factory.newSAXParser();

        parser.parse(file, new XMLHandler());
    }

    class XMLHandler extends DefaultHandler {

        private int sum = 0;
        private String lastElementName;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastElementName = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String information = new String(ch, start, length);

            information = information.replace("\n", "").trim();

            if (!information.isEmpty()) {
                if (lastElementName.equals("field"))
                    sum += Integer.parseInt(information);
            }
            System.out.println(sum);
        }
    }
}
