package net.rom.exchange.browse

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.activity_browse.*
import net.rom.exchange.R
import net.rom.exchange.main.MainActivity
import net.rom.exchange.mapper.ItemExchangeMapper
import net.rom.exchange.presentation.browse.BrowseItemExchangeContract
import net.rom.exchange.presentation.model.ItemExchangeView
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BrowseFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BrowseFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class BrowseFragment : Fragment(), BrowseItemExchangeContract.View {
    // TODO: Rename and change types of parameters
    private var param1: String? = null

    @Inject
    lateinit var browseItemExchangePresenter: BrowseItemExchangeContract.Presenter

    @Inject
    lateinit var browseAdapter: BrowseAdapter

    @Inject
    lateinit var mapper: ItemExchangeMapper

    val searchBoxListener: MainActivity.SearchBoxListener = object : MainActivity.SearchBoxListener {
        override fun onSubmit(keyword: String) {
            browseItemExchangePresenter.searchKeyword(keyword)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_browse, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AndroidSupportInjection.inject(this)
        setupBrowseRecycler()
    }

    override fun onStart() {
        super.onStart()
        browseItemExchangePresenter.start()
    }

    private fun setupBrowseRecycler() {
        val linearLayoutManager = LinearLayoutManager(context)
        recycler_browse.layoutManager = linearLayoutManager
        recycler_browse.adapter = browseAdapter
        recycler_browse.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val totalItemCount = linearLayoutManager.itemCount
                val visibleItemCount = linearLayoutManager.childCount
                val lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition()

//                browseItemExchangePresenter.listScrolled(visibleItemCount, lastVisibleItem, totalItemCount)
            }
        })
    }

    override fun setPresenter(presenter: BrowseItemExchangeContract.Presenter) {
        browseItemExchangePresenter = presenter
    }

    override fun hideProgress() {
        progress.visibility = View.GONE
    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun showItemExchange(itemExchange: List<ItemExchangeView>) {
        browseAdapter.items = itemExchange.map { mapper.mapToViewModel(it) }
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment BrowseFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
                BrowseFragment().apply {
                    arguments = Bundle().apply {
                    }
                }
    }
}
