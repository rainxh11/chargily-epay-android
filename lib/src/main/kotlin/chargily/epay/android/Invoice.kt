package chargily.epay.android

import com.google.gson.annotations.*
import org.valiktor.*
import org.valiktor.functions.*

data class Invoice(
        val client: String,
        @SerializedName("client_email") var clientEmail: String,
        @SerializedName("invoice_number") var invoiceNumber: String,
        @SerializedName("back_url") var backUrl: String,
        @SerializedName("webhook_url") var webhookUrl: String,
        @SerializedName("discount") var discountPercentage: Double = 0.toDouble(),
        var amount: Double,
        @SerializedName("mode") var paymentMethod: PaymentMethod
) {
    init {
        validate(this) {
            try {
                validate(Invoice::client)
                        .isNotEmpty()
                        .isNotNull()
                validate(Invoice::clientEmail)
                        .isEmail().isNotNull()
                        .isNotEmpty()
                validate(Invoice::amount)
                        .isGreaterThanOrEqualTo(75.toDouble())
                        .isNotNull()
                validate(Invoice::discountPercentage)
                        .isLessThan(100.toDouble())
                        .isGreaterThanOrEqualTo(0.toDouble())
                validate(Invoice::paymentMethod)
                        .isNotNull()
                        .isIn(PaymentMethod.CIB, PaymentMethod.EDAHABIA)
                validate(Invoice::backUrl)
                        .isNotEmpty()
                        .isNotNull()
                        .contains(Regex("[(http(s)?):\\/\\/(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)"))
                validate(Invoice::webhookUrl)
                        .isNotNull()
                        .isNotEmpty()
                        .contains(Regex("[(http(s)?):\\/\\/(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)"))
            } catch (ex: ConstraintViolationException) {
                ex.constraintViolations
                        .map { "${it.property}: ${it.constraint.name}" }
                        .forEach(::println)
            }

        }
    }
}

