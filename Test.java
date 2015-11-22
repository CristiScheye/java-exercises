import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by cristi on 11/22/15.
 */
public class Test {
    private int total = 0;
    private int success = 0;

    public Test() {
    }

    public void ok(Boolean testValue, String comment) {
        total++;

        if (testValue) {
            System.out.println(total + " Pass");
            success++;
        }
        else {
            System.out.println(total + " Fail: " + comment);
        }
    }

    public void notOk(Boolean testValue, String comment) {
        ok(!testValue, comment);
    }

    public void equal(Boolean valueA, Boolean valueB, String comment) {
        ok(valueA == valueB, comment);
    }

    public void equal(Object valueA, Object valueB, String comment) {
        ok(valueA.getClass() == valueB.getClass() && valueA.equals(valueB), comment);
    }

    public void end() {
        int fail = total - success;
        System.out.println("Tests complete. " + total + " total, " + success + " passed, " + fail + " failed.");
    }
}
