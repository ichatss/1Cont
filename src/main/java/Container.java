@SuppressWarnings("unchecked")

public class Container <T> {

    private Object[] arr;
    private int size;

    public Container() {
        size = 1;
        arr = new Object[size];
    }

    /**
     * Возвращает элемент по заданному индексу.
     * Получает Object элемент преобразует его к типу Т, возвращает элемент.
     * @param i - индекс полученного элемента
     * @return - возвращает полученный элемент
     * @throws - выбрасывает исключение IndexOutOfBoundsException
     */

    public T get(int i) {
        try {
            rangeCheck(i);
            @SuppressWarnings("unchecked") final T e = (T) arr[i];
            return e;
        } catch (IndexOutOfBoundsException E) {
            System.out.println("index don't right");
        }
        return null;
    }

    /**
     * Инициализирует элемент с заданным индексом, заданным значением.
     * @param index - индекс элемента, который нужно заменить
     * @param element - задаваемое значение для элемента
     * @return - возвращает эелемент, который был до замены.
     */

    public T set(int index, T element) {
        rangeCheck(index);
        T temp = (T) arr[index];
        arr[index] = element;
        return temp;
    }
    /**
     * Удаляет элемент в указанной позиции в списке.
     * Создаёт новый массив в котором указаны все элементы кроме элемента с указаным индексом.
     * Возвращает удаленный элемент.
     * @param index - индекс элемента, который будет удален
     * @return - возвращает удалённый эелемент
     * @throws - возвращает IndexOutOfBoundsException, если мы вышли за пределы массива.
     */

    public T remove(int index) {
        T delEl = null;
        try {
            rangeCheck(index);
            size--;
            Object[] arrTemp = new Object[size];
            int indexTemp = 0;
            for (int ind = 0; ind < size + 1; ind++) {
                if (ind == index) {
                    delEl = (T) arr[ind];
                    continue;
                }
                arrTemp[indexTemp] = arr[ind];
                indexTemp++;
            }
            arr = arrTemp;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("index don't right");
        }
        return delEl;
    }

    /**
     * Удаляет крайний элемент справа.
     * @return - возвращает удаленный элемент.
     */
    public T remove() {
        return remove(size - 1);
    }

    /**
     * Проверяет индекс на доступ
     * @param index - проверяемы индекс
     * @throws IndexOutOfBoundsException
     */
    public boolean rangeCheck(int index) {
        if (index > size - 1)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        return true;
    }

    /**
     * Возвращает информацию об индексе, который не вошёл в массив
     * @param index - печатает индек который
     * @return - возвращает строку информации
     */
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+ size;
    }

    /**
     * Возвращает первый индекс объекта, если данный объект существует.
     * @param o - передаваемый объект
     * @return - возвращает индекс объекта
     */
    public int indexOf(Object o) {
        for(int i = 0; i < size; i++) {
            if (o.equals(arr[i])) return i;
        }
        return -1;
    }

    /**
     * Возвращает последнюю позицию объекта, если он существует.
     * @param o - зававаемый объект
     * @return - возвращает последный индекс заданного объекта
     */
    public int lastIndexOf(Object o) {
        int last = -1;
        for(int i = 0; i < size; i++) {
            if (o.equals(arr[i])) last = i;
        }
        return last;
    }

    /**
     * Возвращает размер массива.
     * Массив инициализирован так, что размер его всегда на 1 ячейку больше, чем хранимых элементов в нем, поэтому мы от размера отнимаем 1.
     * @return - возвращет размер массива
     */

    public int size() {
        return size - 1;
    }

    /**
     * Проверяет наличие элементов в массиве.
     * @return - возвращает boolean (true - пуст), (false - есть элементы)
     */
    public boolean isEmpty() {
        return size - 1 == 0;
    }

    /**
     * Проверяет существует ли элемент в массиве равный заданному
     * @param o - проверяемый объект
     * @return - возвращает результат
     */
    public boolean contains(Object o) {
        for(Object x : arr) {
            if (o.equals(x)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Добавляет элемент в конец массива.
     * @param value - добавляемы параметр
     */
    public void add(T value) {
        arr[size - 1] = value;
        size++;
        Object[] arrTemp = new Object[size];
        System.arraycopy(arr, 0, arrTemp, 0, size - 1);
        arr = arrTemp;
    }

    /**
     * Очищает массив от элементов.     
     */
    public void clear() {
        while (size != 1) {
            remove();
        }
    }
}
