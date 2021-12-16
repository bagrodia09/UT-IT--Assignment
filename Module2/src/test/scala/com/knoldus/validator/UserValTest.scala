package com.knoldus.validator

import org.scalatest.flatspec.AnyFlatSpec
import com.knoldus.db.CompanyDto
import com.knoldus.models.{Company, User}
import org.mockito.MockitoSugar.{mock, when}

class UserValTest extends AnyFlatSpec {

    val shubhamUser: User = User("Shubham","Bagrodia",24,"Netflix","shubham.bagrodia@knoldus.com")
    val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

    val mockedCompanyReadDto: CompanyDto = mock[CompanyDto]
    val mockedEmailvalidator: EmailVal = mock[EmailVal]

    val userValidator = new UserVal(mockedCompanyReadDto,mockedEmailvalidator)

    "User" should "be valid" in {

      when(mockedCompanyReadDto.getCompanyByName(shubhamUser.companyName)) thenReturn Option(knoldusCompany)
      when(mockedEmailvalidator.emailVal(shubhamUser.emailId)) thenReturn true

      val result = userValidator.userIsValid(shubhamUser)
      assert(result)
    }

    "User" should "be invalid because his email is not valid" in {

      when(mockedCompanyReadDto.getCompanyByName(shubhamUser.companyName)) thenReturn Option(knoldusCompany)
      when(mockedEmailvalidator.emailVal(shubhamUser.emailId)) thenReturn false

      val result = userValidator.userIsValid(shubhamUser)
      assert(!result)
    }

    "User" should "be invalid because his company does not exists in DB" in {

      when(mockedCompanyReadDto.getCompanyByName(shubhamUser.companyName)) thenReturn None
      when(mockedEmailvalidator.emailVal(shubhamUser.emailId)) thenReturn true

      val result = userValidator.userIsValid(shubhamUser)
      assert(!result)
    }

    "User" should "be invalid because his email id is not valid and his company does not exists in DB" in {

      when(mockedCompanyReadDto.getCompanyByName(shubhamUser.companyName)) thenReturn None
      when(mockedEmailvalidator.emailVal(shubhamUser.emailId)) thenReturn false

      val result = userValidator.userIsValid(shubhamUser)
      assert(!result)
    }
}
