package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        Money money = new Money(InputView.askAmount());
        Lottos lottos = new Lottos(money.getMoney());
        OutputView.printLottos(lottos);
        WinningLotto winningLotto = new WinningLotto(InputView.askWinningNumber());
        BonusNumber bonusNumber = new BonusNumber(winningLotto, InputView.askBonusNumber());
    }
}
