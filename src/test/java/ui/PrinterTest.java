package ui;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Car;
import domain.CarFactory;

class PrinterTest {

    private Printer printer;
    private CarFactory factory;
    private String[] carNames = {"green", "tea", "star"};

    @BeforeEach
    void setUp() {
        factory = new CarFactory(carNames);
        List<Car> cars = factory.getCars();

        cars.get(0).moveForward();
        cars.get(0).moveForward();
        cars.get(1).moveForward();
        cars.get(2).moveForward();
        cars.get(2).moveForward();

        printer = new Printer(cars);
    }

    @Test
    public void findWinners() throws Exception {
        //given

        //when
        printer.findWinners();
        printer.printWinners();

        //then
        // assertThat()
    }

    @Test
    public void test() throws Exception {
        //given

        //when

        //then
    }
}