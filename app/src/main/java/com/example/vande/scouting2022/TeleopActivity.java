package com.example.vande.scouting2022;

import android.Manifest;
import android.os.Environment;

import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.support.design.widget.TextInputLayout;
import android.content.Intent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import utils.FormatStringUtils;
import utils.PermissionUtils;
import utils.StringUtils;
import utils.ViewUtils;

import static android.R.attr.value;
import static com.example.vande.scouting2022.AutonActivity.AUTON_STRING_EXTRA;
import static com.example.vande.scouting2022.AutonActivity.MATCH_STRING_EXTRA;
import static com.example.vande.scouting2022.AutonActivity.TEAMNUMBER_STRING_EXTRA;


public class TeleopActivity extends AppCompatActivity implements View.OnKeyListener {
    /*This area sets and binds all of the variables that we will use in the auton activity*/

    @BindView(R.id.teleopInnerPort_input_layout)
    public TextInputLayout teleopInnerPortInputLayout;

    @BindView(R.id.teleopOuterPort_input_layout)
    public TextInputLayout teleopOuterPortInputLayout;

    @BindView(R.id.teleopBottomPort_input_layout)
    public TextInputLayout teleopBottomPortInputLayout;

    @BindView(R.id.teleopInnerPort_input)
    public TextInputEditText teleopInnerPortInput;

    @BindView(R.id.teleopOuterPort_input)
    public TextInputEditText teleopOuterPortInput;

    @BindView(R.id.teleopBottomPort_input)
    public TextInputEditText teleopBottomPortInput;

    @BindView(R.id.powerCellPickupLoadingStation_checkBox)
    public CheckBox powerCellPickupLoadingStationCheckBox;

    @BindView(R.id.powerCellPickupFloor_checkBox)
    public CheckBox powerCellPickupFloorCheckBox;

    @BindView(R.id.fouls_checkBox)
    public CheckBox foulsCheckBox;

    @BindView(R.id.controlPanel_RadiobtnGrp)
    public RadioGroup controlPanelRadiobtnGrp;

    @BindView(R.id.climb_RadiobtnGrp)
    public RadioGroup climbRadiobtnGrp;

    @BindView(R.id.defense_RadiobtnGrp)
    public RadioGroup defenseRadiobtnGrp;

    @BindView(R.id.save_btn)
    public Button saveBtn;

    int teleopInnerPort = 0;
    int teleopOuterPort = 0;
    int teleopBottomPort = 0;
    public String auton;
    public String matchNumber;
    public String teamNumber;

    private ArrayList<CharSequence> teleopDataStringList;

    /*When this activity is first called,
 *we will call the activity_auton layout so we can display
 *the user interface
 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teleop);

        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        auton = bundle.getString(AUTON_STRING_EXTRA);
        matchNumber = bundle.getString(MATCH_STRING_EXTRA);
        teamNumber = bundle.getString(TEAMNUMBER_STRING_EXTRA);

        getSupportActionBar().setTitle("Match: " + matchNumber + " - Team: " + teamNumber);

        teleopDataStringList = new ArrayList<>();

        displayTeleopInnerPortInput(teleopInnerPort);
        displayTeleopOuterPortInput(teleopOuterPort);
        displayTeleopBottomPortInput(teleopBottomPort);
    }

    /*If this activity is resumed from a paused state the data
     *will be set to what they previously were set to
     */
    @Override
    protected void onResume() {
        super.onResume();

        teleopInnerPortInput.setOnKeyListener(this);
        teleopOuterPortInput.setOnKeyListener(this);
        teleopBottomPortInput.setOnKeyListener(this);
    }

    /*If this activity enters a paused state the data will be set to null*/
    @Override
    protected void onPause() {
        super.onPause();

        teleopInnerPortInput.setOnKeyListener(null);
        teleopOuterPortInput.setOnKeyListener(null);
        teleopBottomPortInput.setOnKeyListener(null);
    }

    /* This method will display the options menu when the icon is pressed
     * and this will inflate the menu options for the user to choose
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    /*This method will launch the correct activity
     *based on the menu option user presses
      */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_activity:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case R.id.send_data:
                startActivity(new Intent(this, SendDataActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Teleop Inner Power Cell Score
    public void decrease_teleopInnerPortInput(View view) {
        if (teleopInnerPort != 0) {
            teleopInnerPort -= 1;
            displayTeleopInnerPortInput(teleopInnerPort);
        } else {
        }
    }

    public void increase_teleopInnerPortInput(View view) {
        teleopInnerPort += 1;
        displayTeleopInnerPortInput(teleopInnerPort);
    }

    private void displayTeleopInnerPortInput(int number) {
        teleopInnerPortInput.setText("" + number);
    }

    //Teleop outer power cell score
    public void decreaseTeleopOuterPortInput(View view) {
        if (teleopOuterPort != 0) {
            teleopOuterPort -= 1;
            displayTeleopOuterPortInput(teleopOuterPort);
        } else {
        }
    }

    public void increaseTeleopOuterPortInput(View view) {
        teleopOuterPort += 1;
        displayTeleopOuterPortInput(teleopOuterPort);

    }


    private void displayTeleopOuterPortInput(int number) {
        teleopOuterPortInput.setText("" + number);
    }

    //Teleop bottom power cell score
    public void decreaseTeleopBottomPortInput(View view) {
        if (teleopBottomPort != 0) {
            teleopBottomPort -= 1;
            displayTeleopBottomPortInput(teleopBottomPort);
        } else {
        }
    }

    public void increaseTeleopBottomPortInput(View view) {
        teleopBottomPort += 1;
        displayTeleopBottomPortInput(teleopBottomPort);

    }

    private void displayTeleopBottomPortInput(int number) {
        teleopBottomPortInput.setText("" + number);
    }


    /*This method will look at all of the text/number input fields and set error
    *for validation of data entry
     */
    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (keyCode != KeyEvent.KEYCODE_SPACE && keyCode != KeyEvent.KEYCODE_TAB) {
            TextInputEditText inputEditText = (TextInputEditText) v;

            if (inputEditText != null) {

                switch (inputEditText.getId()) {

                    case R.id.teleopInnerPort_input:
                        teleopInnerPortInputLayout.setError(null);
                        break;

                    case R.id.teleopOuterPort_input:
                        teleopOuterPortInputLayout.setError(null);
                        break;

                    case R.id.teleopBottomPort_input:
                        teleopBottomPortInputLayout.setError(null);
                        break;
                }
            }
        }
        return false;
    }

    /*
    * This method will verify that all fields are filled and highlight error to user
    * along with change focus to first blank input area. The radio button values are obtained
    * A file is created on the dvice to send the data to. We add the teleop data to the arraylist
    * delimited by commas. We create our message by concatenating the telop data to the end of
    * the auton data. The data is then output to the file we created. We send a message to the user
    * about the saved message. We send a result back to the auton activity upon completion.
    * We then clear the data of the teleop activity and finish it to close and return
    * to the auton activty to clear its data*/
    public void saveData(View view) throws IOException {
        String state = Environment.getExternalStorageState();
        boolean allInputsPassed = false;

        if (StringUtils.isEmptyOrNull(getTextInputLayoutString(teleopInnerPortInputLayout))) {
            teleopInnerPortInputLayout.setError(getText(R.string.teleopInnerPowerCellError));
            ViewUtils.requestFocus(teleopInnerPortInputLayout, this);
        } else if (StringUtils.isEmptyOrNull(getTextInputLayoutString(teleopOuterPortInputLayout))) {
            teleopOuterPortInputLayout.setError(getText(R.string.teleopOuterPowerCellError));
            ViewUtils.requestFocus(teleopOuterPortInputLayout, this);
        } else if (StringUtils.isEmptyOrNull(getTextInputLayoutString(teleopBottomPortInputLayout))) {
            teleopBottomPortInputLayout.setError(getText(R.string.teleopBottomPowerCellError));
            ViewUtils.requestFocus(teleopBottomPortInputLayout, this);
        } else if (controlPanelRadiobtnGrp.getCheckedRadioButtonId() == -1) {
            ViewUtils.requestFocus(controlPanelRadiobtnGrp, this);
        } else if (climbRadiobtnGrp.getCheckedRadioButtonId() == -1) {
            ViewUtils.requestFocus(climbRadiobtnGrp, this);
        } else if (defenseRadiobtnGrp.getCheckedRadioButtonId() == -1) {
            ViewUtils.requestFocus(defenseRadiobtnGrp, this);
        } else {
            allInputsPassed = true;
        }
        if (!allInputsPassed) {
            return;
        }

        final String powerCellPickup = (powerCellPickupLoadingStationCheckBox.isChecked() ? "Loading Station" : "") +
                                    (powerCellPickupFloorCheckBox.isChecked() ? " Floor" : "");
        final RadioButton climb_Radiobtn = findViewById(climbRadiobtnGrp.getCheckedRadioButtonId());
        final RadioButton controlPanel_Radiobtn = findViewById(controlPanelRadiobtnGrp.getCheckedRadioButtonId());
        final RadioButton defense_Radiobtn = findViewById(defenseRadiobtnGrp.getCheckedRadioButtonId());

        if(PermissionUtils.getPermissions(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            if (Environment.MEDIA_MOUNTED.equals(state)) {
                File dir = new File(Environment.getExternalStorageDirectory() + "/Scouting");
                dir.mkdirs();

                File file = new File(dir, "Match" + Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID) + ".csv");

                teleopDataStringList.add(getTextInputLayoutString(teleopInnerPortInputLayout));
                teleopDataStringList.add(getTextInputLayoutString(teleopOuterPortInputLayout));
                teleopDataStringList.add(getTextInputLayoutString(teleopBottomPortInputLayout));

                if(!powerCellPickupFloorCheckBox.isChecked() && !powerCellPickupLoadingStationCheckBox.isChecked()){
                    teleopDataStringList.add("None");
                } else {
                    teleopDataStringList.add(powerCellPickup);
                }
                teleopDataStringList.add(controlPanel_Radiobtn.getText());
                teleopDataStringList.add(climb_Radiobtn.getText());
                teleopDataStringList.add(defense_Radiobtn.getText());

                teleopDataStringList.add(String.valueOf(foulsCheckBox.isChecked()));

                teleopDataStringList.add(ScouterInitialsActivity.getInitials());

//                String headers = "teamNumber, matchNumber, initiationLine, autonInner, autonOuter, autonBottom, teleopInner, teleopOuter, teleopBottom," +
//                        " pickupLocation, controlPanel, climb, defense, fouls, scouterInitials\n";

//                String message = "";
//
//                if(file.length() == 0){
//                    message = headers + auton + "," + FormatStringUtils.addDelimiter(teleopDataStringList, ",") + "\n";
//                } else{
//                    message =  auton + "," + FormatStringUtils.addDelimiter(teleopDataStringList, ",") + "\n";
//                }

                String message =  auton + "," + FormatStringUtils.addDelimiter(teleopDataStringList, ",") + "\n";

                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                    fileOutputStream.write(message.getBytes());
                    fileOutputStream.close();

                    Toast.makeText(getApplicationContext(), "Saved!", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "IOException! Go talk to the programmers!", Toast.LENGTH_LONG).show();
                    Log.d("Scouting", e.getMessage());
                }
            } else {
                Toast.makeText(getApplicationContext(), "SD card not found", Toast.LENGTH_LONG).show();
            }

            Intent intent = getIntent();
            intent.putExtra("Key", value);
            setResult(RESULT_OK, intent);

            clearData(view);
            finish();
        }

        teleopInnerPortInputLayout.setError(null);
        teleopOuterPortInputLayout.setError(null);
        teleopBottomPortInputLayout.setError(null);
    }

    /*The method will clear all the data in the text fields, checkboxes, and
    * set radio buttons to default*/
    public void clearData(View view) {
        teleopInnerPortInput.setText("" + teleopInnerPort);
        teleopOuterPortInput.setText("" + teleopOuterPort);
        teleopBottomPortInput.setText("" + teleopBottomPort);

        powerCellPickupFloorCheckBox.setChecked(false);
        powerCellPickupLoadingStationCheckBox.setChecked(false);
        foulsCheckBox.setChecked(false);

        controlPanelRadiobtnGrp.clearCheck();
        climbRadiobtnGrp.clearCheck();
        defenseRadiobtnGrp.clearCheck();
    }

    /* This method will change the text entered into the app into a string if it is not already*/
    private String getTextInputLayoutString(@NonNull TextInputLayout textInputLayout) {
        final EditText editText = textInputLayout.getEditText();
        return editText != null && editText.getText() != null ? editText.getText().toString() : "";
    }
}
