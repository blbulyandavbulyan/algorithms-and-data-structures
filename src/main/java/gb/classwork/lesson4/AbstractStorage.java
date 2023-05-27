package gb.classwork.lesson4;
/**
 * Этот интерфейс предназначен для абстрактного хранилища
 * @author David Blbulyan
 * */

public interface AbstractStorage<K extends Comparable<K>, V> {
    /**
     * Ищет значение по ключу
     * @param key ключ, по которому будет производиться поиск
     * @return значение, по ключу key
     * @throws gb.classwork.lesson4.binarysearchthree.exceptions.KeyAlreadyAddedException если такого ключа нет
     * */
    V find(K key);
    /** Добавляет значение по ключу
     * @param key - ключ, по которому будет добавлено значение
     * @param value - значение, которое будет добавлено по ключу
     * @throws gb.classwork.lesson4.binarysearchthree.exceptions.KeyAlreadyAddedException если такой ключ уже был добавлен
     * */
    void add(K key, V value);
    /**
     * Удаляет значение по ключу и возвращает удалённое значение
     * @param key ключ, по которому будет производиться удаление.
     * @return значение, если такой ключ был
     * @throws gb.classwork.lesson4.binarysearchthree.exceptions.KeyNotFoundException если такого ключа не было
     *
     * */
    V remove(K key);

}
