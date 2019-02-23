package net.rom.exchange.domain.interactor.browse

import io.reactivex.Single
import net.rom.exchange.domain.executor.PostExecutionThread
import net.rom.exchange.domain.executor.ThreadExecutor
import net.rom.exchange.domain.interactor.SingleUseCase
import net.rom.exchange.domain.model.Bufferoo
import net.rom.exchange.domain.repository.BufferooRepository
import javax.inject.Inject

/**
 * Use case used for retreiving a [List] of [Bufferoo] instances from the [BufferooRepository]
 */
open class GetBufferoos @Inject constructor(val bufferooRepository: BufferooRepository,
                                            threadExecutor: ThreadExecutor,
                                            postExecutionThread: PostExecutionThread) :
        SingleUseCase<List<Bufferoo>, Void?>(threadExecutor, postExecutionThread) {

    public override fun buildUseCaseObservable(params: Void?): Single<List<Bufferoo>> {
        return bufferooRepository.getBufferoos()
    }

}