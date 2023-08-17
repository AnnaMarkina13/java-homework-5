package ru.markina.homework5.task1;

//        1) Подсчитать количество вхождения каждого слова
//        Пример:
//        Россия идет вперед всей планеты. Планета — это не Россия.
//                toLoverCase().
//        (Усложнение - игнорировать пунктуацию)*


import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> repeatsByWord = new HashMap<>();
        String str = "Россия идет вперед всей планеты. Планета — это не Россия.".toLowerCase();
        fillMap(repeatsByWord, str);

        for (Map.Entry<String, Integer> element : repeatsByWord.entrySet()) {
            System.out.printf("Слово \"%s\" встречается в строке %d раз(а).\n", element.getKey(), element.getValue());
        }
    }

    /**
     * @param repeatsByWord пустая Map
     * @param str строка, словами которой необходимо заполнить Map
     * @apiNote Подсчитать количество вхождения каждого слова
     */
    private static void fillMap(Map<String, Integer> repeatsByWord, String str) {
        var stringArr = str.trim().replaceAll("^\\P{L}+|\\P{L}+$", "").split("\\P{L}+");
        for (String s : stringArr) {
            if (repeatsByWord.containsKey(s)) {
                repeatsByWord.put(s, repeatsByWord.get(s) + 1);
            } else {
                repeatsByWord.put(s, 1);
            }
        }
    }
}
