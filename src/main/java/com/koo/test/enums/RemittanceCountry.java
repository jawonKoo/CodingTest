package com.koo.test.enums;

public enum RemittanceCountry {

    USD("미국(USD)"),
    AUD("호주(AUD)");

    private String country;

    RemittanceCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
}
