package berezkindv.data;

import com.github.javafaker.Faker;

public class TestData {
    public static Faker faker = new Faker();
    public static String mailSubject = faker.pokemon().name();
    public static String mailMessage = faker.yoda().quote();
//    public static String testMailSubject = "Test mail " + System.currentTimeMillis();
//    public static String testMailMessage = "This is a test message";

}
