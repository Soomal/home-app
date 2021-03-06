package org.ctagroup.homeapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import org.ctagroup.homeapp.R;

import org.ctagroup.homeapp.Utils;
import org.ctagroup.homeapp.data.EncampmentSite;
import org.ctagroup.homeapp.fragments.EncampCreateNewFragment;
import org.ctagroup.homeapp.fragments.EncampMainFragment;
import org.ctagroup.homeapp.fragments.EncampSearchFragment;
import org.ctagroup.homeapp.fragments.EncampSiteVisitFragment;

/**
 * @author David Horton
 */
public class EncampmentActivity extends ActionBarActivity
        implements EncampMainFragment.EncampMainFragmentListener,
        EncampSearchFragment.EncampSearchFragmentListener {

    public static final String ENCAMP_SEARCH_BUNDLE_TAG = "ENCAMP_SEARCH";
    public static final String ENCAMP_DETAILS_BUNDLE_TAG = "ENCAMP_DETAILS";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encampment);
        Utils.setActionBarColorToDefault(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.encampmentContainer, new EncampMainFragment(), "EncampMainFragment")
                    .commit();
        }
    }

    @Override
    public void createNewClicked() {

        Utils.hideSoftKeyboard(this);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.encampmentContainer, new EncampCreateNewFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void encampmentVisitClicked() {
        Utils.hideSoftKeyboard(this);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.encampmentContainer, new EncampSiteVisitFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void performSearch(String searchQuery) {

        Utils.hideSoftKeyboard(this);

        EncampSearchFragment searchFragment = new EncampSearchFragment();

        Bundle arguments = new Bundle();
        arguments.putString(ENCAMP_SEARCH_BUNDLE_TAG, searchQuery);
        searchFragment.setArguments(arguments);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.encampmentContainer, searchFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onEncampmentSelected(EncampmentSite selectedSite) {

        Bundle arguments = new Bundle();
        arguments.putSerializable(ENCAMP_DETAILS_BUNDLE_TAG, selectedSite);

        Intent intent = new Intent(EncampmentActivity.this, EncampmentDetailActivity.class);
        intent.putExtras(arguments);
        startActivity(intent);
    }


}
