package com.iset.thaouet.dialogfragmentlist;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;



public class AlertDialogChoice extends DialogFragment  {

    public boolean[] selectedItems = new boolean[] { false, false, false, false,
                false, false };
        private boolean[] clickedItems = selectedItems;

    public interface OnItemsSelectedListener {
        void onItemsSelected(AlertDialogChoice fragment, boolean[] items);
    }



        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final String[] languages = getResources().getStringArray(
                    R.array.languages);
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    getActivity())
                    .setTitle(R.string.alert_dialog_title)
                    .setMultiChoiceItems(R.array.languages, selectedItems,
                            new DialogInterface.OnMultiChoiceClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which, boolean isChecked) {
                                    clickedItems[which]= isChecked;
//                                    Toast.makeText(getActivity(), languages[which],
//                                            Toast.LENGTH_SHORT).show();
                                }
                            })



                    .setPositiveButton(R.string.ok_btn, new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            selectedItems = clickedItems;

                            Activity activity = getActivity();
                            if (activity instanceof OnItemsSelectedListener) {
                                    OnItemsSelectedListener listener = (OnItemsSelectedListener)activity;
                                    listener.onItemsSelected(AlertDialogChoice.this, selectedItems);
                                }
                            }
                    })
                    .setNegativeButton(R.string.cancel_btn, new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                         dialog.dismiss();
                        }
                    });
            AlertDialog dialog = alertDialogBuilder.create();
            return dialog;
        }
}
