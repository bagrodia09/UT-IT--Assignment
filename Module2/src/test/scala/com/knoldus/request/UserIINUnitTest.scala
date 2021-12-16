package com.knoldus.request

import org.scalatest.flatspec.AnyFlatSpec
import com.knoldus.models.User
import com.knoldus.validator.UserVal
import org.mockito.MockitoSugar.{mock, when}

class UserIINUnitTest extends AnyFlatSpec {
  val mockedUserValidator = mock[UserVal]
  val shubhamUser: User = User("Shubham","Bagrodia",24,"knoldus","shubham.bagrodia@knoldus.com")

  "User" should "be created" in {
    val userIIN = new UserIIN(mockedUserValidator)

    when(mockedUserValidator.userIsValid(shubhamUser)) thenReturn(true)
    val result = userIIN.cUser(shubhamUser)
    assert(!result.isEmpty)
  }

  "User" should "not be created" in {
    val userIIN = new UserIIN(mockedUserValidator)

    when(mockedUserValidator.userIsValid(shubhamUser)) thenReturn(false)
    val result = userIIN.cUser(shubhamUser)
    assert(result.isEmpty)
  }

}
