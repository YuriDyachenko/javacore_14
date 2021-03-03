/*
1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
иначе в методе необходимо выбросить RuntimeException.
Написать набор тестов для этого метода (по 3-4 варианта входных данных).
Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
2. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки
или единицы, то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
[ 1 1 1 4 4 1 4 4 ] -> true
[ 1 1 1 1 1 1 ] -> false
[ 4 4 4 4 ] -> false
[ 1 4 4 1 1 4 3 ] -> false
*/
public class HomeWork {

    //1. извлечение подмассива
    public int[] extract(int[] a, int afterWhat) {
        //находим позицию последней четверки
        int p = -1;
        for (int i = 0; i < a.length; i++)
            if (a[i] == afterWhat) p = i;
        //если нет 4-к - бросаем исключение
        if (p == -1)
            throw new RuntimeException();
        //формируем выходной массив, его длина уже известна
        int[] r = new int[a.length - p - 1];
        //заполняем нужными элементами
        for (int i = 0; i < r.length; i++)
            r[i] = a[p + 1 + i];
        //выведем прямо тут
        System.out.println(intArrayToString(a) + ", " + afterWhat + " -> " + intArrayToString(r));
        return r;
    }

    //2. провера наличия только двух значений
    public boolean contain(int[] a, int firstValue, int secondValue) {
        boolean hasFirst = false;
        boolean hasSecond = false;
        boolean hasAnother = false;
        for (int v: a) {
            if (v == firstValue) hasFirst = true;
            else
                if (v == secondValue) hasSecond = true;
                else
                    hasAnother = true;
        }
        boolean res = (hasFirst && hasSecond && (!hasAnother));
        //выведем прямо тут
        System.out.println(intArrayToString(a) + ", " + firstValue + ", " + secondValue + " -> " + res);
        return res;
    }

    //просто вывод массива без перевод строки
    private String intArrayToString(int[] a) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int v: a) stringBuilder.append(v).append(" ");
        return "[" + stringBuilder.toString().trim() + "]";
    }
}
