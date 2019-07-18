package jdbc.optimization.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * This class describes entity "Entry" with one filed - field
 */
@XmlRootElement(name = "table")
@XmlType(propOrder = {"fields"})
public class Entry implements Entity{

    private List<Field> fields;

    public List<Field> getFields() {
        return fields;
    }

    @XmlElement(name = "fields")
    @XmlElementWrapper
    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    @XmlRootElement(name="field")
    public static class Field {

        private int field;

        public int getField() {
            return field;
        }

        @XmlElement
        public void setField(int field) {
            this.field = field;
        }
    }
}


