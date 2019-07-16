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
@XmlType(propOrder = {"field"})
public class Entry  {

    private List<Field> field;
    
    public Entry() {
        
    }

    public Entry(List<Field> field) {
        this.field = field;
    }

    @XmlElement(name = "field")
    @XmlElementWrapper
    public void setField(List<Field> fields) {
        this.field = fields;
    }

    public List<Field> getField() {
        return this.field;
    }

    @XmlRootElement
    public static class Field {
        private int value;

        public Field() {
        }

        public Field(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}


