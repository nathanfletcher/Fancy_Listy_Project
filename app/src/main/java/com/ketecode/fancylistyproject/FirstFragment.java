package com.ketecode.fancylistyproject;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by KobbyFletcher on 1/18/16.
 */
public class FirstFragment extends Fragment {

    TextView someTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /*After you override this method Android Studio will write the line below for you.
        Delet it. or comment it out. You don't need it.
         */
        //return super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment1_layout, container, false);
        someTextView = (TextView) view.findViewById(R.id.fragmentTitle);
        someTextView.setText("First Fragment !!!");
        return view;
    }
}
