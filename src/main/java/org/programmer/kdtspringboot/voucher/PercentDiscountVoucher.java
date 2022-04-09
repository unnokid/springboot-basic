package org.programmer.kdtspringboot.voucher;

import org.springframework.stereotype.Repository;

import java.util.UUID;

public class PercentDiscountVoucher implements Voucher{

    private final UUID voucherId;
    private final Long percent;

    public PercentDiscountVoucher(UUID voucherId, Long percent) {
        this.voucherId = voucherId;
        this.percent = percent;
    }

    @Override
    public UUID getVoucherId() {
        return voucherId;
    }

    @Override
    public Long getValue() {
        return percent;
    }

    @Override
    public Long discount(Long beforeDiscount) {
        return beforeDiscount * (percent/100);
    }
}
