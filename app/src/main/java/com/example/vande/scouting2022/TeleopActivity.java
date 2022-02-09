package com.example.vande.scouting2022;

import android.Manifest;
import android.os.Environment;

import android.provider.MediaStore;
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
import android.view.ViewGroup;
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

import static android.R.attr.checkedButton;
import static android.R.attr.value;
import static com.example.vande.scouting2022.AutonActivity.AUTON_STRING_EXTRA;
import static com.example.vande.scouting2022.AutonActivity.MATCH_STRING_EXTRA;
import static com.example.vande.scouting2022.AutonActivity.TEAMNUMBER_STRING_EXTRA;

import com.whygraphics.multilineradiogroup.MultiLineRadioGroup;


public class TeleopActivity extends AppCompatActivity implements View.OnKeyListener {
    /*This area sets and binds all of the variables that we will use in the auton activity*/

    @BindView(R.id.DefenseTeam_input_layout)
    public TextInputLayout DefenseTeaminputlayout;

    @BindView(R.id.DefenseTeam_input)
    public TextInputEditText DefenseTeaminput;

    @BindView(R.id.teleopHighHub_input_layout)
    public TextInputLayout teleopHighHubinputlayout;

    @BindView(R.id.teleopLowHub_input_layout)
    public TextInputLayout teleopLowHubinputlayout;

   // @BindView(R.id.teleopBottomPort_input_layout)
   // public TextInputLayout teleopBottomPortInputLayout;

    @BindView(R.id.HighHubPort_input)
    public TextInputEditText HighHubPortinput;

    @BindView(R.id.teleopLowHub_input)
    public TextInputEditText teleopLowHub_input;

  //  @BindView(R.id.teleopBottomPort_input)
  //  public TextInputEditText teleopBottomPortInput;

    @BindView(R.id.Fixed_checkBox)
    public CheckBox FixedcheckBox;

    @BindView(R.id.Variable_checkBox)
    public CheckBox VariablecheckBox;

    @BindView(R.id.fouls_checkBox)
    public CheckBox foulsCheckBox;

   @BindView(R.id.climberRung_MultiRadiobtnGrp)
   public RadioGroup climberRungRadiobtnGrp;

    @BindView(R.id.speed_RadiobtnGrp)
    public RadioGroup speedRadiobtnGrp;

   // @BindView(R.id.climberRung_RadiobtnGrp)
  //  public RadioGroup climberRungRadiobtnGrp;

    @BindView(R.id.defense_RadiobtnGrp)
    public RadioGroup defenseRadiobtnGrp;

    @BindView(R.id.speedofrobotClimbingnGrp)
    public RadioGroup speedclimbRadiobtnGrp;

    @BindView(R.id.save_btn)
    public Button saveBtn;

    int teleopHighHub = 0;
    int teleopLowHub = 0;
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

        displayHighHubInput(teleopHighHub);
        displayLowHubInput(teleopLowHub);

    }

    /*If this activity is resumed from a paused state the data
     *will be set to what they previously were set to
     */
    @Override
    protected void onResume() {
        super.onResume();

        HighHubPortinput.setOnKeyListener(this);
        teleopLowHub_input.setOnKeyListener(this);
        DefenseTeaminput.setOnKeyListener(this);
    }

    /*If this activity enters a paused state the data will be set to null*/
    @Override
    protected void onPause() {
        super.onPause();

        HighHubPortinput.setOnKeyListener(null);
        teleopLowHub_input.setOnKeyListener(null);
        DefenseTeaminput.setOnKeyListener(null);
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
    public void decrease_HighHubInput(View view) {
        if (teleopHighHub != 0) {
            teleopHighHub -= 1;
            displayHighHubInput(teleopHighHub);
        } else {
        }
    }

    public void increase_HighHubInput(View view) {
        teleopHighHub += 1;
        displayHighHubInput(teleopHighHub);
    }

    private void displayHighHubInput(int number) {
        HighHubPortinput.setText("" + number);
    }

    //Teleop outer power cell score
    public void decreaseTeleopLowHubInput(View view) {
        if (teleopLowHub != 0) {
            teleopLowHub -= 1;
            displayLowHubInput(teleopLowHub);
        } else {
        }
    }

    public void increaseTeleopLowHubInput(View view) {
        teleopLowHub += 1;
        displayLowHubInput(teleopLowHub);

    }


    private void displayLowHubInput(int number) {
        teleopLowHub_input.setText("" + number);
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

                    case R.id.HighHubPort_input:
                        teleopHighHubinputlayout.setError(null);
                        break;

                    case R.id.teleopLowHub_input:
                        teleopLowHubinputlayout.setError(null);
                        break;

                    case R.id.DefenseTeam_input:
                        DefenseTeaminputlayout.setError(null);
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

//        if (StringUtils.isEmptyOrNull(getTextInputLayoutString(teleopHighHubinputlayout))) {
//            teleopHighHubinputlayout.setError(getText(R.string.teleopInnerPowerCellError));
//            ViewUtils.requestFocus(teleopHighHubinputlayout, this);
//        } else if (StringUtils.isEmptyOrNull(getTextInputLayoutString(teleopLowHubinputlayout))) {
//            teleopLowHubinputlayout.setError(getText(R.string.teleopOuterPowerCellError));
//            ViewUtils.requestFocus(teleopLowHubinputlayout, this);
//        } else if (StringUtils.isEmptyOrNull(getTextInputLayoutString(DefenseTeaminputlayout))) {
//            DefenseTeaminputlayout.setError(getText(R.string.teleopBottomPowerCellError));
//           ViewUtils.requestFocus(DefenseTeaminputlayout, this);
//       } else if (speedclimbRadiobtnGrp.getCheckedRadioButtonId() == -1) {
//            ViewUtils.requestFocus(speedclimbRadiobtnGrp, this);
//
//        } else if (climberRungRadiobtnGrp.getCheckedRadioButtonId() == -1) {
//            ViewUtils.requestFocus(climberRungRadiobtnGrp, this);
//        } else if (defenseRadiobtnGrp.getCheckedRadioButtonId() == -1) {
//            ViewUtils.requestFocus(defenseRadiobtnGrp, this);
//        } else {
//            allInputsPassed = true;
//        }
//        if (!allInputsPassed) {
//            return;
//        }

        MultiLineRadioGroup mMultiLineRadioGroup = (MultiLineRadioGroup) findViewById(R.id.climberRung_MultiRadiobtnGrp);

        final String cargoPickupLocation = (FixedcheckBox.isChecked() ? "Loading Station" : "") +
                                    (VariablecheckBox.isChecked() ? " Floor" : "");
        final RadioButton climb_Radiobtn = (RadioButton) findViewById(mMultiLineRadioGroup.getCheckedRadioButtonId());
       final RadioButton speed_climbRadiobtn = findViewById(speedclimbRadiobtnGrp.getCheckedRadioButtonId());
        final RadioButton defense_Radiobtn = findViewById(defenseRadiobtnGrp.getCheckedRadioButtonId());


        if(PermissionUtils.getPermissions(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            if (Environment.MEDIA_MOUNTED.equals(state)) {
                File dir = new File(Environment.getExternalStorageDirectory() + "/Scouting");
                dir.mkdirs();

                File file = new File(dir, "Match" + Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID) + ".csv");

                teleopDataStringList.add(getTextInputLayoutString(teleopHighHubinputlayout));
                teleopDataStringList.add(getTextInputLayoutString(teleopLowHubinputlayout));
                teleopDataStringList.add(getTextInputLayoutString(DefenseTeaminputlayout));

                if(!VariablecheckBox.isChecked() && !FixedcheckBox.isChecked()){
                    teleopDataStringList.add("None");
                } else {
                    teleopDataStringList.add(cargoPickupLocation);
                }

                teleopDataStringList.add(speed_climbRadiobtn.getText());
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

        teleopHighHubinputlayout.setError(null);
        teleopLowHubinputlayout.setError(null);
        DefenseTeaminputlayout.setError(null);
    }

    /*The method will clear all the data in the text fields, checkboxes, and
    * set radio buttons to default*/
    public void clearData(View view) {
        HighHubPortinput.setText("" + teleopHighHub);
        teleopLowHub_input.setText("" + teleopLowHub);
        DefenseTeaminput.setText("");

        VariablecheckBox.setChecked(false);
        FixedcheckBox.setChecked(false);
        foulsCheckBox.setChecked(false);

        speedclimbRadiobtnGrp.clearCheck();
        climberRungRadiobtnGrp.clearCheck();
        defenseRadiobtnGrp.clearCheck();
    }

    /* This method will change the text entered into the app into a string if it is not already*/
    private String getTextInputLayoutString(@NonNull TextInputLayout textInputLayout) {
        final EditText editText = textInputLayout.getEditText();
        return editText != null && editText.getText() != null ? editText.getText().toString() : "";
    }
}
