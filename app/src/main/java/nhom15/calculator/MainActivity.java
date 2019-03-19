package nhom15.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Stack;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText mEdtDauVao;
    private TextView mTvKetQua;
    private Button mBtn0;
    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private Button mBtn4;
    private Button mBtn5;
    private Button mBtn6;
    private Button mBtn7;
    private Button mBtn8;
    private Button mBtn9;
    private Button mBtnCong;
    private Button mBtnTru;
    private Button mBtnNhan;
    private Button mBtnChia;
    private Button mBtnDauCham;
    private Button mBtnMoNgoac;
    private Button mBtnDongNguoc;
    private Button mBtnBang;
    private Button mBtnXoa1KyTu;
    private Button mXoaHet;
    private Button mTinhNangCao;
    private Button mCanBacHai;
    private Button mMu;
    private Button mBtnLuuKQ;

    private String mSave ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setEventClick();

        mTinhNangCao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, nhom15.calculator.CNNangCaoActivity.class);
                startActivity(intent);
            }
        });

    }

    public void init(){
        mBtn0 = (Button)findViewById(R.id.btn_khong);
        mBtn1 = (Button)findViewById(R.id.btn_mot);
        mBtn2 = (Button)findViewById(R.id.btn_hai);
        mBtn3 = (Button)findViewById(R.id.btn_ba);
        mBtn4 = (Button)findViewById(R.id.btn_bon);
        mBtn5 = (Button)findViewById(R.id.btn_nam);
        mBtn6 = (Button)findViewById(R.id.btn_sau);
        mBtn7 = (Button)findViewById(R.id.btn_bay);
        mBtn8 = (Button)findViewById(R.id.btn_tam);
        mBtn9 = (Button)findViewById(R.id.btn_chin);
        mBtnCong = (Button)findViewById(R.id.btn_cong);
        mBtnTru = (Button)findViewById(R.id.btn_tru);
        mBtnNhan = (Button)findViewById(R.id.btn_nhan);
        mBtnChia = (Button)findViewById(R.id.btn_chia);
        mBtnDauCham = (Button)findViewById(R.id.btn_daucham);
        mBtnMoNgoac = (Button)findViewById(R.id.btn_mongoac);
        mBtnDongNguoc = (Button)findViewById(R.id.btn_dongngoac);
        mBtnBang = (Button)findViewById(R.id.btn_bang);
        mTvKetQua = (TextView)findViewById(R.id.tv_ketqua);
        mEdtDauVao = (EditText) findViewById(R.id.edt_dauvao);
        mBtnXoa1KyTu = (Button)findViewById(R.id.btn_xoatungkitu);
        mXoaHet = (Button)findViewById(R.id.btn_xoahet);
        mTinhNangCao = (Button)this.findViewById(R.id.btn_tinhnangcao);
        mCanBacHai = (Button)this.findViewById(R.id.btn_canbachai);
        mMu = (Button)this.findViewById(R.id.btn_daumu);
        mBtnLuuKQ = (Button)this.findViewById(R.id.btn_luuketqua);
    }

    public void setEventClick(){
        mBtn0.setOnClickListener(this);
        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);
        mBtn4.setOnClickListener(this);
        mBtn5.setOnClickListener(this);
        mBtn6.setOnClickListener(this);
        mBtn7.setOnClickListener(this);
        mBtn8.setOnClickListener(this);
        mBtn9.setOnClickListener(this);
        mBtnCong.setOnClickListener(this);
        mBtnTru.setOnClickListener(this);
        mBtnNhan.setOnClickListener(this);
        mBtnChia.setOnClickListener(this);
        mBtnMoNgoac.setOnClickListener(this);
        mBtnDongNguoc.setOnClickListener(this);
        mBtnBang.setOnClickListener(this);
        mBtnXoa1KyTu.setOnClickListener(this);
        mXoaHet.setOnClickListener(this);
        mCanBacHai.setOnClickListener(this);
        mMu.setOnClickListener(this);
        mBtnDauCham.setOnClickListener(this);
        mBtnLuuKQ.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_khong:
                mEdtDauVao.append("0");
                break;
            case R.id.btn_mot:
                mEdtDauVao.append("1");
                break;
            case R.id.btn_hai:
                mEdtDauVao.append("2");
                break;
            case R.id.btn_ba:
                mEdtDauVao.append("3");
                break;
            case R.id.btn_bon:
                mEdtDauVao.append("4");
                break;
            case R.id.btn_nam:
                mEdtDauVao.append("5");
                break;
            case R.id.btn_sau:
                mEdtDauVao.append("6");
                break;
            case R.id.btn_bay:
                mEdtDauVao.append("7");
                break;
            case R.id.btn_tam:
                mEdtDauVao.append("8");
                break;
            case R.id.btn_chin:
                mEdtDauVao.append("9");
                break;
            case R.id.btn_daucham:
                mEdtDauVao.append(".");
                break;
            case R.id.btn_mongoac:
                mEdtDauVao.append("(");
                break;
            case R.id.btn_dongngoac:
                mEdtDauVao.append(")");
                break;
            case R.id.btn_cong:
                mEdtDauVao.append("+");
                break;
            case R.id.btn_tru:
                mEdtDauVao.append("-");
                break;
            case R.id.btn_nhan:
                mEdtDauVao.append("*");
                break;
            case R.id.btn_chia:
                mEdtDauVao.append("/");
                break;
            case R.id.btn_canbachai:
                mEdtDauVao.append("√");
                break;
            case R.id.btn_daumu:
                mEdtDauVao.append("^");
                break;
            case R.id.btn_xoahet:
                mEdtDauVao.setText("");
                mTvKetQua.setText("");
                break;
            case R.id.btn_xoatungkitu:
                BaseInputConnection inputConnection = new BaseInputConnection(mEdtDauVao, true);
                inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.btn_bang:
            {
                String input = mEdtDauVao.getText().toString();
                Stack<String> A = KhoiTao(input);
                if(KiemTraDuLieuNhap(input)) {
                    String kq = Tinh(A);
                    mSave = kq;
                    mTvKetQua.setText(kq);
                }
                else {
                    mTvKetQua.setText("Lỗi!!!");
                }
                break;
            }
            case R.id.btn_luuketqua:
            {
                mTvKetQua.setText(mSave);
                break;
            }
        }
    }

    public static Stack<String> KhoiTao(String input) {
        int n = input.length();
        Stack<String> queueChar = new Stack<String>();
        Stack<String> Stack = new Stack<String>();

        // chuyen input vao mang A
        String[] A = new String[n];
        for(int i=0; i<n; i++) {
            A[i] = String.valueOf(input.charAt(i));
        }

        boolean flag = true;
        Pattern pattern = Pattern.compile(".*\\D.*");
        for(int i=0; i<n; i++) {
            if(!pattern.matcher(A[i]).matches()) { //la so
                String temp = "";
                if(A[0].equals("-") && flag == true && i==1) {
                    temp = "-";
                    flag = false;
                }
                temp += A[i];
                for(int j=i+1; j<n; j++) {
                    if(!pattern.matcher(A[j]).matches() || A[j].equals(".")) {
                        temp += A[j];
                        i=j;
                    }
                    else {
                        i = j;
                        break;
                    }
                }
                queueChar.push(temp);
            }

            if(A[i].equals("(")) {
                Stack.push("(");
            }
            else if(A[i].equals(")")) {
                while(!Stack.peek().equals("(")) {
                    queueChar.push(Stack.pop());
                }
                if(Stack.peek().equals("(")) {
                    Stack.pop();	// xoa "("
                }
            }
            else if(A[i].equals("^") || A[i].equals("√") || A[i].equals("+") || A[i].equals("*") || A[i].equals("/") /*|| (A[i].equals("-") && i>0)*/) {
                if(Stack.isEmpty()) {	// rong
                    Stack.push(A[i]);
                }
                else {
                    if(KTUuTien(A[i]) <= KTUuTien(Stack.peek())) {
                        queueChar.push(Stack.pop());
                    }
                    Stack.push(A[i]);
                }
            }
            else if(A[i].equals("-") && i>0){
                String temp = "";
                if(LaSo(A[i+1]) && !LaSo(A[i-1])){
                    temp = "-";
                    //temp += A[i+1];
                    for(int j=i+1; j<n; j++) {
                        if(!pattern.matcher(A[j]).matches()) {
                            temp += A[j];
                            i=j;
                        }
                        else {
                            i = j-1;
                            break;
                        }
                    }
                    queueChar.push(temp);
                }
                else {
                    if(Stack.isEmpty()) {	// rong
                        Stack.push(A[i]);
                    }
                    else {
                        if(KTUuTien(A[i]) <= KTUuTien(Stack.peek())) {
                            queueChar.push(Stack.pop());
                        }
                        Stack.push(A[i]);
                    }
                }
            }

        }

        //pop cac ptu trong Stack vao queueChar
        while(!Stack.isEmpty()) {
            queueChar.push(Stack.pop());
        }

		/*while(!queueChar.isEmpty()) {
			System.out.print(queueChar.pop()+" ");
		}*/
        return queueChar;
    }

    public static int KTUuTien(String x) {
        if(x.equals("(") || x.equals(")")) {
            return 0;
        }
        if(x.equals("+") || x.equals("-")) {
            return 1;
        }
        if(x.equals("*") || x.equals("/")) {
            return 2;
        }
        if(x.equals("√") || x.equals("^")){
            return 3;
        }
        return 4;	//chua xu ly
    }

    @SuppressWarnings("unused")
    public static boolean LaSo(String a) {
        boolean flag = true;
        try {
            float x = Float.parseFloat(a);
            flag = true;
        }
        catch (NumberFormatException ex){
            flag = false;
        }
        return flag;
    }

    public static String Tinh(Stack<String> A) {
        Stack<Double> StackTinh = new Stack<Double>();
        String dapSo="";
        int n = A.size();
        for(int i=0; i< n; i++) {
            if(LaSo(A.get(i))) {
                StackTinh.push(Double.parseDouble(A.get(i)));
            }
            else
            {
                double so1, so2, kq;
                if(A.get(i).equals("+")){
                    so1 = StackTinh.pop();
                    so2 = StackTinh.pop();
                    kq = so2 + so1;
                    StackTinh.push(kq);
                }
                else if(A.get(i).equals("-")) {
                    so1 = StackTinh.pop();
                    // nếu là phép tính trừ
                    if(LaSo(String.valueOf(StackTinh.peek()))){
                        so2 = StackTinh.pop();
                        kq = so2 - so1;
                    }
                    // nếu là dấu âm
                    else {
                        kq = -so1;
                    }
                    StackTinh.push(kq);
                }
                else if(A.get(i).equals("*")) {
                    so1 = StackTinh.pop();
                    so2 = StackTinh.pop();
                    kq = so2 * so1;
                    StackTinh.push(kq);
                }
                else if(A.get(i).equals("/")) {
                    so1 = StackTinh.pop();
                    so2 = StackTinh.pop();
                    kq = so2 / so1;
                    StackTinh.push(kq);
                }
                else if(A.get(i).equals("^")){
                    so1 = StackTinh.pop();
                    so2 = StackTinh.pop();
                    kq = Math.pow(so2, so1);
                    StackTinh.push(kq);
                }
                else if(A.get(i).equals("√")){
                    so1 = StackTinh.pop();
                    kq = Math.sqrt(so1);
                    StackTinh.push(kq);
                }
            }
        }
        while(!StackTinh.isEmpty()) {
            dapSo = StackTinh.pop().toString();
        }

        return dapSo;
    }

    // kiem tra du lieu phep tinh nhap vao co hop le ko
    protected static boolean KiemTraDuLieuNhap(String chuoi) {
        int n= chuoi.length();
        Boolean flag = true;
        if(chuoi.charAt(n-1)=='+' ||chuoi.charAt(n-1)=='-' ||chuoi.charAt(n-1)=='*' ||chuoi.charAt(n-1)=='/' ||chuoi.charAt(n-1)=='(')
        {
            flag = false;
        }
        if(chuoi.charAt(0)<48 || chuoi.charAt(0)>57)
        {
            if(chuoi.charAt(0)=='-' || chuoi.charAt(0)=='(' || chuoi.charAt(0)=='√') {
                flag = true;
            }
            else {
                flag = false;
            }

        }
        if(chuoi.charAt(0)=='+' || chuoi.charAt(0)=='*' || chuoi.charAt(0)=='/' || chuoi.charAt(0)==')') {
            flag = false;
        }
        for(int i=0;i<chuoi.length()-1;i++)
        {
            if((chuoi.charAt(i)=='+'||chuoi.charAt(i)=='-'||chuoi.charAt(i)=='*'||chuoi.charAt(i)=='/')
                    &&
                    (chuoi.charAt(i+1)=='+'||chuoi.charAt(i+1)=='-'||chuoi.charAt(i+1)=='*'||chuoi.charAt(i+1)=='/'))
            {
                flag = false;
                break;
            }
        }
        return flag;
    }


}
