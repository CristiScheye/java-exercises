/**
 * Created by cristi on 10/27/15.
 */
public class DigitalRoot {
    static int testCount = 0;
    static int passingTestCount = 0;

    public static void main(String[] args) {
        testEqual(getDigitalRoot(5), 5);
        testEqual(getDigitalRoot(27), 9);
        testEqual(getDigitalRoot(4856), 5);
        System.out.println(passingTestCount + " of " + testCount + " tests pass");
    }

    private static int getDigitalRoot(int originalNum) {
        int nextLevelNum;

        if (originalNum >= 10) {
            nextLevelNum = sumDigits(originalNum);
            return getDigitalRoot(nextLevelNum);
        }
        else {
            return originalNum;
        }
    }

    private static int sumDigits(int startingNum) {
        int accumulator = 0;

        while (startingNum > 0) {
            accumulator += startingNum % 10;
            startingNum /= 10;
        }

        return accumulator;
    }

    private static void testEqual(int testVal, int predictedVal) {
        testCount += 1;
        if (testVal == predictedVal) {
            passingTestCount += 1;
        }
        else {
          System.out.println("Fail: " + testVal + " is equal to " + predictedVal);
        }
    }
}
