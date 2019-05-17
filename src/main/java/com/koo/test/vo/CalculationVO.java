package com.koo.test.vo;

import com.koo.test.enums.RecipientCountry;
import com.koo.test.enums.RemittanceCountry;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class CalculationVO {

    private String amount;

    @Enumerated(EnumType.STRING)
    private RemittanceCountry remittance;

    @Enumerated(EnumType.STRING)
    private RecipientCountry recipient;
}
