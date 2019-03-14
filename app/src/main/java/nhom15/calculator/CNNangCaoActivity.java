package nhom15.calculator;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.math.BigDecimal;

import nhom15.calculator.MainActivity;
import nhom15.calculator.R;

public class CNNangCaoActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnBack, mBtnDoDai, mBtnKhoiLuong, mBtnThoiGian, mBtnAC, btnC, mBtnSo9, mBtnSo8, mBtnSo7, mBtnSo6,
            mBtnSo5, mBtnSo4, mBtnSo3, mBtnSo2, mBtnSo1, mBtnSo0, mBtnDauCham;

    private TextView mTvInputTextLenght1, mTvOutputTextLenghtResult;

    private RadioGroup mRdgroupTren, mRdgroupDuoi;
    private String inputvalue = "";
    //type: xác định đổi loại nào trong 3 loại:
    // type = 0 : độ dài, type=1  khối lượng, type = 2 : thời gian
    private int mType = 0;
    private double mHeso = 1000;
    //kiểm tra nhập dấu chấm
    private boolean mCheckdot = false;
    private RadioButton mRdbtnKMDuoi, mRdbtnMDuoi, mRdbtnCMDuoi, mRdbtnKM, mRdbtnM, mRdbtnCM;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cnnangcao);

        khoiTao();
        setEventClickView();

        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CNNangCaoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mRdgroupTren.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                doiheso();
            }
        });

        mRdgroupDuoi.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                doiheso();
            }
        });
    }

    public void khoiTao() {
        mBtnDoDai = (Button) this.findViewById(R.id.btn_DoDai);
        mBtnKhoiLuong = (Button) this.findViewById(R.id.btn_KhoiLuong);
        mBtnThoiGian = (Button) this.findViewById(R.id.btn_ThoiGian);

        mRdgroupTren = (RadioGroup) this.findViewById(R.id.rdgroup_tren);
        mRdgroupDuoi = (RadioGroup) this.findViewById(R.id.rdgroup_duoi);
        mRdbtnKMDuoi = (RadioButton) this.findViewById(R.id.rdbtn_KMDuoi);
        mRdbtnMDuoi = (RadioButton) this.findViewById(R.id.rdbtn_MDuoi);
        mRdbtnCMDuoi = (RadioButton) this.findViewById(R.id.rdbtn_CMDuoi);
        mRdbtnKM = (RadioButton) this.findViewById(R.id.rdbtn_KM);
        mRdbtnM = (RadioButton) this.findViewById(R.id.rdbtn_M);
        mRdbtnCM = (RadioButton) this.findViewById(R.id.rdbtn_CM);

        mBtnBack = (Button) this.findViewById(R.id.btn_Back);

        mBtnSo0 = (Button) this.findViewById(R.id.btn_So0);
        mBtnSo1 = (Button) this.findViewById(R.id.btn_So1);
        mBtnSo2 = (Button) this.findViewById(R.id.btn_So2);
        mBtnSo3 = (Button) this.findViewById(R.id.btn_So3);
        mBtnSo4 = (Button) this.findViewById(R.id.btn_So4);
        mBtnSo5 = (Button) this.findViewById(R.id.btn_So5);
        mBtnSo6 = (Button) this.findViewById(R.id.btn_So6);
        mBtnSo7 = (Button) this.findViewById(R.id.btn_So7);
        mBtnSo8 = (Button) this.findViewById(R.id.btn_So8);
        mBtnSo9 = (Button) this.findViewById(R.id.btn_So9);

        mBtnDauCham = (Button) this.findViewById(R.id.btn_DauCham);
        mBtnAC = (Button) this.findViewById(R.id.btn_AC);
        btnC = (Button) this.findViewById(R.id.btn_C);

        mTvInputTextLenght1 = (TextView) this.findViewById(R.id.tv_InputTextLenght1);

        mTvOutputTextLenghtResult = (TextView) this.findViewById(R.id.tv_OutputTextLenghtResult);

    }
    //cho cac view lang nghe sự kiện ssetEventClickView
    public void setEventClickView() {
        mBtnDoDai.setOnClickListener(this);
        mBtnKhoiLuong.setOnClickListener(this);
        mBtnThoiGian.setOnClickListener(this);

        mBtnSo0.setOnClickListener(this);
        mBtnSo1.setOnClickListener(this);
        mBtnSo2.setOnClickListener(this);
        mBtnSo3.setOnClickListener(this);
        mBtnSo4.setOnClickListener(this);
        mBtnSo5.setOnClickListener(this);
        mBtnSo6.setOnClickListener(this);
        mBtnSo7.setOnClickListener(this);
        mBtnSo8.setOnClickListener(this);
        mBtnSo9.setOnClickListener(this);

        mBtnDauCham.setOnClickListener(this);
        mBtnAC.setOnClickListener(this);
        btnC.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_KhoiLuong:
                clickButtonKhoiLuong();
                break;
            case R.id.btn_ThoiGian:
                clickButtonThoiGian();
                break;
            case R.id.btn_DoDai:
                clickButtonDoDai();
                break;
            case R.id.btn_AC:
                mTvInputTextLenght1.setText("");
                mTvOutputTextLenghtResult.setText("");
                inputvalue = "";
                mTvInputTextLenght1.setHint("000");
                mTvOutputTextLenghtResult.setHint("000");
                break;
            case R.id.btn_C:
                //  BaseInputConnection textInputConnection = new BaseInputConnection(tvInputTextLenght1,true);
                //textInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                if(!inputvalue.equals("")) {
                    String kytu = LayChuoi(mTvInputTextLenght1.getText().toString());
                    inputvalue = LayChuoi(inputvalue);
                    mTvInputTextLenght1.setText(kytu);
                    resultnc();
                }
                break;
            case R.id.btn_So0:
                mTvInputTextLenght1.append("0");
                inputvalue += "0";
                resultnc();

                break;
            case R.id.btn_So1:
                mTvInputTextLenght1.append("1");
                inputvalue += "1";
                resultnc();
                break;
            case R.id.btn_So2:
                mTvInputTextLenght1.append("2");
                inputvalue += "2";
                resultnc();
                break;
            case R.id.btn_So3:
                mTvInputTextLenght1.append("3");
                inputvalue += "3";
                resultnc();
                break;
            case R.id.btn_So4:
                mTvInputTextLenght1.append("4");
                inputvalue += "4";
                resultnc();
                break;
            case R.id.btn_So5:
                mTvInputTextLenght1.append("5");
                inputvalue += "5";
                resultnc();
                break;
            case R.id.btn_So6:
                mTvInputTextLenght1.append("6");
                inputvalue += "6";
                resultnc();
                break;
            case R.id.btn_So7:
                mTvInputTextLenght1.append("7");
                inputvalue += "7";
                resultnc();
                break;
            case R.id.btn_So8:
                mTvInputTextLenght1.append("8");
                inputvalue += "8";
                resultnc();
                break;
            case R.id.btn_So9:
                mTvInputTextLenght1.append("9");
                inputvalue += "9";
                resultnc();
                break;
            case R.id.btn_DauCham:
                if(!mCheckdot) {
                    mTvInputTextLenght1.append(".");
                    inputvalue += ".";
                    mCheckdot = true;
                }
                break;


        }
    }
    //khi click vào Button Độ dài
    public void clickButtonDoDai()
    {
        mRdbtnCM.setVisibility(View.VISIBLE);
        mRdbtnCMDuoi.setVisibility(View.VISIBLE);
        mBtnDoDai.setBackgroundResource(R.drawable.nen);
        mBtnThoiGian.setBackgroundResource(R.drawable.nentrang);
        mBtnKhoiLuong.setBackgroundResource(R.drawable.nentrang);
        mBtnKhoiLuong.setTypeface(null, Typeface.NORMAL);
        mBtnDoDai.setTypeface(null, Typeface.BOLD);
        mBtnThoiGian.setTypeface(null, Typeface.NORMAL);
        mRdbtnKM.setChecked(true);
        mRdbtnMDuoi.setChecked(true);
        mRdbtnKM.setText("km");
        mRdbtnM.setText("m");
        mRdbtnCM.setText("cm");
        mRdbtnKMDuoi.setText("km");
        mRdbtnMDuoi.setText("m");
        mRdbtnCMDuoi.setText("cm");
        mTvInputTextLenght1.setText("");
        mTvOutputTextLenghtResult.setText("");
        inputvalue = "";
        mTvInputTextLenght1.setHint("000");
        mTvOutputTextLenghtResult.setHint("000");
        mHeso = 1000;
        //type: xác định đổi loại nào trong 3 loại:
        // type = 0 : độ dài, type=1  khối lượng, type = 2 : thời gian
        mType = 0;
    }
    //khi click vào button Khối lượng
    public void clickButtonKhoiLuong()
    {
        mRdgroupTren.setVisibility(View.VISIBLE);
        mRdgroupDuoi.setVisibility(View.VISIBLE);
        mBtnKhoiLuong.setBackgroundResource(R.drawable.nen);
        mBtnThoiGian.setBackgroundResource(R.drawable.nentrang);
        mBtnDoDai.setBackgroundResource(R.drawable.nentrang);
        mBtnKhoiLuong.setTypeface(null, Typeface.BOLD);
        mBtnDoDai.setTypeface(null, Typeface.NORMAL);
        mBtnThoiGian.setTypeface(null, Typeface.NORMAL);
        mRdbtnKM.setChecked(true);
        mRdbtnMDuoi.setChecked(true);
        mRdbtnKM.setText("kg");
        mRdbtnM.setText("g");
        mRdbtnCM.setVisibility(View.INVISIBLE);
        mRdbtnKMDuoi.setText("kg");
        mRdbtnMDuoi.setText("g");
        mRdbtnCMDuoi.setVisibility(View.INVISIBLE);
        //type: xác định đổi loại nào trong 3 loại:
        // type = 0 : độ dài, type=1  khối lượng, type = 2 : thời gian
        mType = 1;
        mTvInputTextLenght1.setText("");
        mTvOutputTextLenghtResult.setText("");
        inputvalue = "";
        mTvInputTextLenght1.setHint("000");
        mTvOutputTextLenghtResult.setHint("000");
        mHeso = 1000;
    }
    //khi click vào button Thời gian
    public void clickButtonThoiGian()
    {
        mRdbtnCM.setVisibility(View.VISIBLE);
        mRdbtnCMDuoi.setVisibility(View.VISIBLE);
        mBtnThoiGian.setBackgroundResource(R.drawable.nen);
        mBtnDoDai.setBackgroundResource(R.drawable.nentrang);
        mBtnKhoiLuong.setBackgroundResource(R.drawable.nentrang);
        mBtnKhoiLuong.setTypeface(null, Typeface.NORMAL);
        mBtnDoDai.setTypeface(null, Typeface.NORMAL);
        mBtnThoiGian.setTypeface(null, Typeface.BOLD);
        mRdbtnKM.setChecked(true);
        mRdbtnMDuoi.setChecked(true);
        mRdbtnKM.setText("giờ");
        mRdbtnM.setText("phút");
        mRdbtnCM.setText("giây");
        mRdbtnKMDuoi.setText("giờ");
        mRdbtnMDuoi.setText("phút");
        mRdbtnCMDuoi.setText("giây");
        mType = 2;
        mTvInputTextLenght1.setText("");
        mTvOutputTextLenghtResult.setText("");
        inputvalue = "";
        mTvInputTextLenght1.setHint("000");
        mTvOutputTextLenghtResult.setHint("000");
        mHeso = 60;
    }
    //hàm settext cho textview result
    public void resultnc() {

        if(!inputvalue.contains("."))
            mCheckdot = false;
        if (inputvalue.equals("")) {
            mTvOutputTextLenghtResult.setText("");
            mTvOutputTextLenghtResult.setHint("000");
        } else {

            double result = Double.parseDouble(inputvalue) * mHeso;
            mTvOutputTextLenghtResult.setText(parseToCientificNotation(result));
        }
    }

    //hàm đổi hệ số khi click vào các radion button
    public void doiheso()
    {
        switch (mType) {
            case 0:
                if (mRdbtnKM.isChecked()) {
                    if (mRdbtnKMDuoi.isChecked())
                        mHeso = 1;
                    if (mRdbtnMDuoi.isChecked())
                        mHeso = 1000;
                    if (mRdbtnCMDuoi.isChecked())
                        mHeso = 100000;
                }
                if (mRdbtnM.isChecked()) {
                    if (mRdbtnKMDuoi.isChecked())
                        mHeso = 0.001;
                    if (mRdbtnMDuoi.isChecked())
                        mHeso = 1;
                    if (mRdbtnCMDuoi.isChecked())
                        mHeso = 100;
                }
                if (mRdbtnCM.isChecked()) {
                    if (mRdbtnKMDuoi.isChecked())
                        mHeso = 0.00001;
                    if (mRdbtnMDuoi.isChecked())
                        mHeso = 0.01;
                    if (mRdbtnCMDuoi.isChecked())
                        mHeso = 1;
                }
                resultnc();
                break;
            case 1:
                if (mRdbtnKM.isChecked()) {
                    if (mRdbtnKMDuoi.isChecked())
                        mHeso = 1;
                    if (mRdbtnMDuoi.isChecked())
                        mHeso = 1000;
                }
                if (mRdbtnM.isChecked()) {
                    if (mRdbtnKMDuoi.isChecked())
                        mHeso = 0.001;
                    if (mRdbtnMDuoi.isChecked())
                        mHeso = 1;
                }
                resultnc();
                break;
            case 2:
                if (mRdbtnKM.isChecked()) {
                    if (mRdbtnKMDuoi.isChecked())
                        mHeso = 1;
                    if (mRdbtnMDuoi.isChecked())
                        mHeso = 60;
                    if (mRdbtnCMDuoi.isChecked())
                        mHeso = 3600;
                }
                if (mRdbtnM.isChecked()) {
                    if (mRdbtnKMDuoi.isChecked())
                        mHeso = 0.01666666666;
                    if (mRdbtnMDuoi.isChecked())
                        mHeso = 1;
                    if (mRdbtnCMDuoi.isChecked())
                        mHeso = 60;
                }
                if (mRdbtnCM.isChecked()) {
                    if (mRdbtnKMDuoi.isChecked())
                        mHeso = 0.00027777777;
                    if (mRdbtnMDuoi.isChecked())
                        mHeso = 0.01666666666;
                    if (mRdbtnCMDuoi.isChecked())
                        mHeso = 1;
                }
                resultnc();
                break;

        }
    }
    //hàm lấy chuỗi trừ ký tự cuối cùng
    public String LayChuoi(String number) {
        int a = number.length();
        String chuoi = number.substring(0, a - 1);
        return chuoi;
    }

    public static String parseToCientificNotation(double result) {
        DecimalFormat df = new DecimalFormat("#.#######");
        BigDecimal a = new BigDecimal(result);
        return df.format(a);
    }
}
