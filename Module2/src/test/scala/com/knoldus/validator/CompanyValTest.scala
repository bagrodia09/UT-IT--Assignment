package com.knoldus.validator

import org.scalatest.flatspec.AnyFlatSpec
import com.knoldus.db.CompanyDto
import com.knoldus.models.Company
import org.mockito.MockitoSugar.{mock, when}

class CompanyValTest extends AnyFlatSpec {

  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  val mockedCompanyReadDto: CompanyDto = mock[CompanyDto]
  val mockedEmailvalidator: EmailVal = mock[EmailVal]

  val companyVal = new CompanyVal(mockedCompanyReadDto,mockedEmailvalidator)

  "Company" should "be valid" in {

    when(mockedCompanyReadDto.getCompanyByName(knoldusCompany.name)) thenReturn None
    when(mockedEmailvalidator.emailVal(knoldusCompany.emailId)) thenReturn true

    val result = companyVal.companyIsValid(knoldusCompany)
    assert(result)
  }

  "Company" should "be invalid as it already exists in the DB" in {

    when(mockedCompanyReadDto.getCompanyByName(knoldusCompany.name)) thenReturn Option(knoldusCompany)
    when(mockedEmailvalidator.emailVal(knoldusCompany.emailId)) thenReturn true

    val result = companyVal.companyIsValid(knoldusCompany)
    assert(!result)
  }

  "Company" should "be invalid as the email id is not valid" in {

    when(mockedCompanyReadDto.getCompanyByName(knoldusCompany.name)) thenReturn None
    when(mockedEmailvalidator.emailVal(knoldusCompany.emailId)) thenReturn false

    val result = companyVal.companyIsValid(knoldusCompany)
    assert(!result)
  }

  "Company" should "be invalid as the email id is not valid and it already exists in the DB" in {

    when(mockedCompanyReadDto.getCompanyByName(knoldusCompany.name)) thenReturn Option(knoldusCompany)
    when(mockedEmailvalidator.emailVal(knoldusCompany.emailId)) thenReturn false

    val result = companyVal.companyIsValid(knoldusCompany)
    assert(!result)
  }
}
