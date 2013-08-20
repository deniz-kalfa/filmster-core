package filmster.api

import filmster.types.View
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

import javax.servlet.http.HttpServletRequest

@Controller
class HomepageController {
  @RequestMapping(value = "/")
  String status(HttpServletRequest request, Model model) {
    model.title = "Filmster Core"

    return View.HOMEPAGE.viewName
  }
}
