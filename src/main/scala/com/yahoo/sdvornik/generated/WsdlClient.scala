package com.yahoo.sdvornik.generated

import com.learnwebservices.services.hello.{HelloEndpoint, HelloEndpointService, SayHelloResponse}

import scala.concurrent.{ExecutionContext, Future, Promise}
import javax.xml.ws.{AsyncHandler, Response}

class WsdlClient(implicit val ec: ExecutionContext) {

  private val client: HelloEndpoint = new HelloEndpointService().getHelloEndpointPort

  def sayHello(r: HelloRequestScala): Future[HelloResponseScala] = {
    val p: Promise[HelloResponseScala] = Promise[HelloResponseScala]

    val asyncHandler: AsyncHandler[SayHelloResponse] = (res: Response[SayHelloResponse]) => {
      try {
        val r = res.get().getHelloResponse
        p.success(HelloResponseScala(r))
      } catch {
        case e: Throwable => p.failure(e)
      }
    }
    client.sayHelloAsync(r.toJava, asyncHandler)
    p.future
  }
}
