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
import android.widget.Toast;
import android.widget.EditText;

public class FragmentA extends Fragment implements View.OnClickListener {
    private IFragmentToActivity mCallback;
    private Button btnFtoA;
    private Button btnFtoF;
    SendMessage SM;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_1, container, false);
        btnFtoA = (Button) view.findViewById(R.id.button11);
        btnFtoF = (Button) view.findViewById(R.id.button7);
        btnFtoA.setOnClickListener(this);
        btnFtoF.setOnClickListener(this);
        Button btnPassData = (Button) view.findViewById(R.id.btnPassData);
        final EditText inData = (EditText) view.findViewById(R.id.inMessage);
        btnPassData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SM.sendData(inData.getText().toString().trim());
            }
        });
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
        try {
            SM = (SendMessage) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again");
        }
    }

    @Override
    public void onDetach() {
        mCallback = null;
        super.onDetach();
    }

    public void onRefresh() {
        Toast.makeText(getActivity(), "Fragment A: Reset.",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button11:
                mCallback.showToast("Call From Fragment A");
                break;

            case R.id.button7:
                mCallback.communicateToFragment2();
                break;
        }
    }


}
