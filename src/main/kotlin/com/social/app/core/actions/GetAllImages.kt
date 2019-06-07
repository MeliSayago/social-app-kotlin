package com.social.app.core.actions

import com.social.app.core.domain.Images
import io.reactivex.Single

class GetAllImages (private val images: Images) {
    operator fun invoke() : Single<List<String>> {
        return images.getAll()
    }
}