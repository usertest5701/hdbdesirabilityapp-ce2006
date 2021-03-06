package ntu.ce2006.swensens.hdbdesirabilityapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.*;
import android.view.*;
import android.content.*;
import android.widget.*;

import ntu.ce2006.swensens.hdbdesirabilityapp.R;

/**
 * Search Amenities Activity allows user to choose amenities
 * @author Faith, Nicholas, Chester
 *
 */

public class Search_Ameni_Activity extends AppCompatActivity {

    /**
     * initialisation of Search Amenities Activity
     * @param savedInstanceState restore the activity state to a previous state using the data stored in this bundle if it exists
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search__ameni_);
        setTitle("Set Amenities");
    }

    /**
     * when the activity is paused, the state of the checkboxes are saved
     */
    @Override
    public void onPause() {
        super.onPause();
        save(((CheckBox) findViewById(R.id.checkBoxMall)).isChecked(), "checkBoxMall");
        save(((CheckBox) findViewById(R.id.checkBoxMRT)).isChecked(), "checkBoxMRT");
        save(((CheckBox) findViewById(R.id.checkBoxClinic)).isChecked(), "checkBoxClinic");
    }

    /**
     * when the activity is resumed, the state of the checkboxes are loaded
     */
    @Override
    public void onResume() {
        super.onResume();
        ((CheckBox) findViewById(R.id.checkBoxMall)).setChecked(load("checkBoxMall"));
        ((CheckBox) findViewById(R.id.checkBoxMRT)).setChecked(load("checkBoxMRT"));
        ((CheckBox) findViewById(R.id.checkBoxClinic)).setChecked(load("checkBoxClinic"));
    }

    /**
     * this saves the state of the checkbox through a SharedPreferences object
     * @param ch state of the checkbox
     * @param name name of the checkbox
     */
    private void save(boolean ch, String name) {
        getSharedPreferences("x",Context.MODE_PRIVATE).edit().putBoolean(name, ch).commit();
    }

    /**
     * this loads the state of the checkbox through a SharedPreferences object
     * @param name name of the checkbox
     * @return returns the state of the checkbox
     */
    private boolean load(String name) {
        return getSharedPreferences("x",Context.MODE_PRIVATE).getBoolean(name,false);
    }
}