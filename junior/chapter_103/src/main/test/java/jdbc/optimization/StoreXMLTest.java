package jdbc.optimization;

import jdbc.optimization.database.Config;
import jdbc.optimization.database.StoreSQL;
import jdbc.optimization.entity.Entry;
import jdbc.optimization.parser.ParserImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.sql.SQLException;

class StoreXMLTest {

    StoreSQL storeSQL;
    StoreXML<Entry> storeXML;

    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {
        Config config = new Config();
        config.init();
        storeSQL = new StoreSQL(config, "entry");
        storeSQL.connection();
        storeSQL.createTable();
        storeSQL.generate(10);
        storeSQL.readDB();
        storeSQL.getTable();
    }

    @Test
    void save() throws Exception, SQLException {
        File file = File.createTempFile("temp", ".xml");
        storeXML = new StoreXML<>(file, new ParserImpl());
        storeXML.save(storeSQL.getTable());
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String str;
        while ((str = reader.readLine()) != null) {
            System.out.println(str);
        }
    }
}