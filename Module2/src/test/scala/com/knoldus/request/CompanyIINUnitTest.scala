package com.knoldus.request

import org.scalatest.flatspec.AnyFlatSpec
import com.knoldus.models.Company
import com.knoldus.validator.CompanyVal
import org.mockito.MockitoSugar.{mock, when}

class CompanyIINUnitTest extends AnyFlatSpec {
  val mockedCompanyValidator: CompanyVal = mock[CompanyVal]
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  "Company" should "be created" in {
    val companyIIN = new CompanyIIN(mockedCompanyValidator)

    when(mockedCompanyValidator.companyIsValid(knoldusCompany)) thenReturn true
    val result = companyIIN.cCompany(knoldusCompany)
    assert(!result.isEmpty)
  }

  "Company" should "not be created" in {
    val companyImpl = new CompanyIIN(mockedCompanyValidator)

    when(mockedCompanyValidator.companyIsValid(knoldusCompany)) thenReturn false
    val result = companyImpl.cCompany(knoldusCompany)
    assert(result.isEmpty)
  }
}
