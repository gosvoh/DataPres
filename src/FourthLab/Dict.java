package FourthLab;

/*
 * Ключи - имена
 * Хеш-функция = сумма кодов имени % B
 */
public class Dict implements Dictionary {
    private final Element[] array;
    private       int       size;

    public Dict(int size) {
        array = new Element[size];
        this.size = size;
    }

    private int hashFunction(char[] key) {
        int sum = 0;
        for (char c : key) sum += c;
        return sum % size;
    }

    private int hashLinearFunction() {
        /* TODO
         * hi(x) = (h(x) + i) % B для разрешения коллизий
         */
        return 0;
    }

    @Override public void insert(char[] key) {
        /* TODO
         * Сохранить место удалённого элемента и продолжать до тех пор,
         * пока не найдём пустое место или не вернёмся в исходное место
         */
    }

    @Override public void delete(char[] key) {
        /* TODO
         * Удалённое и пустое место нужно различать (обнулить используемый массив)
         */
    }

    @Override public void member(char[] key) {
        /* TODO
         * 1. Нашли
         * 2. Нашли пустой
         * 3. Получили исходное хеш-значение
         * Перед выполнением Insert и Delete надо проверить есть/нет ключ/а
         */
    }

    @Override public void makeNull() {
        for (Element element : array) {
            element.name = null;
            element.next = null;
        }
    }

    private static class Element {
        char[]  name;
        Element next;

        Element() {
            name = null;
            next = null;
        }
    }
}
