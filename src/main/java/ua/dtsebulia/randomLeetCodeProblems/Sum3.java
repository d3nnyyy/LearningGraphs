package ua.dtsebulia.randomLeetCodeProblems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sum3 {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        int l = nums.length;
        Set<List<Integer>> set = new LinkedHashSet<>();

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                for (int k = 0; k < l; k++) {

                    if (i != j && i != k && j != k) {
                        if ((nums[i] + nums[j] + nums[k] == 0)) {
                            set.add(Stream.of(nums[i], nums[j],nums[k]).sorted().collect(Collectors.toList()));
                        }
                    }

                }
            }
        }
        return set.stream().toList();

    }
}
