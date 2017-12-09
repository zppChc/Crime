package com.chc.criminalintent.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.chc.criminalintent.CrimeList.CrimePagerActivity;
import com.chc.criminalintent.R;
import com.chc.criminalintent.bean.Crime;
import com.chc.criminalintent.config.CrimeTag;
import com.chc.criminalintent.utils.TimeUtils;

import java.util.List;

/**
 * DESC:
 * Author: CHC
 * Date: 2017/12/6
 * @author CHC
 */

public class CrimeListAdapter extends RecyclerView.Adapter<CrimeListAdapter.ViewHolder>{

    private List<Crime> mCrimes;
    private Context mContext;
    public CrimeListAdapter (List<Crime> crimes, Context context){
        mCrimes = crimes;
        mContext= context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater  = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.list_item_crime,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Crime crime = mCrimes.get(position);
        holder.bindCrime(crime);
    }

    @Override
    public int getItemCount() {
        return mCrimes.size();
    }


    public void setCrimes(List<Crime> crimes) {
        mCrimes = crimes;
    }
    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView mTitle;
        public  TextView mDate;
        public CheckBox mSolved;

        private Crime mCrime;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mTitle = (TextView)itemView.findViewById(R.id.list_item_crime_title_text_view);
            mDate=(TextView)itemView.findViewById(R.id.list_item_crime_date_text_view);
            mSolved=(CheckBox)itemView.findViewById(R.id.list_item_crime_solved_check_box);
        }

        public void bindCrime(Crime crime){
            mCrime = crime;
            mTitle.setText(mCrime.getTitle());
            mDate.setText(TimeUtils.date2Date(mCrime.getDate(),"yyyy-MM-dd HH:ss:mm"));
            mSolved.setChecked(mCrime.isSolved());
            mSolved.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    mCrime.setSolved(isChecked);
                }
            });
        }

        @Override
        public void onClick(View view) {
//            Toast.makeText(mContext, "Hello Click", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(mContext, CrimePagerActivity.class);
            intent.putExtra(CrimeTag.CRIME_ID,mCrime.getId());
            mContext.startActivity(intent);
        }
    }


}
