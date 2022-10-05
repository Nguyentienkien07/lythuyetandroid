package com.example.ntk_ltbai6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnXacnhan;
    EditText edtUser, edtPas;
    CheckBox cbRemember;
    SharedPreferences sharedPreferences;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();

        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);

        //lay gia tri sharedPreferences
        edtUser.setText((sharedPreferences.getString("taikhoan", "")));
        edtPas.setText(sharedPreferences.getString("matkhau",""));
        cbRemember.setChecked(sharedPreferences.getBoolean("checked", false));

        AnhXa();

        btnXacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUser.getText().toString().trim();
                String password = edtPas.getText().toString().trim();

                if(username.equals("tienkien") && password.equals("07122002")){
                    Toast.makeText(MainActivity.this, "Đăng nhập thành cong ", Toast.LENGTH_SHORT).show();
                    // neu co check
                    if(cbRemember.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("taikhoan", username);
                        editor.putString("matkhau", password);
                        editor.putBoolean("checked", true);
                        editor.commit();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Loi dang nhap", Toast.LENGTH_SHORT).show();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("taikhoan");
                        editor.remove("matkhau");
                        editor.remove("checked");
                        editor.commit();
                    }
                }
            }
        });
    }
    private void AnhXa(){
        btnXacnhan = (Button) findViewById(R.id.btndangnhap);
        edtUser = (EditText) findViewById(R.id.edtuser);
        edtPas = (EditText) findViewById(R.id.edtpass);
        cbRemember =(CheckBox) findViewById(R.id.checkbox);



    }
}