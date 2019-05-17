package com.koo.test.vo;

import com.koo.test.enums.RecipientCountry;
import com.koo.test.enums.RemittanceCountry;
import lombok.Data;

@Data
public class ExchangeRate {

    private double USDAUD;

    private double USDKRW;

    private double USDJPY;

    private double USDPHP;

    private double standard;

    private double target;

    private double amount;

    public void setCalc(CalculationVO calculationVO) {
        if(calculationVO.getRemittance().equals(RemittanceCountry.USD)) {
            this.standard = 1;
        } else if(calculationVO.getRemittance().equals(RemittanceCountry.AUD)) {
            this.standard = 1/this.USDAUD;
        }

        if(calculationVO.getRecipient().equals(RecipientCountry.KRW)) {
            this.target = USDKRW;
        } else if(calculationVO.getRecipient().equals(RecipientCountry.JPY)) {
            this.target = USDJPY;
        } else if(calculationVO.getRecipient().equals(RecipientCountry.PHP)) {
            this.target = USDPHP;
        }

        this.amount =  Double.parseDouble(calculationVO.getAmount());
    }

    public double getCalc() {
        return amount*standard*target;
    }
}
