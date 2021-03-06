package jp.sio.testapp.flptest.Repository;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.android.gms.location.LocationRequest;

import jp.sio.testapp.flptest.L;
import jp.sio.testapp.flptest.R;

import static android.content.Context.*;

/**
 * Created by NTT docomo on 2017/05/23.
 */

public class SettingPref {
    private SharedPreferences settingPref;
    private SharedPreferences.Editor editor;
    private Context context;

    //Default設定
    private final boolean defIsSetInterval = false;
    private final int defSetInterval = 0;
    private final int defCount = 0;
    private final long defInterval = 75;
    private final long defTimeout = 60;
    private final boolean defIsCold = true;
    private final int defSuplEndWaitTime = 0;
    private final int defDelAssistDataTime = 3;
    private final String defLocationAPi = "requestLocationUpdates";
    private final String defLocationPriority = "BalancedPowerAccuracy";
    //SharedPreference名
    private String PREFNAME = "FlpTestSetting";

    /**
     * SettingをShearedPreferencesに保存・読み込みを行う
     */
    public SettingPref(Context context){
        this.context = context;
    }
    public void createPref(){
        settingPref = context.getSharedPreferences(PREFNAME, MODE_PRIVATE);
        editor = settingPref.edit();
    }

    public void setLocationAPi(String locationApi){
        editor.putString(context.getString(R.string.settingLocationApi),locationApi);
        L.d("SettingPrefLocationPriority:" + locationApi);
        commitSetting();
    }

    public void setLocationPriority(String locationPriority){
        editor.putString(context.getString(R.string.settingLocationPriority),locationPriority);
        L.d("SettingPrefLocationPriority:" + locationPriority);
        commitSetting();
    }
    public void setIsSetInterval(boolean isSetInterval){
        editor.putBoolean(context.getString(R.string.settingIsSetInterval),isSetInterval);
        commitSetting();
    }

    public void setSetInterval(int setInterval){
        editor.putInt(context.getString(R.string.settingSetInterval),setInterval);
        commitSetting();
    }

    public void setCount(int count){
        editor.putInt(context.getString(R.string.settingCount),count);
        commitSetting();
    }
    public void setInterval(long interval){
        editor.putLong(context.getString(R.string.settingInterval),interval);
        commitSetting();
    }
    public void setTimeout(long timeout){
        editor.putLong(context.getString(R.string.settingTimeout),timeout);
        commitSetting();
    }
    public void setIsCold(boolean isCold){
        editor.putBoolean(context.getString(R.string.settingIsCold),isCold);
        commitSetting();
    }
    public void setSuplEndWaitTime(int suplendwaittime){
        editor.putInt(context.getString(R.string.settingSuplEndWaitTime),suplendwaittime);
        commitSetting();
    }
    public void setDelAssistDataTime(int delAssistDataTime){
        editor.putInt(context.getString(R.string.settingDelAssistdataTime),delAssistDataTime);
        commitSetting();
    }
    public String getLocationAPi(){
        return settingPref.getString(context.getResources().getString(R.string.settingLocationApi),defLocationAPi);
    }
    public String getLocationPriority(){
        return settingPref.getString(context.getResources().getString(R.string.settingLocationPriority),defLocationPriority);
    }
    public boolean getIsSetInterval(){
        return settingPref.getBoolean(context.getString(R.string.settingIsSetInterval),defIsSetInterval);
    }

    public int getSetInterval(){
        return settingPref.getInt(context.getString(R.string.settingSetInterval),defSetInterval);
    }
    public int getCount(){
        return settingPref.getInt(context.getString(R.string.settingCount),defCount);
    }
    public long getInterval(){
        return settingPref.getLong(context.getString(R.string.settingInterval),defInterval);
    }
    public long getTimeout(){
        return settingPref.getLong(context.getString(R.string.settingTimeout),defTimeout);
    }
    public boolean getIsCold(){
        return settingPref.getBoolean(context.getString(R.string.settingIsCold),defIsCold);
    }
    public int getSuplEndWaitTime(){
        return settingPref.getInt(context.getString(R.string.settingSuplEndWaitTime),defSuplEndWaitTime);
    }
    public int getDelAssistDataTime(){
        return settingPref.getInt(context.getString(R.string.settingDelAssistdataTime),defDelAssistDataTime);
    }

    public void setDefaultSetting(){
        setLocationAPi(defLocationAPi);
        setLocationPriority(defLocationPriority);
        setIsSetInterval(defIsSetInterval);
        setSetInterval(defSetInterval);
        setCount(defCount);
        setInterval(defInterval);
        setTimeout(defTimeout);
        setIsCold(defIsCold);
        setSuplEndWaitTime(defSuplEndWaitTime);
        setDelAssistDataTime(defDelAssistDataTime);
        commitSetting();
    }

    public void commitSetting(){
        editor.apply();
        editor.commit();
        L.d("commitSetting");
    }
}