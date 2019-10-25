package dummy

import scala.jdk.CollectionConverters._
import org.scalatest._
import org.slf4j.LoggerFactory
import org.kie.api._

class DummyTest extends FlatSpec with Matchers {

  "drools skeleton" should "support minimum viable knowledge base" in {
    val kServices = KieServices.Factory.get
    val kContainer = kServices.getKieClasspathContainer()
    val kbase = kContainer.getKieBase("ReleasesCheckKB")
    val ksession = kbase.newKieSession
    try {
      ksession.fireAllRules()
      val messages = ksession.getObjects().asScala.collect { case str:String => str }
      messages.toList shouldBe List("Update java to 11 or better")
    } finally {
      ksession.dispose()
    }
  }
}
