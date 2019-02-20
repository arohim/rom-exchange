package kim.rom.exchange.injection.module

import dagger.Module
import dagger.Provides
import kim.rom.exchange.domain.interactor.browse.GetBufferoos
import kim.rom.exchange.presentation.browse.BrowseBufferoosContract
import kim.rom.exchange.presentation.browse.BrowseBufferoosPresenter
import kim.rom.exchange.presentation.mapper.BufferooMapper
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
