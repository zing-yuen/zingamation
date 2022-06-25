package org.auto.zing.questions

import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.questions.Text
import org.auto.zing.user_interfaces.GoogleHomePage

class GoogleSearchResult: Question<String> {

    companion object {
        fun title(): Question<String> {
            return GoogleSearchResult()
        }
    }
    override fun answeredBy(actor: Actor): String {
        return Text.of(GoogleHomePage.searchResultRightSideTitle).answeredBy(actor)
    }

}