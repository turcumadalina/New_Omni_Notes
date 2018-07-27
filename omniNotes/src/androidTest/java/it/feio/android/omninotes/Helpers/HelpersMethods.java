package it.feio.android.omninotes.Helpers;

import android.support.test.espresso.NoMatchingViewException;
import android.view.View;

import org.hamcrest.Matcher;

import java.security.SecureRandom;

import it.feio.android.omninotes.R;
import it.feio.android.omninotes.Screen.TextNote;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.PositionAssertions.isAbove;
import static android.support.test.espresso.assertion.PositionAssertions.isBelow;
import static android.support.test.espresso.assertion.PositionAssertions.isLeftOf;
import static android.support.test.espresso.assertion.PositionAssertions.isRightOf;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class HelpersMethods extends EspressoMethods {
    public static boolean isVisible(Matcher<View> matcher) {
        try {
            onView(matcher).check(matches(isDisplayed()));
            return true;
        } catch (Exception e) {
            // View is not in hierarchy
            return false;
        }
    }

    public static boolean isUIObjectClickable(Matcher<View> matcher) {
        try {
            onView(matcher).check(matches(isClickable()));
            return true;
        } catch (NoMatchingViewException e) {
            // View is not in hierarchy
            return false;
        }
    }

    public static void clickAction(Matcher<View> matcher) {
        onView(matcher).perform(click());
    }

    public static boolean isFirstObjectToTheLeftOfSecondObject(Matcher<View> matcher1, Matcher<View> matcher2) {
        try {
            onView(matcher1).check(isLeftOf(matcher2));
            return true;
        } catch (NoMatchingViewException e) {
            // View is not in hierarchy
            return false;
        }
    }

    public static boolean isFirstObjectToTheRightOfSecondObject(Matcher<View> matcher1, Matcher<View> matcher2) {
        try {
            onView(matcher1).check(isRightOf(matcher2));
            return true;
        } catch (NoMatchingViewException e) {
            // View is not in hierarchy
            return false;
        }
    }

    public static boolean isFirstObjectAboveOfSecondObject(Matcher<View> matcher1, Matcher<View> matcher2) {
        try {
            onView(matcher1).check(isAbove(matcher2));
            return true;
        } catch (NoMatchingViewException e) {
            // View is not in hierarchy
            return false;
        }
    }

    public static boolean isFirstObjectBelowOfSecondObject(Matcher<View> matcher1, Matcher<View> matcher2) {
        try {
            onView(matcher1).check(isBelow(matcher2));
            return true;
        } catch (NoMatchingViewException e) {
            // View is not in hierarchy
            return false;
        }
    }

    private static String getRandomString() {
        final String AB = Constants.ALPHANUMERIC_RANDOM_STRING;

        SecureRandom random = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder(5);

        for (int i = 0; i < 5; i++) {
            stringBuilder.append(AB.charAt(random.nextInt(AB.length())));
        }

        return stringBuilder.toString();
    }

    public static void typeNewItemAction(int xItemsAdded, int xPositionToAddNewText) {
        for (int i = 0; i < xItemsAdded; i++) {
            TextNote.clickAddButton();
            TextNote.clickTextNoteButton();
            TextNote.clickTitleBox();

            if (i == xPositionToAddNewText) {
                HelpersMethods.typeTextAction(withId(R.id.detail_title), Constants.MY_NOTE);
                TextNote.clickReturnButton();
            } else {
                HelpersMethods.typeTextAction(withId(R.id.detail_title), HelpersMethods.getRandomString());
                TextNote.clickContentBox();
                HelpersMethods.typeTextAction(withId(R.id.detail_content), HelpersMethods.getRandomString());
                TextNote.clickReturnButton();
            }
        }
    }

    public static void clickTheSearchButtonAndroid(Matcher<View> matcher) {
        onView(matcher).perform(pressImeActionButton());
    }

    public static void typeTextAction(Matcher<View> matcher, String itemName) {
        onView(matcher).perform(typeText(itemName));
    }

    public static void swipeLeftAction(Matcher<View> matcher) {
        onView(matcher).perform(swipeLeft());
    }

    public static void swipeRightAction(Matcher<View> matcher) {
        onView(matcher).perform(swipeRight());
    }
}