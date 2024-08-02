package com.example.apptestjc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.DeviceViewHolder> {

    private List<Device> deviceList;
    private Context context;

    public DeviceAdapter(Context context, List<Device> deviceList) {
        this.context = context;
        this.deviceList = deviceList;
    }

    @NonNull
    @Override
    public DeviceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_device, parent, false);
        return new DeviceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeviceViewHolder holder, int position) {
        Device device = deviceList.get(position);
        holder.deviceIdText.setText(device.getDeviceId());
        holder.deviceStatus.setText(device.getStatus());

        holder.reconnectButton.setOnClickListener(v -> {
            Toast.makeText(context, "Trying to reconnect...", Toast.LENGTH_SHORT).show();
            holder.deviceStatus.setText("Reconnecting...");
            // สมมติว่าเราทำการเชื่อมต่อใหม่แล้วสำเร็จ
            holder.deviceStatus.setText("Connected");
        });
    }

    @Override
    public int getItemCount() {
        return deviceList.size();
    }

    public static class DeviceViewHolder extends RecyclerView.ViewHolder {

        TextView deviceIdText, deviceStatus,reconnectButton;

        ImageView deviceImage;

        public DeviceViewHolder(@NonNull View itemView) {
            super(itemView);
            deviceIdText = itemView.findViewById(R.id.deviceIdText);
            deviceStatus = itemView.findViewById(R.id.deviceStatus);
            reconnectButton = itemView.findViewById(R.id.reconnectButton);
            deviceImage = itemView.findViewById(R.id.deviceImage);
        }
    }
}
