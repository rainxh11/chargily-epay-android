import chargily.epay.android.*
import kotlinx.coroutines.*

class Main {
    fun main() {
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
        CoroutineScope(Dispatchers.IO).launch {
            val response = chargily.createInvoice(invoice)
            val checkOutUrl = response.body()?.checkoutUrl  // Checkout Url
            println(checkOutUrl)
        }

    }
}