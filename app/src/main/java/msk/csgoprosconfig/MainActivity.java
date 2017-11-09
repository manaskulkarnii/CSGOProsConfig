package msk.csgoprosconfig;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
    private GridView mGridView;
    private TeamAdapter mTeamAdapter;

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
            intent.setData(Uri.parse("https://www.google.com"));
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
