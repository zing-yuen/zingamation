package org.auto.zing.exceptions

import java.lang.AssertionError

class CannotAuthenticateException(actorName: String) : Exception(
    "The actor $actorName does not have the ability to sign in"
)


open class TitleIsNotVisibleException(message: String, cause: Throwable) : AssertionError(message, cause) {
    companion object {
        val RESULT_TITLE_NOT_VISIBLE = "The title is not visible at this point"
    }
}
