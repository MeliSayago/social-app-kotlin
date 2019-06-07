package com.social.app.core.actions

import com.social.app.core.domain.Users
import io.reactivex.Completable

class LoginUser (private val users: Users) {
    operator fun invoke(name : String) : Completable {

        val isAUser = users.isAUser(name).blockingGet()

        if(!isAUser){
            return Completable.error(InvalidUser())
        }
        return Completable.complete()
    }
}