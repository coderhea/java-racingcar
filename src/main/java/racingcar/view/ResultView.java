package racingcar.view;

import racingcar.domain.car.Car;

import java.util.List;

import static racingcar.utils.Constants.*;
import static racingcar.domain.car.Cars.findWinners;
import static racingcar.domain.car.WinnerCars.getWinnersNames;
import static racingcar.utils.StringUtils.repeat;

public class ResultView{

    private static OutputChannel outputChannel = OutputChannel.createSystemOut();

    private ResultView() {}

    public static void printStartResult() {
        outputChannel.printLine("\n"+SAY_VIEW_RESULT);
    }

    public static void printCars(List<Car> cars) {
        cars.forEach(ResultView::printPosition);
    }

    public static void printPosition(Car car) {
        outputChannel.printLine(car.getCarName() + SAY_CAR_NAMES + repeat(PRINT_GO, car.getPosition()));
    }
    public static void printEmptyLine() {
        outputChannel.printLine(EMPTY_LINE);
    }

    public static void printWinners(List<Car> cars) {outputChannel.printLine(getWinnersNames(findWinners(cars)) + SAY_WINNER_CARS_NAMES); }
}
