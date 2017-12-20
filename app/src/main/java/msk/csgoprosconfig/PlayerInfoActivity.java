package msk.csgoprosconfig;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PlayerInfoActivity extends AppCompatActivity {

    List<PlayerInfoModel> mPlayerInfoModelData;
    Integer playerPosi, teamPosi, playerImg;
    String playerName;
    private ListView mListviewPlayerInfo;
    private PlayerInfoAdapter mPlayerInfoAdapter;
    private Toolbar mToolbarPlayerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);
        mPlayerInfoModelData = new ArrayList<>();
        mListviewPlayerInfo = (ListView) findViewById(R.id.idListviewPlayerInfo);

        mToolbarPlayerName = (Toolbar) findViewById(R.id.idToolbarPlayerName);


        setSupportActionBar(mToolbarPlayerName);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mToolbarPlayerName.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mPlayerInfoAdapter = new PlayerInfoAdapter(this, mPlayerInfoModelData);
        mListviewPlayerInfo.setAdapter(mPlayerInfoAdapter);
        Bundle bundle = getIntent().getExtras();
        teamPosi = bundle.getInt("teamPosi");
        playerPosi = bundle.getInt("infoPosition");
        playerName = bundle.getString("playerInfoName");
        playerImg = bundle.getInt("playerInfoImg");
        getSupportActionBar().setTitle(bundle.getString("playerInfoName"));
        Log.d("teamPositon :", teamPosi.toString());
        Log.d("infoPositon :", playerPosi.toString());
        addData();
    }

    void addData() {

        switch (teamPosi) {
            case 0: //SK
                switch (playerPosi) {
                    case 0:
                        String[] fallenData = getResources().getStringArray(R.array.Fallen);
                        PlayerInfoModel fallen = new PlayerInfoModel(playerImg, fallenData[0], fallenData[1], fallenData[2], fallenData[3], fallenData[4], fallenData[5], fallenData[6], fallenData[7], fallenData[8],fallenData[9]);
                        mPlayerInfoModelData.add(fallen);
                        break;
                    case 1:
                        String[] ferData = getResources().getStringArray(R.array.Fer);
                        PlayerInfoModel fer = new PlayerInfoModel(playerImg, ferData[0], ferData[1], ferData[2], ferData[3], ferData[4], ferData[5], ferData[6], ferData[7], ferData[8],ferData[9]);
                        mPlayerInfoModelData.add(fer);
                        break;
                    case 2:
                        String[] coldzeraData = getResources().getStringArray(R.array.Coldzera);
                        PlayerInfoModel coldzera = new PlayerInfoModel(playerImg, coldzeraData[0], coldzeraData[1], coldzeraData[2], coldzeraData[3], coldzeraData[4], coldzeraData[5], coldzeraData[6], coldzeraData[7], coldzeraData[8],coldzeraData[9]);
                        mPlayerInfoModelData.add(coldzera);
                        break;
                    case 3:
                        String[] tacoData = getResources().getStringArray(R.array.Taco);
                        PlayerInfoModel taco = new PlayerInfoModel(playerImg, tacoData[0], tacoData[1], tacoData[2], tacoData[3], tacoData[4], tacoData[5], tacoData[6], tacoData[7], tacoData[8],tacoData[9]);
                        mPlayerInfoModelData.add(taco);
                        break;
                    case 4:
                        String[] boltzData = getResources().getStringArray(R.array.Boltz);
                        PlayerInfoModel boltz = new PlayerInfoModel(playerImg, boltzData[0], boltzData[1], boltzData[2], boltzData[3], boltzData[4], boltzData[5], boltzData[6], boltzData[7], boltzData[8],boltzData[9]);
                        mPlayerInfoModelData.add(boltz);
                        break;
                }
                break;
            case 1: //NaVi
                switch (playerPosi) {
                    case 0:
                        String[] simpleData = getResources().getStringArray(R.array.Simple);
                        PlayerInfoModel simple = new PlayerInfoModel(playerImg, simpleData[0], simpleData[1], simpleData[2], simpleData[3], simpleData[4], simpleData[5], simpleData[6], simpleData[7], simpleData[8],simpleData[9]);
                        mPlayerInfoModelData.add(simple);
                        break;
                    case 1:
                        String[] seizedData = getResources().getStringArray(R.array.Zeus);
                        PlayerInfoModel seized = new PlayerInfoModel(playerImg, seizedData[0], seizedData[1], seizedData[2], seizedData[3], seizedData[4], seizedData[5], seizedData[6], seizedData[7], seizedData[8],seizedData[9]);
                        mPlayerInfoModelData.add(seized);
                        break;
                    case 2:
                        String[] electronicData = getResources().getStringArray(R.array.Electronic);
                        PlayerInfoModel electronic = new PlayerInfoModel(playerImg, electronicData[0], electronicData[1], electronicData[2], electronicData[3], electronicData[4], electronicData[5], electronicData[6], electronicData[7], electronicData[8],electronicData[9]);
                        mPlayerInfoModelData.add(electronic);
                        break;
                    case 3:
                        String[] edwardData = getResources().getStringArray(R.array.Edward);
                        PlayerInfoModel edward = new PlayerInfoModel(playerImg, edwardData[0], edwardData[1], edwardData[2], edwardData[3], edwardData[4], edwardData[5], edwardData[6], edwardData[7], edwardData[8],edwardData[9]);
                        mPlayerInfoModelData.add(edward);
                        break;
                    case 4:
                        String[] flamieData = getResources().getStringArray(R.array.Flamie);
                        PlayerInfoModel flamie = new PlayerInfoModel(playerImg, flamieData[0], flamieData[1], flamieData[2], flamieData[3], flamieData[4], flamieData[5], flamieData[6], flamieData[7], flamieData[8],flamieData[9]);
                        mPlayerInfoModelData.add(flamie);
                        break;
                }
                break;
            case 2: //Fnatic
                switch (playerPosi) {
                    case 0:
                        String[] goldenData = getResources().getStringArray(R.array.Golden);
                        PlayerInfoModel golden = new PlayerInfoModel(playerImg, goldenData[0], goldenData[1], goldenData[2], goldenData[3], goldenData[4], goldenData[5], goldenData[6], goldenData[7], goldenData[8],goldenData[9]);
                        mPlayerInfoModelData.add(golden);
                        break;
                    case 1:
                        String[] lekroData = getResources().getStringArray(R.array.Lekro);
                        PlayerInfoModel Lekro = new PlayerInfoModel(playerImg, lekroData[0], lekroData[1], lekroData[2], lekroData[3], lekroData[4], lekroData[5], lekroData[6], lekroData[7], lekroData[8],lekroData[9]);
                        mPlayerInfoModelData.add(Lekro);
                        break;
                    case 2:
                        String[] jwData = getResources().getStringArray(R.array.Jw);
                        PlayerInfoModel jw = new PlayerInfoModel(playerImg, jwData[0], jwData[1], jwData[2], jwData[3], jwData[4], jwData[5], jwData[6], jwData[7], jwData[8],jwData[9]);
                        mPlayerInfoModelData.add(jw);
                        break;
                    case 3:
                        String[] krimzData = getResources().getStringArray(R.array.Krimz);
                        PlayerInfoModel krimz = new PlayerInfoModel(playerImg, krimzData[0], krimzData[1], krimzData[2], krimzData[3], krimzData[4], krimzData[5], krimzData[6], krimzData[7], krimzData[8],krimzData[9]);
                        mPlayerInfoModelData.add(krimz);
                        break;
                    case 4:
                        String[] flushaData = getResources().getStringArray(R.array.Flusha);
                        PlayerInfoModel flusha = new PlayerInfoModel(playerImg, flushaData[0], flushaData[1], flushaData[2], flushaData[3], flushaData[4], flushaData[5], flushaData[6], flushaData[7], flushaData[8],flushaData[9]);
                        mPlayerInfoModelData.add(flusha);
                        break;
                }
                break;
            case 3: //Astralis
                switch (playerPosi) {
                    case 0:
                        String[] xyp9xData = getResources().getStringArray(R.array.Xyp9x);
                        PlayerInfoModel xyp9x = new PlayerInfoModel(playerImg, xyp9xData[0], xyp9xData[1], xyp9xData[2], xyp9xData[3], xyp9xData[4], xyp9xData[5], xyp9xData[6], xyp9xData[7], xyp9xData[8],xyp9xData[9]);
                        mPlayerInfoModelData.add(xyp9x);
                        break;
                    case 1:
                        String[] deviceData = getResources().getStringArray(R.array.Device);
                        PlayerInfoModel device = new PlayerInfoModel(playerImg, deviceData[0], deviceData[1], deviceData[2], deviceData[3], deviceData[4], deviceData[5], deviceData[6], deviceData[7], deviceData[8],deviceData[9]);
                        mPlayerInfoModelData.add(device);
                        break;
                    case 2:
                        String[] dupreehData = getResources().getStringArray(R.array.Dupreeh);
                        PlayerInfoModel dupreeh = new PlayerInfoModel(playerImg, dupreehData[0], dupreehData[1], dupreehData[2], dupreehData[3], dupreehData[4], dupreehData[5], dupreehData[6], dupreehData[7], dupreehData[8],dupreehData[9]);
                        mPlayerInfoModelData.add(dupreeh);
                        break;
                    case 3:
                        String[] kjaerbyeData = getResources().getStringArray(R.array.Kjaerbye);
                        PlayerInfoModel kjaerbye = new PlayerInfoModel(playerImg, kjaerbyeData[0], kjaerbyeData[1], kjaerbyeData[2], kjaerbyeData[3], kjaerbyeData[4], kjaerbyeData[5], kjaerbyeData[6], kjaerbyeData[7], kjaerbyeData[8],kjaerbyeData[9]);
                        mPlayerInfoModelData.add(kjaerbye);
                        break;
                    case 4:
                        String[] glaiveData = getResources().getStringArray(R.array.Glaive);
                        PlayerInfoModel glaive = new PlayerInfoModel(playerImg, glaiveData[0], glaiveData[1], glaiveData[2], glaiveData[3], glaiveData[4], glaiveData[5], glaiveData[6], glaiveData[7], glaiveData[8],glaiveData[9]);
                        mPlayerInfoModelData.add(glaive);
                        break;
                }
                break;
            case 4: //G2
                switch (playerPosi) {
                    case 0:
                        String[] shoxData = getResources().getStringArray(R.array.Shox);
                        PlayerInfoModel shox = new PlayerInfoModel(playerImg, shoxData[0], shoxData[1], shoxData[2], shoxData[3], shoxData[4], shoxData[5], shoxData[6], shoxData[7], shoxData[8], shoxData[9]);
                        mPlayerInfoModelData.add(shox);
                        break;
                    case 1:
                        String[] nbkData = getResources().getStringArray(R.array.NBK);
                        PlayerInfoModel nbk = new PlayerInfoModel(playerImg, nbkData[0], nbkData[1], nbkData[2], nbkData[3], nbkData[4], nbkData[5], nbkData[6], nbkData[7], nbkData[8], nbkData[9]);
                        mPlayerInfoModelData.add(nbk);
                        break;
                    case 2:
                        String[] kennysData = getResources().getStringArray(R.array.KennyS);
                        PlayerInfoModel kennys = new PlayerInfoModel(playerImg, kennysData[0], kennysData[1], kennysData[2], kennysData[3], kennysData[4], kennysData[5], kennysData[6], kennysData[7], kennysData[8], kennysData[9]);
                        mPlayerInfoModelData.add(kennys);
                        break;
                    case 3:
                        String[] apexData = getResources().getStringArray(R.array.Taco);
                        PlayerInfoModel apex = new PlayerInfoModel(playerImg, apexData[0], apexData[1], apexData[2], apexData[3], apexData[4], apexData[5], apexData[6], apexData[7], apexData[8], apexData[9]);
                        mPlayerInfoModelData.add(apex);
                        break;
                    case 4:
                        String[] bodyyData = getResources().getStringArray(R.array.Boltz);
                        PlayerInfoModel bodyy = new PlayerInfoModel(playerImg, bodyyData[0], bodyyData[1], bodyyData[2], bodyyData[3], bodyyData[4], bodyyData[5], bodyyData[6], bodyyData[7], bodyyData[8], bodyyData[9]);
                        mPlayerInfoModelData.add(bodyy);
                        break;
                }
                break;
            case 5: //NiP
                switch (playerPosi) {
                    case 0:
                        String[] forestData = getResources().getStringArray(R.array.Forest);
                        PlayerInfoModel forest = new PlayerInfoModel(playerImg, forestData[0], forestData[1], forestData[2], forestData[3], forestData[4], forestData[5], forestData[6], forestData[7], forestData[8], forestData[9]);
                        mPlayerInfoModelData.add(forest);
                        break;
                    case 1:
                        String[] get_rightData = getResources().getStringArray(R.array.Get_right);
                        PlayerInfoModel get_right = new PlayerInfoModel(playerImg, get_rightData[0], get_rightData[1], get_rightData[2], get_rightData[3], get_rightData[4], get_rightData[5], get_rightData[6], get_rightData[7], get_rightData[8], get_rightData[9]);
                        mPlayerInfoModelData.add(get_right);
                        break;
                    case 2:
                        String[] rezData = getResources().getStringArray(R.array.REZ);
                        PlayerInfoModel rez = new PlayerInfoModel(playerImg, rezData[0], rezData[1], rezData[2], rezData[3], rezData[4], rezData[5], rezData[6], rezData[7], rezData[8], rezData[9]);
                        mPlayerInfoModelData.add(rez);
                        break;
                    case 3:
                        String[] xiztData = getResources().getStringArray(R.array.Xizt);
                        PlayerInfoModel xizt = new PlayerInfoModel(playerImg, xiztData[0], xiztData[1], xiztData[2], xiztData[3], xiztData[4], xiztData[5], xiztData[6], xiztData[7], xiztData[8], xiztData[9]);
                        mPlayerInfoModelData.add(xizt);
                        break;
                    case 4:
                        String[] drakenData = getResources().getStringArray(R.array.Draken);
                        PlayerInfoModel draken = new PlayerInfoModel(playerImg, drakenData[0], drakenData[1], drakenData[2], drakenData[3], drakenData[4], drakenData[5], drakenData[6], drakenData[7], drakenData[8], drakenData[9]);
                        mPlayerInfoModelData.add(draken);
                        break;
                }
                break;
            case 6: //EnVyUs
                switch (playerPosi) {
                    case 0:
                        String[] happyData = getResources().getStringArray(R.array.Happy);
                        PlayerInfoModel happy = new PlayerInfoModel(playerImg, happyData[0], happyData[1], happyData[2], happyData[3], happyData[4], happyData[5], happyData[6], happyData[7], happyData[8], happyData[9]);
                        mPlayerInfoModelData.add(happy);
                        break;
                    case 1:
                        String[] xmsData = getResources().getStringArray(R.array.XMS);
                        PlayerInfoModel xms = new PlayerInfoModel(playerImg, xmsData[0], xmsData[1], xmsData[2], xmsData[3], xmsData[4], xmsData[5], xmsData[6], xmsData[7], xmsData[8], xmsData[9]);
                        mPlayerInfoModelData.add(xms);
                        break;
                    case 2:
                        String[] rpkData = getResources().getStringArray(R.array.RPK);
                        PlayerInfoModel rpk = new PlayerInfoModel(playerImg, rpkData[0], rpkData[1], rpkData[2], rpkData[3], rpkData[4], rpkData[5], rpkData[6], rpkData[7], rpkData[8], rpkData[9]);
                        mPlayerInfoModelData.add(rpk);
                        break;
                    case 3:
                        String[] screamData = getResources().getStringArray(R.array.Scream);
                        PlayerInfoModel scream = new PlayerInfoModel(playerImg, screamData[0], screamData[1], screamData[2], screamData[3], screamData[4], screamData[5], screamData[6], screamData[7], screamData[8], screamData[9]);
                        mPlayerInfoModelData.add(scream);
                        break;
                    case 4:
                        String[] sixerData = getResources().getStringArray(R.array.Sixer);
                        PlayerInfoModel sixer = new PlayerInfoModel(playerImg, sixerData[0], sixerData[1], sixerData[2], sixerData[3], sixerData[4], sixerData[5], sixerData[6], sixerData[7], sixerData[8], sixerData[9]);
                        mPlayerInfoModelData.add(sixer);
                        break;
                }
                break;
            case 7: //Virtus.Pro
                switch (playerPosi) {
                    case 0:
                        String[] pashaData = getResources().getStringArray(R.array.Pasha);
                        PlayerInfoModel pasha = new PlayerInfoModel(playerImg, pashaData[0], pashaData[1], pashaData[2], pashaData[3], pashaData[4], pashaData[5], pashaData[6], pashaData[7], pashaData[8], pashaData[9]);
                        mPlayerInfoModelData.add(pasha);
                        break;
                    case 1:
                        String[] neoData = getResources().getStringArray(R.array.Neo);
                        PlayerInfoModel neo = new PlayerInfoModel(playerImg, neoData[0], neoData[1], neoData[2], neoData[3], neoData[4], neoData[5], neoData[6], neoData[7], neoData[8], neoData[9]);
                        mPlayerInfoModelData.add(neo);
                        break;
                    case 2:
                        String[] snaxData = getResources().getStringArray(R.array.Snax);
                        PlayerInfoModel snax = new PlayerInfoModel(playerImg, snaxData[0], snaxData[1], snaxData[2], snaxData[3], snaxData[4], snaxData[5], snaxData[6], snaxData[7], snaxData[8], snaxData[9]);
                        mPlayerInfoModelData.add(snax);
                        break;
                    case 3:
                        String[] tazData = getResources().getStringArray(R.array.TAZ);
                        PlayerInfoModel taz = new PlayerInfoModel(playerImg, tazData[0], tazData[1], tazData[2], tazData[3], tazData[4], tazData[5], tazData[6], tazData[7], tazData[8], tazData[9]);
                        mPlayerInfoModelData.add(taz);
                        break;
                    case 4:
                        String[] byaliData = getResources().getStringArray(R.array.Byali);
                        PlayerInfoModel byali = new PlayerInfoModel(playerImg, byaliData[0], byaliData[1], byaliData[2], byaliData[3], byaliData[4], byaliData[5], byaliData[6], byaliData[7], byaliData[8], byaliData[9]);
                        mPlayerInfoModelData.add(byali);
                        break;
                }
                break;
            case 8: //Cloud9
                switch (playerPosi) {
                    case 0:
                        String[] tarikData = getResources().getStringArray(R.array.Tarik);
                        PlayerInfoModel tarik = new PlayerInfoModel(playerImg, tarikData[0], tarikData[1], tarikData[2], tarikData[3], tarikData[4], tarikData[5], tarikData[6], tarikData[7], tarikData[8], tarikData[9]);
                        mPlayerInfoModelData.add(tarik);
                        break;
                    case 1:
                        String[] rushData = getResources().getStringArray(R.array.Rush);
                        PlayerInfoModel rush = new PlayerInfoModel(playerImg, rushData[0], rushData[1], rushData[2], rushData[3], rushData[4], rushData[5], rushData[6], rushData[7], rushData[8], rushData[9]);
                        mPlayerInfoModelData.add(rush);
                        break;
                    case 2:
                        String[] skadoodleData = getResources().getStringArray(R.array.Skadoodle);
                        PlayerInfoModel skadoodle = new PlayerInfoModel(playerImg, skadoodleData[0], skadoodleData[1], skadoodleData[2], skadoodleData[3], skadoodleData[4], skadoodleData[5], skadoodleData[6], skadoodleData[7], skadoodleData[8], skadoodleData[9]);
                        mPlayerInfoModelData.add(skadoodle);
                        break;
                    case 3:
                        String[] stewie2KData = getResources().getStringArray(R.array.Stewie2K);
                        PlayerInfoModel stewie2K = new PlayerInfoModel(playerImg, stewie2KData[0], stewie2KData[1], stewie2KData[2], stewie2KData[3], stewie2KData[4], stewie2KData[5], stewie2KData[6], stewie2KData[7], stewie2KData[8], stewie2KData[9]);
                        mPlayerInfoModelData.add(stewie2K);
                        break;
                    case 4:
                        String[] autimaticData = getResources().getStringArray(R.array.Autimatic);
                        PlayerInfoModel autimatic = new PlayerInfoModel(playerImg, autimaticData[0], autimaticData[1], autimaticData[2], autimaticData[3], autimaticData[4], autimaticData[5], autimaticData[6], autimaticData[7], autimaticData[8], autimaticData[9]);
                        mPlayerInfoModelData.add(autimatic);
                        break;
                }
                break;
        }
    }

}
