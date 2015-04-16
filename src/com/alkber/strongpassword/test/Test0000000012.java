package com.alkber.strongpassword.test;

import com.alkber.strongpassword.StrongPassword;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Password missing a lowercase character
 */
public class Test0000000012 {

	public static void main(String... arg) {

		try {


			StrongPassword strongPasswordObject = new StrongPassword();

			Method checkPasswordQuality = StrongPassword.class.
					getDeclaredMethod("checkPasswordQuality", String.class);
			checkPasswordQuality.setAccessible(true);

			boolean returnValue = (Boolean) checkPasswordQuality.invoke(strongPasswordObject,
					"/G7I,64]0");

			if(returnValue == false) {

				System.out.println(Test0000000012.class.getCanonicalName() + ": passed");
			} else {

				System.out.println(Test0000000012.class.getCanonicalName() + ": failed");
			}

		} catch(NoSuchMethodException e) {

			System.out.println(Test0000000012.class.getCanonicalName() + ": failed");

		} catch(InvocationTargetException e) {

			System.out.println(Test0000000012.class.getCanonicalName() + ": failed");
		} catch(IllegalAccessException e) {

			System.out.println(Test0000000012.class.getCanonicalName() + ": failed");
		}
	}
}
