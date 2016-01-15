package com.bluecompute.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod}


@Controller
class HomeController {

  @RequestMapping(value = Array("/"), method = Array(RequestMethod.GET))
  def getHomePage: String = {
        return "index"
  }

}


