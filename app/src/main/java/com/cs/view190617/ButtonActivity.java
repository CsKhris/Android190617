package com.cs.view190617;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ButtonActivity extends AppCompatActivity {
    //XML에 만들어진 View를 위한 변수
    private TextView display;
    private Button btn;
    private CheckBox bold;

    private RadioGroup colorradio;

    private RadioButton black;
    private RadioButton blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Layout File의 내용을 Memory에 Load하여 출력
        //Layout에 작성된 View 들의 설정은 이 Method 출력 이후에 해야 합니다.
        setContentView(R.layout.activity_button);

        display = (TextView)findViewById(R.id.display);
        btn = (Button)findViewById(R.id.btn);
        bold = (CheckBox)findViewById(R.id.bold);

        colorradio = (RadioGroup)findViewById(R.id.colorradio);
        black = (RadioButton)findViewById(R.id.black);
        blue = (RadioButton)findViewById(R.id.blue);

        //Button의 Event 처리
        btn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                display.setText(R.string.displaytext);
            }
        });

        //CheckBox의 Event 처리
        bold.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){
            //Event 처리 Method의 첫번째 매개변수는 Event가 발생한 객체 입니다.
            public void onCheckedChanged(CompoundButton checkBox, boolean isChecked){
                if(isChecked){
                    display.setTextSize(37);
                }else{
                    display.setTextSize(17);
                }

            }

        });

        //Radio Button은 Radio Button의 Event를 처리하지 않고
        //Radio Group의 Event를 처리하는 경우가 많습니다.

        colorradio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            //두번째 매개변수가 눌러진 Radio Button의 ID
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i){
                    case R.id.black:
                        display.setTextColor(Color.BLACK);
                        break;

                        case R.id.blue:
                           display.setTextColor(Color.BLUE);
                        break;

                        default:
                            display.setTextColor(Color.RED);
                            break;

                }

            }

        });

    }

}
