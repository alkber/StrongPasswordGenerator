package com.alkber.strongpassword.test;


import com.alkber.strongpassword.StrongPassword;

/**
 * Verify minimum valid password length 6 and allowDuplicateToken = true
 */
public class Test0000000008 {

	public static void main(String... args) {

		try {

			StrongPassword.generate(6, true);
			System.out.println(Test0000000008.class.getCanonicalName() + ": passed");
		} catch(IllegalArgumentException e) {

			System.out.println(Test0000000008.class.getCanonicalName() + ": failed");
		}


	}

}
