package com.andrew.footballeaguelocal

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeagueItem(
    val logo: Int?,val name: String?, val description: String?
) : Parcelable