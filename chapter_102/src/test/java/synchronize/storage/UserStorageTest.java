package synchronize.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserStorageTest {

    private User user1;
    private User user2;
    private UserStorage userStorage;

    @Before
    public void setUp() throws Exception {
        user1 = new User(1, 100);
        user2 = new User(2, 50);
        userStorage = new UserStorage();
    }

    class OneMoreThread implements Runnable {
        /**
         * Создаем новую нить;
         */
        Thread t;
        /**
         * Имя нити.
         */
        String name;
        /**
         * Хранилище данных пользователей.
         */
        private final UserStorage userStorage;

        /**
         * Конструтор, в нем создается новый поток и запускается.
         * @param name
         * @param userStorage
         */
        OneMoreThread(String name, UserStorage userStorage) {
            this.userStorage = userStorage;
            t = new Thread(this, name);
            t.start();
        }

        public void run() {
            this.userStorage.transfer(user1.getId(), user2.getId(), 10);
        }
    }

    /**
     * Добавляем нового пользователя в хранилище
     * @throws Exception
     */
    @Test
    public void add() throws Exception {
        Assert.assertEquals(true, userStorage.add(user1));
        Assert.assertEquals(true, userStorage.add(user2));
    }

    /**
     * Обновляем данные пользователя
     * @throws Exception
     */
    @Test
    public void update() throws Exception {
        this.add();
        User user3 = new User(user1.getId(), 123);
        Assert.assertEquals(true, userStorage.update(user3));
    }

    /**
     * Удаляем пользователя
     * @throws Exception
     */
    @Test
    public void delete() throws Exception {
        this.add();
        Assert.assertEquals(true, userStorage.delete(user2));
    }

    @Test
    public void transfer() throws Exception {
        int i = 0; // Счетчик
        System.out.println("Имя главного потока - " + Thread.currentThread().getName());
        Assert.assertEquals(true, userStorage.add(user1));
        Assert.assertEquals(true, userStorage.add(user2));
        OneMoreThread one = new OneMoreThread("Первая нить", userStorage);
        OneMoreThread two = new OneMoreThread("Вторая нить", userStorage);
        // Можно заменить на join.
        while(one.t.isAlive() || two.t.isAlive()) {
            System.out.println("Ждем пока звершатся поток one & two: " + i);
            Thread.sleep(i);
        }
        Assert.assertEquals(70, user2.getAmount());
        Assert.assertEquals(80, user1.getAmount());
    }
}