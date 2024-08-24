package API.testCases;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class BaseClass {
    Random random;

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

    public String random4Str(String c1, String c2, String c3, String c4)
    {
        random = new Random();
        List<String> choice = Arrays.asList(c1, c2, c3, c4);
        return choice.get(random.nextInt(choice.size()));
    }

    public String random3Str(String c1, String c2, String c3)
    {
        random = new Random();
        List<String> choice = Arrays.asList(c1, c2, c3);
        return choice.get(random.nextInt(choice.size()));
    }

    public String random2Str(String c1, String c2)
    {
        random = new Random();
        List<String> choice = Arrays.asList(c1, c2);
        return choice.get(random.nextInt(choice.size()));
    }

    public int random2Int(int biggerInt, int smallerInt)
    {
        random = new Random();
        return random.nextInt(biggerInt - smallerInt + 1) + smallerInt;
    }



}
