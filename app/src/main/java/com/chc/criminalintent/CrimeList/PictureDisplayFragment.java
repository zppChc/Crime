package com.chc.criminalintent.CrimeList;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chc.criminalintent.R;
import com.chc.criminalintent.config.CrimeTag;
import com.chc.criminalintent.utils.PictureUtils;

/**
 * DESC:
 * Author: CHC
 * Date: 2017/12/11
 */

public class PictureDisplayFragment extends DialogFragment {
    private ImageView mImageView;

    public static PictureDisplayFragment newInstance(String path){
        Bundle args = new Bundle();
        args.putSerializable(CrimeTag.IMAGE_PATH,path);
        PictureDisplayFragment fragment = new PictureDisplayFragment();
        fragment.setArguments(args);
        return  fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.picture_display,container,false);
        mImageView=(ImageView)view.findViewById(R.id.picture_display_image_view);
        String path=getArguments().getString(CrimeTag.IMAGE_PATH);
        Bitmap btm= PictureUtils.getScaledBitmap(path,getActivity());
        mImageView.setImageBitmap(btm);
        return view;
    }
}
