package racingcar.view;

import racingcar.domain.RacingCars;

import java.util.Scanner;

import static racingcar.Constants.*;

public class RacingCarMain {
    public static void main(String[] args) {

        //  Scanner scanner = new Scanner(System.in); - InputView
        //    System.out.println(""); -OutputView

        int carCounts = InputView.getCarCounts();
        int racingCounts = InputView.getRacingCounts();

        RacingCars racingCars = new RacingCars(carCounts, racingCounts);
        ResultView.printStartResult();
        while (racingCars.yesRacingCond( )) {
            racingCars.yesRacingCars( );
        ResultView.printCars(racingCars.getCars());
        ResultView.printLine();
        }
    }

}
