package com.social.app.core.domain

import io.reactivex.Completable
import io.reactivex.Single

interface Users {
    fun isAUser(name : String) : Single<Boolean>
    fun add(name: String) : Completable
}