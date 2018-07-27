package it.feio.android.omninotes.Screen;

import it.feio.android.omninotes.Helpers.Constants;
import it.feio.android.omninotes.Helpers.HelpersMethods;
import it.feio.android.omninotes.R;

import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class Trash {
    public static void clickMoreOptionsButton() {
        HelpersMethods.clickAction(withContentDescription(Constants.MORE_OPTIONS));
    }

    public static void clickEmptyTrashButton() {
        HelpersMethods.clickAction(withText(Constants.EMPTY_TRASH));
    }

    public static void clickTheConfirmButton() {
        HelpersMethods.clickAction(withId(R.id.buttonDefaultPositive));
    }

    public static boolean isPayTheBillsTextVisible() {
        return HelpersMethods.isVisible(withText(Constants.PAY_THE_BILLS));
    }
}