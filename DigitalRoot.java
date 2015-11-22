/**
 * Created by cristi on 10/27/15.
 *
 * Find the "digital root" of any natural number. The "digital root" is the sum of all digits;
 * continue adding digits until the sum is a single digit.
 */
public class DigitalRoot {
    static int testCount = 0;
    static int passingTestCount = 0;

    public static void main(String[] args) {
        Test t = new Test();
        t.equal(getDigitalRoot(5), 5, "finds digital root of single-digit number");
        t.equal(getDigitalRoot(27), 9, "finds digital root of double-digit number");
        t.equal(getDigitalRoot(4856), 5, "finds digital root of multi-digit number");
        t.end();
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

}
