package chargily.epay.android


import retrofit2.Response

class Chargily(apiKey: String) {
    private val API_KEY: String = apiKey;
    private val chargilyApi: ChargilyApi = ChargilyApiClient.chargilyApi;

    suspend fun createInvoice(invoice: Invoice): Response<ChargilyResponse> {
        return chargilyApi.createInvoice(API_KEY, invoice)
    }
}

