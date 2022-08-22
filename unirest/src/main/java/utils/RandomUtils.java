package utils;

import java.util.Random;

public class RandomUtils {

    private static String randomTextTitle;
    private static String randomTextBody;
    private static Integer randomSize = Integer.parseInt(JsonParseUtils.getElementFromJsonParse("testFile.json", "/randomTextSize"));

    public static String generateString() {
        String text = "ABCDEFGHIJKLMNOPQRSTUVWXZ0123456789";
        StringBuilder sb = new StringBuilder(randomSize);
        Random random = new Random();
        for (int i = 0; i < randomSize; i++) {
            int index = random.nextInt(text.length());
            char randomChar = text.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public static String getRandomTextTitle() {
        return randomTextTitle;
    }

    public static void setRandomTextTitle(String randomTextTitle) {
        RandomUtils.randomTextTitle = randomTextTitle;
    }

    public static String getRandomTextBody() {
        return randomTextBody;
    }

    public static void setRandomTextBody(String randomTextBody) {
        RandomUtils.randomTextBody = randomTextBody;
    }

    public static String getRandomTextForTitle() {
        setRandomTextTitle(generateString());
        return getRandomTextTitle();
    }

    public static String getRandomTextForBody() {
        setRandomTextBody(generateString());
        return getRandomTextBody();
    }
}
