package com.programmers.voucher.repository.voucher;

import com.programmers.voucher.entity.voucher.Voucher;

import java.util.List;

public interface VoucherRepository {
    Voucher save(String name, Voucher.type type);

    List<Voucher> listAll();
}
