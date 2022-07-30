package com.example.heroapp.data.remote.models

import com.example.heroapp.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class HeroModel(

    @SerializedName("id")
    override val id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("duration")
    val duration: Int,

    @SerializedName("start_time")
    val startTime: Int,

    @SerializedName("radiant_name")
    val radiantName: String,

    @SerializedName("dire_name")
    val direName: String,

    @SerializedName("league_name")
    val leagueName: String,

    @SerializedName("series_type")
    val seriesType: Int,

    @SerializedName("radiant_score")
    val radiantScore: Int,

    @SerializedName("dire_score")
    val direScore: Int

) : IBaseDiffModel