package tracker;

/**
 * Public API
 */
public interface ITracker {
    Item add(Item item);
    void replace(int id, Item item);
    void delete(int id);
    Item[] findAll();
    Item[] findByName(String key);
    Item findById(int id);
}
