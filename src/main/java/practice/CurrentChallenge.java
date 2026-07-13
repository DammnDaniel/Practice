package practice;

import java.time.DayOfWeek;
import java.time.Duration;
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

        Set<Integer> fDuplicated = new HashSet<Integer>();

        for(Integer number: numbers){
            if(!fDuplicated.add(number)) return Optional.of(number);
        }

        return Optional.empty();
    }

    // ---------------------------------------------------------------------
    // 09. Map - conteos
    // ---------------------------------------------------------------------

    public static Map<String, Integer> countNormalizedWords(List<String> words) {

        Map<String, Integer> countWords = new HashMap<>();
        for(String word: words){
            String normalized = word.toLowerCase().trim();
            if(!normalized.isEmpty() && !normalized.isBlank()){
                countWords.put(normalized, countWords.getOrDefault(normalized, 0) + 1);
            }
        }

        return countWords;
    }

    // ---------------------------------------------------------------------
    // 10. Map - agrupaciones
    // ---------------------------------------------------------------------

    public record Order(long id, long userId, double total) {
    }

    /*
     * CHULETA — métodos de Map (cuándo usar cada uno)
     *
     *  LEER
     *   get(k)                  -> valor de k, o null si no está.
     *   getOrDefault(k, def)    -> valor de k, o 'def' si no está. NO inserta nada.
     *   containsKey(k)          -> true/false si existe la clave.
     *
     *  ESCRIBIR
     *   put(k, v)               -> mete v en k. Si ya había algo, LO MACHACA. Usar cuando
     *                              no te importa el valor previo (asignar/reemplazar).
     *
     *  ACTUALIZAR SEGÚN LO QUE HAYA (los que confunden)
     *   computeIfAbsent(k, k -> nuevo)
     *       Si k NO existe: crea 'nuevo', LO GUARDA y lo devuelve.
     *       Si k existe:    devuelve el valor que ya hay (no toca nada).
     *       -> el "get-or-create". IDEAL para AGRUPAR: Map<K, List> / Map<K, Set>.
     *          .computeIfAbsent(id, k -> new ArrayList<>()).add(x)
     *
     *   merge(k, valorInicial, (viejo, nuevo) -> combinado)
     *       Si k NO existe: pone 'valorInicial'.
     *       Si k existe:    guarda combinar(viejo, nuevo).
     *       -> IDEAL para CONTAR:  .merge(palabra, 1, Integer::sum)
     *
     *   computeIfPresent(k, (k, v) -> nuevoV)  -> solo actúa si k YA existe.
     *   compute(k, (k, v) -> ...)              -> siempre recalcula (v puede ser null).
     *
     *  REGLA RAPIDA
     *   contar frecuencias      -> merge  (o getOrDefault + put)
     *   agrupar en listas/sets  -> computeIfAbsent
     *   asignar/reemplazar      -> put
     *   leer con defecto        -> getOrDefault  (recuerda: NO inserta)
     */
    public static Map<Long, List<Order>> groupOrdersByUser(List<Order> orders) {

        Map<Long, List<Order>> mapGrouped = new LinkedHashMap<>();

        for (Order order : orders) {
            mapGrouped.computeIfAbsent(order.userId(), k -> new ArrayList<>()).add(order);
        }

        return mapGrouped;
    }

    // ---------------------------------------------------------------------
    // 11. Ordenación y Comparator
    // ---------------------------------------------------------------------

    public record Product(long id, String name, double price) {
    }

    public static List<Product> sortProducts(List<Product> products) {

        List<Product>sortedproducts = new ArrayList<practice.CurrentChallenge.Product>(products);
        sortedproducts.sort(Comparator.comparingDouble(Product::price).reversed().thenComparing(Product::name));

        System.out.println(products.toString());
        return sortedproducts;
    }

    // ---------------------------------------------------------------------
    // 12. Clases y records
    // ---------------------------------------------------------------------

    public record OpeningInterval(
            DayOfWeek day,
            LocalTime openingTime,
            LocalTime closingTime) {
        // Añadiremos validaciones únicamente después de acordar el contrato.

        public OpeningInterval{
            if (day == null || openingTime == null || closingTime == null) throw new IllegalArgumentException("Cant be null");
            if(openingTime.isAfter(closingTime)) throw new IllegalArgumentException("Opening time cant be after closing time");
        }
    }

    public static long durationInMinutes(OpeningInterval interval) {

        LocalTime openingTime = interval.openingTime();
        long timeBetween = Duration.between( interval.openingTime(), interval.closingTime()).toMinutes() ;
        return timeBetween;
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
        return switch (from) {
            case PENDING -> to == OrderStatus.PAID || to == OrderStatus.CANCELLED;
            case PAID -> to == OrderStatus.SHIPPED;
            case SHIPPED, CANCELLED -> false;
        };
    }

    /*
     * El switch es una expresion: cada rama produce directamente un boolean.
     * Con enums se puede comparar mediante == porque cada constante es unica.
     * SHIPPED y CANCELLED son estados finales, por eso comparten resultado false.
     */

    // ---------------------------------------------------------------------
    // 14. Interfaces y polimorfismo
    // ---------------------------------------------------------------------

    // La abstraccion: define QUE se hace (aplicar un descuento), no COMO.
    @FunctionalInterface
    public interface DiscountPolicy {
        double apply(double originalPrice);
    }

    // Los tipos de cliente a los que aplica un descuento distinto.
    public enum UserType {
        NORMAL,
        VIP,
        EMPLOYEE
    }

    // FACTORY: elige la estrategia segun el tipo de usuario.
    // Cada rama devuelve una DiscountPolicy en forma de lambda,
    // asi no hace falta una clase por cada tipo de descuento.
    public static DiscountPolicy policyFor(UserType type) {
        return switch (type) {
            case NORMAL   -> price -> price;            // sin descuento
            case VIP      -> price -> price * 0.80;     // 20%
            case EMPLOYEE -> price -> price * 0.50;     // 50%
        };
    }

    // APLICA la politica al precio. No sabe que descuento es: solo lo aplica.
    // Anadir un nuevo tipo de descuento NO obliga a tocar este metodo (Open/Closed).
    public static double applyDiscount(double price, DiscountPolicy policy) {
        return policy.apply(price);
    }

    // Une las dos piezas: elige la politica del usuario y la aplica.
    public static double applyDiscountForUser(double price, UserType type) {
        return applyDiscount(price, policyFor(type));
    }

    // ---------------------------------------------------------------------
    // 15. Excepciones
    // ---------------------------------------------------------------------

    public static int parsePositiveInteger(String value) {
        final int convertedValue;

        try {
            convertedValue = Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("Invalid integer format: " + value);
        }

        if (convertedValue <= 0) {
            throw new IllegalArgumentException("The number must be positive");
        }

        return convertedValue;
    }

    // ---------------------------------------------------------------------
    // 16. Optional
    // ---------------------------------------------------------------------

    public record User(long id, String name) {


    }

    public static Optional<User> findUserById(List<User> users, long id) {
        Optional<User> find = users.stream().filter(user -> user.id() == id).findFirst();

      //  return find;
        return find;
    }

    // ---------------------------------------------------------------------
    // 17. Lambdas y Comparator
    // ---------------------------------------------------------------------

    public static List<String> sortByLengthAndAlphabetically(List<String> values) {

        List<String> copy = new ArrayList<>(values);
        copy.sort(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));

        return copy;



    }

    // ---------------------------------------------------------------------
    // 18. Streams
    // ---------------------------------------------------------------------

    public static List<String> normalizeUniqueNamesWithLoop(List<String> names) {
        List<String> normalizedNames = new ArrayList<>();
        Set<String> seenNames = new HashSet<>();

        for (String name : names) {
            String normalizedName = name.trim().toLowerCase();

            if (!normalizedName.isBlank() && seenNames.add(normalizedName)) {
                normalizedNames.add(normalizedName);
            }
        }

        normalizedNames.sort(Comparator.naturalOrder());
        return normalizedNames;
    }

    public static List<String> normalizeUniqueNamesWithStream(List<String> names) {
        List<String> copy = new ArrayList<>(names);

        List<String> filteredList = copy.stream()
                .filter(a -> !a.isBlank())
                .map(name -> name.trim().toLowerCase())
                .distinct()
                .sorted(Comparator.naturalOrder()).toList();

        return filteredList;
    }

    // ---------------------------------------------------------------------
    // 19. Fechas, horas e intervalos
    // ---------------------------------------------------------------------

    public static boolean isTimeInsideInterval(
            LocalTime time,
            LocalTime openingTime,
            LocalTime closingTime) {

        //  8:00 - 17:00
        //  22:00 - 8:00

      if(openingTime.isBefore(closingTime)){
          return ((time.equals(openingTime) || time.isAfter(openingTime)) && time.isBefore(closingTime));
      }else{
          return ((time.equals(openingTime) || time.isAfter(openingTime))  || time.isBefore(closingTime));
      }



    }

    // ---------------------------------------------------------------------
    // 20. equals y hashCode
    // ---------------------------------------------------------------------

    public record BusinessId(String countryCode, String registrationNumber) {


    }

    public static Set<BusinessId> uniqueBusinessIds(
            List<BusinessId> ids) {

        return new HashSet<>(ids);
    }

    // ---------------------------------------------------------------------
    // 21. Queue y Deque
    // ---------------------------------------------------------------------

    public static boolean hasBalancedBrackets(String text) {
        Deque<Character> openings = new ArrayDeque<>();

        for (char character : text.toCharArray()) {
            if (character == '(' || character == '[' || character == '{') {
                openings.push(character);
                continue;
            }

            if (character == ')' || character == ']' || character == '}') {
                if (openings.isEmpty()) {
                    return false;
                }

                char lastOpening = openings.pop();
                boolean matches =
                        character == ')' && lastOpening == '('
                        || character == ']' && lastOpening == '['
                        || character == '}' && lastOpening == '{';

                if (!matches) {
                    return false;
                }
            }
        }

        return openings.isEmpty();
    }

    // ---------------------------------------------------------------------
    // 22. PriorityQueue
    // ---------------------------------------------------------------------

    public static List<Integer> findLargestValues(List<Integer> values, int k) {
        if (k == 0) {
            return List.of();
        }

        PriorityQueue<Integer> largestValues = new PriorityQueue<>();

        for (int value : values) {
            largestValues.offer(value);

            if (largestValues.size() > k) {
                largestValues.poll();
            }
        }

        List<Integer> result = new ArrayList<>(largestValues);
        result.sort(Comparator.reverseOrder());
        return result;
    }

    // ---------------------------------------------------------------------
    // 23. Testing
    // ---------------------------------------------------------------------

    public static int calculateShippingCost(int distanceKm, boolean priority) {
        if (distanceKm < 0) {
            throw new IllegalArgumentException("Distance cannot be negative");
        }

        int cost = 5 + distanceKm;

        if (priority) {
            cost += 10;
        }

        return cost;
    }
}
