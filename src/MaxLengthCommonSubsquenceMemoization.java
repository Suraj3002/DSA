import java.util.Arrays;
import java.util.Scanner;

public class MaxLengthCommonSubsquenceMemoization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        for(int row[]:dp)
            Arrays.fill(row , -1);

        System.out.println(memoization(n,m,s1,s2,dp));
    }

    private static int memoization(int i, int j, String s1, String s2, int[][] dp) {
        if(i==0 || j==0)
            return 0;
        if(dp[i][j]!= -1)
            return dp[i][j];
        if(s1.charAt(i-1)==s2.charAt(j-1))
            return dp[i][j] = 1+ memoization(i-1, j-1, s1, s2, dp);
        return dp[i][j] = Math.max(memoization(i-1, j, s1, s2, dp), memoization(i , j-1, s1, s2, dp));
    }
}
