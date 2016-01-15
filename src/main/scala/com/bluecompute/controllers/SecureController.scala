package com.bluecompute.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMethod, RequestMapping}
import scala.Array
import org.springframework.security.access.prepost.PreAuthorize


@Controller
@RequestMapping(value = Array("/secure"))
class SecureController {

  @PreAuthorize("hasRole('ROLE_USER')")
  @RequestMapping(value = Array("/home"), method = Array(RequestMethod.GET))
  def getSecurePage: String = {
    return "secure"
  }

}
