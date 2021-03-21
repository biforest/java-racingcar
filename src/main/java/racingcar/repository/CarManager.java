package racingcar.repository;

import racingcar.domain.Car;
import racingcar.dto.CarNumberDto;
import racingcar.repository.exception.NotDuplicateNameException;
import racingcar.ui.Printer;
import racingcar.util.Discriminator;
import racingcar.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class CarManager {
    private List<Car> cars;

    public CarManager() {
        cars = new ArrayList<>();
    }

    private void checkDuplicateName(Car car) {
        if (cars.contains(car)) {
            throw new NotDuplicateNameException("중복되는 이름의 차를 입력하실 수 없습니다.");
        }
    }

    public int size() {
        return cars.size();
    }

    public void addAllCars(List<Car> cars) {
        for (Car car : cars) {
            checkDuplicateName(car);
            this.cars.add(car);
        }
    }

    public List<CarNumberDto> generateCarNumberDtos() {
        List<CarNumberDto> dtos = new ArrayList<>();

        for (Car car: cars) {
            int randomNumber = RandomGenerator.generateNumber();
            dtos.add(new CarNumberDto(car, randomNumber));
        }

        return dtos;
    }

    public void moveAllCars(List<CarNumberDto> carNumberList) {
        for (CarNumberDto dto : carNumberList) {
            if (Discriminator.isMove(dto.getNumber())) {
                dto.getCar().move();
            }
        }
    }

    public void printCarState(Printer printer) {
        for (Car car : cars) {
            printer.printCarState(car);
        }
        printer.printNewLine();
    }

    public String createWinnerMessage() {
        StringJoiner winnerMessage = new StringJoiner(",");
        List<Car> winners = winnerList();
        for (Car winner : winners) {
            winnerMessage.add(winner.getName());
        }
        return winnerMessage.toString();
    }

    private List<Car> winnerList() {
        int winnerPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalArgumentException::new);

        return cars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .collect(Collectors.toList());
    }
}
