package com.alkber.strongpassword.test;

import com.alkber.strongpassword.StrongPassword;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Password missing uppercase character
 */
public class Test0000000011 {

	public static void main(String... arg) {

		try {


			StrongPassword strongPasswordObject = new StrongPassword();

			Method checkPasswordQuality = StrongPassword.class.
					getDeclaredMethod("checkPasswordQuality", String.class);
			checkPasswordQuality.setAccessible(true);

			boolean returnValue = (Boolean) checkPasswordQuality.invoke(strongPasswordObject,
					"y/7,d6r4]0");

			if(returnValue == false) {

				System.out.println(Test0000000011.class.getCanonicalName() + ": passed");
			} else {

				System.out.println(Test0000000011.class.getCanonicalName() + ": failed");
			}

		} catch(NoSuchMethodException e) {

			System.out.println(Test0000000011.class.getCanonicalName() + ": failed");

		} catch(InvocationTargetException e) {

			System.out.println(Test0000000011.class.getCanonicalName() + ": failed");
		} catch(IllegalAccessException e) {

			System.out.println(Test0000000011.class.getCanonicalName() + ": failed");
		}
	}
}
