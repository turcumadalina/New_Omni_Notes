package it.feio.android.omninotes.helpers;

import android.support.test.espresso.AppNotIdleException;
import android.support.test.espresso.NoMatchingRootException;
import android.support.test.espresso.NoMatchingViewException;
import android.view.View;

import junit.framework.AssertionFailedError;

import org.hamcrest.Matcher;

import java.util.Random;

import it.feio.android.omninotes.screens.Home;
import it.feio.android.omninotes.screens.TextNote;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressKey;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.PositionAssertions.isAbove;
import static android.support.test.espresso.assertion.PositionAssertions.isBelow;
import static android.support.test.espresso.assertion.PositionAssertions.isLeftOf;
import static android.support.test.espresso.assertion.PositionAssertions.isRightOf;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;

public class HelpersMethods {

    public static void clickUIElement(Matcher<View> matcher) {
        onView(matcher).perform(click());
    }

    public static void typeItemText(Matcher<View> matcher, String textToBeTyped) {
        onView(matcher).perform(typeText(textToBeTyped));
    }

    public static boolean isUIObjectDisplayed(Matcher<View> matcher) {
        try {
            onView(matcher).check(matches(isCompletelyDisplayed()));
            return true;
        } catch (NoMatchingViewException | AppNotIdleException | AssertionFailedError | NoMatchingRootException e) {
            return false;
        }
    }

    public static void deleteUIItem(Matcher<View> matcher) {
        onView(matcher).perform(swipeLeft());
    }

    public static int getNoOfChildsFromListView(Matcher<View> matcher) {
        return EspressoMatchers.getListViewChildCount(matcher);
    }

    private static String generatingRandomText() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    public static void addItemsContent(Matcher<View> matcher, int contentTextLines) {
        String noteContent = generatingRandomText();
        for (int i = 0; i < contentTextLines; i++) {
            onView(matcher).perform(typeText(noteContent));
            onView(matcher).perform(pressKey(66));
        }
    }

    public static boolean isUIObjectIsClickable(Matcher<View> matcher) {
        try {
            onView(matcher).check(matches(isClickable()));
            return true;
        } catch (NoMatchingViewException | AppNotIdleException | AssertionFailedError | NoMatchingRootException e) {
            return false;
        }
    }

    public static boolean isUIObjectAboveAnotherObject(Matcher<View> matcher1, Matcher<View> matcher2) {
        try {
            onView(matcher1).check(isAbove(matcher2));
            return true;
        } catch (NoMatchingViewException | AppNotIdleException | AssertionFailedError | NoMatchingRootException e) {
            return false;
        }
    }

    public static boolean isUIObjectBelowAnotherObject(Matcher<View> matcher1, Matcher<View> matcher2) {
        try {
            onView(matcher1).check(isBelow(matcher2));
            return true;
        } catch (NoMatchingViewException | AppNotIdleException | AssertionFailedError | NoMatchingRootException e) {
            return false;
        }
    }

    public static boolean isUIObjectRightOfAnotherUIObject(Matcher<View> matcher1, Matcher<View> matcher2) {
        try {
            onView(matcher1).check(isRightOf(matcher2));
            return true;
        } catch (NoMatchingViewException | AppNotIdleException | AssertionFailedError | NoMatchingRootException e) {
            return false;
        }
    }

    public static boolean isUIObjectLeftOfAnotherUIObject(Matcher<View> matcher1, Matcher<View> matcher2) {
        try {
            onView(matcher1).check(isLeftOf(matcher2));
            return true;
        } catch (NoMatchingViewException | AppNotIdleException | AssertionFailedError | NoMatchingRootException e) {
            return false;
        }
    }

    public static void addNoteItems(Matcher<View> matcher, String specificToDoItemText, int positionOfSpecificItem, int noOfItems) {
        for (int i = 0; i < noOfItems; i++) {
            Home.clickAddButton();
            Home.clickTextNoteButton();
            if (i == positionOfSpecificItem) {
                onView(matcher).perform(typeText(specificToDoItemText));
            } else {
                onView(matcher).perform(typeText(generatingRandomText()));
            }
            TextNote.clickReturnButton();
        }
    }
}