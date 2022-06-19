package org.auto.zing.questions

import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.annotations.Subject
import net.serenitybdd.screenplay.questions.Visibility

class MyQuestions {
    fun isUIState(): Question<ElementAvailability> {
        return SearchPageForSomeElements()
    }
}

@Subject("Search the page.")
class SearchPageForSomeElements : Question<ElementAvailability> {
    override fun answeredBy(actor: Actor): ElementAvailability {
        return ElementAvailability.from(
            Visibility.of("").answeredBy(actor)
        )
    }

}