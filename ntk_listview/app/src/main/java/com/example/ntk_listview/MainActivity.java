package com.example.ntk_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvMonHoc;
    Button btnThem, btnCapNhat, btnXoa;
    EditText edtMonHoc;
    ArrayList<String> arrayCourse;

    int vitri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvMonHoc = (ListView) findViewById(R.id.listviewMonHoc);
        btnThem = (Button) findViewById(R.id.buttonThem);
        edtMonHoc =(EditText) findViewById(R.id.editTextMonHoc);
        btnCapNhat = (Button) findViewById(R.id.buttonCapNhat);
        btnXoa = (Button) findViewById(R.id.buttonXoa);
        arrayCourse = new ArrayList<>();

        arrayCourse.add("Android");
        arrayCourse.add("PHP");
        arrayCourse.add("Python");
        arrayCourse.add("ios");
        ArrayAdapter adapter = new ArrayAdapter(
                MainActivity.this, android.R.layout.simple_list_item_1,arrayCourse
        );
        lvMonHoc.setAdapter(adapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monhoc = edtMonHoc.getText().toString();
                arrayCourse.add(monhoc);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Đã thêm thành công", Toast.LENGTH_SHORT).show();
            }
        });
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtMonHoc.setText(arrayCourse.get(i));
                vitri = i;
            }
        });
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayCourse.set(vitri, edtMonHoc.getText().toString());
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Đã cập nhật thành công!", Toast.LENGTH_SHORT).show();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0; i < arrayCourse.size();i++){
                    String getname = edtMonHoc.getText().toString();
                    if(arrayCourse.get(i).equals(getname)){
                        arrayCourse.remove(i);
                        adapter.notifyDataSetChanged();
                        break;
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Đã xoá thành công!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    startActivity(new Intent(MainActivity.this, Android.class));
                }
                if(i==1){
                    startActivity(new Intent(MainActivity.this, PHP.class));
                }
                return false;
            }
        });

    }
}