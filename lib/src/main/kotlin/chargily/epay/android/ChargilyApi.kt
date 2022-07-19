package chargily.epay.android

import retrofit2.*
import retrofit2.http.*

public interface ChargilyApi {
    @Headers("Accept: application/json")
    @POST("/api/invoice")
    suspend fun createInvoice(@Header("X-Authorization") apiKey: String,
                              @Body invoice: Invoice): Response<ChargilyResponse>
}