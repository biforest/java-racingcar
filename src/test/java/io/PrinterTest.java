package io;

import domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PrinterTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    Printer printer;
    List<Car> cars = new ArrayList<>();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        printer = new Printer();
    }

    @Test
    void printProgressWithSymbolTest() {
        printer.printProgressWithSymbol("kim", 5);
        assertEquals("kim : -----", outputStreamCaptor.toString().trim());
    }

    @Test
    void makeWinnerToStringTest() {
        Car car1 = new Car("kim");
        Car car2 = new Car("park");
        cars.add(car1);
        cars.add(car2);

        String result = printer.makeWinnerToString(cars);
        assertThat(result).isEqualTo("kim, park");
    }

    @Test
    void printWinnerTest() {
        printer.printWinner("hobi, nonus");
        assertEquals("hobi, nonus가 최종 우승했습니다.", outputStreamCaptor.toString().trim());

    }

    @Test
    void printGeneralMessageTest() {
        printer.printGeneralMessage("INPUT_COUNT");
        assertEquals("시도할 회수는 몇회인가요?", outputStreamCaptor.toString().trim());

    }

    @Test
    void printExceptionMessageTest() {
        printer.printExceptionMessage("INPUT_NOTHING");
        assertEquals("아무 문자도 입력되지 않았습니다.", outputStreamCaptor.toString().trim());
    }
}