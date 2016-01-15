package com.bluecompute.security

import org.springframework.security.access.PermissionEvaluator
import org.springframework.security.core.Authentication
import java.io.Serializable


class CustomPermissionEvaluator extends PermissionEvaluator{

  def hasPermission(authentication: Authentication, targetDomainObject: Any, permission: Any): Boolean = {
    true
  }

  def hasPermission(authentication: Authentication, targetId: Serializable, targetType: String, permission: Any): Boolean = {
    true
  }
}
