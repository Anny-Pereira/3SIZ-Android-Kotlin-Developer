package br.com.annypereira.orbisapp.data.local

import android.content.Context

class PreferenciasManager(
    context: Context
) {

    private val preferences =
        context.getSharedPreferences(
            "orbis_preferences",
            Context.MODE_PRIVATE
        )

    companion object {
        private const val ONBOARDING_CONCLUIDO =
            "onboarding_concluido"
    }

    fun salvarOnboardingConcluido() {

        preferences.edit()
            .putBoolean(
                ONBOARDING_CONCLUIDO,
                true
            )
            .apply()

    }

    fun onboardingConcluido(): Boolean {

        return preferences.getBoolean(
            ONBOARDING_CONCLUIDO,
            false
        )

    }
}