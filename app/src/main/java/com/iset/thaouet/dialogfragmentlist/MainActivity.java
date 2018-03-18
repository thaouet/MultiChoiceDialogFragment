package com.iset.thaouet.dialogfragmentlist;

import android.support.v4.app.DialogFragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements ItemPickerDialogFragment.OnItemSelectedListener,
        AlertDialogChoice.OnItemsSelectedListener

{


    private TextView txtSelection;
    private AlertDialogChoice multiChoiceDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        multiChoiceDialog = new AlertDialogChoice();
        txtSelection =(TextView)findViewById(R.id.txtSelected);

    }

    public void openDialogMultiChoice(View view) {

        ArrayList<ItemPickerDialogFragment.Item> pickerItems = new ArrayList<>();
        pickerItems.add(new ItemPickerDialogFragment.Item("Zero", "0"));
        pickerItems.add(new ItemPickerDialogFragment.Item("One", "1"));
        pickerItems.add(new ItemPickerDialogFragment.Item("Two", "2"));
        pickerItems.add(new ItemPickerDialogFragment.Item("Three", "3"));

        ItemPickerDialogFragment dialog = ItemPickerDialogFragment.newInstance(
              this.getResources().getString(R.string.title_item_picker),
                pickerItems,
                -1
        );
        dialog.show(getFragmentManager(), "ItemPicker");

    }


    @Override
    public void onItemSelected(ItemPickerDialogFragment fragment, ItemPickerDialogFragment.Item item, int index) {
        String selectedValue = item.getTitle();
//        if (!selectedValue.equals(dataObject.getValue())) {
//            dataObject.setValue(selectedValue);
//            onDataObjectChanged();
//        }

        txtSelection.setText(selectedValue);
    }


public void openDialogSingleChoice(View view)
{
//    ArrayList<MultiItemPickerDialogFragment.Item> pickerItems = new ArrayList<>();
//    pickerItems.add(new MultiItemPickerDialogFragment.Item("VANILLE", "0"));
//    pickerItems.add(new MultiItemPickerDialogFragment.Item("CHOCOLAT", "1"));
//    pickerItems.add(new MultiItemPickerDialogFragment.Item("FRAISE", "2"));
//    pickerItems.add(new MultiItemPickerDialogFragment.Item("CARAMEL", "3"));
//
//    MultiItemPickerDialogFragment dialog = MultiItemPickerDialogFragment.newInstance(
//            this.getResources().getString(R.string.title_item_picker),
//            pickerItems,
//            -1
//    );
//    dialog.show(getFragmentManager(), "ItemPicker");
//

AlertDialogChoice dialogChoice = new AlertDialogChoice();
FragmentManager fragment = getFragmentManager();
dialogChoice.show(fragment,"choice");


}


    @Override
    public void onItemsSelected(AlertDialogChoice fragment, boolean[] items) {

        String choix="";
        String[] languages = getResources().getStringArray(
                R.array.languages);

        for(int i = 0; i < items.length; i++)
        {
            if (items[i])
            {
                //choix.concat(languages[i]) ;
                choix+= languages[i];
                choix+= " - ";
            }
        }

txtSelection.setText(choix);

        }

}


