package com.example.homework1.fragments;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.homework1.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyListFragment extends Fragment {

    private ArrayList<String> mNumbers = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private Button mAddButton;
    private TextView mNumCount;
    private int mDataSize;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataSize = (savedInstanceState == null)? 100 : savedInstanceState.getInt("Numcount", 100);
        Log.d("FUCK", "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        mRecyclerView = view.findViewById(R.id.num_list);
        mAddButton = view.findViewById(R.id.add_number);
        mNumCount = view.findViewById(R.id.num_count);
        Log.d("FUCK", "onCreateView");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Define sources
        makeNumbers(mNumbers);

        final int currentOrient = getResources().getConfiguration().orientation;
        final int spanCount = (currentOrient == Configuration.ORIENTATION_PORTRAIT)? 3 : 4;
        final GridLayoutManager layoutManager = new GridLayoutManager(getContext(), spanCount);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(new NumAdapter(mNumbers));
        mNumCount.setText(String.valueOf(mRecyclerView.getAdapter().getItemCount()));
        Log.d("FUCK", "onActivityCreated");
    }

    @Override
    public void onResume() {
        super.onResume();

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNumbers.add((mNumbers.size() + 1) + "");
                mRecyclerView.getAdapter().notifyItemInserted(mNumbers.size());
                mNumCount.setText(String.valueOf(++mDataSize));
            }
        });
        Log.d("FUCK", "onResume");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Numcount", mNumbers.size());
        Log.d("FUCK", "onSaveInstanceState");
    }

    void makeNumbers(List<String> numbers) {

        for (int i = 1; i <= mDataSize; i++) {
            numbers.add(i + "");
        }
    }

    class NumViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        public NumViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.num);
            Log.d("FUCK", "NumViewHolder");
        }
    }

    class NumAdapter extends RecyclerView.Adapter<NumViewHolder> {

        private List<String> mNumbers;

        NumAdapter(List<String> numbers) {
            mNumbers = numbers;
        }

        @NonNull
        @Override
        public NumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            Log.d("FUCK", "onCreateViewHolder");
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            View view = inflater.inflate(R.layout.list_element, viewGroup, false);
            return new NumViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull NumViewHolder numViewHolder, int i) {
            Resources res = getResources();
            int color = (i%2 != 0)? res.getColor(R.color.colorRed)
                    : res.getColor(R.color.colorBlue);
            numViewHolder.mTextView.setText(mNumbers.get(i));
            numViewHolder.mTextView.setTextColor(color);
            Log.d("FUCK", "onBindViewHolder");
        }

        @Override
        public int getItemCount() {
            return mNumbers.size();
        }
    }
}