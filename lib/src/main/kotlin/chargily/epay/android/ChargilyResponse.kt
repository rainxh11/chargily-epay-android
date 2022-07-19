package chargily.epay.android

import com.google.gson.annotations.SerializedName

data class ChargilyResponse(@SerializedName("checkout_url") val checkoutUrl: String)