package it.feio.android.omninotes.screens;

import it.feio.android.omninotes.helpers.Constants;
import it.feio.android.omninotes.helpers.HelpersMethods;

import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class Archives {

    public static boolean isNoteWithTextPayTheBillsDisplayed() {
        return HelpersMethods.isUIObjectDisplayed(withText(Constants.PAY_THE_BILLS));
    }

    public static void removeNoteWithTitlePayTheBills() {
        HelpersMethods.deleteUIItem(withText(Constants.PAY_THE_BILLS));
    }
}