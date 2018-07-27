package it.feio.android.omninotes.Screen;

import it.feio.android.omninotes.Helpers.Constants;
import it.feio.android.omninotes.Helpers.EspressoMethods;
import it.feio.android.omninotes.Helpers.HelpersMethods;
import it.feio.android.omninotes.R;

import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

public class Home {
    public static boolean isMenuSortInTheRightOfSearch() {
        return HelpersMethods.isFirstObjectToTheRightOfSecondObject(withId(R.id.menu_sort), withId(R.id.menu_search));
    }

    public static boolean isMenuSortInTheLeftOfMoreOptions() {
        return HelpersMethods.isFirstObjectToTheLeftOfSecondObject(withId(R.id.menu_sort), withContentDescription(Constants.MORE_OPTIONS));
    }

    public static void clickSearchButton() {
        HelpersMethods.clickAction(withId(R.id.menu_search));
    }

    public static boolean isMyNoteTextVisible() {
        return HelpersMethods.isVisible(allOf(withId(R.id.note_title), withText(Constants.MY_NOTE), isCompletelyDisplayed()));
    }

    public static void clickMyNoteItemFromTheList() {
        HelpersMethods.clickAction(withText(Constants.MY_NOTE));
    }

    public static void clickSearchButtonAndroid() {
        HelpersMethods.clickTheSearchButtonAndroid(withId(R.id.search_src_text));
    }

    public static boolean isTextStyleBold() {
        return HelpersMethods.isVisible(allOf(withId(R.id.note_content), EspressoMethods.hasBoldText()));
    }

    public static void clickAddButton() {
        HelpersMethods.clickAction(withId(R.id.fab_expand_menu_button));
    }

    public static void clickArchiveButton() {
        HelpersMethods.clickAction(withText(Constants.ARCHIVE));
    }

    public static void clickTrashButton() {
        HelpersMethods.clickAction(withText(Constants.TRASH));
    }

    public static boolean isNothingHereTextVisible() {
        return HelpersMethods.isVisible(withId(R.id.empty_list));
    }

    public static boolean isAddButtonVisible() {
        return HelpersMethods.isVisible(withId(R.id.fab_expand_menu_button));
    }

    public static boolean isAddButtonClickable() {
        return HelpersMethods.isUIObjectClickable(withId(R.id.fab_expand_menu_button));
    }

    public static boolean isNothingHereTextClickable() {
        return HelpersMethods.isUIObjectClickable(withId(R.id.empty_list));
    }

    public static boolean isSuggestivePictureOfPhotoAboveChecklistSuggestivePicture() {
        return HelpersMethods.isFirstObjectAboveOfSecondObject(withId(R.id.fab_camera), withId(R.id.fab_checklist));
    }

    public static boolean isContentBoxDescendantOfALinearLayout() {
        return HelpersMethods.isVisible(allOf(withId(R.id.detail_content), isDescendantOfA(withParent(withId(R.id.content_wrapper)))));
    }

    public static boolean isAddReminderDescendantOfALinearLayout() {
        return HelpersMethods.isVisible(allOf(withId(R.id.datetime), isDescendantOfA(withId(R.id.reminder_layout))));
    }

    public static boolean isContentParentSiblingWithAddReminder() {
        return HelpersMethods.isVisible(allOf(withChild(withId(R.id.detail_content)), hasSibling(withId(R.id.reminder_layout))));
    }

    public static boolean isArchiveTextVisible() {
        return HelpersMethods.isVisible(allOf(withId(R.id.title), withText(Constants.ARCHIVE)));
    }

    public static boolean isArchiveButtonSiblingWithNotesButton() {
        return HelpersMethods.isVisible(allOf(withChild(allOf(withId(R.id.title), withText(Constants.ARCHIVE))), hasSibling(withChild(allOf(withId(R.id.title), withText(Constants.NOTES))))));
    }

    public static void clickTextNoteButton() {
        HelpersMethods.clickAction(withId(R.id.fab_note));
    }
}