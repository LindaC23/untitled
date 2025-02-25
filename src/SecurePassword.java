public class SecurePassword {
    // instance variable
    private String password;

    // constructor
    public SecurePassword(String password) {
        this.password = password;
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }


    /* Returns true if password:
       - Is at least 8 characters long
       - Contains at least one uppercase letter
       - Contains at least one lowercase letter
       - Contains at least one numeric digit
       - Contains at least one of these "special symbols":  ! @ # $ % ^ & * ?
       Must satisfy ALL FIVE categories for password to be "secure"
       Return false if any of the above security requirements are not fulfilled.
    */
    public boolean isSecure() {
        return (isLongEnough() && containsUppercase() && containsLowercase() && containsDigit() && containsSpecialSymbol());
    }



    /* Returns a String that contains information about the security status of the
       current password.

       If isSecure() is true, this method returns the string "Password is secure"
       If isSecure() is false, this methods should return a single String that informs the
       user of which security requirements are not currently being met.

       For example, the password 3WrT6tH does not meet length or special symbol
       requirements, so this method should return the following String (using a line
       break \n):

       "The password must be at least 8 characters
        The password must contain a special symbol: ! @ # $ % ^ & * ?"
    */
    public String status() {
        String requirements = "";
        if (isSecure()){
            return "Password is secure";
        } else {
            if (!isLongEnough()){
                requirements += "The password must be at least 8 characters" + "\n";
            }
            if (!containsUppercase()){
                requirements += "The password must contain at least one uppercase letter" + "\n";
            }
            if (!containsLowercase()){
                requirements += "The password must contain at least one lowercase letter" + "\n";
            }
            if (!containsDigit()){
                requirements += "The password must contain at least one numeric digit" + "\n";
            }
            if (!containsSpecialSymbol()){
                requirements += "The password must contain a special symbol: ! @ # $ % ^ & * ?" + "\n";
            }
        }
        return requirements;
    }



    // PRIVATE "HELPER" METHODS (marked "private" rather than "public" which means other
    // methods in this class can call these methods, but code outside this class cannot)

    /* Returns true if the password’s length meets the minimum requirement of 8 characters
       and false otherwise.
     */
    private boolean isLongEnough() {
        return (password.length() >= 8);
    }


    /* Returns true if the password has at least one uppercase letter and false otherwise.
     */
    private boolean containsUppercase() {
        /* this one is completed for you as a hint for how to do the others! */
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return checkString(upperCaseLetters);  // this method implemented below
    }


    /* Returns true if the password has at least one lowercase letter and false otherwise.
     */
    private boolean containsLowercase() {
        return (checkString("abcdefghijklmnopqrstuvwxyz"));
    }


    /* Returns true if the password has at least one digit and false otherwise.
     */
    private boolean containsDigit() {
        return (checkString("1234567890"));
    }


    /* Returns true if the password has at least one of these special symbols:
       ! @ # $ % ^ & * ?    and false otherwise.
     */
    private boolean containsSpecialSymbol() {
        return (checkString("!@#$%^&*?"));
    }

    /* Checks characterString to see if password contains at least one
       character from that string. Returns true if so, false otherwise.

       For example, if characterString is "ABCDEFGH" and password == "jbHFmfA"
       this method will find two occurrences (F and A) and return true, since two
       is at least one.  If characterString is "ABCDEFGH" and password == "xyz123"
       this method will return false, since password contains none of the characters in
        characterString.
     */
    private boolean checkString(String characterString) {
        for (int i = 0; i < characterString.length(); i++){
            if ((password.indexOf(characterString.substring(i, i + 1)) != -1)){
                return true;
            }
        }
        return false;

    }
}
