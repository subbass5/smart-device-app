package com.example.apptestjc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private RecyclerView deviceRecyclerView;
    private DeviceAdapter deviceAdapter;
    private List<Device> deviceList;
    private FloatingActionButton addDeviceFab;
    private TextView deviceCountText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ซ่อน ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        deviceRecyclerView = findViewById(R.id.deviceRecyclerView);
        addDeviceFab = findViewById(R.id.addDeviceFab);
        deviceCountText = findViewById(R.id.deviceCountText);

        // Sample data
        deviceList = new ArrayList<>();
        Random random = new Random();
        deviceList.add(new Device("J2025F 3B9D", "Device not connected"));
        // เพิ่มข้อมูลอุปกรณ์ตามที่ต้องการ


        deviceAdapter = new DeviceAdapter(this, deviceList);
        deviceRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        deviceRecyclerView.setAdapter(deviceAdapter);

        addDeviceFab.setOnClickListener(v -> {

            Toast.makeText(MainActivity.this, "Add new device clicked!", Toast.LENGTH_SHORT).show();
            // การทำงานเมื่อคลิกที่ปุ่ม Floating Action Button
            deviceList.add(new Device("J2025F "+random.nextInt(9000), "Device not connected"));
            // เพิ่มข้อมูลอุปกรณ์ตามที่ต้องการ
            deviceRecyclerView.setAdapter(deviceAdapter);
            //get size of data
            deviceCountText.setText("Added Device("+(deviceList.size())+")");

        });
    }
}