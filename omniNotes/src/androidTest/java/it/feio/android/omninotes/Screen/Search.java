package it.feio.android.omninotes.Screen;

import it.feio.android.omninotes.Helpers.Constants;
import it.feio.android.omninotes.Helpers.HelpersMethods;
import it.feio.android.omninotes.R;

import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class Search {
    public static void clickSearchReturn() {
        HelpersMethods.clickAction(withContentDescription(Constants.DRAWER_OPEN));
    }

    public static void typeMyNoteText() {
        HelpersMethods.typeTextAction(withId(R.id.search_src_text), Constants.MY_NOTE);
    }

    public static boolean isMyNoteTextVisible() {
        return HelpersMethods.isVisible(withId(R.id.note_title));
    }
}