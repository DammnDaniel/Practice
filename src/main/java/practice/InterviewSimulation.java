package practice;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Punto de entrada vacío para los simulacros de entrevista.
 *
 * Lee primero el enunciado correspondiente dentro de exercises/simulations.
 * Decide tú las clases, records, enums, funciones y casos necesarios.
 */
public final class InterviewSimulation {

    public InterviewSimulation() {
    }

    public static void main(String[] args) {
        List<Interval> bakeryIntervals = new ArrayList<>();
        bakeryIntervals.add(new Interval(
                DayOfWeek.MONDAY,
                LocalTime.of(8, 0),
                LocalTime.of(14, 0)));

        List<Interval> restaurantIntervals = new ArrayList<>();
        restaurantIntervals.add(new Interval(
                DayOfWeek.MONDAY,
                LocalTime.of(12, 0),
                LocalTime.of(16, 0)));
        restaurantIntervals.add(new Interval(
                DayOfWeek.MONDAY,
                LocalTime.of(19, 0),
                LocalTime.of(23, 0)));

        List<Interval> weekendShopIntervals = new ArrayList<>();
        weekendShopIntervals.add(new Interval(
                DayOfWeek.SATURDAY,
                LocalTime.of(9, 0),
                LocalTime.of(20, 0)));

        List<Negocio> negocios = List.of(
                new Negocio(1, "Bakery", bakeryIntervals),
                new Negocio(2, "Restaurant", restaurantIntervals),
                new Negocio(3, "Weekend shop", weekendShopIntervals));

        InterviewSimulation simulation = new InterviewSimulation();
        List<Negocio> abiertos = simulation.consultar(
                DayOfWeek.MONDAY,
                LocalTime.of(13, 0),
                negocios);

        System.out.println(abiertos);
    }

    public record Interval(
            DayOfWeek weekDay,
            LocalTime openingTime,
            LocalTime closingTime) {

    }

    public record Negocio(
            long id,
            String name,
            List<Interval> intervalList) {
    }

    public List<Negocio> consultar(
            DayOfWeek day,
            LocalTime actualTime,
            List<Negocio> negocios) {

        List<Negocio> abiertos = new ArrayList<>();

        for (Negocio negocio : negocios) {
            for (Interval interval : negocio.intervalList()) {
                boolean sameDay = interval.weekDay() == day;
                boolean openingReached = !actualTime.isBefore(interval.openingTime());
                boolean beforeClosing = actualTime.isBefore(interval.closingTime());

                if (sameDay && openingReached && beforeClosing) {
                    abiertos.add(negocio);
                    break;
                }
            }
        }

        /* Alternativa con streams:
        return negocios.stream()
                .filter(negocio -> negocio.intervalList().stream()
                        .anyMatch(interval ->
                                interval.weekDay() == day
                                && !actualTime.isBefore(interval.openingTime())
                                && actualTime.isBefore(interval.closingTime())))
                .toList();
        */

        return abiertos;
    }
}
