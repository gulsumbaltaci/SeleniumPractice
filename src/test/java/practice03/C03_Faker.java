package practice03;

import com.github.javafaker.Faker;

public class C03_Faker {
    public static void main(String[] args) {
        Faker faker = new Faker();

        System.out.println(faker.name().fullName());
        System.out.println(faker.internet().emailAddress());
        System.out.println(faker.address().fullAddress());
        System.out.println(faker.finance().iban());
        faker.internet().password(10,14,true,false,true);
    }
}
