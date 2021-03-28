package com.yahoo.sdvornik

import com.yahoo.sdvornik.generated.{HelloRequestScala, WsdlClient}

import scala.concurrent.{Await, ExecutionContext}
import scala.concurrent.duration._

object AppScala extends App {

  implicit val ec: ExecutionContext = ExecutionContext.global

  val client = new WsdlClient

  val f = client.sayHello(HelloRequestScala("John Doe"))

  println(Await.result(f, 1.second))

}
