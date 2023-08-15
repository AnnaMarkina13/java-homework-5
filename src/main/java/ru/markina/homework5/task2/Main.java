package ru.markina.homework5.task2;

//   2) Пусть дан список сотрудников
//   Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений.
//   Отсортировать по убыванию популярности.

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream.of("Иван Иванов", "Светлана Петрова",
                        "Кристина Белова", "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов",
                        "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова",
                        "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов")
                .map(s -> s.split(" ")[0])
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .sorted((o1, o2) -> (-1) * o1.getValue().compareTo(o2.getValue()))
                .forEach(e -> System.out.printf("Имя %s повторяется %d раз(а).\n", e.getKey(), e.getValue()));
    }
}
