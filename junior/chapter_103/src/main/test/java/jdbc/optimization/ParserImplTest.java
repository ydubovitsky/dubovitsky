//package jdbc.optimization;
//
//import jdbc.optimization.entity.Table;
//import jdbc.optimization.parser.Parser;
//import jdbc.optimization.parser.ParserImpl;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.io.File;
//import java.util.Arrays;
//
//public class ParserImplTest {
//    private Parser parser;
//    private File file;
//
//    @Before
//    public void setUp() throws Exception {
//        parser = new ParserImpl();
//        file = new File("table.xml");
//    }
//
//    @Test
//    public void testGetObject() throws Exception {
//        Table table = (Table) parser.getObject(file, Table.class);
//        System.out.println(table);
//    }
//
//    @Test
//    public void testSaveObject() throws Exception {
//        Table table = new Table();
//
//        // add fields to table
//        table.setField("Field");
//        table.setValueList(Arrays.asList(new Table.Value(98765), new Table.Value(12345)));
//
//        parser.saveObject(file,table);
//    }
//}