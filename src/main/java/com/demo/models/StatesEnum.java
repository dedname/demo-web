package com.demo.models;

import java.util.Random;

//Enum for state
public enum StatesEnum {

    NULL("", "-"),
    AL("1", "Alabama"),
    AK("2", "Alaska"),
    AZ("3", "Arizona"),
    AR("4", "Arkansas"),
    CA("5", "California"),
    CO("6", "Colorado"),
    CT("7", "Connecticut"),
    DE("8", "Delaware"),
    FL("9", "Florida"),
    GA("10", "Georgia"),
    HI("11", "Hawaii"),
    ID("12", "Idaho"),
    IL("13", "Illinois"),
    IN("14", "Indiana"),
    IA("15", "Iowa"),
    KS("16", "Kansas"),
    KY("17", "Kentucky"),
    LA("18", "Louisiana"),
    ME("19", "Maine"),
    MD("20", "Maryland"),
    MA("21", "Massachusetts"),
    MI("22", "Michigan"),
    MN("23", "Minnesota"),
    MS("24", "Mississippi"),
    MO("25", "Missouri"),
    MT("26", "Montana"),
    NE("27", "Nebraska"),
    NV("28", "Nevada"),
    NH("29", "New Hampshire"),
    NJ("30", "New Jersey"),
    NM("31", "New Mexico"),
    NY("32", "New York"),
    NC("33", "North Carolina"),
    ND("34", "North Dakota"),
    OH("35", "Ohio"),
    OK("36", "Oklahoma"),
    OR("37", "Oregon"),
    PA("38", "Pennsylvania"),
    RI("39", "Rhode Island"),
    SC("40", "South Carolina"),
    SD("41", "South Dakota"),
    TN("42", "Tennessee"),
    TX("43", "Texas"),
    UT("44", "Utah"),
    VT("45", "Vermont"),
    VA("46", "Virginia"),
    WA("47", "Washington"),
    WV("48", "West Virginia"),
    WI("49", "Wisconsin"),
    WY("50", "Wyoming"),
    PR("51", "Puerto Rico"),
    VI("52", "US Virgin Islands"),
    DC("53", "District of Columbia");

    private final String key;
    private final String value;

    StatesEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static StatesEnum getRandomState() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }
}

