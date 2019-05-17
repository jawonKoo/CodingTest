package com.koo.test.vo;

import lombok.Data;

@Data
public class ExchangeRateVo {

    private String success;

    private String terms;

    private String privacy;

    private String timestamp;

    private String source;

    private ExchangeRate quotes;
}
