package kim.rom.exchange.domain.interactor.browse

import io.reactivex.Single
import kim.rom.exchange.domain.executor.PostExecutionThread
import kim.rom.exchange.domain.executor.ThreadExecutor
import kim.rom.exchange.domain.interactor.SingleUseCase
import kim.rom.exchange.domain.model.rom.Item
import kim.rom.exchange.domain.repository.ROMExchangeRepository
import javax.inject.Inject

data class ROMExchangeRequest(
        val kw: String,
        val exact: Boolean,
        val type: Int,
        val sort: String,
        val sortDir: String,
        val page: Int
)

open class ROMExchange @Inject constructor(private val romExchangeRepository: ROMExchangeRepository,
                                           threadExecutor: ThreadExecutor,
                                           postExecutionThread: PostExecutionThread) :
        SingleUseCase<List<Item>, ROMExchangeRequest>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: ROMExchangeRequest?): Single<List<Item>> {
        return romExchangeRepository.getItems(
                kw = params?.kw ?: "",
                exact = params?.exact ?: false,
                type = params?.type ?: 0,
                sort = params?.sort ?: "",
                sortDir = params?.sortDir ?: "",
                page = params?.page ?: 1
        )
    }
}