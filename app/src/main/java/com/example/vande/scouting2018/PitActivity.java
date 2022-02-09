package com.example.vande.scouting2018;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import utils.FormatStringUtils;
import utils.PermissionUtils;
import utils.StringUtils;
import utils.ViewUtils;

/**
 * Created by Matt on 9/30/2017.
 */

public class PitActivity extends AppCompatActivity implements View.OnKeyListener {
    @BindView(R.id.pit_teamNumber_input_layout)
    public TextInputLayout pitTeamNumberInputLayout;

    @BindView(R.id.pit_size_input_layout)
    public TextInputLayout pitSizeInputLayout;

    @BindView(R.id.pit_size_input)
    public TextInputEditText pitSizeInput;

    @BindView(R.id.pit_cargoHighHub_input_layout)
    public TextInputLayout pitPowerCellTopInputLayout;

    @BindView(R.id.pit_cargoBottominput_layout)
    public TextInputLayout pitPowerCellBottomInputLayout;

    @BindView(R.id.pit_weight_input_layout)
    public TextInputLayout pitWeightInputLayout;

    @BindView(R.id.pit_stormTrooperShots_input_layout)
    public TextInputLayout pitStormTrooperShotsInputLayout;

    @BindView(R.id.pit_comments_input_layout)
    public TextInputLayout pitCommentInputLayout;

    @BindView(R.id.pit_teamNumber_input)
    public TextInputEditText pitTeamNumberInput;

    @BindView(R.id.PitCargoTop_input)
    public TextInputEditText pitPowerCellTopInput;

    @BindView(R.id.pit_cargoBottom_input)
    public TextInputEditText pitPowerCellBottomInput;

    @BindView(R.id.pit_weight_input)
    public TextInputEditText pitWeightInput;

    @BindView(R.id.pit_stormTrooperShots_input)
    public TextInputEditText pitStormTrooperShotsInput;

    @BindView(R.id.pit_comments_input)
    public TextInputEditText pitCommentInput;

    @BindView(R.id.pit_teleopPreference_RadiobtnGrp)
    public RadioGroup pitTeleopPreferenceRadiobtnGrp;

    @BindView(R.id.pit_climbLevel_RadiobtnGrp)
    public RadioGroup pitControlPanelRadioGrp;

    @BindView(R.id.pit_programmingLanguage_RadiobtnGrp)
    public RadioGroup pitProgrammingLanguageRadiobtnGrp;

    @BindView(R.id.save_pit_btn)
    public Button savePitBtn;

    private ArrayList<CharSequence> pitDataStringList;
//    private ArrayList<CharSequence> headingDataStringList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pit);
        pitDataStringList = new ArrayList<>();

        ButterKnife.bind(this);

        checkForPermissions();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

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

    @Override
    protected void onResume() {
        super.onResume();

        pitTeamNumberInputLayout.setOnKeyListener(this);
        pitPowerCellTopInputLayout.setOnKeyListener(this);
        pitPowerCellBottomInputLayout.setOnKeyListener(this);
        pitWeightInputLayout.setOnKeyListener(this);
        pitStormTrooperShotsInputLayout.setOnKeyListener(this);
        pitCommentInputLayout.setOnKeyListener(this);
        pitCommentInputLayout.setOnKeyListener(this);
        pitSizeInputLayout.setOnKeyListener(this);
    }


    @Override
    protected void onPause() {
        super.onPause();

        pitTeamNumberInputLayout.setOnKeyListener(null);
        pitPowerCellTopInputLayout.setOnKeyListener(null);
        pitPowerCellBottomInputLayout.setOnKeyListener(null);
        pitWeightInputLayout.setOnKeyListener(null);
        pitStormTrooperShotsInputLayout.setOnKeyListener(null);
        pitCommentInputLayout.setOnKeyListener(null);
        pitSizeInputLayout.setOnKeyListener(null);

    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {

        if (keyCode != KeyEvent.KEYCODE_SPACE && keyCode != KeyEvent.KEYCODE_TAB) {
            TextInputEditText inputEditText = (TextInputEditText) v;

            if (inputEditText != null) {

                switch (inputEditText.getId()) {

                    case R.id.pit_teamNumber_input:
                        pitTeamNumberInputLayout.setError(null);
                        break;

                    case R.id.PitCargoTop_input:
                        pitPowerCellTopInputLayout.setError(null);
                        break;

                    case R.id.pit_cargoBottom_input:
                        pitPowerCellBottomInputLayout.setError(null);
                        break;

                    case R.id.pit_weight_input:
                        pitWeightInputLayout.setError(null);
                        break;

                    case R.id.pit_stormTrooperShots_input:
                        pitStormTrooperShotsInputLayout.setError(null);
                        break;
                    case R.id.pit_size_input_layout:
                        pitSizeInputLayout.setError(null);
                        break;
                }
            }
        }
        return false;
    }

    public void savePitData(View view) throws IOException {
        String state = Environment.getExternalStorageState();
        boolean allInputsPassed = false;

        if (StringUtils.isEmptyOrNull(getTextInputLayoutString(pitTeamNumberInputLayout)) || Integer.valueOf(getTextInputLayoutString(pitTeamNumberInputLayout)) == 0) {
            pitTeamNumberInputLayout.setError(getText(R.string.pitTeamNumberError));
            ViewUtils.requestFocus( pitTeamNumberInputLayout, this);
        } else if (pitTeleopPreferenceRadiobtnGrp.getCheckedRadioButtonId() == -1) {
            ViewUtils.requestFocus(pitTeleopPreferenceRadiobtnGrp, this);
        } else if (StringUtils.isEmptyOrNull(getTextInputLayoutString(pitPowerCellTopInputLayout))) {
            pitPowerCellTopInputLayout.setError(getText(R.string.pitPowerCellTopError));
            ViewUtils.requestFocus(pitPowerCellTopInputLayout, this);
        } else if (StringUtils.isEmptyOrNull(getTextInputLayoutString(pitPowerCellBottomInputLayout))) {
            pitPowerCellBottomInputLayout.setError(getText(R.string.pitPowerCellBottomError));
            ViewUtils.requestFocus(pitPowerCellBottomInputLayout, this);
        } else if (pitControlPanelRadioGrp.getCheckedRadioButtonId() == -1) {
            ViewUtils.requestFocus(pitControlPanelRadioGrp, this);
        } else if (pitProgrammingLanguageRadiobtnGrp.getCheckedRadioButtonId() == -1) {
            ViewUtils.requestFocus(pitProgrammingLanguageRadiobtnGrp, this);
        } else if (StringUtils.isEmptyOrNull(getTextInputLayoutString(pitWeightInputLayout))) {
            pitWeightInputLayout.setError(getText(R.string.pitWeightError));
            ViewUtils.requestFocus(pitWeightInputLayout, this);
        } else if (StringUtils.isEmptyOrNull(getTextInputLayoutString(pitStormTrooperShotsInputLayout))) {
            pitStormTrooperShotsInputLayout.setError(getText(R.string.pitStormTrooperShotsError));
            ViewUtils.requestFocus(pitStormTrooperShotsInputLayout, this);
        } else if (StringUtils.isEmptyOrNull(getTextInputLayoutString(pitSizeInputLayout))) {
            pitSizeInputLayout.setError(getText(R.string.pitSizeError));
            ViewUtils.requestFocus(pitSizeInputLayout, this);
        } else {
            allInputsPassed = true;
        }
        if (!allInputsPassed) {
            return;
        }

        //final RadioButton pitStaring_Radiobtn = findViewById(pitStartingPositionRadiobtnGrp.getCheckedRadioButtonId());

        final RadioButton pitTeleopPreference_Radiobtn = findViewById(pitTeleopPreferenceRadiobtnGrp.getCheckedRadioButtonId());
        final RadioButton pitControlPanel_Radiobtn = findViewById(pitControlPanelRadioGrp.getCheckedRadioButtonId());
        final RadioButton pitProgrammingLanguage_Radiobtn = findViewById(pitProgrammingLanguageRadiobtnGrp.getCheckedRadioButtonId());

        if(PermissionUtils.getPermissions(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            if (Environment.MEDIA_MOUNTED.equals(state)) {
                File dir = new File(Environment.getExternalStorageDirectory() + "/Scouting");
                //create csv file
                File file = new File(dir, "Pit" + Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID) + ".csv");

                pitDataStringList.add(getTextInputLayoutString(pitTeamNumberInputLayout));

                pitDataStringList.add(pitTeleopPreference_Radiobtn.getText());
                pitDataStringList.add(getTextInputLayoutString(pitPowerCellTopInputLayout));
                pitDataStringList.add(getTextInputLayoutString(pitPowerCellBottomInputLayout));
                pitDataStringList.add(pitControlPanel_Radiobtn.getText());
                pitDataStringList.add(pitProgrammingLanguage_Radiobtn.getText());
                pitDataStringList.add(getTextInputLayoutString(pitWeightInputLayout));
                pitDataStringList.add(getTextInputLayoutString(pitStormTrooperShotsInputLayout));
                pitDataStringList.add(getTextInputLayoutString(pitCommentInputLayout));
                pitDataStringList.add(getTextInputLayoutString(pitSizeInputLayout));


                String message = FormatStringUtils.addDelimiter(pitDataStringList, ",") + "\n";


                //Output data to file
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

            clearData();
            pitTeamNumberInput.requestFocus();
        }

        pitDataStringList.clear();

        pitTeamNumberInputLayout.setError(null);
        pitPowerCellTopInputLayout.setError(null);
        pitPowerCellBottomInputLayout.setError(null);
        pitWeightInputLayout.setError(null);
        pitStormTrooperShotsInputLayout.setError(null);
        pitSizeInputLayout.setError(null);
    }

    public void takePhoto(View view) {
        String name = getTextInputLayoutString(pitTeamNumberInputLayout);

        if(PermissionUtils.getPermissions(this, Manifest.permission.CAMERA) &&
                PermissionUtils.getPermissions(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) &&
                PermissionUtils.getPermissions(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            if (!StringUtils.isEmptyOrNull(name)) {
                File dir = new File(Environment.getExternalStorageDirectory() + "/Scouting/Photos");
                dir.mkdirs();

                File file = new File(dir, name + ".jpg");

                try {
                    file.createNewFile();
                } catch (IOException e) {
                    Log.d("Scouting", e.getMessage());
                }

                Uri outputUri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".provider", file);

                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputUri);
                    startActivityForResult(takePictureIntent, 0);
                }
            } else {
                pitTeamNumberInputLayout.setError(getText(R.string.pitTeamNumberError));
                ViewUtils.requestFocus(pitTeamNumberInputLayout, this);
            }
        } else {
            checkForPermissions();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {
            if(resultCode == RESULT_OK) {
                compressPhoto();
            }
        }
    }

    private void compressPhoto() {
        try {
            String name = getTextInputLayoutString(pitTeamNumberInputLayout);

            File dir = new File(Environment.getExternalStorageDirectory() + "/Scouting/Photos");
            File file = new File(dir, name + ".jpg");

            FileInputStream inputStream = new FileInputStream(file);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 25, out);

            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(out.toByteArray());
            inputStream.close();
            out.close();
            outputStream.close();

            Toast.makeText(this, "Photo taken!", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Log.d("Scouting", e.getMessage());
            Toast.makeText(this, "Failed to save photo. Try again!", Toast.LENGTH_LONG).show();
        }
    }

    public void clearData() {
        pitTeamNumberInput.setText("");

        pitTeleopPreferenceRadiobtnGrp.clearCheck();

        pitPowerCellTopInput.setText("");
        pitPowerCellBottomInput.setText("");

        pitControlPanelRadioGrp.clearCheck();
        pitProgrammingLanguageRadiobtnGrp.clearCheck();

        pitWeightInput.setText("");
        pitSizeInput.setText("");
        pitStormTrooperShotsInput.setText("");
        pitCommentInput.setText("");
    }

    private void checkForPermissions() {
        int cameraPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (cameraPermission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
        }
    }

    private String getTextInputLayoutString(@NonNull TextInputLayout textInputLayout) {
        final EditText editText = textInputLayout.getEditText();
        return editText != null && editText.getText() != null ? editText.getText().toString() : "";
    }
}
