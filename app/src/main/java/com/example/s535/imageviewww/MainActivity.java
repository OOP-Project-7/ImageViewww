package com.example.s535.imageviewww;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;
    CheckBox chkAgree;
    RadioGroup rGroup1;
    RadioButton rdoDog, rdoCat, rdoRab;
    Button btnOK;
    ImageView imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기");

        text1 = (TextView) findViewById(R.id.Text1);
        chkAgree = (CheckBox) findViewById(R.id.ChkAgree);

        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        rdoDog = (RadioButton) findViewById(R.id.RdoDog);
        rdoCat = (RadioButton) findViewById(R.id.RdoCat);
        rdoRab = (RadioButton) findViewById(R.id.RdoRab);

        btnOK = (Button) findViewById(R.id.BtnOK);
        imgPet = (ImageView) findViewById(R.id.ImgPet);

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                public void onCheckedChanged(CompoundButton arg0, boolean arg1) {

                                                    if (chkAgree.isChecked() == true) {
                                                        text2.setVisibility(android.view.View.VISIBLE);
                                                        rGroup1.setVisibility(android.view.View.VISIBLE);
                                                        btnOK.setVisibility(android.view.View.VISIBLE);
                                                        imgPet.setVisibility(android.view.View.VISIBLE);
                                                    } else {
                                                        text2.setVisibility(android.view.View.INVISIBLE);
                                                        rGroup1.setVisibility(android.view.View.INVISIBLE);
                                                        btnOK.setVisibility(android.view.View.INVISIBLE);
                                                        imgPet.setVisibility(android.view.View.INVISIBLE);
                                                    }
                                                }
                                            });

        btnOK.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                switch (rGroup1.getCheckedRadioButtonId()) {
                    case R.id.RdoDog:
                        imgPet.setImageResource(R.mipmap.dog);
                        break;
                    case R.id.RdoCat:
                        imgPet.setImageResource(R.mipmap.cat);
                        break;
                    case R.id.RdoRab:
                        imgPet.setImageResource(R.mipmap.rab);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "동물먼저선택", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
