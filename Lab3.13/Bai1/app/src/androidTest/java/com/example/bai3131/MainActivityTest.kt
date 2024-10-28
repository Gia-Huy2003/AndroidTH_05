package com.example.bai3131

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.Matchers.`is`
import androidx.test.espresso.assertion.ViewAssertions.matches

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testEvenNumber() {
        onView(withId(R.id.editTextNumber)).perform(typeText("4"), closeSoftKeyboard())
        onView(withId(R.id.buttonCheck)).perform(click())
        onView(withId(R.id.textViewResult)).check(matches(withText(`is`("Even Number"))))
    }

    @Test
    fun testOddNumber() {
        onView(withId(R.id.editTextNumber)).perform(typeText("3"), closeSoftKeyboard())
        onView(withId(R.id.buttonCheck)).perform(click())
        onView(withId(R.id.textViewResult)).check(matches(withText(`is`("Odd Number"))))
    }

    @Test
    fun testInvalidInput() {
        onView(withId(R.id.editTextNumber)).perform(typeText("abc"), closeSoftKeyboard())
        onView(withId(R.id.buttonCheck)).perform(click())
        onView(withId(R.id.textViewResult)).check(matches(withText(`is`("Please enter a valid number"))))
    }
}
