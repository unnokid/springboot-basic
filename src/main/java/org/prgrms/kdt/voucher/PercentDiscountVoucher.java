package org.prgrms.kdt.voucher;

import java.util.UUID;

public class PercentDiscountVoucher implements Voucher {
    private final long MAX_RANGE = 100L;
    private final long MIN_RANGE = 0L;
    private final int PERCENTAGE = 100;

    private final UUID voucherId;
    private final long percent;

    public PercentDiscountVoucher(UUID voucherId, long percent) {
        this.voucherId = voucherId;
        this.percent = percent;
    }

    @Override
    public void validate(UUID voucherId, long amount) {
        if (voucherId == null || amount > MAX_RANGE || amount < MIN_RANGE) {
            throw new RuntimeException();
        }
    }

    @Override
    public UUID getVoucherId() {
        return voucherId;
    }

    @Override
    public long discount(long beforeDiscount) {
        return beforeDiscount * (percent / PERCENTAGE);
    }

    @Override
    public String toString() {
        return "Percent " +
                voucherId + " " +
                percent;
    }
}
