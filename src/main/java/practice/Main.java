package practice;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import static practice.CurrentChallenge.Business;
import static practice.CurrentChallenge.BusinessId;
import static practice.CurrentChallenge.DiscountPolicy;
import static practice.CurrentChallenge.OpeningInterval;
import static practice.CurrentChallenge.Order;
import static practice.CurrentChallenge.OrderStatus;
import static practice.CurrentChallenge.Product;
import static practice.CurrentChallenge.TemperatureLevel;
import static practice.CurrentChallenge.User;

/**
 * Ejecutores acumulativos de todos los ejercicios de sintaxis.
 *
 * Cambia ACTIVE_EXERCISE para ejecutar únicamente el apartado que estás
 * resolviendo. Los runners anteriores se conservan como batería de repaso.
 */
public final class Main {

    private static final int ACTIVE_EXERCISE = 7;
    private static final double DOUBLE_TOLERANCE = 0.000_001;

    private static int passed;
    private static int failed;

    private Main() {
    }

    public static void main(String[] args) {
        switch (ACTIVE_EXERCISE) {
            case 1 -> runExercise01();
            case 2 -> runExercise02();
            case 3 -> runExercise03();
            case 4 -> runExercise04();
            case 5 -> runExercise05();
            case 6 -> runExercise06();
            case 7 -> runExercise07();
            case 8 -> runExercise08();
            case 9 -> runExercise09();
            case 10 -> runExercise10();
            case 11 -> runExercise11();
            case 12 -> runExercise12();
            case 13 -> runExercise13();
            case 14 -> runExercise14();
            case 15 -> runExercise15();
            case 16 -> runExercise16();
            case 17 -> runExercise17();
            case 18 -> runExercise18();
            case 19 -> runExercise19();
            case 20 -> runExercise20();
            case 21 -> runExercise21();
            case 22 -> runExercise22();
            case 23 -> runExercise23();
            case 24 -> runExercise24();
            default -> throw new IllegalArgumentException("Unknown exercise: " + ACTIVE_EXERCISE);
        }

        System.out.printf("%nEjercicio %d: %d correctos, %d fallidos%n",
                ACTIVE_EXERCISE, passed, failed);

        if (failed > 0) {
            System.exit(1);
        }
    }

    // Contrato: precio * cantidad, aplicando discountPercent sobre el total.
    private static void runExercise01() {
        checkDouble("sin descuento", 30.0,
                () -> CurrentChallenge.calculateDiscountedTotal(10.0, 3, 0.0));
        checkDouble("descuento del 20 por ciento", 24.0,
                () -> CurrentChallenge.calculateDiscountedTotal(10.0, 3, 20.0));
        checkDouble("cantidad cero", 0.0,
                () -> CurrentChallenge.calculateDiscountedTotal(10.0, 0, 20.0));
        checkDouble("precio decimal", 8.55,
                () -> CurrentChallenge.calculateDiscountedTotal(9.50, 1, 10.0));
    }

    // Contrato: menor que lower = LOW; mayor que upper = HIGH; límites incluidos en NORMAL.
    private static void runExercise02() {
        check("por debajo", TemperatureLevel.LOW,
                () -> CurrentChallenge.classifyTemperature(9, 10, 20));
        check("límite inferior", TemperatureLevel.NORMAL,
                () -> CurrentChallenge.classifyTemperature(10, 10, 20));
        check("valor intermedio", TemperatureLevel.NORMAL,
                () -> CurrentChallenge.classifyTemperature(15, 10, 20));
        check("límite superior", TemperatureLevel.NORMAL,
                () -> CurrentChallenge.classifyTemperature(20, 10, 20));
        check("por encima", TemperatureLevel.HIGH,
                () -> CurrentChallenge.classifyTemperature(21, 10, 20));
    }

    private static void runExercise03() {
        check("normal", 12, () -> CurrentChallenge.sumEvenNumbers(List.of(1, 2, 4, 5, 6)));
        check("vacía", 0, () -> CurrentChallenge.sumEvenNumbers(List.of()));
        check("negativos", -4, () -> CurrentChallenge.sumEvenNumbers(List.of(-2, -2, 3)));
        check("sin pares", 0, () -> CurrentChallenge.sumEvenNumbers(List.of(1, 3, 5)));
    }

    // La entrada tendrá al menos un elemento y no puede modificarse.
    private static void runExercise04() {
        int[] normal = {8, 3, 10, -2};
        check("normal", 12, () -> CurrentChallenge.differenceBetweenMaxAndMin(normal));
        check("un elemento", 0,
                () -> CurrentChallenge.differenceBetweenMaxAndMin(new int[]{7}));
        check("todos iguales", 0,
                () -> CurrentChallenge.differenceBetweenMaxAndMin(new int[]{4, 4, 4}));
        check("entrada intacta", "[8, 3, 10, -2]", () -> java.util.Arrays.toString(normal));
    }

    // trim, espacios interiores únicos y primera letra de cada palabra en mayúscula.
    private static void runExercise05() {
        check("nombre simple", "Daniel", () -> CurrentChallenge.normalizeName("  dANIEL  "));
        check("nombre compuesto", "Daniel Alexander",
                () -> CurrentChallenge.normalizeName("  dANIEL    aLEXANDER "));
        check("ya normalizado", "Ana María",
                () -> CurrentChallenge.normalizeName("Ana María"));
        check("vacío", "", () -> CurrentChallenge.normalizeName("   "));
    }

    private static void runExercise06() {
        check("tres palabras", "three two one",
                () -> CurrentChallenge.joinWordsInReverseOrder(List.of("one", "two", "three")));
        check("una palabra", "java",
                () -> CurrentChallenge.joinWordsInReverseOrder(List.of("java")));
        check("vacía", "", () -> CurrentChallenge.joinWordsInReverseOrder(List.of()));
    }

    private static void runExercise07() {
        List<Integer> input = new ArrayList<>(List.of(-2, 0, 4, -1, 7));
        check("filtrado", List.of(0, 4, 7),
                () -> CurrentChallenge.copyWithoutNegativeNumbers(input));
        check("entrada intacta", List.of(-2, 0, 4, -1, 7), () -> input);
        check("vacía", List.of(),
                () -> CurrentChallenge.copyWithoutNegativeNumbers(List.of()));
    }

    private static void runExercise08() {
        check("primer duplicado", Optional.of(2),
                () -> CurrentChallenge.findFirstDuplicate(List.of(1, 2, 3, 2, 1)));
        check("sin duplicados", Optional.empty(),
                () -> CurrentChallenge.findFirstDuplicate(List.of(1, 2, 3)));
        check("duplicado inmediato", Optional.of(5),
                () -> CurrentChallenge.findFirstDuplicate(List.of(5, 5, 2)));
    }

    // Ignorar mayúsculas, espacios exteriores y entradas blank.
    private static void runExercise09() {
        check("conteos normalizados", Map.of("java", 3, "go", 1),
                () -> CurrentChallenge.countNormalizedWords(
                        List.of("Java", " java ", "GO", "JAVA", "   ")));
        check("vacía", Map.of(),
                () -> CurrentChallenge.countNormalizedWords(List.of()));
    }

    // Los grupos y sus elementos deben conservar el orden de aparición.
    private static void runExercise10() {
        Order first = new Order(1, 20, 10.0);
        Order second = new Order(2, 10, 15.0);
        Order third = new Order(3, 20, 5.0);

        Map<Long, List<Order>> result = CurrentChallenge.groupOrdersByUser(
                List.of(first, second, third));

        Map<Long, List<Order>> expected = new LinkedHashMap<>();
        expected.put(20L, List.of(first, third));
        expected.put(10L, List.of(second));

        check("grupos", expected, () -> result);
        check("orden de claves", List.of(20L, 10L),
                () -> new ArrayList<>(result.keySet()));
    }

    // Precio descendente; empate por nombre ascendente; no modificar entrada.
    private static void runExercise11() {
        Product keyboard = new Product(1, "Keyboard", 50.0);
        Product monitor = new Product(2, "Monitor", 200.0);
        Product mouse = new Product(3, "Mouse", 50.0);
        List<Product> input = new ArrayList<>(List.of(keyboard, monitor, mouse));

        check("orden", List.of(monitor, keyboard, mouse),
                () -> CurrentChallenge.sortProducts(input));
        check("entrada intacta", List.of(keyboard, monitor, mouse), () -> input);
    }

    // Primera versión: el intervalo no cruza medianoche.
    private static void runExercise12() {
        check("cinco horas", 300L,
                () -> CurrentChallenge.durationInMinutes(new OpeningInterval(
                        DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(14, 0))));
        check("media hora", 30L,
                () -> CurrentChallenge.durationInMinutes(new OpeningInterval(
                        DayOfWeek.TUESDAY, LocalTime.of(9, 15), LocalTime.of(9, 45))));
    }

    // Reglas: PENDING -> PAID/CANCELLED; PAID -> SHIPPED; estados finales no cambian.
    private static void runExercise13() {
        check("pendiente a pagado", true,
                () -> CurrentChallenge.canTransition(OrderStatus.PENDING, OrderStatus.PAID));
        check("pendiente a cancelado", true,
                () -> CurrentChallenge.canTransition(OrderStatus.PENDING, OrderStatus.CANCELLED));
        check("pagado a enviado", true,
                () -> CurrentChallenge.canTransition(OrderStatus.PAID, OrderStatus.SHIPPED));
        check("enviado a pendiente", false,
                () -> CurrentChallenge.canTransition(OrderStatus.SHIPPED, OrderStatus.PENDING));
        check("mismo estado", false,
                () -> CurrentChallenge.canTransition(OrderStatus.PAID, OrderStatus.PAID));
    }

    private static void runExercise14() {
        DiscountPolicy noDiscount = price -> price;
        DiscountPolicy twentyPercent = price -> price * 0.80;

        checkDouble("sin descuento", 100.0,
                () -> CurrentChallenge.applyDiscount(100.0, noDiscount));
        checkDouble("veinte por ciento", 80.0,
                () -> CurrentChallenge.applyDiscount(100.0, twentyPercent));
    }

    private static void runExercise15() {
        check("válido", 25, () -> CurrentChallenge.parsePositiveInteger("25"));
        checkThrows("texto inválido", IllegalArgumentException.class,
                () -> CurrentChallenge.parsePositiveInteger("hello"));
        checkThrows("cero", IllegalArgumentException.class,
                () -> CurrentChallenge.parsePositiveInteger("0"));
        checkThrows("negativo", IllegalArgumentException.class,
                () -> CurrentChallenge.parsePositiveInteger("-3"));
    }

    private static void runExercise16() {
        User ana = new User(1, "Ana");
        User daniel = new User(2, "Daniel");
        check("encontrado", Optional.of(daniel),
                () -> CurrentChallenge.findUserById(List.of(ana, daniel), 2));
        check("no encontrado", Optional.empty(),
                () -> CurrentChallenge.findUserById(List.of(ana, daniel), 99));
    }

    // Longitud ascendente; empate alfabético. No modificar entrada.
    private static void runExercise17() {
        List<String> input = new ArrayList<>(List.of("pear", "fig", "apple", "kiwi"));
        check("orden", List.of("fig", "kiwi", "pear", "apple"),
                () -> CurrentChallenge.sortByLengthAndAlphabetically(input));
        check("entrada intacta", List.of("pear", "fig", "apple", "kiwi"), () -> input);
    }

    // trim + minúsculas + eliminar blank + únicos + orden alfabético.
    private static void runExercise18() {
        List<String> input = List.of(" Daniel ", "ana", "ANA", " ", "Marta");
        List<String> expected = List.of("ana", "daniel", "marta");

        check("con bucle", expected,
                () -> CurrentChallenge.normalizeUniqueNamesWithLoop(input));
        check("con stream", expected,
                () -> CurrentChallenge.normalizeUniqueNamesWithStream(input));
        check("vacía con bucle", List.of(),
                () -> CurrentChallenge.normalizeUniqueNamesWithLoop(List.of()));
        check("vacía con stream", List.of(),
                () -> CurrentChallenge.normalizeUniqueNamesWithStream(List.of()));
    }

    // Intervalo [opening, closing): apertura incluida y cierre excluido.
    private static void runExercise19() {
        LocalTime opening = LocalTime.of(9, 0);
        LocalTime closing = LocalTime.of(14, 0);
        check("antes", false,
                () -> CurrentChallenge.isTimeInsideInterval(LocalTime.of(8, 59), opening, closing));
        check("apertura", true,
                () -> CurrentChallenge.isTimeInsideInterval(opening, opening, closing));
        check("dentro", true,
                () -> CurrentChallenge.isTimeInsideInterval(LocalTime.of(12, 0), opening, closing));
        check("cierre", false,
                () -> CurrentChallenge.isTimeInsideInterval(closing, opening, closing));
    }

    private static void runExercise20() {
        BusinessId first = new BusinessId("ES", "A123");
        BusinessId duplicate = new BusinessId("ES", "A123");
        BusinessId second = new BusinessId("ES", "B999");
        check("elimina duplicados", Set.of(first, second),
                () -> CurrentChallenge.uniqueBusinessIds(List.of(first, duplicate, second)));
    }

    // Los caracteres que no sean brackets se ignoran.
    private static void runExercise21() {
        check("vacía", true, () -> CurrentChallenge.hasBalancedBrackets(""));
        check("balanceada", true, () -> CurrentChallenge.hasBalancedBrackets("({[]})"));
        check("con texto", true, () -> CurrentChallenge.hasBalancedBrackets("a + (b * [c])"));
        check("orden incorrecto", false, () -> CurrentChallenge.hasBalancedBrackets("([)]"));
        check("falta cierre", false, () -> CurrentChallenge.hasBalancedBrackets("(()"));
    }

    // Devuelve hasta k valores, de mayor a menor. k será >= 0.
    private static void runExercise22() {
        check("top tres", List.of(9, 7, 5),
                () -> CurrentChallenge.findLargestValues(List.of(5, 1, 9, 3, 7), 3));
        check("k cero", List.of(),
                () -> CurrentChallenge.findLargestValues(List.of(5, 1), 0));
        check("k mayor que size", List.of(5, 2),
                () -> CurrentChallenge.findLargestValues(List.of(2, 5), 10));
    }

    // Regla del ejercicio: coste = 5 + distanceKm; si priority, añadir 10.
    private static void runExercise23() {
        check("envío normal", 15,
                () -> CurrentChallenge.calculateShippingCost(10, false));
        check("envío prioritario", 25,
                () -> CurrentChallenge.calculateShippingCost(10, true));
        check("distancia cero", 5,
                () -> CurrentChallenge.calculateShippingCost(0, false));
        checkThrows("distancia negativa", IllegalArgumentException.class,
                () -> CurrentChallenge.calculateShippingCost(-1, false));
    }

    // Varios intervalos por tienda; intervalo [apertura,cierre); sin cruce de medianoche.
    private static void runExercise24() {
        Business bakery = new Business(1, "Bakery", List.of(
                new OpeningInterval(DayOfWeek.MONDAY, LocalTime.of(8, 0), LocalTime.of(14, 0))));
        Business restaurant = new Business(2, "Restaurant", List.of(
                new OpeningInterval(DayOfWeek.MONDAY, LocalTime.of(12, 0), LocalTime.of(16, 0)),
                new OpeningInterval(DayOfWeek.MONDAY, LocalTime.of(19, 0), LocalTime.of(23, 0))));
        Business closedOnMonday = new Business(3, "Weekend shop", List.of(
                new OpeningInterval(DayOfWeek.SATURDAY, LocalTime.of(9, 0), LocalTime.of(20, 0))));
        List<Business> businesses = List.of(bakery, restaurant, closedOnMonday);

        check("lunes a las 13", List.of(bakery, restaurant),
                () -> CurrentChallenge.findOpenBusinesses(
                        businesses, DayOfWeek.MONDAY, LocalTime.of(13, 0)));
        check("lunes a las 18", List.of(),
                () -> CurrentChallenge.findOpenBusinesses(
                        businesses, DayOfWeek.MONDAY, LocalTime.of(18, 0)));
        check("apertura incluida", List.of(bakery),
                () -> CurrentChallenge.findOpenBusinesses(
                        businesses, DayOfWeek.MONDAY, LocalTime.of(8, 0)));
        check("cierre excluido", List.of(),
                () -> CurrentChallenge.findOpenBusinesses(
                        businesses, DayOfWeek.MONDAY, LocalTime.of(23, 0)));
    }

    private static <T> void check(String name, T expected, CheckedSupplier<T> action) {
        try {
            T actual = action.get();
            if (Objects.equals(expected, actual)) {
                passed++;
                System.out.printf("[OK]   %s%n", name);
            } else {
                failed++;
                System.out.printf("[FAIL] %s - esperado: %s, obtenido: %s%n",
                        name, expected, actual);
            }
        } catch (Throwable throwable) {
            failed++;
            System.out.printf("[ERROR] %s - %s: %s%n",
                    name, throwable.getClass().getSimpleName(), throwable.getMessage());
        }
    }

    private static void checkDouble(
            String name,
            double expected,
            CheckedSupplier<Double> action) {
        try {
            double actual = action.get();
            if (Math.abs(expected - actual) <= DOUBLE_TOLERANCE) {
                passed++;
                System.out.printf("[OK]   %s%n", name);
            } else {
                failed++;
                System.out.printf("[FAIL] %s - esperado: %.6f, obtenido: %.6f%n",
                        name, expected, actual);
            }
        } catch (Throwable throwable) {
            failed++;
            System.out.printf("[ERROR] %s - %s: %s%n",
                    name, throwable.getClass().getSimpleName(), throwable.getMessage());
        }
    }

    private static void checkThrows(
            String name,
            Class<? extends Throwable> expectedType,
            CheckedAction action) {
        try {
            action.run();
            failed++;
            System.out.printf("[FAIL] %s - se esperaba %s, pero no se lanzó ninguna excepción%n",
                    name, expectedType.getSimpleName());
        } catch (Throwable throwable) {
            if (expectedType.isInstance(throwable)) {
                passed++;
                System.out.printf("[OK]   %s%n", name);
            } else {
                failed++;
                System.out.printf("[FAIL] %s - se esperaba %s, pero se recibió %s%n",
                        name, expectedType.getSimpleName(), throwable.getClass().getSimpleName());
            }
        }
    }

    @FunctionalInterface
    private interface CheckedSupplier<T> {
        T get() throws Exception;
    }

    @FunctionalInterface
    private interface CheckedAction {
        void run() throws Exception;
    }
}
