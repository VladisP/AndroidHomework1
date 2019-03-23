package com.example.homework1.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.homework1.R;

public class FocusFragment extends Fragment {

    private int mNumber;

    public static FocusFragment newInstance(int number) {
        FocusFragment focusFragment = new FocusFragment();
        Bundle argument = new Bundle();
        argument.putInt("Number", number);
        focusFragment.setArguments(argument);
        return focusFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNumber = getArguments().getInt("Number", -1);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_focus, container, false);
        TextView textNum = view.findViewById(R.id.big_num);
        textNum.setText(String.valueOf(mNumber));
        Resources res = getResources();
        int color = (mNumber % 2 == 0) ? res.getColor(R.color.colorRed)
                : res.getColor(R.color.colorBlue);
        textNum.setTextColor(color);
        return view;
    }
}
