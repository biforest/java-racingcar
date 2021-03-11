package ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Car;

public class Printer {
    private final List<Car> cars;
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    private List<Integer> winners = new ArrayList<>();

    public Printer(List<Car> cars) {
        this.cars = cars;
    }

    private void putPositionOfCars() {
        for (int i = 0; i < cars.size(); i++) {
            map.put(i, cars.get(i).getPosition());
        }
    }

    public void findWinners() { // sortPositionsByReverseOrder
        putPositionOfCars();

        List<Integer> keySetList = new ArrayList<>(map.keySet());
        keySetList.sort((o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        /*for(Integer key : keySetList) {
            System.out.println("key : " + key + " / " + "value : " + map.get(key));
        }*/

        // int numberOfWinners = 0;
        int maxPosition = map.get(keySetList.get(0));
        for (int i = 0; i < cars.size(); i++) {
            if (map.get(keySetList.get(i)) < maxPosition) {
                break;
            }
            winners.add(keySetList.get(i));
            // numberOfWinners++;
        }
        // System.out.println("numberOfWinners : " + numberOfWinners);
    }

    public void printWinners() {
        findWinners();

        int numOfWinners = winners.size();
        for (int i = 0; i < numOfWinners; i++) {
            System.out.print(cars.get(winners.get(i)).getName());
            if (i != numOfWinners - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("가 최종 우승했습니다.");
    }
}
