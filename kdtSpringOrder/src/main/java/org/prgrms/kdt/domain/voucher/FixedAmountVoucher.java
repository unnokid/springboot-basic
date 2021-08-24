package org.prgrms.kdt.domain.voucher;

import org.prgrms.kdt.enums.VoucherType;

import java.util.UUID;

public class FixedAmountVoucher implements Voucher {

    private static final long MAX_VOUCHER_AMOUNT = 10000;

    private final UUID voucherId;
    private final long amount;

    public FixedAmountVoucher(UUID voucherId, long amount) {
        if(amount < 0) throw new IllegalArgumentException("Amount should be positive");
        if(amount == 0) throw new IllegalArgumentException("Amount should not be zero");
        if(amount > MAX_VOUCHER_AMOUNT) throw new IllegalArgumentException("Amount should be less than %d".formatted(MAX_VOUCHER_AMOUNT));

        this.voucherId = voucherId;
        this.amount = amount;
    }

    @Override
    public UUID getVoucherId() {
        return voucherId;
    }

    @Override
    public long getDiscount() {
        return amount;
    }

    @Override
    public long discount(long beforeDiscount) {
        long discountAmount = beforeDiscount - amount;
        return (discountAmount < 0) ? 0 : discountAmount;
    }

    @Override
    public VoucherType getVoucherType(){ return VoucherType.FIXED; };

    @Override
    public String toString() {
        return "Fixed Amount Voucher [ " +
                "voucherId = " + voucherId +
                ", amount = " + amount +
                " ]";
    }

}