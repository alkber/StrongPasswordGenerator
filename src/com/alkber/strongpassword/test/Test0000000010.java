package com.alkber.strongpassword.test;

import com.alkber.strongpassword.StrongPassword;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Valid password with that meet all the constraints, no duplicate tokens and include
 * characters from all the scope
 */
public class Test0000000010 {

	public static void main(String... arg) {

		try {

			StrongPassword strongPasswordObject = new StrongPassword();

			Method checkPasswordQuality = StrongPassword.class.
					getDeclaredMethod("checkPasswordQuality", String.class);
			checkPasswordQuality.setAccessible(true);

			boolean returnValue = (Boolean) checkPasswordQuality.invoke(strongPasswordObject,
					"y/G7I,d6r4]0");
			if(returnValue == true) {

				System.out.println(Test0000000010.class.getCanonicalName() + ": passed");
			} else {

				System.out.println(Test0000000010.class.getCanonicalName() + ": failed");
			}

		} catch(NoSuchMethodException e) {

			System.out.println(Test0000000010.class.getCanonicalName() + ": failed");

		} catch(InvocationTargetException e) {

			System.out.println(Test0000000010.class.getCanonicalName() + ": failed");
		} catch(IllegalAccessException e) {

			System.out.println(Test0000000010.class.getCanonicalName() + ": failed");
		}
	}
}
