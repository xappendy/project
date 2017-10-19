package pro.dp;

import java.io.*;
import java.util.*;

/**

최장증가 부분수열

6
10 20 10 30 20 50
==>
4

10 20 30 50

 */
public class 최장증가부분수열 {

	static int N;
	static int[] a;
	static int[] dp;  // 오름차순 정답
	
	static void input(Scanner sc) {
        N = sc.nextInt();
        a = new int[N + 1];
        for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}
        dp = new int[N + 1];
        System.out.println(Arrays.toString(a));
	}
	
	static void solve() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int max = a[i];    // max value  
			int maxCnt = 1;
			for (int j = i + 1; j < N; j++) {
				if (max < a[j]) {
					max = a[j];
					maxCnt++;
					System.out.println(a[i] + " " + a[j] + " " + max + " >> " + maxCnt);
				}
			}
			
			if (sum < maxCnt) {
				sum = maxCnt;
			}
		}
		
		System.out.println(sum);
	}
	
	/*
	 * 참고
	 */
	static void solve2() {
		for (int i = 1; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
				System.out.println(a[i] + " " + a[j] + " >> " + dp[i]);
			}
		}
		
		System.out.println(dp[N]);
	}
	
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("input/최장증가부분수열.txt"));
		} catch (Exception e) {
			// TODO: handle exception
		}
        Scanner sc = new Scanner(System.in);
		input(sc);
		solve();
//		solve2();
	}
}
