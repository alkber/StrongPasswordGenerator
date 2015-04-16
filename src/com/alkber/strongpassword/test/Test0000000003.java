package com.alkber.strongpassword.test;


import com.alkber.strongpassword.StrongPassword;

/**
 * Verify minimum valid password length 6 and allowDuplicate = false
 */
public class Test0000000003 {

	public static void main(String... args) {

		try {

			StrongPassword.generate(6, false);
			System.out.println(Test0000000003.class.getCanonicalName() + ": passed");
		} catch(IllegalArgumentException e) {

			System.out.println(Test0000000003.class.getCanonicalName() + ": failed");
		}
	}

}
