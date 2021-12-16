package com.knoldus.validator

import com.knoldus.db.CompanyDto

import com.knoldus.models.Company

class CompanyVal(compamyName: CompanyDto, validateEmail: EmailVal) {

  def companyIsValid(company: Company): Boolean = {
    if (compamyName.getCompanyByName(company.name).isEmpty &&
      validateEmail.emailVal(company.emailId))
      true
    else
      false
  }
}
