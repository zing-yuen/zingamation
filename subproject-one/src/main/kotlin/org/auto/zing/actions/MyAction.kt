package org.auto.zing.actions

import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Interaction
import net.serenitybdd.screenplay.abilities.BrowseTheWeb

open class MyAction: Interaction {

    companion object {
        fun theBrowserSession(): MyAction {
            return MyAction()
        }
    }
    override fun <T : Actor> performAs(actor: T) {
        BrowseTheWeb.`as`(actor).driver.manage().deleteAllCookies()
    }


}