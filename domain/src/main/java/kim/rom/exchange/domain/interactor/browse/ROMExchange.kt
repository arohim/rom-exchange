package kim.rom.exchange.domain.interactor.browse

import io.reactivex.Single
import kim.rom.exchange.domain.executor.PostExecutionThread
import kim.rom.exchange.domain.executor.ThreadExecutor
import kim.rom.exchange.domain.interactor.SingleUseCase
import kim.rom.exchange.domain.model.rom.*
import kim.rom.exchange.domain.repository.ROMExchangeRepository
import javax.inject.Inject

open class ROMExchange @Inject constructor(private val romExchangeRepository: ROMExchangeRepository,
                                           threadExecutor: ThreadExecutor,
                                           postExecutionThread: PostExecutionThread) :
        SingleUseCase<List<Item>, ROMExchangeRequest>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: ROMExchangeRequest?): Single<List<Item>> {
        return romExchangeRepository.getItems(
                kw = params?.kw ?: "",
                exact = params?.exact ?: false,
                type = params?.type?.itemId ?: 0,
                sort = params?.sort?.value ?: Sort.CHANGE.value,
                sortDir = params?.sortDir?.value ?: SortDir.DESC.value,
                sortServer = params?.sortServer?.value ?: SortServer.ALL.value,
                sortRange = params?.sortRange ?: "",
                page = params?.page ?: 1
        )
    }
}