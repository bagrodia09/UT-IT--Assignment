package com.knoldus.validator

import org.scalatest.flatspec.AnyFlatSpec

class EmailValTest extends AnyFlatSpec {

  "email" should "be invalid as it does not contains recipient name" in {
    val emailValidator = new EmailVal
    assert(!emailValidator.emailVal("@gmail.com"))
  }

  "email" should "be invalid as it does not contains @ symbol" in {
    val emailValidator = new EmailVal
    assert(!emailValidator.emailVal("shubhambagrodia.com"))
  }

  "email" should "be invalid as it does not contains domain name" in {
    val emailValidator = new EmailVal
    assert(!emailValidator.emailVal("shubham@.com"))
  }

  "email" should "be invalid as it does not contains .(com,net,org)" in {
    val emailValidator = new EmailVal
    assert(!emailValidator.emailVal("shubham@gmail.in"))
  }

  "email" should "be valid" in {
    val emailValidator = new EmailVal
    assert(emailValidator.emailVal("shubhambagrodia@gmail.com"))
  }

}
