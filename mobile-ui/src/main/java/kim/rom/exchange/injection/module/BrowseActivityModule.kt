package kim.rom.exchange.injection.module

import dagger.Module
import dagger.Provides
import org.buffer.android.boilerplate.domain.interactor.browse.GetBufferoos
import org.buffer.android.boilerplate.presentation.browse.BrowseBufferoosContract
import org.buffer.android.boilerplate.presentation.browse.BrowseBufferoosPresenter
import org.buffer.android.boilerplate.presentation.mapper.BufferooMapper
import kim.rom.exchange.browse.BrowseActivity
import kim.rom.exchange.injection.scopes.PerActivity



/**
 * Module used to provide dependencies at an activity-level.
 */
@Module
open class BrowseActivityModule {

    @PerActivity
    @Provides
    internal fun provideBrowseView(browseActivity: BrowseActivity): BrowseBufferoosContract.View {
        return browseActivity
    }

    @PerActivity
    @Provides
    internal fun provideBrowsePresenter(mainView: BrowseBufferoosContract.View,
                                        getBufferoos: GetBufferoos, mapper: BufferooMapper):
            BrowseBufferoosContract.Presenter {
        return BrowseBufferoosPresenter(mainView, getBufferoos, mapper)
    }

}
