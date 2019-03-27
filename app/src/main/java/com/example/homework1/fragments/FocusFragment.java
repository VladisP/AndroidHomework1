package com.example.homework1.fragments;

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

    public final static String KEY_NUMBER = "Number";
    public final static String KEY_TEXT_COLOR = "Color";
    private int mNumber;
    private int mColor;

    public static FocusFragment newInstance(int number, int color) {
        FocusFragment focusFragment = new FocusFragment();
        Bundle argument = new Bundle();
        argument.putInt(KEY_NUMBER, number);
        argument.putInt(KEY_TEXT_COLOR, color);
        focusFragment.setArguments(argument);
        return focusFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNumber = getArguments().getInt(KEY_NUMBER, -1);
        mColor = getArguments().getInt(KEY_TEXT_COLOR, -1);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_focus, container, false);
        TextView textNum = view.findViewById(R.id.big_num);
        textNum.setText(String.valueOf(mNumber));
        textNum.setTextColor(mColor);
        return view;
    }
}
