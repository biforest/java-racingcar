package domain;

import io.Receiver;

public class CarManager {
    private final Receiver receiver = new Receiver();

    public Car[] produceCar(){
        String[] listOfName = receiver.receiveName();

        Car[] cars = new Car[listOfName.length];
        for (int i = 0; i < listOfName.length; i++)
            cars[i] = new Car(listOfName[i]);

        return cars;
    }


}
