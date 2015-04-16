package com.alkber.strongpassword.com.albker.strongpassword.test;


import com.alkber.strongpassword.StrongPassword;

/**
 * Verify invalid password length -1, allowDuplicateToken = true
 */
public class Test0000000007 {

	public static void main(String... args) {

		try {

			StrongPassword.generate(-1, true);
			System.out.println(Test0000000007.class.getCanonicalName() + ": failed");
		} catch(IllegalArgumentException e) {

			System.out.println(Test0000000007.class.getCanonicalName() + ": passed");
		}


	}

}
