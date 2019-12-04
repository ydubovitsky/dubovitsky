package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Рефлексия (от позднелат. reflexio — обращение назад) —
 * это механизм исследования данных о программе во время её выполнения.
 * Рефлексия позволяет исследовать информацию о полях, методах и конструкторах классов.

 Сам же механизм рефлексии позволяет обрабатывать типы,
 отсутствующие при компиляции, но появившиеся во время выполнения программы.
 Рефлексия и наличие логически целостной модели выдачи информации об ошибках
 дает возможность создавать корректный динамический код.

 Что позволяет рефлексия:

 Узнать/определить класс объекта;
 Получить информацию о модификаторах класса, полях, методах, константах, конструкторах и суперклассах;
 Выяснить, какие методы принадлежат реализуемому интерфейсу/интерфейсам;
 Создать экземпляр класса, причем имя класса неизвестно до момента выполнения программы;
 Получить и установить значение поля объекта по имени;
 Вызвать метод объекта по имени.
 */

class Main {

    PrivateClass privateClass = null; // ссылка на пустой класс.
    String something = null; // Инициализируем переменную.

    /**
     * Создаем экземпляр класса при помощи рефлексии используя конструктор по умолчанию.
     */
    public void getDefaultConstructor() {
        try {
            Class localClass = Class.forName(PrivateClass.class.getName()); // Создаем экземпляр при помощи рефлексии;
            privateClass = (PrivateClass) localClass.newInstance(); // Дефолтный конструктор.
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.out.println(e);
        }
    }

    /**
     * Создаем объек используя рефлексию, через конструктор с параметрами.
     */
    public void getConstructorWithParameters() {
        try {
            Class localClass = Class.forName("reflection.PrivateClass");
            Class[] params = {int.class, String.class};
            privateClass = (PrivateClass) localClass.getConstructor(params).newInstance(1, "Параметр");
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException |
                InvocationTargetException | IllegalAccessException e) {
            System.out.println(e);
        }
    }

    /**
     * Получаем приватное поле класса PrivateClass.
     */
    public void getField() {
        try {
            Field field = privateClass.getClass().getDeclaredField("name"); // Доступ к приватному полю.
            field.setAccessible(true);
            something = (String)field.get(privateClass); // ссылаемся на закрытое поле.
            field.set(privateClass, (String) "privateClass");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println(e);
        }
    }

    /**
     * Используем приватный метод класса PrivateClass используя рефлексию.
     */
    public void getMethod() {
        try {
            Method method = privateClass.getClass().getDeclaredMethod("printData"); // Доступ к приватному методу.
            method.setAccessible(true);
            method.invoke(privateClass);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.out.println(e);
        }
    }

    /**
     * Возвращаем параметры всех конструкторов.
     */
    public void getManyConstructors() {
        try {
            Class localClass = Class.forName(PrivateClass.class.getName()); // or "reflection.Main"
            Constructor[] constructors = localClass.getConstructors();
            for (Constructor constructor : constructors) {
                Class[] paramConstructor = constructor.getParameterTypes();
                for (Class parameter : paramConstructor) {
                    System.out.println(parameter.getName() + " ");
                }
                System.out.println();
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    /**
     * Должен возвращать параметры всех методов.
     */
    public void getAllMethodsParameters() {
        try {
            Class localClass = Class.forName(PrivateClass.class.getName());
            Method[] methods = localClass.getMethods();
            for (Method method : methods) {
                Class[] methodsParameters = method.getParameterTypes();
                System.out.println("Methods name = " + method.getName());
                int i = 0;
                for (Class parameter : methodsParameters) {
                    System.out.println("parameter " + i + " - " +parameter.getName() + " ");
                    i++;
                }
            }
            System.out.println();
        } catch (ClassNotFoundException e) {

        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.getConstructorWithParameters();
        System.out.println("Before = " + main.something);
        main.getField();
        System.out.println("After = " + main.something);
        main.getManyConstructors();
        // Показываем параметры методов
        main.getAllMethodsParameters();
    }
}