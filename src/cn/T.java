package cn;

import java.util.Scanner;

public class T {



	public static long Fib(long n) {
		long f1 = 1;
		long f2 = 1;
		long fib = 0;
		if (n == 0 || n == 1) {
			return 1;
		} else if (n >= 2) {
			for (int i = 2; i <= n; i++) {
				fib = f1 + f2;
				f1 = f2;
				f2 = fib;
			}
			return fib;
		} else
			return -1;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		in.close();
		System.out.println(Fib(n));
	}
}


