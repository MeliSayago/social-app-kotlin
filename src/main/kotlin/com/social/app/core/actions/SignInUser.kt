package com.social.app.core.actions

import com.social.app.core.domain.Users
import io.reactivex.Completable

class SignInUser (private val users: Users){

    operator fun invoke(name: String) : Completable {
        if(name == ""){
            return Completable.error(EmptyUsername())
        }

        return users.add(name)
    }
}