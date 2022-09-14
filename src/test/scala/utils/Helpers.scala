package utils

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

trait Helpers {

  def createScenarioBuilder(scenarioName: String, requestName: String, path: String, pauseDuration: Int, url: String): ScenarioBuilder = {
    /**
     * generic method for creating a scenario
     */
    val scene: ScenarioBuilder = scenario(scenarioName) // creating the scenario on which simulation will happen.
      .exec(http(requestName)
        .get(url).check(status.is(200)) // status code assertion
        .check(jsonPath(path).findAll))// asserting JSON
      .pause(pauseDuration)
    scene
  }
}
