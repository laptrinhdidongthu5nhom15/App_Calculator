package nhom15.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mTvDauVao;
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
    private Button mBtnMoNgoac;
    private Button mBtnDongNguoc;
    private Button mBtnBang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setEventClick();

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
        mBtnMoNgoac = (Button)findViewById(R.id.btn_mongoac);
        mBtnDongNguoc = (Button)findViewById(R.id.btn_dongngoac);
        mBtnBang = (Button)findViewById(R.id.btn_bang);
        mTvKetQua = (TextView)findViewById(R.id.tv_ketqua);
        mTvDauVao = (TextView)findViewById(R.id.tv_dauvao);
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
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_khong:
                mTvDauVao.append("0");
            case R.id.btn_mot:
                mTvDauVao.append("1");
            case R.id.btn_hai:
                mTvDauVao.append("2");
            case R.id.btn_ba:
                mTvDauVao.append("3");
            case R.id.btn_bon:
                mTvDauVao.append("4");
            case R.id.btn_nam:
                mTvDauVao.append("5");
            case R.id.btn_sau:
                mTvDauVao.append("6");
            case R.id.btn_bay:
                mTvDauVao.append("7");
            case R.id.btn_tam:
                mTvDauVao.append("8");
            case R.id.btn_chin:
                mTvDauVao.append("9");
            case R.id.btn_mongoac:
                mTvDauVao.append("(");
            case R.id.btn_dongngoac:
                mTvDauVao.append(")");
            case R.id.btn_cong:
                mTvDauVao.append("+");
            case R.id.btn_tru:
                mTvDauVao.append("-");
            case R.id.btn_nhan:
                mTvDauVao.append("*");
            case R.id.btn_chia:
                mTvDauVao.append("/");
            case R.id.btn_bang:
            {
                String input = mTvDauVao.getText().toString();
                Stack<String> A = KhoiTao(input);
                if(KiemTraDuLieuNhap(input)) {
                    String kq = Tinh(A);
                    mTvKetQua.setText(kq);
                }
                else {
                    mTvKetQua.setText("input không hợp lệ");
                }
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
                if(A[0].equals("-") && flag == true) {
                    temp = "-";
                    flag = false;
                }
                temp += A[i];
                for(int j=i+1; j<n; j++) {
                    if(!pattern.matcher(A[j]).matches()) {
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

            else if(A[i].equals("+") || A[i].equals("*") || A[i].equals("/") || (A[i].equals("-") && i>0)) {
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
        return 3;	//dau am
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
        Stack<Float> StackTinh = new Stack<Float>();
        String dapSo="";
        int n = A.size();
        for(int i=0; i< n; i++) {
            if(LaSo(A.get(i))) {
                StackTinh.push(Float.parseFloat(A.get(i)));
            }
            else
            {
                float so1, so2, kq;
                if(A.get(i).equals("+")){
                    so1 = StackTinh.pop();
                    so2 = StackTinh.pop();
                    kq = so2 + so1;
                    StackTinh.push(kq);
                }
                else if(A.get(i).equals("-")) {
                    so1 = StackTinh.pop();
                    so2 = StackTinh.pop();
                    kq = so2 - so1;
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
            }
        }
        while(!StackTinh.isEmpty()) {
            System.out.print("kq=");
            dapSo = StackTinh.pop().toString();
        }

        return dapSo;
    }

    // thuy
    protected static boolean KiemTraDuLieuNhap(String chuoi) {
        int n= chuoi.length();
        Boolean flag = true;
        if(chuoi.charAt(n-1)=='+' ||chuoi.charAt(n-1)=='-' ||chuoi.charAt(n-1)=='*' ||chuoi.charAt(n-1)=='/' ||chuoi.charAt(n-1)=='(')
        {
            flag = false;
        }
        if(chuoi.charAt(0)<48 || chuoi.charAt(0)>57)
        {
            if(chuoi.charAt(0)=='-') {
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
            if((chuoi.charAt(i)=='+'||chuoi.charAt(i)=='-'||chuoi.charAt(i)=='*'||chuoi.charAt(i)=='/')&&
                    (chuoi.charAt(i+1)=='+'||chuoi.charAt(i+1)=='-'||chuoi.charAt(i+1)=='*'||chuoi.charAt(i+1)=='/'))
            {
                flag = false;
                break;
            }

        }
        return flag;
    }

}
