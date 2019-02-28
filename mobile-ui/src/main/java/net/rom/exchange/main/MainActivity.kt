package net.rom.exchange.main

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import net.rom.exchange.R
import net.rom.exchange.browse.BrowseFragment

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var searchBoxListener: SearchBoxListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        search?.setOnEditorActionListener { v, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                searchBoxListener?.onSubmit(v?.text.toString())
            }
            true
        }

        displayFragment(PAGE.ITEM)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // TODO: we will have favourite feature soon.
//        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_favorite -> {
                displayFragment(PAGE.FAVOURITE)
            }
            else -> {
                displayFragment(PAGE.ITEM, item.title.toString())
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun displayFragment(page: PAGE, itemTitle: String? = null) {
        var fragment: Fragment? = null
        when (page) {
            PAGE.FAVOURITE -> {
                // Handle the camera action
                Toast.makeText(this, "Favourite feature coming soon!!", Toast.LENGTH_LONG).show()
            }
            else -> {
                fragment = BrowseFragment.newInstance(itemTitle)
                searchBoxListener = fragment.searchBoxListener
            }
        }

        fragment?.also {
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.content_main, it)
            ft.commit()
        }
    }

    enum class PAGE {
        ITEM,
        FAVOURITE
    }

    interface SearchBoxListener {
        fun onSubmit(keyword: String)
    }
}
