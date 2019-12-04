package jdbc.optimization;

import jdbc.optimization.database.StoreSQL;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartingApp {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "jdbc/optimization/config/config.xml"
        );

        StoreSQL storeSQL = (StoreSQL) context.getBean("storeSQL");
        storeSQL.createTable();
        storeSQL.generate(15);

        StoreXML storeXML = (StoreXML) context.getBean("storeXML");
        storeXML.save(storeSQL.load());
    }
}
