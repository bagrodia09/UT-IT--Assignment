package com.knoldus.validator

class EmailVal {
  def emailVal(emailId: String): Boolean = {
    if ("""^([a-zA-Z\d\.-]+)@([a-zA-Z\d-]+)\.(com|net|org)$""".r.findFirstIn(emailId) == None)
      false
    else
      true
  }
}
