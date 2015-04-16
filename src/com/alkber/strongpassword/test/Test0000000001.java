package com.alkber.strongpassword.test;


import com.alkber.strongpassword.StrongPassword;

/**
 * Verify invalid password length -1 for password generation with allowDuplicate = false
 */
public class Test0000000001 {

	public static void main(String... args) {

		try {

			StrongPassword.generate(-1, false);
			System.out.println(Test0000000001.class.getCanonicalName() + ": failed");
		} catch(IllegalArgumentException e) {

			System.out.println(Test0000000001.class.getCanonicalName() + ": passed");
		}

	}

}
