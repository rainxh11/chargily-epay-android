package chargily.epay.android

import com.google.gson.annotations.*

enum class PaymentMethod {
    @SerializedName("EDAHABIA") EDAHABIA,
    @SerializedName("CIB") CIB
}