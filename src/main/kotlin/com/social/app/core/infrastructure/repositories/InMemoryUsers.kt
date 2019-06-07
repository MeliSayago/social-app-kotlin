package com.social.app.core.infrastructure.repositories

import com.social.app.core.domain.Users
import io.reactivex.Completable
import io.reactivex.Single


class InMemoryUsers : Users {

    private val users = mutableListOf<String>()

    override fun add(name: String): Completable {
        users.add(name)
        return Completable.complete() //esta bien?
    }

    override fun isAUser(name: String): Single<Boolean> {
        return Single.just(users.contains(name))
    }

}