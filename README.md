# Strong Password Generator
 Generates a strong password of given password length  
 Ensuring following for the generated password
  - Password contains  
  
        -ABCDEFGHIJKLMNOPQRSTUVWXYZ 
        -abcdefghijklmnopqrstuvwxyz 
        -0123456789
        -{[(~!@#$%^&_+-/.,|>=<?:)]};
    - There is only one occurrence of the same character.
    - Upper case / lower case characters are followed by either a digit, other characters.
    - At most one occurrence of a character from the given set.
    - There are no consecutive occurrence of characters from the same set
  
        #allowDuplicate = false
            -Minimum input password length is 6
            -Maximum input password length is 45.
   
        #allowDuplicate = true 
            -Minimum input password length is 6
            -Maximum input password length is 100.
  
  Beyond 45 it is not possible ensure all the above password constraints are met. Usually, the first constraint "occurrence of same character once" fails and take too long to complete the generation
  
    Usage
        //Generate password of length 6 and no duplicate tokens
         StrongPassword.generate(6, false);
        //Generate password of lenthg 12 and allow duplicate tokens                  StrongPassword.generate(6, true);
