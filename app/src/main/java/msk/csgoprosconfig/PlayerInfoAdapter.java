package msk.csgoprosconfig;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;



public class PlayerInfoAdapter extends ArrayAdapter<PlayerInfoModel> {

    LayoutInflater inflator;
    List<PlayerInfoModel> mListPlayerInfo;
    DownloadManager manager;
    Boolean result;

    public PlayerInfoAdapter(@NonNull Context context, @NonNull List<PlayerInfoModel> data) {
        super(context, R.layout.activity_player_info_adapter);

        mListPlayerInfo = data;
        inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        manager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        result=isDownloadManagerAvailable(context.getApplicationContext());

    }

    @Override
    public int getCount() {
        return mListPlayerInfo.size();
    }

    @Nullable
    @Override
    public PlayerInfoModel getItem(int position) {
        return mListPlayerInfo.get(position);
    }

    @Nullable
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = inflator.inflate(R.layout.activity_player_info_adapter, null);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.idPlayerInfoImg);
        TextView mouseView = (TextView) convertView.findViewById(R.id.idMouseData);
        TextView keyboardView = (TextView) convertView.findViewById(R.id.idKeyboardData);
        TextView headsetView = (TextView) convertView.findViewById(R.id.idHeadsetData);
        TextView mousepadView = (TextView) convertView.findViewById(R.id.idMousepadData);
        TextView monitorView = (TextView) convertView.findViewById(R.id.idMonitorData);
        TextView resolutionView = (TextView) convertView.findViewById(R.id.idResolutionData);
        TextView scalingView = (TextView) convertView.findViewById(R.id.idScalingData);
        TextView sensitivityView = (TextView) convertView.findViewById(R.id.idSensitivityData);
        TextView dpiView = (TextView) convertView.findViewById(R.id.idDpiData);
        final Button downloadView = (Button) convertView.findViewById(R.id.idDownload);


        final PlayerInfoModel model = getItem(position);
        imageView.setImageResource(model.getmPlayerInfoImg());
        mouseView.setText(model.getmMouse());
        keyboardView.setText(model.getmKeyboard());
        headsetView.setText(model.getmHeadset());
        mousepadView.setText(model.getmMousepad());
        monitorView.setText(model.getmMonitor());
        resolutionView.setText(model.getmResolution());
        scalingView.setText(model.getmScaling());
        sensitivityView.setText(model.getmSensitivity());
        dpiView.setText(model.getmDpi());
        downloadView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result)
                    downloadFile(model.getmDownload());
            }
        });

        return convertView;
}

    public void downloadFile(String linkVariable){
        String DownloadUrl = linkVariable;
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
        request.setDescription("config pdf file for testing");   //appears the same in Notification bar while downloading
        request.setTitle("config.cfg");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "config.cfg");

        // get download service and enqueue file

        manager.enqueue(request);
    }

    public static boolean isDownloadManagerAvailable(Context context) {
        try {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.GINGERBREAD) {
                return false;
            }
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            intent.setClassName("com.android.providers.downloads.ui","com.android.providers.downloads.ui.DownloadList");
            List list = context.getPackageManager().queryIntentActivities(intent,
                    PackageManager.MATCH_DEFAULT_ONLY);
            return list.size() > 0;
        } catch (Exception e) {
            return false;
        }
    }



}
