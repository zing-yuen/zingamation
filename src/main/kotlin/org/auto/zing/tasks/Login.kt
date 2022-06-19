package org.auto.zing.tasks

import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Task
import net.serenitybdd.screenplay.Tasks.instrumented
import net.thucydides.core.annotations.Step

open class Login : Task {
    companion object {
        @Step("Logs in {0}")
        fun withCredentials(): Login {
            return instrumented(Login::class.java)
        }
    }

    override fun <T : Actor> performAs(actor: T) {
        actor.attemptsTo()
    }
}