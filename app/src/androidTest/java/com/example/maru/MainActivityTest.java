package com.example.maru;


import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.annotation.IdRes;
import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.contrib.PickerActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.maru.utils.DeleteViewAction;
import com.example.maru.utils.RecyclerViewItemCountAssertion;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import Service.MeetingApiService;
import cUI.ui.main.Main.MainActivity;
import configure.injection.DI;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.example.maru.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private int ITEMS_COUNT;
    MainActivity mMainActivity;
    MeetingApiService mApiService;
    final int[] COUNT = {0};


    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() {
        mMainActivity = mActivityTestRule.getActivity();
        assertThat(mMainActivity, notNullValue());
        mApiService = DI.getNewInstanceApiService();
        ITEMS_COUNT = mApiService.getMeetings().size();


    }

    @Test

    public void myRecyclerViewShouldNotBeEmpty() {

        onView(withId(R.id.recyclerviewMain))
                .check(matches(ViewMatchers.hasMinimumChildCount(1)));
    }


    @Test
    public void selectSpinnerItem() {
        onView(withId(R.id.spinnerRoom))
                .check(matches(isDisplayed()))
                .perform(click());
        Espresso.onData(anything("Vienna")).atPosition(3).perform(click());
        onView(allOf(withId(R.id.recyclerviewMain), isDisplayed()))
                .check(withItemCount(1));
        Espresso.onData(anything("")).atPosition(0).perform(click());
    }

    @Test
    public void selectDateFilter() {
        onView(withId(R.id.button_picker_date))
                .perform(click());
        ;
        onView(ViewMatchers.withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2022, 1, 1));
        onView(withText("OK")).perform(click());
        onView(allOf(withId(R.id.recyclerviewMain), isDisplayed()))
                .check(withItemCount(8));


    }


    public static int getCountFromRecyclerView(@IdRes int RecyclerViewId) {
        final int[] COUNT = {0};
        Matcher matcher = new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {

            }

            @Override
            protected boolean matchesSafely(View item) {
                COUNT[0] = ((RecyclerView) item).getAdapter().getItemCount();
                return true;
            }

        };
        onView(allOf(withId(RecyclerViewId), isDisplayed())).check(matches(matcher));
        return COUNT[0];
    }

    @Test
    public void myRecyclerViewDeleteActionShouldRemoveItem() {
        ITEMS_COUNT = getCountFromRecyclerView(R.id.recyclerviewMain);
        onView(withId(R.id.recyclerviewMain))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));
        onView(withId(R.id.recyclerviewMain)).check(withItemCount(ITEMS_COUNT - 1));

    }


    @Test
    public void addAction_shouldAddItem() {
        ITEMS_COUNT = getCountFromRecyclerView(R.id.recyclerviewMain);
        onView(ViewMatchers.withId(R.id.floatingActionButtonadd)).perform(click());

        onView(ViewMatchers.withId(R.id.buttonDate)).perform(click());
        onView(ViewMatchers.withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2022, 2, 18));
        onView(withText("OK")).perform(click());
        onView(ViewMatchers.withId(R.id.buttonHaour)).perform(click());
        onView(ViewMatchers.withClassName(Matchers.equalTo(TimePicker.class.getName())))
                .perform(PickerActions.setTime(10, 0));
        onView(withText("OK")).perform(click());
        onView(ViewMatchers.withId(R.id.editTextTextPersonName)).perform(typeText("Test"));
        onView(ViewMatchers.withId(R.id.editTextTextPersonName)).perform(swipeUp());

        onView(ViewMatchers.withId(R.id.multiAutoCompleteTextView)).perform(typeText("zouzou@gmail.com"));
        Espresso.pressBack();

        onView(ViewMatchers.withId(R.id.buttonSubmit)).perform(click());

        onView(ViewMatchers.withId(R.id.recyclerviewMain)).check(RecyclerViewItemCountAssertion.withItemCount(ITEMS_COUNT + 1));
    }


}