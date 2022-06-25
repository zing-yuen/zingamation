package org.auto.zing

import com.google.common.collect.ImmutableList
import net.serenitybdd.junit.runners.SerenityRunner
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.GivenWhenThen.*
import net.serenitybdd.screenplay.abilities.BrowseTheWeb
import net.serenitybdd.screenplay.ensure.that
import net.serenitybdd.screenplay.ensure.web.ElementLocated
import net.serenitybdd.screenplay.ensure.web.NamedExpectation
import net.serenitybdd.screenplay.targets.Target.the
import net.thucydides.core.annotations.Managed
import net.thucydides.core.annotations.WithTag
import org.auto.zing.exceptions.TitleIsNotVisibleException
import org.auto.zing.exceptions.TitleIsNotVisibleException.Companion.RESULT_TITLE_NOT_VISIBLE
import org.auto.zing.questions.GoogleSearchResult
import org.auto.zing.tasks.Navigate
import org.auto.zing.user_interfaces.GoogleHomePage
import org.hamcrest.Matchers.hasToString
import org.joda.time.ReadableDateTime
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.openqa.selenium.WebDriver
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime

@RunWith(SerenityRunner::class)
class MyTest {
    private val user1 = Actor.named("user 1")

    @Managed
    lateinit var hisBrowser: WebDriver

    @Before
    fun setStage() {
        user1.can(BrowseTheWeb.with(hisBrowser))
    }

    @Test
    @WithTag("release:sprint-1")
    fun sprint1Test01() {
        println("running sprint 1 test 01")
    }

    @Test
    @WithTag("release:sprint-1")
    fun sprint1Test02() {
        println("running sprint 1 test 02")
    }

    @Test
    @WithTag("release:sprint-2")
    fun sprint2Test01() {
        println("running sprint 2 test 01")
    }

    @Test
    @WithTag("release:sprint-2")
    fun sprint2Test02() {
        println("running sprint 2 test 02")
    }

    @Test
    fun sampleTest() {
        givenThat(user1).wasAbleTo(Navigate.to(GoogleHomePage.PageSearchBar))

        then(user1).attemptsTo(
            that(GoogleHomePage.searchResultRightSideTitle).hasText("Data lake")
        )

        then(user1).should(
            seeThat(
                GoogleSearchResult.title(),
                hasToString("Data lake")
            ).orComplainWith(
                TitleIsNotVisibleException::class.java, RESULT_TITLE_NOT_VISIBLE
            )
        )
    }

    fun process(dateTime: ReadableDateTime) {
        println(dateTime.toDateTime())
    }

    @Test
    fun testWithDatesAndTime() {

        // from joda.time
//        val timezoneProvider = DateTimeZone.getProvider()
//        println(timezoneProvider.availableIDs)

        val tenInTheMorning = LocalTime.of(10, 0)
        val twoInTheAfternoon = LocalTime.of(14, 0)
        val firstOfJanuary = LocalDate.of(2022, 1, 1)
        user1.attemptsTo(
            that(tenInTheMorning).isBefore(twoInTheAfternoon),
            that(firstOfJanuary).isDayOfWeek(DayOfWeek.SATURDAY)
        )
    }

    @Test
    fun testWithCollections() {
        val colors = listOf("red", "green", "blue")
        val sameColors = listOf("red", "green", "blue")
        val differentColors = listOf("red", "green", "cyan")
        val allColors = listOf("red", "green", "blue", "yellow", "cyan")
        val lastColors = listOf("yellow", "cyan")
        val noColors = emptyList<String>()

        user1.attemptsTo(
            that("red").isIn(colors),
            that(colors).isEqualTo(sameColors),
            that(noColors).isEmpty(),
            that(colors).hasSize(3),
            that(colors).hasSizeGreaterThan(2),
            that(colors).hasSizeLessThan(4),
            that(colors).hasSizeBetween(2, 4),
            that(colors).containsOnlyElementsFrom(allColors),
            that(colors).containsAnyElementsOf(differentColors),
            that(colors).not().containsAnyElementsOf(lastColors),
            that(colors).isASubsetOf(allColors),
            that(colors).doesNotHaveDuplicates(),
            that(allColors).endsWithElementsFrom(lastColors)
        )

        // matching list elements
        val primaryColors = ImmutableList.of("blue", "cyan", "pink")
        val nonPrimaryColors = ImmutableList.of("orange", "cyan", "pink")
        val mixedColors = ImmutableList.of("blue", "cyan", "red", "pink")
        user1.attemptsTo(
            that(primaryColors).allMatch("4 characters long"){
                it.length == 4
            },
            that(primaryColors).anyMatch("is a primary color") {
                isAPrimaryColor(it)
            },
            that(nonPrimaryColors).noneMatch("is a primary color") {
                isAPrimaryColor(it)
            },
            that(mixedColors).atLeast(2, "is a primary color") {
                isAPrimaryColor(it)
            },
            // using named expectation
            that(mixedColors).anyMatch(isAPrimaryColor)
        )
    }

    // target for demo purposes, does not work
    @Test
    fun testWithWebElements() {
        val FIRST_NAME = the("First name field").locatedBy("#firstName")

        user1.attemptsTo(
            that(FIRST_NAME).value().isEqualTo("Joe"),
            that(ElementLocated.by("#firstName")).isDisabled(),
            that(ElementLocated.by("#firstName")).isEnabled(),
            that(ElementLocated.by("#firstName")).isDisabled()
        )

        // checking text content and field values
        val SEARCH_RESULTS_SUMMARY = the("Search Results Summary").locatedBy("searchResultHeader")
        user1.attemptsTo(
            that(SEARCH_RESULTS_SUMMARY)
                .text() // text of the element
                .endsWith("Lake"),
            that(SEARCH_RESULTS_SUMMARY)
                .textContent() // CSS attribute
                .isNotEmpty(),
            that(SEARCH_RESULTS_SUMMARY)
                .selectedValue()
                .isEqualTo("")
        )
    }

    private fun isAPrimaryColor(color: String): Boolean {
        return color == "red" || color == "green" || color == "blue"
    }

    private val isAPrimaryColor = NamedExpectation<String>("is a primary color"){
        it == "red" || it == "green" || it == "blue"
    }
}