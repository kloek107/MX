package api.mx.presentation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/")
public class test {

  @RequestMapping
  public String getHello() { return "Greetings from Spring Boot!"; }
}
