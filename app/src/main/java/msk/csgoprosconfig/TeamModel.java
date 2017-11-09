package msk.csgoprosconfig;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by manas on 19-07-2017.
 */

public class TeamModel extends ArrayList<Parcelable> implements Parcelable {

    private int mTeamImg;
    private String mTeamName;

    public TeamModel() {

    }

    public TeamModel(int img, String name) {
        mTeamImg = img;
        mTeamName = name;
    }

    protected TeamModel(Parcel in) {
        mTeamImg = in.readInt();
        mTeamName = in.readString();
    }

    public static final Parcelable.Creator<TeamModel> CREATOR = new Parcelable.Creator<TeamModel>() {

        @Override
        public TeamModel createFromParcel(Parcel in) {
            return new TeamModel(in);
        }

        @Override
        public TeamModel[] newArray(int size) {
            return new TeamModel[size];
        }

    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(mTeamImg);
        dest.writeString(mTeamName);

    }

    public int getmTeamImg() {
        return mTeamImg;
    }

    public void setmTeamImg(int mTeamImg) {
        this.mTeamImg = mTeamImg;
    }

    public String getmTeamName() {
        return mTeamName;
    }

    public void setmTeamName(String mTeamName) {
        this.mTeamName = mTeamName;
    }
}
