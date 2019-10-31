package com.andrew.footballeaguelocal

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    private var league: LeagueItem? = null
    private lateinit var imgLeague: ImageView
    private lateinit var tvLeagueName: TextView
    private lateinit var tvLeagueDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DetailActivityUI().setContentView(this)
        imgLeague = find(R.id.img_league)
        tvLeagueName = find(R.id.tv_league_name)
        tvLeagueDescription = find(R.id.tv_league_description)

        league = intent.getParcelableExtra("league")
        Glide.with(this).load(league?.logo).into(imgLeague)
        tvLeagueName.text = league?.name
        tvLeagueDescription.text = league?.description

        supportActionBar?.title = league?.name
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    class DetailActivityUI : AnkoComponent<DetailActivity> {
        override fun createView(ui: AnkoContext<DetailActivity>): View = with(ui){
            scrollView {
                lparams(width = matchParent, height = matchParent)

                verticalLayout {
                    lparams(width = matchParent, height = matchParent) {
                        padding = dip(16)
                    }

                    imageView {
                        id = R.id.img_league
                        contentDescription = resources.getString(R.string.image)
                    }.lparams(width = dip(150), height = dip(170)) {
                        gravity = Gravity.CENTER_HORIZONTAL
                        bottomMargin = dip(8)
                    }

                    textView {
                        id = R.id.tv_league_name
                        textSize = 24F
                        textColor = Color.BLACK
                        typeface = Typeface.DEFAULT_BOLD
                    }.lparams(width = wrapContent, height = wrapContent) {
                        gravity = Gravity.CENTER_HORIZONTAL
                        bottomMargin = dip(16)
                    }

                    textView {
                        id = R.id.tv_description
                        text = resources.getString(R.string.tv_description)
                        textSize = 20F
                        textColor = Color.BLACK
                    }.lparams(width = matchParent, height = wrapContent) {
                        bottomMargin = dip(8)
                    }

                    textView {
                        id = R.id.tv_league_description
                        textColor = Color.BLACK
                        textSize = 16F
                    }.lparams(width = matchParent, height = wrapContent)
                }
            }
        }
    }
}