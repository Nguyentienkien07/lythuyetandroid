package com.example.ntk_thtuan7;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FriendAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Friend> friendList;

    public FriendAdapter(Context context, int layout, List<Friend> friendList) {
        this.context = context;
        this.layout = layout;
        this.friendList = friendList;
    }

    @Override
    public int getCount() {
        return friendList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        // ánh xạ
        TextView textTen = (TextView) view.findViewById(R.id.textviewTen);
        TextView textMoTa = (TextView) view.findViewById(R.id.textviewMoTa);
        ImageView imgHinh = (ImageView) view.findViewById(R.id.imageviewHinh);
        // gán giá trị
        Friend friend = friendList.get(i);
        textTen.setText(friend.getTen());
        textMoTa.setText(friend.getMoTa());
        imgHinh.setImageResource(friend.getHinh());

        return view;
    }
}
