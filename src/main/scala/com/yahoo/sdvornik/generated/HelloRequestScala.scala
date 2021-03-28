package com.yahoo.sdvornik.generated

import com.learnwebservices.services.hello.HelloRequest

case class HelloRequestScala(name: String) {
  def toJava: HelloRequest = {
    val r = new HelloRequest
    r.setName(name)
    r
  }
}

