package com.example.a55014.mytest.bottomsheet;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.a55014.mytest.R;

import java.util.ArrayList;
import java.util.List;

public class PlayBottomSheetDialog extends AppCompatActivity implements View.OnClickListener {

    private BottomSheetDialog bsd1;
    private BottomSheetDialog bsd2;
    private BottomDialogAdapter adapter;
    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_bottom_sheet_dialog);
        btn1 = (Button) this.findViewById(R.id.btn_bsd1);
        btn2 = (Button) this.findViewById(R.id.btn_bsd2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        setTitle("BottomSheetDialog");
        initView();
    }

    private void initView() {
        View view = View.inflate(this, R.layout.bottom_dialog, null);
        ImageView man = (ImageView) view.findViewById(R.id.image_man);
        ImageView women = (ImageView) view.findViewById(R.id.image_women);
        man.setOnClickListener(this);
        women.setOnClickListener(this);

        bsd1 = new BottomSheetDialog(this);
        bsd1.setContentView(view);
        Window window=bsd1.getWindow();
        //设置透明背景
//        window.findViewById(R.id.design_bottom_sheet)
//                .setBackgroundResource(android.R.color.transparent);
        assert window != null;
        window.setDimAmount(0.4f);
        bsd1.setCanceledOnTouchOutside(true);

        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) {
            list.add("" + i);
        }

        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(this).inflate(R.layout.item_recycler, null);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BottomDialogAdapter(this, list);
        recyclerView.setAdapter(adapter);

        bsd2 = new BottomSheetDialog(this);
        bsd2.setContentView(recyclerView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_bsd1:
                bsd1.show();
                break;
            case R.id.btn_bsd2:
                bsd2.show();
                break;
            case R.id.image_man:
                Toast.makeText(this, "男", Toast.LENGTH_SHORT).show();
                bsd1.dismiss();
                break;
            case R.id.image_women:
                Toast.makeText(this, "女", Toast.LENGTH_SHORT).show();
                bsd1.dismiss();
                break;
        }
    }
}
