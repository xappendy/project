package pro.dp;

import java.io.*;
import java.util.*;

/*

최장 공통부분 수열 (LCS, Longest Common Subsequence)

abcd
bcf
==>
2

 */
public class LCS {

	static String S, E;
	static char[] arrS;
	static char[] arrE;
	static int[][] LCS;
	
	static void input(Scanner sc) {
        S = sc.nextLine();
        E = sc.nextLine();
        arrS = new char[S.length()];
        arrS = S.toCharArray();
        arrE = new char[E.length()];
        arrE = E.toCharArray();
        LCS = new int[501][501];    
        //System.out.println(Arrays.toString(arrE));
	}
	
	static void solve() {
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 1; j <= E.length(); j++) {
				// 문자가 일치하는 경우 (1번 경우)
				if (arrS[i - 1] == arrE[j - 1]) {
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
				// 일치하지 않는 경우 (2, 3번 경우)
				} else { 
					LCS[i][j] = LCS[i - 1][j] > LCS[i][j - 1] ? LCS[i - 1][j] : LCS[i][j - 1];
				}
			}
		}
		
		System.out.println(LCS[S.length()][E.length()]);
	}
	
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("input/LCS.txt"));
		} catch (Exception e) {
			// TODO: handle exception
		}
        	Scanner sc = new Scanner(System.in);
		input(sc);
		solve();
	}
}
