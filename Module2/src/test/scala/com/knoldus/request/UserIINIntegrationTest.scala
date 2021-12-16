package com.knoldus.request

import org.scalatest.flatspec.AnyFlatSpec
import com.knoldus.db.CompanyDto
import com.knoldus.models.User
import com.knoldus.validator.{EmailVal, UserVal}

class UserIINIntegrationTest extends AnyFlatSpec {

  val companyName = new CompanyDto
  val validateEmail = new EmailVal
  val userValidator = new UserVal(companyName,validateEmail)

  val userIIN = new UserIIN(userValidator)

  "User" should "not be created as company does not exists in DB" in {
    val SadgiUser: User = User("Sadgi","Sethi",21,"Google","sadgi.sethi@gmail.com")

    val result = userIIN.cUser(SadgiUser)
    assert(result.isEmpty)
  }

  "User" should "not be created as email id is not valid" in {
    val UmarUser: User = User("Umar","Ullav",23,"Knoldus","umar.ullav@knoldus")

    val result = userIIN.cUser(UmarUser)
    assert(result.isEmpty)
  }

  "User" should "not be created as company does not exists in DB and email id is not valid" in {
    val RahulUser: User = User("Rahul","Raj",26,"Netflix","rahul.raj@netflix")

    val result = userIIN.cUser(RahulUser)
    assert(result.isEmpty)
  }

  "User" should "be created" in {
    val ShubhamUser: User = User("Shubham","Bagrodia",24,"Knoldus","shubham.bagrodia@knoldus.com")

    val result = userIIN.cUser(ShubhamUser)
    assert(!result.isEmpty)
  }
}
