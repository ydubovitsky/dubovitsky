package jdbc.optimization;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Вместо того, чтобы в жёстко заданном виде выводить информацию в выходящий поток,
 * можно создать XML-документ в виде DOM-объекта и затем применить к нему XSLT-преобразование,
 * которое создаст для него требуемое HTML-представление.
 */
public class ConvertXSQT {

    /**
     * Метод - читает файл source и преобразовывает его в файл dest за счет XSTL схемы scheme.
     * @param source - xml
     * @param dest - html
     * @param scheme -xsl schema
     * @return
     */
    public void convert(File source, File dest, File scheme) {
        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();

            Source xslDoc = new StreamSource(scheme);
            Source xmlDoc = new StreamSource(source);


            OutputStream htmlFile = new FileOutputStream(dest);
            Transformer trasform = tFactory.newTransformer(xslDoc);
            trasform.transform(xmlDoc, new StreamResult(htmlFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerException t) {
            t.printStackTrace();
        }
    }
}
