package com.koo.test.enums;

public enum RecipientCountry {
    KRW("한국(KRW)"),
    JPY("일본(JPY)"),
    PHP("필리핀(PHP)");

    private String country;

    RecipientCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

}
