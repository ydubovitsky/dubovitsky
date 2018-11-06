package generic.store;

import org.junit.Before;
import org.junit.Test;

/**
 * Класс, тестирующий класс RoleStore.
 */
public class RoleStoreTest {

    RoleStore roleStore;

    @Before
    public void setUp() throws Exception {
        roleStore = new RoleStore(5);
    }

    /**
     * Добавляется ли элемент в RoleStore.
     */
    @Test
    public void whenAddRoleIntoRepository(){
        roleStore.add(new Role("1"));
    }

//    /**
//     * Когда пытаемся добавить в хранилище RoleStore не Role-элементы.
//     */
//    @Test
//    public void whenTryAddNoRoleItemIntoRoleStore(){
//        roleStore.add(new User("1"));
//    }
}