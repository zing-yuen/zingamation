package org.auto.zing.abilities

import net.serenitybdd.screenplay.Ability
import net.serenitybdd.screenplay.Actor

open class MyAbility() : Ability {

    companion object {
        fun with(): MyAbility {
            return MyAbility()
        }

        fun `as`(actor: Actor): MyAbility {
            return actor.abilityTo(MyAbility::class.java)
        }

    }
}