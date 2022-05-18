package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPassiveNumbersTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void 수동_로또_설정(String string) {
        LottoGameCount lottoGameCount = new LottoGameCount(3, "1");

        LottoPassiveNumbers lottoPassiveNumbers = new LottoPassiveNumbers(lottoGameCount);

        assertThat(lottoPassiveNumbers.generatePassiveNumbers(string.split(","))).size().isEqualTo(1);
    }
}
