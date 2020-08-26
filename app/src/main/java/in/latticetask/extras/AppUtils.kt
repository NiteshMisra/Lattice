package `in`.latticetask.extras

import java.util.regex.Pattern

class AppUtils {

    companion object {

        fun isValidPassword(password : String) : Boolean {
            val passwordPattern = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$"
            val pattern = Pattern.compile(passwordPattern)
            val matcher = pattern.matcher(password)
            return matcher.matches()
        }

    }

}