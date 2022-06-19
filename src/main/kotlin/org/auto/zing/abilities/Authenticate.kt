package org.auto.zing.abilities

import net.serenitybdd.screenplay.Ability
import net.serenitybdd.screenplay.Actor
import org.auto.zing.exceptions.CannotAuthenticateException

open class Authenticate(
    val username: String,
    val password: String
): Ability {
    companion object {
        fun with(username: String, password: String): Authenticate {
            return Authenticate(username, password)
        }

        fun `as`(actor: Actor): Authenticate {
            if (actor.abilityTo(Authenticate::class.java) == null) {
                throw CannotAuthenticateException(actor.name)
            }
            return actor.abilityTo(Authenticate::class.java)
        }
    }
}