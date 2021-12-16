package com.knoldus.request

import com.knoldus.models.Employee

import com.knoldus.validator.EmployeeVal

class EmployeeIIN(employeeVal: EmployeeVal) {
  def cEmployee(employee: Employee): Option[String] = {
    if (employeeVal.employeeIsValid(employee)) Option(employee.emailId)
    else None
  }
}
