package com.knoldus.db

import com.knoldus.models.Company

import scala.collection.immutable.HashMap

class CompanyDto {

    val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
    val netflixCompany: Company = Company("Netflix", "netflix43@gmail.com", "Noida")
    val companies: HashMap[String, Company] = HashMap("Knoldus" -> knoldusCompany, "Netflix" -> netflixCompany)

    def getCompanyByName(name: String): Option[Company] = companies.get(name)

}
