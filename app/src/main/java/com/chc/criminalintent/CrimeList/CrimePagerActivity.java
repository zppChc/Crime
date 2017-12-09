package com.chc.criminalintent.CrimeList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.chc.criminalintent.CrimeFragment;
import com.chc.criminalintent.R;
import com.chc.criminalintent.bean.Crime;
import com.chc.criminalintent.bean.CrimeLab;
import com.chc.criminalintent.config.CrimeTag;

import java.util.List;
import java.util.UUID;

/**
 * DESC:
 * Author: CHC
 * Date: 2017/12/6
 */

public class CrimePagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private List<Crime> mCrimes;

    public static Intent newIntent(Context packageContext, UUID crimeId){
        Intent intent = new Intent(packageContext,CrimePagerActivity.class);
        intent.putExtra(CrimeTag.CRIME_ID,crimeId);
        return  intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_pager);

        UUID crimeId= (UUID)getIntent().getSerializableExtra(CrimeTag.CRIME_ID);

        mCrimes= CrimeLab.get(this).getCrimes();
        mViewPager=(ViewPager)findViewById(R.id.activity_crime_pager_view_pager);

        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentPagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                Crime crime = mCrimes.get(position);
                return new CrimeFragment().newInstance(crime.getId());
            }

            @Override
            public int getCount() {
                return mCrimes.size();
            }
        });

        for (int i  = 0; i<mCrimes.size(); i++){
            if (mCrimes.get(i).getId().equals(crimeId)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
