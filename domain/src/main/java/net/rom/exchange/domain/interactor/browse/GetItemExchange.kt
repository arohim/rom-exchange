package net.rom.exchange.domain.interactor.browse

import io.reactivex.Single
import net.rom.exchange.domain.executor.PostExecutionThread
import net.rom.exchange.domain.executor.ThreadExecutor
import net.rom.exchange.domain.interactor.SingleUseCase
import net.rom.exchange.domain.model.rom.*
import net.rom.exchange.domain.repository.ItemExchangeRepository
import javax.inject.Inject

open class GetItemExchange @Inject constructor(private val ItemExchangeRepository: ItemExchangeRepository,
                                               threadExecutor: ThreadExecutor,
                                               postExecutionThread: PostExecutionThread) :
        SingleUseCase<List<ItemExchange>, ItemExchangeRequest>(threadExecutor, postExecutionThread) {

    public override fun buildUseCaseObservable(params: ItemExchangeRequest?): Single<List<ItemExchange>> {
        return ItemExchangeRepository.getItems(
                kw = params?.kw ?: "",
                exact = params?.exact ?: false,
                type = params?.type?.itemId ?: 0,
                sort = params?.sort?.value ?: Sort.CHANGE.value,
                sortDir = params?.sortDir?.value ?: SortDir.DESC.value,
                sortServer = params?.sortServer?.value ?: SortServer.BOTH.value,
                sortRange = params?.sortRange?.value ?: "all",
                page = params?.page ?: 1
        )
    }
}