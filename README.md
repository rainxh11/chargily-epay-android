<img src="https://raw.githubusercontent.com/rainxh11/chargily-epay-android/master/assets/chargily_kotlin.svg" heigh="300">

###  Chargily ePay Gateway Kotlin (Android SDK) with JAVA Support

![Chargily ePay Gateway](https://raw.githubusercontent.com/Chargily/epay-gateway-php/main/assets/banner-1544x500.png "Chargily ePay Gateway")

 This Package is to integrate ePayment gateway with Chargily easily.
- Currently support payment by **CIB / EDAHABIA** cards and soon by **Visa / Mastercard** 
- This repo is recently created for **Android SDK**, If you are a developer and want to collaborate to the development of this Package, you are welcomed!

# Instaltation:
[![](https://jitpack.io/v/rainxh11/chargily-epay-android.svg)](https://jitpack.io/#rainxh11/chargily-epay-android)
To install add Jitpack Repository & chargily package dependency to `build.gradle.kts` gradle build file:
```kotlin
repositories {
    ...
    maven {
        url = uri("https://jitpack.io")
    }
}
dependencies {
    implementation("com.github.rainxh11:chargily-epay-android:1.0")
}
```
# Usage:
### Using coroutines:
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
### Using async/await:
```kotlin
import chargily.epay.android.*
import kotlinx.coroutines.*

class Main {
    suspend fun main() {
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

        val scope = NetworkScope()
        val response = chargily.createInvoiceAsync(invoice, scope).await()
        val checkOutUrl = response.body()?.checkoutUrl  // Checkout Url
        println(checkOutUrl)
    }
}
```
### Usage with Spring boot & dependency injection
*Soon* 
