package loblaw.ca

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import utils.Helpers

class PerformanceTest extends Simulation with Helpers {

  val baseURL: String = "https://reqres.in/api/users?page=2";

  val httpProtocol: HttpProtocolBuilder = http.baseUrl(baseURL)
  val scenarioBuilder = createScenarioBuilder("Sample api test", "IndividualRequest", "$..page", 1, baseURL)
  setUp(scenarioBuilder.inject(atOnceUsers(100)).protocols(httpProtocol))
}
