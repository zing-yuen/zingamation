package org.auto.zing.questions

enum class ElementAvailability(private val isAvailable: Boolean) {
    Available(true), Unavailable(false);

    companion object {
        fun from(visibility: Boolean): ElementAvailability {
            for (elementAvailability in values()) {
                if (visibility == elementAvailability.isAvailable) {
                    return elementAvailability
                }
            }
            throw java.lang.IllegalArgumentException("Unknown value $visibility")
        }
    }
}