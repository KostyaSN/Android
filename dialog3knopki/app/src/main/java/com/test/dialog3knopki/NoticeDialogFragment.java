package com.test.dialog3knopki;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class NoticeDialogFragment extends android.app.DialogFragment {

    public interface NoticeDialogListener {
         void onDialogClick(String string);
    }

    NoticeDialogListener mListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{

            mListener=(NoticeDialogListener) activity;
        }
        catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()+ " must implement NoticeDialogListener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().setTitle("Dialog");

        final View view = inflater.inflate(R.layout.dialog,null);
        final EditText editText=(EditText) view.findViewById(R.id.editText);
        view.findViewById(R.id.buttonYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onDialogClick(editText.getText().toString());
            }
        });
        view.findViewById(R.id.buttonNo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onDialogClick("BUTTON");
            }
        });
        view.findViewById(R.id.buttonCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return view;
    }
}