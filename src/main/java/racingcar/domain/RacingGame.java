package racingcar.domain;
import racingcar.strategy.DoOneForward;
import racingcar.strategy.OneOrZeroForwardCondition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static racingcar.Constants.INIT_POSITION;

public class RacingGame {
    private int carCounts;
    private int racingCounts;
    private List<Car> cars;

    public List<Car> getCars() { return Collections.unmodifiableList(cars);}

    public RacingGame(int carCounts, int racingCounts) {
        this.carCounts = carCounts;
        this.cars = createCars(carCounts);
        this.racingCounts = racingCounts;
    }

    public static List<Car> createCars(int carCounts) {
        List<Car> carList = new ArrayList<>(carCounts);
        for (int i = 0; i < carCounts; i++) {
            carList.add(new Car(new Position(INIT_POSITION)));
        }
        return carList;
    }

    public void yesRacingCars() {
        this.racingCounts--;
        moveCars();
    }

    public boolean yesRacingCond() {
        return this.racingCounts > 0;
    }

    private void moveCars() {
        for (Car car:cars) {
            car.move(new OneOrZeroForwardCondition(), new DoOneForward());
        }
    }

}



/* BEFORE
    public List<Integer> allDoRace(int carCounts, int racingCounts) {
        this.carList = new ArrayList<>(carCounts);
        List<Integer> resultList = Arrays.asList(0);

        if (racingCounts == 0) {
            return resultList;
        }
        resultList = carList.stream( )
                .map(Car::getPosition)
                .collect(Collectors.toList( ));
        resultList.add(0);
        racingCounts -= 1;
        resultList.addAll(allDoRace(carCounts, racingCounts));
        return resultList;
    }

 */



