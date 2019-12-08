package icu.random.controller.web;

import static icu.random.api.WebControllerPaths.WEB_INDEX_PATH;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

  @RequestMapping(WEB_INDEX_PATH)
  public String index() {
    return "index";
  }
}
