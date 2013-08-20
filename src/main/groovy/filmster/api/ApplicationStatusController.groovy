package filmster.api

import filmster.types.View
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class ApplicationStatusController {

  @RequestMapping(value = "/admin/status")
  String status(Model model) {
    model.title = "Filmster Core Status"

    return View.STATUS_SHOW.viewName
  }

  @RequestMapping(value = "/admin/status", method = RequestMethod.GET, consumes="application/json", produces="application/json")
  @ResponseBody
  Map<String, Object> statusJson() {
    return [status: 'OK  ']
  }
}
