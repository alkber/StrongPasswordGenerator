package com.alkber.strongpassword.com.albker.strongpassword.test;


import com.alkber.strongpassword.StrongPassword;

/**
 * Verify maximum valid password length 45 for password generation with allowDuplicate = false
 */
public class Test0000000004 {

	public static void main(String... args) {

		try {

			StrongPassword.generate(45, false);
			System.out.println(Test0000000004.class.getCanonicalName() + ": passed");
		} catch(IllegalArgumentException e) {

			System.out.println(Test0000000004.class.getCanonicalName() + ": failed");
		}

	}

}
