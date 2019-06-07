package com.social.app.core.domain

import io.reactivex.Completable
import io.reactivex.Single

interface Images {
    fun getAll() : Single<List<String>>
    fun add(images : List<String>) : Completable
}