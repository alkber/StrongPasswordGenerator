package com.alkber.strongpassword.com.albker.strongpassword.test;


import com.alkber.strongpassword.StrongPassword;

/**
 * Verify invalid password length 101 for password generation with allowDuplicate = true
 */
public class Test0000000006 {

	public static void main(String... args) {

		try {

			StrongPassword.generate(101, true);
			System.out.println(Test0000000006.class.getCanonicalName() + ": failed");
		} catch(IllegalArgumentException e) {

			System.out.println(Test0000000006.class.getCanonicalName() + ": passed");
		}


	}

}
