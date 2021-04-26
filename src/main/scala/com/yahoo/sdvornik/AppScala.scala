package com.yahoo.sdvornik

import com.yahoo.sdvornik.generated.{HelloRequestScala, WsdlClient}

import scala.concurrent.{Await, ExecutionContext}
import scala.concurrent.duration._
import scala.util.{Failure, Success}

object AppScala extends App {

  implicit val ec: ExecutionContext = ExecutionContext.global

  val client = new WsdlClient

  val f = client.sayHello(HelloRequestScala("John Doe"))

  f.onComplete {
    case Success(value) => println(s"Response $value")
    case Failure(e) =>
      println("**********************************")
      e.printStackTrace()
  }

  Thread.sleep(2000)

}
