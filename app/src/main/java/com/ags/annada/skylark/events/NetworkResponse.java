package com.ags.annada.skylark.events;

/**
 * Created by Annada on 20/10/2015.
 */
public class NetworkResponse {
    private static String mStatus;
    private static String mResult;

    public String getStatus(){
        return mStatus;
    }

    public void setStatus(String status){
        this.mStatus = status;
    }

    public String getResult(){
        return mResult;
    }

    public void setResult(String result){
        this.mResult = result;
    }
}
