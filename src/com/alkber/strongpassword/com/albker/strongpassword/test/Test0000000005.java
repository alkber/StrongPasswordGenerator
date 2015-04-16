package com.alkber.strongpassword.com.albker.strongpassword.test;


import com.alkber.strongpassword.StrongPassword;

/**
 * Verify invalid password length 46 for password generation with allowDuplicate = false
 */
public class Test0000000005 {

	public static void main(String... args) {

		try {

			StrongPassword.generate(46, false);
			System.out.println(Test0000000005.class.getCanonicalName() + ": failed");
		} catch(IllegalArgumentException e) {

			System.out.println(Test0000000005.class.getCanonicalName() + ": passed");
		}


	}

}
