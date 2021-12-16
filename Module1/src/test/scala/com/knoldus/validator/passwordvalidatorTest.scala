package com.knoldus.validator

import org.scalatest.flatspec.AnyFlatSpec

class passwordvalidatorTest extends AnyFlatSpec {
  "A password" should "be invalid as it contains a blank space" in {
    val pass = new passwordvalidator()
    assert(!pass.isPasswordValid("Shubham Bagrodia@10"))
  }

  "A password" should "be invalid as it does not contain a digit" in {
    val pass = new passwordvalidator()
    assert(!pass.isPasswordValid("ShubhamBagrodia@"))
  }

  "A password" should "be invalid as it contains less than 8 characters" in {
    val pass = new passwordvalidator()
    assert(!pass.isPasswordValid("Shu@10"))
  }

  "A password" should "be invalid as contains more than 15 characters" in {
    val pass = new passwordvalidator()
    assert(!pass.isPasswordValid("ShubhamBagrodia@10"))
  }

  "A password" should "be invalid as it does not contain any lower case character" in {
    val pass = new passwordvalidator()
    assert(!pass.isPasswordValid("SHUBBAG@10"))
  }

  "A password" should "be invalid as it does not contain any upper case character" in {
    val pass = new passwordvalidator()
    assert(!pass.isPasswordValid("shubbag@10"))
  }

  "A password" should "be invalid as it does not contain any special character" in {
    val pass = new passwordvalidator()
    assert(!pass.isPasswordValid("ShubBag10"))
  }

  "A password" should "be valid as it has all necessary features" in {
    val pass = new passwordvalidator()
    assert(pass.isPasswordValid("ShubBag@10"))
  }

}
