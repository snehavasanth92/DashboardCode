package Utilities;

import com.github.javafaker.Faker;

public class FakerUtility {


    public static String getRandomDigitNumber(int digit){
        Faker faker=new Faker();
        return faker.number().digits(digit).toString();
    }

}
