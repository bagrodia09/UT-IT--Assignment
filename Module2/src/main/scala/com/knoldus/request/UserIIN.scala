package com.knoldus.request

import com.knoldus.models.User

import com.knoldus.validator.UserVal

class UserIIN(userVal: UserVal) {
  def cUser(user: User): Option[String] = {
    if (userVal.userIsValid(user)) Option(user.emailId)
    else None
  }
}
