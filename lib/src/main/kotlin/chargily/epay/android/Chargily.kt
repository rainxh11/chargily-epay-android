package chargily.epay.android

import kotlinx.coroutines.*
import retrofit2.*

class Chargily(apiKey: String) {
    private val API_KEY: String = apiKey;
    private val chargilyApi: ChargilyApi = ChargilyApiClient.chargilyApi;

    suspend fun createInvoice(invoice: Invoice): Response<ChargilyResponse> {
        return withContext(Dispatchers.IO) {
             chargilyApi.createInvoice(API_KEY, invoice)
        }
    }
    suspend fun createInvoiceAsync(invoice: Invoice, parentScope: CoroutineScope) = parentScope.async {
        chargilyApi.createInvoice(API_KEY, invoice)
    }

}

