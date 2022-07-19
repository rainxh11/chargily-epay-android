package chargily.epay.android

import com.google.gson.annotations.*

data class ChargilyResponse(@SerializedName("checkout_url") val checkoutUrl: String)