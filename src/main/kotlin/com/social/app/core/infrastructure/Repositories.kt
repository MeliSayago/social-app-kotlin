package com.social.app.core.infrastructure

import com.social.app.core.infrastructure.repositories.InMemoryUsers

object Repositories {
    private val inMemoryRepository = InMemoryUsers()
}