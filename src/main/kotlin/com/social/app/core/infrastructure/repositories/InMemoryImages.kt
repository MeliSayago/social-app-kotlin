package com.social.app.core.infrastructure.repositories

import com.social.app.core.domain.Images
import io.reactivex.Completable
import io.reactivex.Single

class InMemoryImages : Images{

    val images = mutableListOf<String>()

    override fun getAll(): Single<List<String>> {
        return Single.just(images)
    }

    override fun add(images: List<String>): Completable {
        this.images.addAll(images)

        return Completable.complete()
    }

}