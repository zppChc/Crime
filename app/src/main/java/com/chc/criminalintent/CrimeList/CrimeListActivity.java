package com.chc.criminalintent.CrimeList;

import android.support.v4.app.Fragment;

import com.chc.criminalintent.SingleFragmentActivity;

public class CrimeListActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
