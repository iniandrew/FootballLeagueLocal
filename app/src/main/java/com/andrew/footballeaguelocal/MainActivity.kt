package com.andrew.footballeaguelocal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    private var leagueList: MutableList<LeagueItem> = mutableListOf()
    private lateinit var rvLeague: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MainActivityUI().setContentView(this)

        setupRecyclerView()
        initData()
    }

    private fun setupRecyclerView() {
        rvLeague = find(R.id.rv_league)
        rvLeague.layoutManager = GridLayoutManager(this, 2)
        rvLeague.setHasFixedSize(true)
        rvLeague.adapter = LeagueAdapter(this, leagueList)
    }

    private fun initData() {
        val dataLogo = resources.obtainTypedArray(R.array.league_image)
        val dataName = resources.getStringArray(R.array.league_name)
        val dataDescription = resources.getStringArray(R.array.league_description)

        for (i in dataName.indices) {
            leagueList.add(
                LeagueItem(
                dataLogo.getResourceId(i, 0),
                dataName[i],
                dataDescription[i]
            ))
        }
        dataLogo.recycle()
    }

    class MainActivityUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>): View  = with(ui){
            verticalLayout {
                lparams(matchParent, matchParent)

                recyclerView {
                    id = R.id.rv_league
                    lparams(matchParent, matchParent)
                }
            }
        }
    }
}
