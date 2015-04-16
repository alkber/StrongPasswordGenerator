package com.alkber.strongpassword.test;


import com.alkber.strongpassword.StrongPassword;

/**
 * Verify invalid password length 0 for password generation with allowDuplicate = false
 */
public class Test0000000002 {

	public static void main(String... args) {

		try {
			StrongPassword.generate(0, false);
			System.out.println(Test0000000002.class.getCanonicalName() + ": failed");
		} catch(IllegalArgumentException e) {

			System.out.println(Test0000000002.class.getCanonicalName() + ": passed");
		}

	}

}
