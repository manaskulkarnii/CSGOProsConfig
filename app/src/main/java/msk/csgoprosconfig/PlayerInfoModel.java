package msk.csgoprosconfig;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by manas on 23-07-2017.
 */

public class PlayerInfoModel extends ArrayList<Parcelable> implements Parcelable {

    int mPlayerInfoImg;
    String mMouse, mKeyboard, mHeadset, mMousepad, mMonitor, mResolution, mScaling, mSensitivity, mDpi, mDownload;


    public PlayerInfoModel(int img, String mouse, String keyboard, String headset, String mousepad, String monitor, String resolution, String scaling, String sensitivity, String dpi, String download) {
        mPlayerInfoImg = img;
        mMouse = mouse;
        mKeyboard = keyboard;
        mHeadset = headset;
        mMousepad = mousepad;
        mMonitor = monitor;
        mResolution = resolution;
        mScaling = scaling;
        mSensitivity = sensitivity;
        mDpi = dpi;
        mDownload = download;

    }


    protected PlayerInfoModel(Parcel in) {

        mPlayerInfoImg = in.readInt();
        mMouse = in.readString();
        mKeyboard = in.readString();
        mHeadset = in.readString();
        mMousepad = in.readString();
        mMonitor = in.readString();
        mResolution = in.readString();
        mScaling = in.readString();
        mSensitivity = in.readString();
        mDpi = in.readString();
        mDownload = in.readString();
    }

    public static final Parcelable.Creator<PlayerInfoModel> CREATOR = new Parcelable.Creator<PlayerInfoModel>() {

        @Override
        public PlayerInfoModel createFromParcel(Parcel in) {
            return new PlayerInfoModel(in);
        }

        @Override
        public PlayerInfoModel[] newArray(int size) {
            return new PlayerInfoModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(mPlayerInfoImg);
        dest.writeString(mMouse);
        dest.writeString(mKeyboard);
        dest.writeString(mHeadset);
        dest.writeString(mMousepad);
        dest.writeString(mMonitor);
        dest.writeString(mResolution);
        dest.writeString(mScaling);
        dest.writeString(mSensitivity);
        dest.writeString(mDpi);
        dest.writeString(mDownload);

    }

    public int getmPlayerInfoImg() {
        return mPlayerInfoImg;
    }

    public void setmPlayerInfoImg(int mPlayerImg) {
        this.mPlayerInfoImg = mPlayerImg;
    }

    public String getmMouse() {
        return mMouse;
    }

    public void setmMouse(String mMouse) {
        this.mMouse = mMouse;
    }

    public String getmKeyboard() {
        return mKeyboard;
    }

    public void setmKeyboard(String mKeyboard) {
        this.mKeyboard = mKeyboard;
    }

    public String getmHeadset() {
        return mHeadset;
    }

    public void setmHeadset(String mHeadset) {
        this.mHeadset = mHeadset;
    }

    public PlayerInfoModel() {
    }

    public String getmMousepad() {
        return mMousepad;
    }

    public void setmMousepad(String mMousepad) {
        this.mMousepad = mMousepad;
    }

    public String getmMonitor() {
        return mMonitor;
    }

    public void setmMonitor(String mMonitor) {
        this.mMonitor = mMonitor;
    }

    public String getmResolution() {
        return mResolution;
    }

    public void setmResolution(String mResolution) {
        this.mResolution = mResolution;
    }

    public String getmScaling() {
        return mScaling;
    }

    public void setmScaling(String mScaling) {
        this.mScaling = mScaling;
    }

    public String getmSensitivity() {
        return mSensitivity;
    }

    public void setmSensitivity(String mSensitivity) {
        this.mSensitivity = mSensitivity;
    }

    public String getmDpi() {
        return mDpi;
    }

    public void setmDpi(String mDpi) {
        this.mDpi = mDpi;
    }

    public String getmDownload() {
        return mDownload;
    }

    public void setmDownload(String mDownload) {
        this.mDownload = mDownload;
    }
}
