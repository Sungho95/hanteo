package com.hanteo.problem2;

public class Solution {
    public static void main(String[] args) {
        Solution ex = new Solution();
        // dp 사용
        System.out.println(ex.solution1(4, new int[]{1, 2, 3}));
        System.out.println(ex.solution1(10, new int[]{2, 5, 3, 6}));

        // 재귀 사용
        System.out.println(ex.solution2(4, new int[]{1, 2, 3}));
        System.out.println(ex.solution2(10, new int[]{2, 5, 3, 6}));
    }

    /**
     * 동적 계획법(DP) 활용
     */
    public int solution1(int sum, int[] coins) {
        // 인덱스에 해당하는 수를 구할 수 있는 경우의 수를 담을 dp 배열
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        // 동전 순회
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= sum; j++) {
                // dp[j]를 만들 수 있는 경우의 수에 추가
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[sum];
    }

    /**
     * 재귀 활용
     */
    public int solution2(int sum, int[] coins) {
        return recursion(coins.length, sum, coins);

    }

    private int recursion(int i, int sum, int[] coins) {
        // sum 만들 수 있는 경우
        if (sum == 0) {
            return 1;
        }

        // sum을 만들 수 없는 경우
        if (sum < 0 || (i <= 0 && sum > 0)) {
            return 0;
        }

        // 재귀 호출
        return recursion(i - 1, sum, coins) + recursion(i, sum - coins[i - 1], coins);
    }
}
