package org.auto.zing.user_interfaces

import net.serenitybdd.screenplay.targets.SearchableTarget
import net.thucydides.core.pages.PageObject
import net.serenitybdd.screenplay.targets.Target
import net.thucydides.core.annotations.DefaultUrl

@DefaultUrl("http://localhost:3000")
class MyPages: PageObject() {
    companion object {
        val TITLE: SearchableTarget = Target.the("Title").locatedBy("#firstName")
    }
}