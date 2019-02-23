package net.rom.exchange.browse

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import dagger.android.AndroidInjection
import net.rom.exchange.mapper.ROMExchangeItemMapper
import net.rom.exchange.presentation.browse.BrowseROMExchangeContract
import net.rom.exchange.presentation.model.ROMExchangeItemView
import kotlinx.android.synthetic.main.activity_browse.*
import net.rom.exchange.R
import javax.inject.Inject

class BrowseActivity : AppCompatActivity(), BrowseROMExchangeContract.View {

    @Inject
    lateinit var onboardingPresenter: BrowseROMExchangeContract.Presenter

    @Inject
    lateinit var browseAdapter: BrowseAdapter

    @Inject
    lateinit var mapper: ROMExchangeItemMapper


    override fun setPresenter(presenter: BrowseROMExchangeContract.Presenter) {
        onboardingPresenter = presenter
    }

    override fun hideProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun showProgress() {
        progress.visibility = View.GONE
    }

    override fun showROMExchangeItems(romExchangeItems: List<ROMExchangeItemView>) {
        browseAdapter.items = romExchangeItems.map { mapper.mapToViewModel(it) }
        browseAdapter.notifyDataSetChanged()
        recycler_browse.visibility = View.VISIBLE
    }

    override fun hideItems() {
        recycler_browse.visibility = View.VISIBLE
    }

    override fun showErrorState() {
    }

    override fun hideErrorState() {
    }

    override fun showEmptyState() {
    }

    override fun hideEmptyState() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browse)
        AndroidInjection.inject(this)
        setupBrowseRecycler()
    }

    override fun onStart() {
        super.onStart()
        onboardingPresenter.start()
    }

    private fun setupBrowseRecycler() {
        recycler_browse.layoutManager = LinearLayoutManager(this)
        recycler_browse.adapter = browseAdapter
    }

}