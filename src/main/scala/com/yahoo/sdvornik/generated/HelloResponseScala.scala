package com.yahoo.sdvornik.generated

import com.learnwebservices.services.hello.HelloResponse

case class HelloResponseScala(message: String)

case object HelloResponseScala {
  def apply(r: HelloResponse): HelloResponseScala = {
    HelloResponseScala(r.getMessage)
  }
}
