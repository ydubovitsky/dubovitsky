package jdbc.optimization.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement(name = "table")
@XmlType(propOrder = {"field", "valueList"})
public class Table {

    private String field;
    private List<Value> valueList;

    public String getField() {
        return field;
    }

    @XmlElement(name = "field")
    public void setField(String field) {
        this.field = field;
    }

    @XmlElement(name = "valueList")
    public void setValueList(List<Value> list) {
        this.valueList = list;
    }

    public List<Value> getValueList() {
        return this.valueList;
    }

    @XmlRootElement
    public static class Value {

        int value;

        public Value() {}

        public Value(int value) {
            this.value = value;
        }
    }
}


