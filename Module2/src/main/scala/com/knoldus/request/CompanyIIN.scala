package com.knoldus.request

import com.knoldus.models.Company

import com.knoldus.validator.CompanyVal

class CompanyIIN (companyVal: CompanyVal){

    def cCompany(company: Company): Option[String] = {
      if (companyVal.companyIsValid(company)) Option(company.name)
      else None

    }
  }

