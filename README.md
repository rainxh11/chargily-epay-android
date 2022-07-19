# chargily-epay-android
Chargily ePay Gateway Kotlin (Android SDK) with JAVA Support

![Chargily ePay Gateway](https://raw.githubusercontent.com/Chargily/epay-gateway-php/main/assets/banner-1544x500.png "Chargily ePay Gateway")

 This Package is to integrate ePayment gateway with Chargily easily.
- Currently support payment by **CIB / EDAHABIA** cards and soon by **Visa / Mastercard** 
- This repo is recently created for **Android SDK**, If you are a developer and want to collaborate to the development of this Package, you are welcomed!

# Contribution tips
1. Make a fork of this repo.
2. Take a tour to our [API documentation here](https://dev.chargily.com/docs/#/epay_integration_via_api)
3. Get your API Key/Secret from [ePay by Chargily](https://epay.chargily.com.dz) dashboard for free.
4. Start developing.
5. Finished? Push and merge.


# Example Usage
```kotlin
import chargily.epay.android.*
import kotlinx.coroutines.*

class Main {
    fun main() {
        val chargily = Chargily("[API_KEY]") // <-- API KEY
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
```