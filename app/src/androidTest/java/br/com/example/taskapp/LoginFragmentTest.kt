package br.com.example.taskapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import br.com.example.taskapp.R.*
import br.com.example.taskapp.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class SplashActivityToLoginFragment {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
     fun renderMainActivityAndFindTheTextTaskApp() {
        onView(withId(id.TextTaskAppSplash)).check(matches(isDisplayed()))
        Thread.sleep(3000)
    }

    @Test
    fun renderLoginFragment() {
        Thread.sleep(3000)
        onView(withId(id.Login_fragment_layout)).check(matches(isDisplayed()))
    }
}