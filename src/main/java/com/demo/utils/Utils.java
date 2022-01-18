package com.demo.utils;

import com.demo.models.StatesEnum;
import com.demo.models.User;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.Year;
import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.random;

public final class Utils {

    public User generateNewUser() {
        return new User()
                .setEmail(generateNewEmail())
                .setFirstName(random(8, true,false))
                .setLastName(random(8, true,false))
                .setCompany(random(8, true, false))
                .setAddress(random(10, true, true))
                .setCity(random(8, true, false))
                .setState(StatesEnum.getRandomState())
                .setPostcode(random(5, false, true))
                .setAdditionalInformation(random(20, true, true))
                .setHomePhone(random(7, false, true))
                .setMobilePhone(random(11, false, true))
                .setAlias(random(20, true, true))
                .setBdDay(new Random().nextInt(27) + 1)
                .setBdMonth(new Random().nextInt(11) + 1)
                .setBdYear(new Random().nextInt(Year.now().getValue() - 1900) + 1900);

    }

    public String generateNewEmail() {
        return String.format("qwe+%s@123.com", RandomStringUtils.random(12, true,true)).toLowerCase();
    }

}
