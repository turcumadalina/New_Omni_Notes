package it.feio.android.omninotes.screens;

import it.feio.android.omninotes.R;
import it.feio.android.omninotes.helpers.Constants;
import it.feio.android.omninotes.helpers.HelpersMethods;

import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class Trash {

    public static boolean isNoteWithTitlePayTheBillsDisplayed() {
        return HelpersMethods.isUIObjectDisplayed(withText(Constants.PAY_THE_BILLS));
    }

    public static void clickOnMoreOptionButton() {
        HelpersMethods.clickUIElement(withContentDescription(Constants.MORE_OPTIONS));
    }

    public static void clickOnEmptyTrashButton() {
        HelpersMethods.clickUIElement(withText(R.string.empty_trash));
    }

    public static void clickOkButton() {
        HelpersMethods.clickUIElement(withId(R.id.buttonDefaultPositive));
    }

    public static int isListViewWithOneItem() {
        return HelpersMethods.getNoOfChildsFromListView(withId(R.id.list));
    }
}