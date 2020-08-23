package racingcar.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car_old;

import static org.assertj.core.api.Assertions.assertThat;

public class StrategyTest {

    @DisplayName("1만큼 전진 전략 확인")
    @Test
    void OneForwardPosition() {
        Car_old car = new Car_old();
        RaceCondition alwaysOneForward = () -> true;
        car.move(alwaysOneForward, new DoOneForward());
        int actual = car.getPosition();
        assertThat(actual).isEqualTo(1);
    }

    @DisplayName("0만큼 전진, 즉 멈춤 전략 확인")
    @Test
    void ZeroForwardPosition() {
        Car_old car = new Car_old();
        RaceCondition alwaysZeroForward = () -> false;
        car.move(alwaysZeroForward, new DoOneForward());
        int actual = car.getPosition();
        assertThat(actual).isEqualTo(0);
    }
}
