package msk.csgoprosconfig;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PlayerAdapter extends ArrayAdapter<PlayerModel> {

    LayoutInflater inflator;
    List<PlayerModel> mListPlayerNames;

    public PlayerAdapter(@NonNull Context context, @NonNull List<PlayerModel> data) {
        super(context, R.layout.activity_player_adapter);

        mListPlayerNames = data;
        inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mListPlayerNames.size();
    }

    @Nullable
    @Override
    public PlayerModel getItem(int position) {
        return mListPlayerNames.get(position);
    }

    @Nullable
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = inflator.inflate(R.layout.activity_player_adapter, null);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.idPlayerImg);
        TextView textView= (TextView) convertView.findViewById(R.id.idPlayerName);

        PlayerModel model=getItem(position);
        imageView.setImageResource(model.getmPlayerImg());
        textView.setText(model.getmPlayerName());

        return convertView;
    }

}
