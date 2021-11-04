package lotto.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberRange {
    private static final List<Integer> lottoNumberRangeList = new LinkedList<>();
    private static LottoNumberRange lottoNumberRange = new LottoNumberRange();
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;

    private LottoNumberRange() {
        for (int i = LOTTO_START_NUMBER; i <= LOTTO_END_NUMBER; i++) {
            lottoNumberRangeList.add(i);
        }
    }

    public static List<Integer> getLottoNumberRange() {
        return new ArrayList<>(lottoNumberRangeList);
    }
}