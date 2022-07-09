package com.example.heroapp.data.remote.models

import com.example.heroapp.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class HeroModel(

    @SerializedName("id")
    override val id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("attack_type")
    var attackType: String

) : IBaseDiffModel