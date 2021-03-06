package org.jmotor.metral.utils

import scala.util.{ Failure, Success, Try }

/**
 * Component:
 * Description:
 * Date: 2018/11/20
 *
 * @author AI
 */
object Retryable {

  def retry[T](execution: () ⇒ T)(attempts: Int): T = {
    Try(execution()) match {
      case Success(r)                 ⇒ r
      case Failure(_) if attempts > 0 ⇒ retry(execution)(attempts - 1)
      case Failure(t)                 ⇒ throw t
    }
  }

}
