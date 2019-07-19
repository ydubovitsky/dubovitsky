package jdbc.optimization.entities;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "entry")
@XmlType(propOrder = {"field"})
public class Entry {

    private List<Integer> field;

    public Entry(List<Integer> field) {
        this.field = field;
    }

    public Entry() {
    }

    public List<Integer> getField() {
        return field;
    }

    public void setField(List<Integer> field) {
        this.field = field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return Objects.equals(field, entry.field);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field);
    }
}
