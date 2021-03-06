package test.myapplication2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yangsu.baek on 2017-11-01.
 */

public class Item implements Parcelable{
    private int id;
    private String name;
    private String address;
    private String latitude;
    private String longitude;
    private String url;
    private boolean showCheck = false;
    private boolean isCheck = false;



    Item (){

    }
    Item(String name, String address){
        this.name = name;
        this.address = address;
    }


    Item(int id ,String name, String address, String latitude, String longitude, String url){
        this.id = id;
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.url = url;

    }


    public int describeContents(){
        return 0;
    }

    public Item(Parcel in) {
        readFromParcel(in);
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(address);
        dest.writeString(latitude);
        dest.writeString(longitude);
        dest.writeString(url);

    }

    private void readFromParcel(Parcel in){
        id = in.readInt();
        name = in.readString();
        address = in.readString();
        latitude = in.readString();
        longitude = in.readString();
        url = in.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public int getDBId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public String getLatitude(){
        return this.latitude;
    }

    public String getLongitude(){
        return this.longitude;
    }

    public String getUrl(){ return this.url; }

    public boolean getShowCheck(){ return this.showCheck; }

    public boolean getIsCheck(){ return this.isCheck; }

    public void setUrl(String url){ this.url = url;}

    public void setShowCheck(boolean check){ this.showCheck = check ;}

    public void setIsCheck(boolean check){ this.isCheck = check ;}

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setLatitude(String latitude){
        this.latitude = latitude;
    }

    public void setLongitude(String longitude){
        this.longitude = longitude;
    }


}
