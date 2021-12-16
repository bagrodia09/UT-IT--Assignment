package com.knoldus.validator

class passwordvalidator {

    def isPasswordValid(password: String): Boolean = {
      val regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.\\S)(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$"
      if (password.matches(regex) && !password.contains(" "))
        true
      else
        false

    }

}
