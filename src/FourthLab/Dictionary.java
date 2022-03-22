package FourthLab;

public interface Dictionary {

    /*
     * 1. Связный список
     * - Долго искать
     * 2. Двоичные вектора
     * + Уникальность значений
     * - Только инты
     * 3. Массив
     * - Время поиска
     * - Приходится сдвигать после удаления
     *
     * Хеширование:
     * 1. Открытое
     * 2. Закрытое
     *
     * Разбиваем мн-во на B классов.
     * Значения словаря - ключ.
     * h(ключ - хеш-функция от 0 до B-1) - качество хеш-функции
     * [0   ][  ]
     * [1   ][  ] -> [  ] -> [  |x]
     * [2   ][  ]
     * ...
     * [B-1 ][  ]
     * Если 2 ключам соответствует одно значение, то это коллизия (1 элем)
     * Длина имени участников = 10 символов
     * F имя
     * Добавление имени
     * Добавление в список good guys
     * U имя
     * Добавление имени
     * Добавление в список bad guys
     * ? имя в каком списке?
     * E
     *
     *
     */

    void insert(char[] name);

    void delete(char[] name);

    void member(char[] name);

    void makeNull();
}