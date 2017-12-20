package msk.csgoprosconfig;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SupportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        Button mTradeButton, mProfileButton;

        mTradeButton= (Button) findViewById(R.id.idTradeButton);
        mProfileButton = (Button) findViewById(R.id.idProfileButton);

        mTradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://steamcommunity.com/tradeoffer/new/?partner=449551168&token=I1kj7XaV"));
                startActivity(intent);
            }
        });

        mProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://steamcommunity.com/id/franklampardcsgo/"));
                startActivity(intent);
            }
        });
    }
}
