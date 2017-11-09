package msk.csgoprosconfig;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by manas on 20-07-2017.
 */

public class PlayerModel extends ArrayList<Parcelable> implements Parcelable {

    int mPlayerImg;
    String mPlayerName;

    public PlayerModel() {
    }

    public PlayerModel(int img, String name) {
        mPlayerImg = img;
        mPlayerName = name;

    }

    protected PlayerModel(Parcel in) {

        mPlayerName = in.readString();
        mPlayerImg = in.readInt();
    }

    public static final Parcelable.Creator<PlayerModel> CREATOR = new Parcelable.Creator<PlayerModel>() {

        @Override
        public PlayerModel createFromParcel(Parcel in) {
            return new PlayerModel(in);
        }

        @Override
        public PlayerModel[] newArray(int size) {
            return new PlayerModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(mPlayerName);
        dest.writeInt(mPlayerImg);

    }

    public int getmPlayerImg() {
        return mPlayerImg;
    }

    public void setmPlayerImg(int mPlayerImg) {
        this.mPlayerImg = mPlayerImg;
    }

    public String getmPlayerName() {
        return mPlayerName;
    }

    public void setmPlayerName(String mPlayerName) {
        this.mPlayerName = mPlayerName;
    }
}
