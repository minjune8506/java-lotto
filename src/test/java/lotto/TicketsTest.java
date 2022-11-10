package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketsTest {

    @Test
    @DisplayName("구입 금액에 맞게 로또가 생성되었는지 확인")
    void testTicketSize() {
        int amount = 10_000;
        Tickets tickets = new Tickets(amount);
        assertThat(tickets.getLottoTickets())
                .size()
                .isEqualTo(10);
    }

    @Test
    @DisplayName("구입 금액이 0원인 경우")
    void testZeroAmount() {
        int amount = 0;
        Tickets tickets = new Tickets(amount);
        assertThat(tickets.getLottoTickets())
                .isNotNull()
                .isEmpty();
    }

    @Test
    @DisplayName("티켓을 수정하려 할 경우 예외 발생")
    void throwExcpetionWhenTryToChangeTicket() {
        int amount = 10_000;
        Tickets tickets = new Tickets(amount);
        List<Lotto> lottoTickets = tickets.getLottoTickets();
        assertThatThrownBy(lottoTickets::clear)
                .isInstanceOf(UnsupportedOperationException.class);
    }
}