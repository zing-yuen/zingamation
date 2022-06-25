package org.auto.zing.user_interfaces

import net.serenitybdd.screenplay.targets.SearchableTarget
import net.serenitybdd.screenplay.targets.Target
import net.thucydides.core.annotations.DefaultUrl
import net.thucydides.core.pages.PageObject

@DefaultUrl("https://www.google.com")
open class GoogleHomePage: PageObject() {
    companion object {
        val PageSearchBar: SearchableTarget = Target.the("Search Input")
            .locatedBy("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")

        val searchResultRightSideTitle: SearchableTarget = Target.the("Search Result Title")
            .locatedBy("//body[1]/div[7]/div[1]/div[10]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/h2[1]/span[1]")
    }
}