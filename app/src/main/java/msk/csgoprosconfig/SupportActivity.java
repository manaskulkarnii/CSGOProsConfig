package msk.csgoprosconfig;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SupportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        TextView mTradeInfo;
        Button mTradeButton;
        Toolbar mToolbarSupport;

        mTradeInfo= (TextView) findViewById(R.id.idTradeInfo);
        mTradeButton= (Button) findViewById(R.id.idTradeButton);
        mToolbarSupport= (Toolbar) findViewById(R.id.idSupportActivity_toolbar);

        setSupportActionBar(mToolbarSupport);
        getSupportActionBar().setTitle("Support Developer");

        mTradeButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(SupportActivity.this,"Trade Link is copied!",Toast.LENGTH_SHORT).show();
                //tradelink code
                return false;
            }
        });
    }
}
