package com.example.nikecodetest;


import android.app.KeyguardManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner.class)
public class MainActivityTest {

    @ClassRule
    public static ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    private static void wakeUpDevice(){
        if (BuildConfig.DEBUG){
            MainActivity homeActivity = mActivityTestRule.getActivity();

            KeyguardManager myKM = (KeyguardManager) homeActivity.getSystemService(MainActivity.KEYGUARD_SERVICE);
            boolean isPhoneLocked = myKM.inKeyguardRestrictedInputMode();

            if (isPhoneLocked){
                homeActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
                        | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                        | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
            }
        }
    }


    @BeforeClass
    public static void setUp(){
        wakeUpDevice();
    }
    @Test
    public void mainActivityTest() {
        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.searchTextView),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.searchView),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText.perform(replaceText("goods"), closeSoftKeyboard());

        pressBack();

        pressBack();
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
