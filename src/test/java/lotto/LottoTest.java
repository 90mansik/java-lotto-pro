package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoPrize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoTest {
    LottoNumbers winningNumbers;

    @BeforeEach
    void init() {
        winningNumbers = new LottoNumbers(Arrays.asList("1", "2", "3", "4", "5", "6"));
    }

    @Test
    void 로또번호_범위_에러() {
        assertAll(
                () -> assertThatThrownBy(() ->
                        new Lotto(new LottoNumbers(Arrays.asList("0", "2", "3", "7", "8", "9"))))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() ->
                        new Lotto(new LottoNumbers(Arrays.asList("1", "2", "3", "7", "8", "46"))))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 로또_4등() {
        Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList("1", "2", "3", "7", "8", "9")));
        assertThat(lotto.compareWinningNumbers(winningNumbers)).isEqualTo(LottoPrize.FOURTH);
    }

    @Test
    void 로또_3등() {
        Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList("1", "2", "3", "4", "8", "9")));
        assertThat(lotto.compareWinningNumbers(winningNumbers)).isEqualTo(LottoPrize.THIRD);
    }

    @Test
    void 로또_2등() {
        Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList("1", "2", "3", "4", "5", "9")));
        assertThat(lotto.compareWinningNumbers(winningNumbers)).isEqualTo(LottoPrize.SECOND);
    }

    @Test
    void 로또_1등() {
        Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList("1", "2", "3", "4", "5", "6")));
        assertThat(lotto.compareWinningNumbers(winningNumbers)).isEqualTo(LottoPrize.FIRST);
    }
}