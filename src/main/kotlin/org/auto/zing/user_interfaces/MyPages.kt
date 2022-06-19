package org.auto.zing.user_interfaces

import net.thucydides.core.pages.PageObject
import net.serenitybdd.screenplay.targets.Target

class MyPages: PageObject() {
    companion object {
        val HEADER = Target.the("header")
    }
}