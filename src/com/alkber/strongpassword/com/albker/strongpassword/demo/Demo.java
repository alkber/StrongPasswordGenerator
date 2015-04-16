package com.alkber.strongpassword.com.albker.strongpassword.demo;

import com.alkber.strongpassword.StrongPassword;

/**
 * @author Althaf K Backer <althafkbacker@gmail.com>
 *         16 APR 15 8:58 AM IST
 */
public class Demo {

	public static void main(String... args) {

		System.out.println("without duplicate tokens");
		System.out.println("min length 6");
		System.out.println(StrongPassword.generate(6, false));
		System.out.println("length 12");
		System.out.println(StrongPassword.generate(12, false));
		System.out.println("max length 45");
		System.out.println(StrongPassword.generate(45, false));
		System.out.println("with duplicate tokens");
		System.out.println("min length 6");
		System.out.println(StrongPassword.generate(6, true));
		System.out.println("length 12");
		System.out.println(StrongPassword.generate(12, true));
		System.out.println("max length 45");
		System.out.println(StrongPassword.generate(45, true));
	}
}
