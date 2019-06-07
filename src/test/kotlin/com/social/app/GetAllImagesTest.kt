package com.social.app

import com.social.app.core.actions.AddImages
import com.social.app.core.actions.GetAllImages
import com.social.app.core.infrastructure.repositories.InMemoryImages
import io.reactivex.Single
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

object GetAllImagesTest : Spek({
    Feature("Get all images"){
        Scenario("calling get all images"){
            lateinit var getAllImages : GetAllImages
            lateinit var result : Single<List<String>>
            Given("get all images action with preloaded content"){
                val images = InMemoryImages()
                val listOfImages = listOf("image1", "image2")
                val addImages = AddImages(images)
                addImages(listOfImages)
                getAllImages = GetAllImages(images)
            }
            When("call get all images"){
                result = getAllImages()
            }
            Then("get de list"){
                result.test().assertValues(listOf("image1", "image2"))
            }
        }
    }
})