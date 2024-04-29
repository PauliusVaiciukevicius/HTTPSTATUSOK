package Util;

import java.util.Random;

public class RandomGenerator {

        public static String generateRandomEmail() {
            Random randomGenerator = new Random();
            return randomGenerator.nextInt(1000)+ "violeta@mail.com";
        }

    public static String generateRandomUsername(){
        Random randomUsername = new Random();
        return randomUsername.nextInt(1000)+ "Violeta";
    }

}
