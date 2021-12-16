package com.knoldus.request

import org.scalatest.flatspec.AnyFlatSpec
import com.knoldus.db.CompanyDto
import com.knoldus.models.Company
import com.knoldus.validator.{CompanyVal, EmailVal}

class CompanyIINIntegrationTest extends AnyFlatSpec {
  val companyName = new CompanyDto
  val validateEmail = new EmailVal
  val companyValidator = new CompanyVal(companyName,validateEmail)

  "Company" should "not be created as it already exists in DB" in {
    val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

    val companyIIN = new CompanyIIN(companyValidator)
    val result = companyIIN.cCompany(knoldusCompany)
    assert(result.isEmpty)
  }

  "Company" should "not be created as email id is not valid" in {
    val googleCompany: Company = Company("Google", "google@gmail", "Gurugram")

    val companyIIN = new CompanyIIN(companyValidator)
    val result = companyIIN.cCompany(googleCompany)
    assert(result.isEmpty)
  }

  "Company" should "not be created as it already exists in DB and email id is not valid" in {
    val knoldusCompany: Company = Company("Knoldus", "knoldus@gmailcom", "Noida")

    val companyIIN = new CompanyIIN(companyValidator)
    val result = companyIIN.cCompany(knoldusCompany)
    assert(result.isEmpty)
  }

  "Company" should "be created" in {
    val googleCompany: Company = Company("Google", "google@gmail.com", "Gurugram")

    val companyIIN = new CompanyIIN(companyValidator)
    val result = companyIIN.cCompany(googleCompany)
    assert(!result.isEmpty)
  }
}
