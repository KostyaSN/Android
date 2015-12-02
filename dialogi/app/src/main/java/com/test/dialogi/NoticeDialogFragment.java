package com.test.dialogi;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import java.util.ArrayList;

public class NoticeDialogFragment extends DialogFragment {

    public interface NoticeDialogListener {
        void onDialogPositiveClick(ArrayList<Integer> arrayList);
    }

    NoticeDialogListener mListener;
    public ArrayList<Integer> mSelectedItems=new ArrayList<>();

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
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.choice)
                .setCancelable(true)
                .setMultiChoiceItems(R.array.check_box, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            mSelectedItems.add(which);
                        } else if (mSelectedItems.contains(which)) {
                            mSelectedItems.remove(Integer.valueOf(which));
                        }
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mListener.onDialogPositiveClick(mSelectedItems);
                        dialog.dismiss();
                    }
                });

        return builder.create();
    }
}
