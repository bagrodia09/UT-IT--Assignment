package com.knoldus.numbertest

class palindromeandfactorial extends PalindromeAndFactorialTrait {

  def isPalindrome(Num: Int): Boolean = {
    var sum: Int = 0
    var remainder: Int = 0
    var temp: Int = Num

    while (temp > 0) {
      remainder = temp % 10
      sum = (sum * 10) + remainder
      temp = temp / 10
    }
    if (Num == sum)
      true
    else
      false
  }

  def isFactorial(Num: Int): Int = {
    var res: Int = 1
    for (i <-2 to Num){
      res *= i
    }
    res
  }

}