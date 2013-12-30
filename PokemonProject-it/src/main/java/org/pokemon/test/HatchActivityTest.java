package org.pokemon.test;

import android.test.ActivityInstrumentationTestCase2;

import org.pokemon.activity.HatchActivity;

public class HatchActivityTest extends ActivityInstrumentationTestCase2<HatchActivity> {

    public HatchActivityTest() {
        super(HatchActivity.class);
    }

    public void testActivity() {
        HatchActivity activity = getActivity();
        assertNotNull(activity);
    }
}

