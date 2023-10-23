
import java.math.BigDecimal;

public class LucasGenerator {
    private int lastIndex = 0;
    private BigDecimal current = new BigDecimal(2);
    private BigDecimal lucasPrev = new BigDecimal(2);
    private BigDecimal lucasCurrent = new BigDecimal(1);

    public void reset() {
        lastIndex = 0;
        current = new BigDecimal(2);
        lucasPrev = new BigDecimal(2);
        lucasCurrent = new BigDecimal(1);
    }

    public BigDecimal nextTerm() {
        if (lastIndex > 1) {
            current = lucasPrev.add(lucasCurrent);
            lucasPrev = lucasCurrent;
            lucasCurrent = current;
        } else if (lastIndex == 1) {
            current = new BigDecimal(1);
        } else {
            current = new BigDecimal(2);
        }
        lastIndex++;
        return current;
    }

    public BigDecimal getTerm(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i < lastIndex) {
            reset();
        }
        while (lastIndex < i) {
            nextTerm();
        }
        return current;
    }
}
