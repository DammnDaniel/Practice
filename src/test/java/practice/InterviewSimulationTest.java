package practice;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static practice.InterviewSimulation.Interval;
import static practice.InterviewSimulation.Negocio;

class InterviewSimulationTest {

    private final InterviewSimulation simulation = new InterviewSimulation();

    @Test
    void returnsBusinessesOpenAtTheRequestedTime() {
        Negocio bakery = new Negocio(1, "Bakery", List.of(
                new Interval(DayOfWeek.MONDAY, LocalTime.of(8, 0), LocalTime.of(14, 0))));
        Negocio restaurant = new Negocio(2, "Restaurant", List.of(
                new Interval(DayOfWeek.MONDAY, LocalTime.of(12, 0), LocalTime.of(16, 0))));

        var result = simulation.consultar(
                DayOfWeek.MONDAY,
                LocalTime.of(13, 0),
                List.of(bakery, restaurant));

        assertIterableEquals(List.of(bakery, restaurant), result);
    }

    @Test
    void includesTheExactOpeningTime() {
        Negocio bakery = new Negocio(1, "Bakery", List.of(
                new Interval(DayOfWeek.MONDAY, LocalTime.of(8, 0), LocalTime.of(14, 0))));

        var result = simulation.consultar(
                DayOfWeek.MONDAY,
                LocalTime.of(8, 0),
                List.of(bakery));

        assertIterableEquals(List.of(bakery), result);
    }

    @Test
    void excludesTheExactClosingTime() {
        Negocio bakery = new Negocio(1, "Bakery", List.of(
                new Interval(DayOfWeek.MONDAY, LocalTime.of(8, 0), LocalTime.of(14, 0))));

        var result = simulation.consultar(
                DayOfWeek.MONDAY,
                LocalTime.of(14, 0),
                List.of(bakery));

        assertIterableEquals(List.of(), result);
    }

    @Test
    void returnsEmptyWhenTheBusinessIsClosedThatDay() {
        Negocio bakery = new Negocio(1, "Bakery", List.of(
                new Interval(DayOfWeek.MONDAY, LocalTime.of(8, 0), LocalTime.of(14, 0))));

        var result = simulation.consultar(
                DayOfWeek.SATURDAY,
                LocalTime.of(10, 0),
                List.of(bakery));

        assertIterableEquals(List.of(), result);
    }
}
