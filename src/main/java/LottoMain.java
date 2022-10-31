import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        LottoMain lottoMain = new LottoMain();
        //입력받은 금액 설정
        Money money = new Money(InputView.inputReadPurchaseMoney());
        int lottoTicketCount = money.countOfLottoTicket();
        //입력받은 금액에 횟수 반환
        OutputView.outputCountLottoTicket(lottoTicketCount);
        // 자동으로 발급된 로또 번호 저장
        LottoMachine lottoMachine = new AutoLottoMachine();
        List<Lotto> lottoList =  lottoMachine.purchaseLotte(lottoTicketCount);
        // 지난주 당첨번호 입력
        OutputView.outputPurchaseLottoList(lottoList);
        // 당첨 비교
        WinLotto winLotto = new WinLotto(InputView.inputWinLottoNumbers(), new WinReport());
        winLotto.findWinner(lottoList);
        OutputView.outputReportStart();;
        // 결과 출력
        lottoMain.getResultPrintMessage(winLotto,lottoTicketCount);
    }

    public void getResultPrintMessage(WinLotto winLotto, int lottoTicketCount){
        OutputView.MatchReportResult(winLotto);
        OutputView.outputProfit(winLotto, lottoTicketCount);
    }

}
