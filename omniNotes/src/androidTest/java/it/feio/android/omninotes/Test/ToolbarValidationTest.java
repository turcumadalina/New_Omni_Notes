package it.feio.android.omninotes.Test;


import org.junit.Test;

import it.feio.android.omninotes.Helpers.EspressoMethods;
import it.feio.android.omninotes.Helpers.HelpersMethods;
import it.feio.android.omninotes.Helpers.StartTheApplication;
import it.feio.android.omninotes.R;
import it.feio.android.omninotes.Screen.Home;
import it.feio.android.omninotes.Screen.Search;
import it.feio.android.omninotes.Screen.TextNote;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class ToolbarValidationTest extends StartTheApplication {
    @Test
    public void testToolbar() {
        // Step: Start the app

        // Expected Result: Menu_Sort is displayed between menu_search and more option.
        assertTrue("MenuSort in not displayed in the right of Search.", Home.isMenuSortInTheRightOfSearch());
        assertTrue("MenuSort is not displayed in the left of MoreOptions.", Home.isMenuSortInTheLeftOfMoreOptions());

        // Step: Add 5 items (1 of them with title "My note").
        HelpersMethods.typeNewItemAction(4, 4);

        // Step: Verify if content has bold style.
        assertTrue("Content text has NOT bold style.", Home.isTextStyleBold());

        // Expected Result: In the fragment_container there are 5 items.
        assertEquals("There are more/less then 5 items in fragment container.", 5, EspressoMethods.getChildCountFromListView(withId(R.id.list)));

        // Step:On toolbar, search for the item with text "My note".
        Home.clickSearchButton();
        Search.typeMyNoteText();
        Home.clickSearchButtonAndroid();

        // Expected Result: Item with text "My note" is displayed.
        assertTrue("My note text is not displayed.", Search.isMyNoteTextVisible());

        // Step: Click return button.
        Search.clickSearchReturn();

        // Expected Result: All 5 items are displayed.
        assertEquals("There are more/less then 5 items in fragment container.", 5, EspressoMethods.getChildCountFromListView(withId(R.id.list)));

        // Step: Click on the item with text " My Note" and move it to trash (on more option click on "Trash").
        Home.clickMyNoteItemFromTheList();
        TextNote.clickMoreOptionsButton();
        TextNote.clickTrashButton();

        // Expected Result: Item with text " My Note" is not displayed.
        assertFalse("My note text is not displayed.", Home.isMyNoteTextVisible());
    }
}