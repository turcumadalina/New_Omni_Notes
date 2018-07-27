package it.feio.android.omninotes.Screen;

import it.feio.android.omninotes.Helpers.Constants;
import it.feio.android.omninotes.Helpers.HelpersMethods;

import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class Archive {
    public static boolean isPayTheBillsTextVisible() {
        return HelpersMethods.isVisible(withText(Constants.PAY_THE_BILLS));
    }

    public static void deleteTheNote() {
        HelpersMethods.swipeLeftAction(withText(Constants.PAY_THE_BILLS));
    }

    public static void clickHamburgerButton() {
        HelpersMethods.clickAction(withContentDescription(Constants.DRAWER_OPEN));
    }
}
