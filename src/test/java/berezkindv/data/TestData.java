package berezkindv.data;

import com.github.javafaker.Faker;

public class TestData {
    public static Faker faker = new Faker();
    public static String mailSubject = faker.pokemon().name();
    public static String mailMessage = faker.yoda().quote();
}
