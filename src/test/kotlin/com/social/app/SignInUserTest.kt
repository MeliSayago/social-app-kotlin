package com.social.app

import com.social.app.core.actions.EmptyUsername
import com.social.app.core.actions.SignInUser
import com.social.app.core.infrastructure.repositories.InMemoryUsers
import io.reactivex.Completable
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

object SignInUserTest : Spek ({
    Feature("Sign in user in social network"){
        Scenario("Register person in first time without name"){
            lateinit var name : String
            lateinit var result : Completable
            lateinit var signInUser: SignInUser
            Given("a sign in user action with an empty name"){
                val users = InMemoryUsers()
                name = ""
                signInUser = SignInUser(users)
            }
            When("sign in the empty name"){
                result = signInUser(name)
            }
            Then("return an error"){
                result.test().assertError(EmptyUsername::class.java)
            }
        }
        Scenario("Register person in first time"){
            lateinit var name : String
            lateinit var result : Completable
            lateinit var signInUser: SignInUser
            Given("a sign in action and an username"){
                val users = InMemoryUsers()
                name = "@meli"
                signInUser = SignInUser(users)
            }
            When("sign in the username"){
                result = signInUser(name)
            }
            Then("sign in successful"){

                result.test().assertNoErrors()
            }
        }
    }
})