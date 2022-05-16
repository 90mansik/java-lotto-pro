package lotto;

import static java.util.stream.IntStream.range;

import generic.Money;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottoList;

    private Lottos(final List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static Lottos of(Lotto... lotto) {
        return new Lottos(Arrays.asList(lotto));
    }

    public static Lottos purchaseAuto(final Money purchaseMoney) {
        return purchase(purchaseMoney);
    }

    private static Lottos purchase(final Money purchaseMoney) {
        return new Lottos(buyLottoList(purchaseMoney));
    }

    private static List<Lotto> buyLottoList(final Money purchaseMoney) {
        return range(0, purchaseMoney.divide(Lotto.PURCHASE_PRICE).getIntValue())
                .mapToObj(value -> Lotto.generate())
                .collect(Collectors.toList());
    }

    public int size() {
        return lottoList.size();
    }

    public Money purchasePrice() {
        return Lotto.PURCHASE_PRICE.times(this.lottoList.size());
    }

    public LottoWinResultGroup end(final LottoNumbers winningNumbers) {
        return new LottoWinResultGroup(this.lottoList.stream()
                .map(lotto -> lotto.confirm(winningNumbers))
                .collect(Collectors.toList())
        );
    }

    public void each(final Consumer<Lotto> consumer) {
        this.lottoList.forEach(consumer);
    }
}