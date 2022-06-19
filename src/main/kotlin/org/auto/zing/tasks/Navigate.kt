package org.auto.zing.tasks

import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Task
import net.serenitybdd.screenplay.Tasks.instrumented
import net.serenitybdd.screenplay.actions.Enter
import net.serenitybdd.screenplay.actions.Open
import net.serenitybdd.screenplay.targets.SearchableTarget
import org.auto.zing.user_interfaces.GoogleHomePage
import org.openqa.selenium.Keys

open class Navigate(
    private val target: SearchableTarget
): Task {

    val googleHomePage = GoogleHomePage()

    companion object {
        fun to(target: SearchableTarget): Navigate {
            return instrumented(Navigate::class.java, target)
        }
    }
    override fun <T : Actor> performAs(actor: T) {
        actor.attemptsTo(
            Open.browserOn(googleHomePage),
            Enter.theValue("data lake").into(target).thenHit(Keys.ENTER)
        )
    }
}