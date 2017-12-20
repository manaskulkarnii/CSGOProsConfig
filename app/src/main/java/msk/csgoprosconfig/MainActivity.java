package msk.csgoprosconfig;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public int i=0;
    List<TeamModel> mTeamModelData;
    String[] permissions = new String[]{
            Manifest.permission.INTERNET,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.READ_PHONE_STATE
    };
    private GridView mGridView;
    private TeamAdapter mTeamAdapter;

    private boolean checkPermissions() {
        int result;
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String p : permissions) {
            result = ContextCompat.checkSelfPermission(this, p);
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), 100);
            return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == 100) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // do something
            }
            return;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolbar= (Toolbar) findViewById(R.id.idMainActivity_Toolbar);
        setSupportActionBar(mToolbar);

        mTeamModelData = new ArrayList<>();
        mGridView = (GridView) findViewById(R.id.idGridView);
        mTeamAdapter = new TeamAdapter(this, mTeamModelData);
        mGridView.setAdapter(mTeamAdapter);
        addData();
        checkPermissions();
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, mTeamModelData.get(position).getmTeamName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
                intent.putExtra("teamName", mTeamModelData.get(position).getmTeamName());
                intent.putExtra("teamImg",mTeamModelData.get(position).getmTeamImg());
                Bundle bundle=new Bundle();
                bundle.putInt("position",position);
                bundle.putString("teamName",mTeamModelData.get(position).getmTeamName());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMenuInflater= getMenuInflater();
        mMenuInflater.inflate(R.menu.mainactivity_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent=null, chooser=null;

        if (item.getItemId()== R.id.action_help){
            intent= new Intent(android.content.Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.youtube.com/watch?v=c3Wh8pUMVyI"));
            chooser=Intent.createChooser(intent,"Launch Youtube");
            startActivity(intent);
        }
        if (item.getItemId()== R.id.action_Report){
            intent= new Intent(android.content.Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://goo.gl/forms/80o53jzyVdPqDJLI3"));
            chooser=Intent.createChooser(intent,"Launch Google Forms");
            startActivity(intent);
        }
        if (item.getItemId()== R.id.action_supportDev){
            intent= new Intent(MainActivity.this, SupportActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    void addData() {

        String[] teamNames = getResources().getStringArray(R.array.teamName);
        int[] teamImages = {R.drawable.sklogo, R.drawable.natusvincerelogo,R.drawable.fnaticlogo,R.drawable.astralislogo,R.drawable.g2logo,R.drawable.niplogo,R.drawable.envyuslogo,R.drawable.virtusprologo,R.drawable.cloud9logo};

        for ( i = 0; i < teamNames.length; i++) {
            TeamModel model = new TeamModel(teamImages[i], teamNames[i]);
            mTeamModelData.add(model);
            Log.d("Team","List size-"+mTeamModelData.size());
            Log.d("Team","Name"+mTeamModelData.get(i).getmTeamName());
        }

    }

}
