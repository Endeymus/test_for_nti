import java.io.*;
import java.util.*;

/**
 * Класс реализующий логику приложение на Java, которое будет анализировать слово, подаваемое на вход и возвращать ту букву, которая встречается в слове наибольшее количество раз с указанием числа вхождений.
 * @author Mark Shamray
 */
public class Test1 {

    /**
     * Точка входа в программу
     * @param args - аргументы
     * @throws IOException - выдает при ошибке чения из консоли или закрытия потока
     */
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = reader.readLine();
        reader.close();

        System.out.println(wordAnalyzer(word));
    }

    /**
     * Ищет в карте букву встречающуюся максимальное количество раз
     * @param map - карта с подсчитанным количеством символов
     * @return набор {@link java.util.Map.Entry}
     */
    public static Map.Entry<Character, Integer> max(Map<Character, Integer> map) {
        Map.Entry<Character, Integer> max = null;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (max == null || entry.getValue().compareTo(max.getValue()) >= 0)
                max = entry;
        }
        return max;
    }

    /**
     * Подсчет количества вхождений каждой буквы и выдача результата
     * @param word - слово которое необходимо проанализировать
     * @return найденое слово
     */
    public static String wordAnalyzer(String word) {
        Map<Character, Integer> keys = new LinkedHashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char symbol = word.charAt(i);
            if (keys.containsKey(symbol)) {
                keys.put(symbol, keys.get(symbol) + 1);
            } else {
                keys.put(symbol, 1);
            }
        }
        Map.Entry<Character, Integer> max = max(keys);
        return String.format("%s %d", max.getKey(), max.getValue());
    }
}


