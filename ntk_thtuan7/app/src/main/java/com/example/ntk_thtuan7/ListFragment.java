package com.example.ntk_thtuan7;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;
import android.app.AlertDialog;
import android.content.DialogInterface;


public class ListFragment extends Fragment {
    private ListView lvFriend;
    private ArrayList<Friend> arrayFriend;
    private FriendAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list,container,false);
        lvFriend = view.findViewById(R.id.listviewFriend);

        arrayFriend = new ArrayList<>();

        arrayFriend.add(new Friend("Thái Trần Duy Hoàng", "07/12/2002", R.drawable.hinh2));
        arrayFriend.add(new Friend("Trần Phước Lục", "08/10/2003", R.drawable.hinh3));
        arrayFriend.add(new Friend("Trần Viết Thịnh", "06/12/2005", R.drawable.hinh4));
        arrayFriend.add(new Friend("Trần Viết Ý", "08/05/2005", R.drawable.hinh5));
        arrayFriend.add(new Friend("Trần Văn Thành", "08/09/2003", R.drawable.h6));
        adapter = new FriendAdapter(getContext(), R.layout.dong_friend, arrayFriend);
        lvFriend.setAdapter(adapter);
        lvFriend.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getContext(),Detail.class);
                Friend friend = arrayFriend.get(i);
                intent.putExtra("ten",friend.getTen());
                intent.putExtra("moTa",friend.getMoTa());
                intent.putExtra("hinh",friend.getHinh());
                startActivity(intent);

            }
        });
        return view;
    }
}
