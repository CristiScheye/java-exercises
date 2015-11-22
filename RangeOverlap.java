/**
 * Created by cristi on 11/22/15.
 *
 * given two ranges, determine whether they overlap
 * ranges are inclusive and in format [min, max]
 */
public class RangeOverlap {
    public static void main(String[] args){
        Test t = new Test();

        int[] rangeA = {0,5};
        int[] rangeB = {3,7};
        int[] rangeC = {5,12};
        int[] rangeD = {7,12};

        t.ok(hasOverlap(rangeA, rangeB),"returns true for overlapping ranges");
        t.ok(hasOverlap(rangeA, rangeC), "returns true for overlapping ranges when just one point overlaps");
        t.ok(hasOverlap(rangeB, rangeA), "returns true for overlapping ranges when in different order");
        t.notOk(hasOverlap(rangeD, rangeA), "returns false for non-overlapping ranges");
        t.end();
    }

    private static boolean hasOverlap(int[] rangeA, int[] rangeB) {
        int a0 = rangeA[0];
        int a1 = rangeA[1];
        int b0 = rangeB[0];
        int b1 = rangeB[1];

//        when a is on left, and a max extends into b range || when b is on left, and b max extends into a range
        return (a0 < b0 && a1 >= b0) || (b0 < a0 && b1 >= a0);
    }
}
