package com.demo.models;

import lombok.Data;
import lombok.experimental.Accessors;

//This annotation from lombok create getters and setters for class
@Data
//This annotation makes getters and setters return 'this' for chain use
@Accessors(chain = true)
public class User {

    private String email;
    private String firstName;
    private String lastName;
    private String company;
    private String address;
    private String city;
    private StatesEnum state;
    private String postcode;
    private String additionalInformation;
    private String homePhone;
    private String mobilePhone;
    private String alias;
    private int bdDay;
    private int bdMonth;
    private int bdYear;

}
