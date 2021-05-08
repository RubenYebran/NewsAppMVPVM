package com.example.newsappmvvm.data.model

import com.google.gson.annotations.SerializedName

class Source(
        @SerializedName("id")
        val id: String = "",
        @SerializedName("name")
        val name: String = ""
)