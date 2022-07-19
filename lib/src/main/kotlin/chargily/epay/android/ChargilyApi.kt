package chargily.epay.android

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

public interface ChargilyApi {
    @Headers("Accept: application/json")
    @POST("/api/invoice")
    suspend fun createInvoice(@Header("X-Authorization") apiKey: String,
                              @Body invoice: Invoice): Response<ChargilyResponse>
}