package racingcar.domain.car;

import racingcar.domain.car.strategy.raceStrategy.DoRace;
import racingcar.domain.car.strategy.condition.RaceCondition;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static racingcar.domain.game.utils.Constants.INIT_POSITION;

public class Car {

    private final String carName;
    private Position position;

    public Car(String carName) {
        this (carName, new Position(INIT_POSITION));
    }

    public Car(String carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public void Car(Position position) {
        this.position = position;
    }

    public int getPosition() {
        return position.getPosition();
    }

    public Map<String, Integer> toMap() {
        Map<String, Integer> carMap = new HashMap<>();
        carMap.put(carName, getPosition());
        return carMap;
    }

    public void move(RaceCondition raceCondition, DoRace doRace) {
        position.increase(raceCondition, doRace);
    }

    public boolean isMaxPosition(int maxPosition) {
        return position.checkMaxPosition(maxPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) &&
                Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
