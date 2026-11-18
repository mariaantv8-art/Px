package edu.course.lab04;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class SampleRegistryTest {

    @Test
    void testEqualKeysFindSameValue() {
        SampleRegistry registry = new SampleRegistry();
        SampleId id1 = new SampleId("cats_vs_dogs", 42);
        SampleId id2 = new SampleId("cats_vs_dogs", 42); // Логически равный ключ

        registry.put(id1, 1.5);
        assertEquals(1.5, registry.get(id2)); // Достаем по второму (логически равному) ключу
        assertTrue(registry.containsKey(id2)); // Проверка containsKey
    }

    @Test
    void testOverwriteValueKeepsSize() {
        SampleRegistry registry = new SampleRegistry();
        SampleId id1 = new SampleId("dataset", 1);
        SampleId id2 = new SampleId("dataset", 1);

        registry.put(id1, 10.0);
        registry.put(id2, 20.0); // Перезаписываем

        assertEquals(1, registry.size()); // Размер не увеличился
        assertEquals(20.0, registry.get(id1)); // Значение обновилось
    }

    @Test
    void testRemoveKey() {
        SampleRegistry registry = new SampleRegistry();
        SampleId id = new SampleId("dataset", 1);
        registry.put(id, 100.0);

        assertTrue(registry.containsKey(id));
        registry.remove(id); // Удаляем
        assertFalse(registry.containsKey(id)); // Ключа больше нет
        assertNull(registry.get(id)); // Значение не достается
        assertEquals(0, registry.size());
    }

    @Test
    void testEqualsWithNullAndDifferentType() {
        SampleId id = new SampleId("dataset", 1);
        assertFalse(id.equals(null)); // Сравнение с null
        assertFalse(id.equals("какая-то строка")); // Сравнение с другим типом
    }

    @Test
    void testForcedHashCollision() {
        // Создаем два РАЗНЫХ ключа, у которых НАМЕРЕННО одинаковый hashCode
        // Это проверяет, что HashMap корректно разрешает коллизии через equals()
        SampleId id1 = new SampleId("A", 1) {
            @Override
            public int hashCode() { return 123; }
        };
        SampleId id2 = new SampleId("B", 2) {
            @Override
            public int hashCode() { return 123; }
        };

        SampleRegistry registry = new SampleRegistry();
        registry.put(id1, 10.0);
        registry.put(id2, 20.0);

        // Оба ключа должны лежать в таблице, несмотря на одинаковый хеш
        assertEquals(2, registry.size());
        assertEquals(10.0, registry.get(id1)); 
        assertEquals(20.0, registry.get(id2)); 
    }

    @Test
    void testMutableKeyBreaksHashMap() {
        // Класс с изменяемым полем (эксперимент)
        class MutableKey {
            int value;
            MutableKey(int value) { this.value = value; }
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof MutableKey)) return false;
                return value == ((MutableKey) o).value;
            }
            @Override
            public int hashCode() { return Objects.hash(value); }
        }

        Map<MutableKey, String> map = new HashMap<>();
        MutableKey key = new MutableKey(10);
        map.put(key, "Данные");

        assertEquals("Данные", map.get(key)); 

        key.value = 20; // ИЗМЕНЯЕМ КЛЮЧ ПОСЛЕ ДОБАВЛЕНИЯ!

        // Теперь поиск ломается, так как hashCode изменился, а HashMap ищет по старому хешу
        assertNull(map.get(key)); 
    }
}