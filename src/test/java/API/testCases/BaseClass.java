package API.testCases;

import org.apache.commons.lang3.RandomStringUtils;

public class BaseClass {

    public static String bvn = "22212345678";

    public String randomString(int count)
    {
        return RandomStringUtils.randomAlphabetic(count);
    }

    public String randomNumber(int count)
    {
        return RandomStringUtils.randomNumeric(count);
    }

    public String randomAlphaNumeric(int count)
    {
        return RandomStringUtils.randomAlphanumeric(count);
    }
}
