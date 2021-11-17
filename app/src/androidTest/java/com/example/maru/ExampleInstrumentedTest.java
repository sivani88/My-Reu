package com.example.maru;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Objects;

import Service.MeetingApiService;
import cUI.ui.main.Main.MainActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    public class MeetingListTest {

        private MeetingApiService service;

        // This is fixed
        private int ITEMS_COUNT = 14;

        private MainActivity mActivity;


        @Rule
        public ActivityTestRule<MainActivity> mActivityRule =
                new ActivityTestRule(MainActivity.class);
        private Object MyMeetingProfileActivity;
        private Objects AddMeetingActivity;


        @Before
        public void setUp() {
            mActivity = mActivityRule.getActivity();
            ViewMatchers.assertThat(mActivity, notNullValue());
        }

        @Before
        public void meetingRecyclerview() {

        }

        /**
         * We ensure that our recyclerview is displaying at least on item
         */
        @Test

        public void ShouldNotBeEmpty() {
            // First scroll to the position that needs to be matched and click on it.
            onView(withId(R.id.recyclerviewMain))
                    .check(matches(ViewMatchers.hasMinimumChildCount(1)));
        }


        /*@Test
        public void myMeetingListDeleteActionShouldRemoveItem() {
            // Given : We remove the element at position 2


            // When perform a click on a delete icon
            onView(withId(R.id.recyclerviewMain))
                    .perform(RecyclerViewActions.actionOnItemAtPosition(1, ));
            // Then : the number of element is 11
            onView(withId(R.id.recyclerviewMain)).check(withItemCount(ITEMS_COUNT - 1));
        }


        @Test
        public void infoActivity() {
            onView(withId(R.id.recyclerviewMain))
                    .perform(RecyclerViewActions.actionOnItemAtPosition(3, ViewActions.click()));
            onView(withId(R.id.NamePlace)).check(matches(withText("Paris")));

        }


        @Test
        public void testTimePicker() {

          /*  openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getInstrumentation().getTargetContext());
            onView(withText(R.string.filter_option_1))
                    .perform(click());
            onView(withClassName(Matchers.equalTo(TimePicker.class.getName()))).perform(RecyclerViewMatcher.setTime(6, 0));
            onView(withText("OK")).perform(click());

        }*/
        }
    }

