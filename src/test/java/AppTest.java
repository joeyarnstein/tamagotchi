//import java.util.ArrayList;

import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.fluentlenium.core.filter.FilterConstructor.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Make a pet");
  }

//SOME EXAMPLE TESTS ARE BELOW


  @Test
  public void taskIsCreatedTest(){
    goTo("http://localhost:4567/");
    fill("#tama").with("Killer");
    submit(".btn");
    assertThat(pageSource()).contains("You have a new friend.");
  }

  @Test
  public void taskIsDisplayed(){
    goTo("http://localhost:4567/");
    fill("#tama").with("Killer");
    submit(".btn");
    click("a", withText("Go Back"));
    assertThat(pageSource()).contains("Killer");
  }

  @Test
  public void multipleTaskAreDisplayed(){
    goTo("http://localhost:4567/");
    fill("#tama").with("Killer");
    submit(".btn");
    click("a", withText("Go Back"));
    fill("#tama").with("Rufus");
    submit(".btn");
    click("a", withText("Go Back"));
    assertThat(pageSource()).contains("Killer");
    assertThat(pageSource()).contains("Rufus");
  }
}
