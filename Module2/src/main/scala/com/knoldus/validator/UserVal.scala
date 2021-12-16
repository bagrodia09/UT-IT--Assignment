package com.knoldus.validator

import com.knoldus.db.CompanyDto

import com.knoldus.models.User

class UserVal(companyName: CompanyDto, validateEmail: EmailVal) {
  def userIsValid(user: User): Boolean = {
    if (companyName.getCompanyByName(user.companyName).isDefined &&
      validateEmail.emailVal(user.emailId))
      true
    else
      false
  }


}
