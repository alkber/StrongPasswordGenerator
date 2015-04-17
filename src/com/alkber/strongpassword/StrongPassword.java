package com.alkber.strongpassword;

import java.util.Random;

/**
 * Generates a strong password of given password length
 * <p>
 * Ensuring following for the generated password
 * <p>
 * - Password contains
 * <p>
 * -- ABCDEFGHIJKLMNOPQRSTUVWXYZ
 * <p>
 * -- abcdefghijklmnopqrstuvwxyz
 * <p>
 * -- 0123456789
 * <p>
 * -- {[(~!@#$%^&*_+-/*.,|>=<?:)]};
 * <p>
 * - There is only one occurrence of the same character.
 * <p>
 * - Upper case / lower case characters are followed by either a digit, other characters.
 * <p>
 * - At most one occurrence of a character from the given set.
 * <p>
 * - There are no consecutive occurrence of characters from the same set
 * <p>
 * <p>
 * <code> allowDuplicate = false </code>
 * <p>
 * - Minimum input password length is 6
 * <p>
 * - Maximum input password length is 45.
 * <p>
 * <code> allowDuplicate = true </code>
 * <p>
 * - Minimum input password length is 6
 * <p>
 * - Maximum input password length is 100.
 * <p>
 * Beyond 45 it is not possible ensure all the above password constraints are met. Usually, the
 * first constraint "occurrence of same character once" fails and take too long to complete the
 * generation
 * <p>
 * Usage
 * <p>
 * Generate password of length 6 and no duplicate tokens
 * <p>
 * StrongPassword.generate(6, false);
 * <p>
 * Generate password of lenthg 12 and allow duplicate tokens
 * <p>
 * StrongPassword.generate(6, true);
 *
 * @author Althaf K Backer <althafkbacker@gmail.com>
 *         15 APR 15 12:37 PM IST
 */
public class StrongPassword {

	private final static String ABC                     = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final static String abc                     = ABC.toLowerCase();
	private final static String DIGITS                  = "0123456789";
	private final static String OTHERS                  = "{[(~!@#$%^&*_+-*/.,|>=<?:)]};";
	private final static String SCOPE_abc_DIGITS_ABC    = abc + DIGITS + ABC;
	private final static String SCOPE_ABC_OTHERS_abc    = ABC + OTHERS + abc;
	private final static String SCOPE_DIGITS_OTHERS     = DIGITS + OTHERS;
	private final static String SCOPE_FULL              = ABC + abc + OTHERS + DIGITS;
	private final static Random rd                      = new java.util.Random();
	private final static int    MIN_PASSWORD_LEN        = 6;
	private final static int    MAX_PASSWORD_LEN_NO_DUP = 45;
	private final static int    MAX_PASSWORD_LEN_DUP    = 100;
	// SCOPE_CURRENT and SCOPE_CURRENT_LEN is altered by <code> setNextScope(...) </code>
	private              String SCOPE_CURRENT           = SCOPE_FULL;
	private              int    SCOPE_CURRENT_LEN       = SCOPE_CURRENT.length();

	/**
	 * Generates a strong password of given password lenght
	 * <p>
	 * Routine ensure following for the generated password
	 * <p>
	 * - Password contains
	 * <p>
	 * -- ABCDEFGHIJKLMNOPQRSTUVWXYZ
	 * <p>
	 * -- abcdefghijklmnopqrstuvwxyz
	 * <p>
	 * -- 0123456789
	 * <p>
	 * -- {[(~!@#$%^&*_+-/*.,|>=<?:)]};
	 * <p>
	 * - There is only one occurrence of the same character.
	 * <p>
	 * - Upper case / lower case characters are followed by either a digit, other characters.
	 * <p>
	 * - At most one occurrence of a character from the given set.
	 * <p>
	 * - There are no consicutive occurance of characters from the same set.
	 * <p>
	 * Don't bother to optimize the speed of this routine while compromising strong password
	 * policy.Since this is not a frequently called routine, speed optimizations hardly matters.
	 * However feel free to optimize, if password passes the quality check.
	 *
	 * @param passwordLength required password string length
	 * @return password
	 * generated password
	 * @throws IllegalArgumentException if password doesn't meet minimum password length
	 */
	public static String generate(int passwordLength, boolean allowDuplicateToken) throws
			IllegalArgumentException {

		// we are creating this temporary object as <code> SCOPE_CURRENT </code> and
		// <code> SCOPE_CURRENT_LEN </code> should be individual state of an object.
		// we still have the comfort to invoke this method,
		// </code> StrongPassword.generate(...) </code>
		StrongPassword currentSession = new StrongPassword();
		if(passwordLength < MIN_PASSWORD_LEN) {

			throw new IllegalArgumentException("minimum password length is 6");
		}

		if(!allowDuplicateToken && (passwordLength > MAX_PASSWORD_LEN_NO_DUP)) {

			throw new IllegalArgumentException("max password length when allowDuplicateToken = " +
					"false is " + MAX_PASSWORD_LEN_NO_DUP);
		}

		if(allowDuplicateToken && (passwordLength > MAX_PASSWORD_LEN_DUP)) {

			throw new IllegalArgumentException("max password length when allowDuplicateToken = " +
					"true is " + MAX_PASSWORD_LEN_DUP);
		}

		// initial scope of password characters
		currentSession.SCOPE_CURRENT = SCOPE_FULL;
		currentSession.SCOPE_CURRENT_LEN = currentSession.SCOPE_CURRENT.length();
		StringBuilder password           = new StringBuilder("");
		boolean       qualityCheckFailed = true;

		do {
			// reset the password as QA failed
			password = new StringBuilder("");

			for(int i = 0;i < passwordLength;i++) {

				char token;
				if(allowDuplicateToken) {

					token = currentSession.SCOPE_CURRENT.charAt(rd.nextInt(currentSession
							.SCOPE_CURRENT_LEN));
				} else {

					token = currentSession.getNextToken(password.toString());
				}
				password = password.append(token);
				currentSession.setNextScope(token);
			}

			qualityCheckFailed = !currentSession.checkPasswordQuality(password.toString());

		} while(qualityCheckFailed);

		return password.toString();
	}

	/**
	 * Responsible for ensuring that, a particular character from <code> SCOPE_CURRENT
	 * </code> doesn't reappear twice in the partial password.
	 *
	 * @param partialPassword partial password till the time of call
	 * @return next non repeated token
	 */
	private char getNextToken(String partialPassword) {

		char token = SCOPE_CURRENT.charAt(rd.nextInt(SCOPE_CURRENT_LEN));
		//check to see if current token already exist in previous partial password, if so
		//find another one till we get a unique one
		while(-1 != partialPassword.indexOf(token)) {

			token = SCOPE_CURRENT.charAt(rd.nextInt(SCOPE_CURRENT_LEN));
		}
		return token;
	}

	/**
	 * Set the next scope of character set based on current token, this ensure that next token
	 * generated by <code> getNextToken() </code> will not in the same character set as
	 * the previous token.This will help prevent, occurrence of a dictionary word by chance.
	 * All in all, this will ensure that all the scope of characters are covered.
	 * <p>
	 * Changes following class members
	 * -SCOPE_CURRENT
	 * -SCOPE_CURRENT_LEN
	 *
	 * @param token current token is used to understand the current scope and choose a new scope
	 */
	private void setNextScope(char token) {

		if(-1 != ABC.indexOf(token) || -1 != abc.indexOf(token)) {

			SCOPE_CURRENT = SCOPE_DIGITS_OTHERS;
		} else if(-1 != DIGITS.indexOf(token)) {

			SCOPE_CURRENT = SCOPE_ABC_OTHERS_abc;
		} else if(-1 != OTHERS.indexOf(token)) {

			SCOPE_CURRENT = SCOPE_abc_DIGITS_ABC;
		}
		SCOPE_CURRENT_LEN = SCOPE_CURRENT.length();
	}

	/**
	 * Quality check ensure that, we have character set from all the SCOPE covered.
	 *
	 * @param password newly generated password
	 * @return <code> true </code> if password cover all the scope
	 * <code> false </code> if password doesn't cover all the scope
	 */
	private boolean checkPasswordQuality(String password) {

		return password.matches(".*[0-9].*") &&
				password.matches(".*[A-Z].*") &&
				password.matches(".*[a-z].*") &&
				password.matches(".*[{\\[(~!@#$%^&*_+\\-*/.,|>=<?:)\\]};].*");
	}
}
