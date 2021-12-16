package com.knoldus.db

import org.scalatest.flatspec.AnyFlatSpec

class CompanyDtoTest extends AnyFlatSpec {
  "Company" should "exist" in {
    val companyDto = new CompanyDto
    val result = companyDto.getCompanyByName("Knoldus")
    assert(!result.isEmpty)
  }
  "Company" should "not exist" in {
    val companyDto = new CompanyDto
    val result = companyDto.getCompanyByName("Google")
    assert(result.isEmpty)
  }
}
