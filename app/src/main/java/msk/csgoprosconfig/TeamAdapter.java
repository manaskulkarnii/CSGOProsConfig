package msk.csgoprosconfig;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TeamAdapter extends ArrayAdapter<TeamModel>  {

    LayoutInflater inflator;
    List<TeamModel> mListTeamNames;


    void TeamAdapter(){}

    public TeamAdapter(@NonNull Context context, @NonNull List<TeamModel> data) {
        super(context, R.layout.activity_team_adapter);

        mListTeamNames=data;
        inflator= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount(){return mListTeamNames.size();}

    @Nullable
    @Override
    public TeamModel getItem(int position){return mListTeamNames.get(position);}

    @Nullable
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        convertView=inflator.inflate(R.layout.activity_team_adapter,null);
        ImageView imageView= (ImageView) convertView.findViewById(R.id.idTeamImg);
        TextView textView= (TextView) convertView.findViewById(R.id.idTeamName);

        TeamModel model=getItem(position);
        imageView.setImageResource(model.getmTeamImg());
        textView.setText(model.getmTeamName());

        return convertView;
    }

}
