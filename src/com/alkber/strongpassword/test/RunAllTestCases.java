package com.alkber.strongpassword.test;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.InvalidParameterException;

/**
 * @author Althaf K Backer <althafkbacker@gmail.com>
 *         16 APR 15 8:58 AM IST
 */
public class RunAllTestCases {

	public static void main(String... args) {

		String testPackage = "com.alkber.strongpassword.test.";

		int totalTestCases = 15;

		for(int i = 1;i <= totalTestCases;i++) {
			try {

				Class<?> current = Class.forName(testPackage + nextTestCase(i));
				Method main = current.getMethod("main", String[].class);
				main.invoke(null, (Object) new String[1]);
			} catch(ClassNotFoundException e) {
				System.out.println(" [x] " + e.toString());
			} catch(NoSuchMethodException e) {
				e.printStackTrace();
			} catch(IllegalAccessException e) {
				e.printStackTrace();
			} catch(InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}

	private static String nextTestCase(long number) throws InvalidParameterException {

		String TestCaseClass = "Test0000000000";
		int    adjustmentLen = String.valueOf(number).length();
		if(adjustmentLen > 10) {
			throw new InvalidParameterException("can't handle number that has more than 10 " +
					"digits");
		}
		String t = TestCaseClass.substring(0, TestCaseClass.length() - adjustmentLen);
		return t + number;
	}


}
