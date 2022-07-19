package chargily.epay.android

import kotlinx.coroutines.*
import retrofit2.Response
import kotlin.test.*

class ChargilyTest {
    @Test fun createInvoiceReturnsCheckoutUrl() {
        runBlocking() {
            val chargily = Chargily("api_KFWtdBczv0qnAMHNxGXCGVK93yEZahZwr4EgFa4xmfnLTIJkezPvW0LgqholrC7S")
            val invoice = Invoice(
                client = "Ahmed Chakhoum",
                clientEmail = "rainxh11@gmail.com",
                invoiceNumber = "10001",
                paymentMethod = PaymentMethod.EDAHABIA,
                discountPercentage = 3.toDouble(),
                amount = 5000.toDouble(),
                webhookUrl = "https://backend.com/webhook_endpoint",
                backUrl = "https://frontend.com"
            )
            val response = chargily.createInvoice(invoice)
            println(response.body()?.checkoutUrl)
            assertIs<Response<ChargilyResponse>>(response, "'createInvoice()' returns Response<ChargilyResponse>")
        }
    }
}
