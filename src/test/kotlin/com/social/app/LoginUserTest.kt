package com.social.app

import com.social.app.core.actions.InvalidUser
import com.social.app.core.actions.LoginUser
import com.social.app.core.actions.SignInUser
import com.social.app.core.infrastructure.repositories.InMemoryUsers
import io.reactivex.Completable
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

object LoginUserTest : Spek({
    Feature("Login a user"){
        Scenario("Login a not registered user"){
            lateinit var result : Completable
            lateinit var login : LoginUser
            lateinit var name : String
            Given("login user action"){
                val users = InMemoryUsers()
                name = "@juancito"
                login = LoginUser(users)
            }
            When("login the invalid username"){
                result = login(name)
            }
            Then("returns an error"){
                result.test().assertError(InvalidUser::class.java)
            }
        }
        Scenario("Login a valid user"){
            lateinit var result : Completable
            lateinit var login : LoginUser
            lateinit var name : String
            lateinit var signInUser: SignInUser
            Given("a registered user and login user action"){
                val users = InMemoryUsers()
                name = "@juancito"
                signInUser = SignInUser(users)
                signInUser(name)
                login = LoginUser(users)
            }
            When("login the valid username"){
                result = login(name)
            }
            Then("returns an sucesfull"){
                result.test().assertNoErrors()
            }
        }
    }
})