package com.example.demoapp;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest  {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityTestRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void changeText_sameActivity() {
        // 1. Find a View
        onView(withId(R.id.etPersonName))
                // 2. Perform an action
                .perform(typeText("abdul"), closeSoftKeyboard());
        onView(withId(R.id.buttonLogin)).perform(click());
        // 3. Verify action was taken, assert result
        onView(withId(R.id.txtviewName))
                .check(matches(withText("abdul")));
    }

}