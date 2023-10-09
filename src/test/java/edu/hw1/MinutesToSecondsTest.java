package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MinutesToSecondsTest {
    @Test
    @DisplayName("Преобразование корректного времени")
    void validTimeConversion() {
        String time1 = "01:00";
        String time2 = "13:56";

        int seconds1 = Task1.minutesToSeconds(time1);
        int seconds2 = Task1.minutesToSeconds(time2);

        assertThat(seconds1).isEqualTo(60);
        assertThat(seconds2).isEqualTo(836);
    }

    @Test
    @DisplayName("Преобразование времени с некорректными секундами")
    void invalidSecondsConversion() {
        String time = "10:60";

        int seconds = Task1.minutesToSeconds(time);

        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Преобразование времени с большим количеством минут")
    void largeMinutesConversion() {
        String time = "35791394:07";

        int seconds = Task1.minutesToSeconds(time);

        assertThat(seconds).isEqualTo(2147483647);
    }

    @Test
    @DisplayName("Преобразование времени с слишком большим количеством минут")
    void invalidLargeMinutesConversion() {
        String time = "35791395:07";

        int seconds = Task1.minutesToSeconds(time);

        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Преобразование нуля")
    void zeroConversion() {
        String time = "00:00";

        int seconds = Task1.minutesToSeconds(time);

        assertThat(seconds).isEqualTo(0);
    }

    @Test
    @DisplayName("Преобразование отрицательного времени")
    void negativeConversion() {
        String time = "-1:-1";

        int seconds = Task1.minutesToSeconds(time);

        assertThat(seconds).isEqualTo(-1);
    }
}
