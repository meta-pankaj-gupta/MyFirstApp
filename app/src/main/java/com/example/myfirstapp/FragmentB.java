package com.example.myfirstapp;

/**
 * Created by Pankaj on 4/11/2018.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentB extends Fragment implements View.OnClickListener {
    private IFragmentToActivity mCallback;
    private TextView mTextView1;
    private Button btnFtoA;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_2, container, false);
        mTextView1 = (TextView) view.findViewById(R.id.textView5);
        btnFtoA = (Button) view.findViewById(R.id.button11);
        btnFtoA.setOnClickListener(this);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (IFragmentToActivity) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement IFragmentToActivity");
        }
    }

    @Override
    public void onDetach() {
        mCallback = null;
        super.onDetach();
    }

    public void onRefresh() {
        Toast.makeText(getActivity(), "Fragment B: Reset.",
                Toast.LENGTH_SHORT).show();
        mTextView1.setText("");
    }

    public void fragmentCommunication() {
        mTextView1.setText("Inter Communication from Fragment A");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button11:
                mCallback.showToast("Call From FragmentB");
                break;
        }
    }
}