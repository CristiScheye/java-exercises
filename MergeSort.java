import java.util.*;


/**
 * Created by cristi on 10/24/15.
 *
 * implement merge sort for array of integers
 */
public class MergeSort {
    public static void main(String[] args) {
        Test t = new Test();

        List<Integer> nums = generateRandomNums();
        List<Integer> mergeSortedNums = mergeSort(nums);

        Collections.sort(nums);

        t.notOk(nums == mergeSortedNums, "array sorted by internal method is not pointing to same list in memory");
        t.equal(mergeSortedNums, nums, "sorts array of integers");
        t.end();
    }

    private static List<Integer> generateRandomNums() {
        Random randoGenerator = new Random();
        List<Integer> randos = new ArrayList<Integer>(15);

        for (int i = 0; i < 15; i++) {
            randos.add(randoGenerator.nextInt());
        }

        return randos;
    }

    private static List<Integer> mergeSort(List<Integer> nums) {
        List<Integer> numsCopy;
        List<Integer> firstHalf;
        List<Integer> secondHalf;
        int numsSize = nums.size();

        if (nums.size() <= 1) {
            return nums;
        }
        else {
            numsCopy = new ArrayList<Integer>(nums);
            firstHalf = numsCopy.subList(0, numsSize / 2);
            secondHalf = numsCopy.subList(numsSize / 2, numsSize);

            return merge(mergeSort(firstHalf), mergeSort(secondHalf));
        }
    }

    private static List<Integer> merge(List<Integer> first, List<Integer> second) {
        int i = 0;
        int j = 0;
        List<Integer> merged = new ArrayList<Integer>();

        while (i < first.size() && j < second.size()) {
            if (first.get(i) <= second.get(j)) {
                merged.add(first.get(i));
                i++;
            }
            else {
                merged.add(second.get(j));
                j++;
            }
        }

        merged.addAll(first.subList(i, first.size()));
        merged.addAll(second.subList(j, second.size()));

        return merged;
    }
}
