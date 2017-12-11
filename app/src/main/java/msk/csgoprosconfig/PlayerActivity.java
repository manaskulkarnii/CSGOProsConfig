package msk.csgoprosconfig;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PlayerActivity extends AppCompatActivity {

    List<PlayerModel> mPlayerModelData;
    Integer teamPosi;
    private ListView mListView;
    private PlayerAdapter mPlayerAdapter;
    private Toolbar mToolbarTeamName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        mPlayerModelData = new ArrayList<>();
        mListView = (ListView) findViewById(R.id.idListview);
        mToolbarTeamName= (Toolbar) findViewById(R.id.idToolbarTeamName);
//        Intent intent=getIntent();
//        mToolbarTeamName.intent.setTitle(intent.getExtras("teamName"));

        setSupportActionBar(mToolbarTeamName);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mToolbarTeamName.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mPlayerAdapter = new PlayerAdapter(this, mPlayerModelData);
        mListView.setAdapter(mPlayerAdapter);
        Bundle bundle = getIntent().getExtras();
        teamPosi = bundle.getInt("position");
        getSupportActionBar().setTitle(bundle.getString("teamName"));
        Log.d("position :", teamPosi.toString());
        addData();

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(PlayerActivity.this, mPlayerModelData.get(position).getmPlayerName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PlayerActivity.this, PlayerInfoActivity.class);
                intent.putExtra("playerName", mPlayerModelData.get(position).getmPlayerName());
                intent.putExtra("playerImg", mPlayerModelData.get(position).getmPlayerImg());
                Bundle bundle=new Bundle();
                bundle.putInt("teamPosi",teamPosi);
                bundle.putInt("infoPosition",position);
                bundle.putInt("playerInfoImg",mPlayerModelData.get(position).getmPlayerImg());
                bundle.putString("playerInfoName",mPlayerModelData.get(position).getmPlayerName());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    void addData() {



        switch (teamPosi){
            case 0: //SK
                String[] skNames = getResources().getStringArray(R.array.SK);
                int[] skImages={R.drawable.fallen,R.drawable.fer,R.drawable.coldzera,R.drawable.taco,R.drawable.felps};
                for (int i = 0; i < skNames.length; i++) {
                PlayerModel model = new PlayerModel(skImages[i],skNames[i]);
                mPlayerModelData.add(model);
                Log.d("Team", "List size-" + mPlayerModelData.size());
                Log.d("Team", "Name" + mPlayerModelData.get(i).getmPlayerName());
            }
            break;
            case 1: //NaVi
                String[] naviNames = getResources().getStringArray(R.array.NatusVincere);
                int[] naviImages={R.drawable.simple,R.drawable.zeus,R.drawable.electronic,R.drawable.edward,R.drawable.flamie};
                for (int i = 0; i < naviNames.length; i++) {
                    PlayerModel model = new PlayerModel(naviImages[i],naviNames[i]);
                    mPlayerModelData.add(model);
                    Log.d("Team", "List size-" + mPlayerModelData.size());
                    Log.d("Team", "Name" + mPlayerModelData.get(i).getmPlayerName());
                }
                break;
            case 2: //Fnatic
                String[] nipNames = getResources().getStringArray(R.array.Fnatic);
                int[] nipImages={R.drawable.golden,R.drawable.lekro,R.drawable.jw,R.drawable.krimz,R.drawable.flusha};
                for (int i = 0; i < nipNames.length; i++) {
                    PlayerModel model = new PlayerModel(nipImages[i],nipNames[i]);
                    mPlayerModelData.add(model);
                    Log.d("Team", "List size-" + mPlayerModelData.size());
                    Log.d("Team", "Name" + mPlayerModelData.get(i).getmPlayerName());
                }
                break;

            case 3: //Astralis
                String[] astralisNames = getResources().getStringArray(R.array.Astralis);
                int[] astralisImages={R.drawable.xyp9x,R.drawable.device,R.drawable.dupreeh,R.drawable.kjaerbye,R.drawable.glav1e};
                for (int i = 0; i < astralisNames.length; i++) {
                    PlayerModel model = new PlayerModel(astralisImages[i],astralisNames[i]);
                    mPlayerModelData.add(model);
                    Log.d("Team", "List size-" + mPlayerModelData.size());
                    Log.d("Team", "Name" + mPlayerModelData.get(i).getmPlayerName());
                }
                break;
            case 4: //G2
                String[] cloud9Names = getResources().getStringArray(R.array.Gamers2);
                int[] cloud9Images={R.drawable.shox,R.drawable.nbk,R.drawable.kennys,R.drawable.apex,R.drawable.bodyy};
                for (int i = 0; i < cloud9Names.length; i++) {
                    PlayerModel model = new PlayerModel(cloud9Images[i],cloud9Names[i]);
                    mPlayerModelData.add(model);
                    Log.d("Team", "List size-" + mPlayerModelData.size());
                    Log.d("Team", "Name" + mPlayerModelData.get(i).getmPlayerName());
                }
                break;
            case 5: //NiP
                String[] envyusNames = getResources().getStringArray(R.array.NiP);
                int[] envyusImages = {R.drawable.forest, R.drawable.getright, R.drawable.rez, R.drawable.xizt, R.drawable.draken};
                for (int i = 0; i < envyusNames.length; i++) {
                    PlayerModel model = new PlayerModel(envyusImages[i],envyusNames[i]);
                    mPlayerModelData.add(model);
                    Log.d("Team", "List size-" + mPlayerModelData.size());
                    Log.d("Team", "Name" + mPlayerModelData.get(i).getmPlayerName());
                }
                break;
            case 6: //EnVyUs
                String[] g2Names = getResources().getStringArray(R.array.Envyus);
                int[] g2Images={R.drawable.happy,R.drawable.xms,R.drawable.rpk,R.drawable.scream,R.drawable.sixer};
                for (int i = 0; i < g2Names.length; i++) {
                    PlayerModel model = new PlayerModel(g2Images[i],g2Names[i]);
                    mPlayerModelData.add(model);
                    Log.d("Team", "List size-" + mPlayerModelData.size());
                    Log.d("Team", "Name" + mPlayerModelData.get(i).getmPlayerName());
                }
                break;
            case 7: //Virtus.Pro
                String[] fnaticNames = getResources().getStringArray(R.array.Virtuspro);
                int[] fnaticImages={R.drawable.pasha,R.drawable.neo,R.drawable.snax,R.drawable.taz,R.drawable.byali};
                for (int i = 0; i < fnaticNames.length; i++) {
                    PlayerModel model = new PlayerModel(fnaticImages[i],fnaticNames[i]);
                    mPlayerModelData.add(model);
                    Log.d("Team", "List size-" + mPlayerModelData.size());
                    Log.d("Team", "Name" + mPlayerModelData.get(i).getmPlayerName());
                }
                break;
            case 8: //Cloud9
                String[] virtusproNames = getResources().getStringArray(R.array.Cloud9);
                int[] virtusproImages = {R.drawable.tarik, R.drawable.rush, R.drawable.skadoodle, R.drawable.stewie2k, R.drawable.autimatic};
                for (int i = 0; i < virtusproNames.length; i++) {
                    PlayerModel model = new PlayerModel(virtusproImages[i],virtusproNames[i]);
                    mPlayerModelData.add(model);
                    Log.d("Team", "List size-" + mPlayerModelData.size());
                    Log.d("Team", "Name" + mPlayerModelData.get(i).getmPlayerName());
                }
                break;
        }



    }
}
