package org.programmer.kdtspringboot.voucher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class PercentDiscountVoucher implements Voucher {
    private static final Logger logger = LoggerFactory.getLogger(PercentDiscountVoucher.class);
    private final UUID voucherId;
    private final long percent;
    private final static Integer MAX_AMOUNT = 100;
    private final static Integer MIN_AMOUNT = 0;
    public PercentDiscountVoucher(UUID voucherId, Long percent) {
        if (percent <= MIN_AMOUNT || percent > MAX_AMOUNT) {
            throw new IllegalArgumentException(MIN_AMOUNT + 1 + "~" + MAX_AMOUNT + " 범위의 값을 입력해주세요");
        }
        this.voucherId = voucherId;
        this.percent = percent;
    }

    @Override
    public UUID getVoucherId() {
        return voucherId;
    }

    @Override
    public long discount(Long beforeDiscount) {
        return (long) (beforeDiscount * ((100 - percent) / 100.0));
    }

    @Override
    public String getInfo() {
        return voucherId+","+percent+","+this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return "PercentDiscountVoucher{" +
                "voucherId=" + voucherId +
                ", percent=" + percent +
                ", class=" + this.getClass().getSimpleName() +
                '}';
    }
}
