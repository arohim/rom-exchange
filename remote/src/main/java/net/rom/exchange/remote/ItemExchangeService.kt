package net.rom.exchange.remote

import io.reactivex.Single
import net.rom.exchange.remote.model.rom.ItemExchangeModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ItemExchangeService {
    @GET("/api")
    fun getItems(
            @Query("item") kw: String,
            @Query("exact") exact: Boolean,
            @Query("type") type: Int,
            @Query("sort") sort: String,
            @Query("sort_dir") sortDir: String,
            @Query("range") sortRange: String,
            @Query("page") page: Int

    ): Single<List<ItemExchangeModel>>

    class ROMExchangeResponse {
        lateinit var team: List<ItemExchangeModel>
    }
}