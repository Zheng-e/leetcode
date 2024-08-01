class Solution {
    public boolean isMatch(String s, String p) {
		int m = s.length(), n = p.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		char[] c1 = s.toCharArray(), c2 = p.toCharArray();
		dp[0][0] = true;
		for (int i = 2; i <= n; i++) {
			if (c2[i - 1] == '*')
				dp[0][i] = dp[0][i - 2];
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (c1[i - 1] == c2[j - 1] || c2[j - 1] == '.')
					dp[i][j] = dp[i - 1][j - 1];
				else if (c2[j - 1] == '*') {
					dp[i][j] = dp[i][j - 2] || dp[i - 1][j] && c1[i - 1] == c2[j - 2]
							|| dp[i - 1][j] && c2[j - 2] == '.';
				}
			}
		}
		return dp[m][n];
	}
}