package com.alkber.strongpassword.com.albker.strongpassword.test;


import com.alkber.strongpassword.StrongPassword;

/**
 * Verify maximum valid password length 100, allowDuplicateToken = true
 */
public class Test0000000009 {

	public static void main(String... args) {

		try {

			StrongPassword.generate(100, true);
			System.out.println(Test0000000009.class.getCanonicalName() + ": passed");
		} catch(IllegalArgumentException e) {

			System.out.println(Test0000000009.class.getCanonicalName() + ": failed");
		}


	}

}
