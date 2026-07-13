package practice;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.*;

/**
 * Cuaderno acumulativo de sintaxis Java.
 *
 * Cada apartado tiene una plantilla compilable, pero no una solución. Cuando
 * termines un ejercicio, conserva aquí la implementación: al final esta clase
 * será tu material de repaso práctico.
 *
 * Regla: trabaja únicamente en el ejercicio activo. No intentes completar las
 * firmas siguientes por adelantado.
 */
public final class CurrentChallenge {

    private CurrentChallenge() {
    }

    // ---------------------------------------------------------------------
    // 01. Variables y operadores
    // ---------------------------------------------------------------------

    public static double calculateDiscountedTotal(
            double unitPrice,
            int quantity,
            double discountPercent) {

        /*
        Utilizamos double porque tiene que ser un dedcimal.
         */

        double totalPrice = unitPrice * quantity;

        double discountedPrice = totalPrice - (totalPrice * (discountPercent/100));

        return discountedPrice;


    }

    // ---------------------------------------------------------------------
    // 02. Condicionales
    // ---------------------------------------------------------------------

    public enum TemperatureLevel {
        LOW,
        NORMAL,
        HIGH
    }

    public static TemperatureLevel classifyTemperature(
            double temperature,
            double lowerLimit,
            double upperLimit) {

        TemperatureLevel tLevel ;
        if (temperature < lowerLimit) return TemperatureLevel.LOW;

        tLevel = (temperature > upperLimit) ? TemperatureLevel.HIGH : TemperatureLevel.NORMAL;

        return tLevel;
    }

    // ---------------------------------------------------------------------
    // 03. Bucles
    // ---------------------------------------------------------------------

    public static int sumEvenNumbers(List<Integer> numbers) {

        int sum = 0;

        for(Integer num: numbers){
            if(num % 2 == 0){
                sum+=num;
            }
        }

        return sum;

        /*
        return numbers.stream()
        .filter(number -> number % 2 == 0)
        .mapToInt(Integer::intValue)
        .sum();

        return numbers.stream()
        .filter(number -> number % 2 == 0)
        .reduce(0, Integer::sum);


         */
    }

    // ---------------------------------------------------------------------
    // 04. Arrays
    // ---------------------------------------------------------------------

    public static int differenceBetweenMaxAndMin(int[] numbers) {

        if (numbers == null ) throw new IllegalArgumentException("No puedes pasar una lista vacía");
        if (numbers.length == 0 ) throw new IllegalArgumentException("No puedes pasar una lista vacía");

        int max = numbers[0];
        int min = numbers[0];
        for(int num : numbers){
            if (num > max) max = num;
            if (num < min) min = num;
        }

        return max - min;
    }

    // ---------------------------------------------------------------------
    // 05. Strings
    // ---------------------------------------------------------------------

    public static String normalizeName(String name) {

       String nameNormalized = name.trim().toLowerCase();

       if (nameNormalized.isEmpty()) {
           return "";
       }

       String[] words = nameNormalized.split("\\s+");

       StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String firstLetter = words[i].substring(0, 1).toUpperCase();
            String normalizedWord = firstLetter + words[i].substring(1);

            stringBuilder.append(normalizedWord);
            if (i != words.length - 1) {
                stringBuilder.append(" ");
            }
        }



        return stringBuilder.toString();
    }

    // ---------------------------------------------------------------------
    // 06. StringBuilder
    // ---------------------------------------------------------------------

    public static String joinWordsInReverseOrder(List<String> words) {
        List<String> copy = new ArrayList<>(words);


        StringBuilder stringBuilder = new StringBuilder();

        for (int i = words.size() -1; i >= 0 ; i--) {
            stringBuilder.append(copy.get(i));

            if (i > 0) stringBuilder.append(" ");
        }

        return stringBuilder.toString();
    }

    // ---------------------------------------------------------------------
    // 07. List
    // ---------------------------------------------------------------------

    public static List<Integer> copyWithoutNegativeNumbers(List<Integer> numbers) {

        List<Integer> test = new ArrayList<>();
        for(Integer number: numbers){
            if (number >= 0) test.add(number);

        }

        List<Integer> copy = new ArrayList<>(numbers);
        copy.stream().filter(number -> number > 0);

        return test;

        /*
        List<Integer> result = numbers.stream()
        .filter(number -> number >= 0)
        .toList();

         */
    }

    // ---------------------------------------------------------------------
    // 08. Set
    // ---------------------------------------------------------------------

    public static Optional<Integer> findFirstDuplicate(List<Integer> numbers) {
        throw pending(8);
    }

    // ---------------------------------------------------------------------
    // 09. Map - conteos
    // ---------------------------------------------------------------------

    public static Map<String, Integer> countNormalizedWords(List<String> words) {
        throw pending(9);
    }

    // ---------------------------------------------------------------------
    // 10. Map - agrupaciones
    // ---------------------------------------------------------------------

    public record Order(long id, long userId, double total) {
    }

    public static Map<Long, List<Order>> groupOrdersByUser(List<Order> orders) {
        throw pending(10);
    }

    // ---------------------------------------------------------------------
    // 11. Ordenación y Comparator
    // ---------------------------------------------------------------------

    public record Product(long id, String name, double price) {
    }

    public static List<Product> sortProducts(List<Product> products) {
        throw pending(11);
    }

    // ---------------------------------------------------------------------
    // 12. Clases y records
    // ---------------------------------------------------------------------

    public record OpeningInterval(
            DayOfWeek day,
            LocalTime openingTime,
            LocalTime closingTime) {
        // Añadiremos validaciones únicamente después de acordar el contrato.
    }

    public static long durationInMinutes(OpeningInterval interval) {
        throw pending(12);
    }

    // ---------------------------------------------------------------------
    // 13. Enums
    // ---------------------------------------------------------------------

    public enum OrderStatus {
        PENDING,
        PAID,
        SHIPPED,
        CANCELLED
    }

    public static boolean canTransition(OrderStatus from, OrderStatus to) {
        throw pending(13);
    }

    // ---------------------------------------------------------------------
    // 14. Interfaces y polimorfismo
    // ---------------------------------------------------------------------

    @FunctionalInterface
    public interface DiscountPolicy {
        double apply(double originalPrice);
    }

    public static double applyDiscount(double price, DiscountPolicy policy) {
        throw pending(14);
    }

    // ---------------------------------------------------------------------
    // 15. Excepciones
    // ---------------------------------------------------------------------

    public static int parsePositiveInteger(String value) {
        throw pending(15);
    }

    // ---------------------------------------------------------------------
    // 16. Optional
    // ---------------------------------------------------------------------

    public record User(long id, String name) {
    }

    public static Optional<User> findUserById(List<User> users, long id) {
        throw pending(16);
    }

    // ---------------------------------------------------------------------
    // 17. Lambdas y Comparator
    // ---------------------------------------------------------------------

    public static List<String> sortByLengthAndAlphabetically(List<String> values) {
        throw pending(17);
    }

    // ---------------------------------------------------------------------
    // 18. Streams
    // ---------------------------------------------------------------------

    public static List<String> normalizeUniqueNamesWithLoop(List<String> names) {
        throw pending(18);
    }

    public static List<String> normalizeUniqueNamesWithStream(List<String> names) {
        throw pending(18);
    }

    // ---------------------------------------------------------------------
    // 19. Fechas, horas e intervalos
    // ---------------------------------------------------------------------

    public static boolean isTimeInsideInterval(
            LocalTime time,
            LocalTime openingTime,
            LocalTime closingTime) {
        throw pending(19);
    }

    // ---------------------------------------------------------------------
    // 20. equals y hashCode
    // ---------------------------------------------------------------------

    public record BusinessId(String countryCode, String registrationNumber) {
    }

    public static Set<BusinessId> uniqueBusinessIds(List<BusinessId> ids) {
        throw pending(20);
    }

    // ---------------------------------------------------------------------
    // 21. Queue y Deque
    // ---------------------------------------------------------------------

    public static boolean hasBalancedBrackets(String text) {
        throw pending(21);
    }

    // ---------------------------------------------------------------------
    // 22. PriorityQueue
    // ---------------------------------------------------------------------

    public static List<Integer> findLargestValues(List<Integer> values, int k) {
        throw pending(22);
    }

    // ---------------------------------------------------------------------
    // 23. Testing
    // ---------------------------------------------------------------------

    public static int calculateShippingCost(int distanceKm, boolean priority) {
        throw pending(23);
    }

    // ---------------------------------------------------------------------
    // 24. Integración final - horarios comerciales
    // ---------------------------------------------------------------------

    public record Business(
            long id,
            String name,
            List<OpeningInterval> openingHours) {
    }

    public static List<Business> findOpenBusinesses(
            List<Business> businesses,
            DayOfWeek day,
            LocalTime time) {
        throw pending(24);
    }

    private static UnsupportedOperationException pending(int exerciseNumber) {
        return new UnsupportedOperationException(
                "Implementa el ejercicio " + exerciseNumber + " cuando sea el ejercicio activo");
    }
}
