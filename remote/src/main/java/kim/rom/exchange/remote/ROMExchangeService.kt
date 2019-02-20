package kim.rom.exchange.remote

import io.reactivex.Single
import kim.rom.exchange.remote.model.rom.ItemModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ROMExchangeService {

    @GET("/api")
    fun getItems(
            @Query("item") kw: String,
            @Query("exact") exact: Boolean,
            @Query("type") type: Int,
            @Query("sort") sort: String,
            @Query("sort_dir") sortDir: String,
            @Query("page") page: Int

    ): Single<ItemResponse>

    class ItemResponse {
        lateinit var team: List<ItemModel>
    }
}