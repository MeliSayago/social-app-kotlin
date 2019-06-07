package com.social.app.core.actions

import com.social.app.core.domain.Images
import io.reactivex.Completable

class AddImages(private val images : Images) {
    operator fun invoke(images : List<String>) : Completable {
        return this.images.add(images)
    }
}