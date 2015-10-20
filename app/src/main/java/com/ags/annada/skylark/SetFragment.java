package com.ags.annada.skylark;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ags.annada.skylark.events.NetworkResponse;
import com.ags.annada.skylark.json.SetFactory;
import com.ags.annada.skylark.json.SetModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by Annada on 20/10/2015.
 */
public class SetFragment extends Fragment{
    private static final String TAG = SetFragment.class.getSimpleName();

    private RecyclerView mSetList;
    private SetAdapter mSetAdapter;
    List<SetInfo> mSetInfoList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_set,container,false);
        mSetList = (RecyclerView)rootView.findViewById(R.id.setList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mSetList.setLayoutManager(linearLayoutManager);

        Intent networkServiceIntent = new Intent(Intent.ACTION_SYNC, null, getContext(), NetworkService.class);
        getContext().startService(networkServiceIntent);

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().registerSticky(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(NetworkResponse event){
        if(event.getStatus().equalsIgnoreCase("success")) {
            String data = event.getResult();

            Gson gson = new Gson();
            JsonParser parser = new JsonParser();
            JsonArray jArray = (JsonArray)parser.parse(data).getAsJsonObject().getAsJsonArray("objects");
            ArrayList<SetModel>setModels = new ArrayList<SetModel>();

            for(JsonElement obj : jArray ){
                SetModel setModel = (SetModel)(gson.fromJson(obj,SetModel.class));

                setModels.add(setModel);
            }

            createSetInfoList(setModels);
            mSetAdapter.notifyDataSetChanged();

        }else if(event.getStatus().equalsIgnoreCase("failed")){
            Log.e(TAG, "network operation failed");
        }
    }

    public void createSetInfoList(List<SetModel> setModels){
        for(int i=0;i<setModels.size();i++){
            SetInfo setInfo = new SetInfo();
            SetModel setModel = setModels.get(i);
            setInfo.title = setModel.getTitle();

            mSetInfoList.add(setInfo);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mSetInfoList = new ArrayList<SetInfo>();
        mSetAdapter = new SetAdapter(mSetInfoList);
        mSetList.setAdapter(mSetAdapter);
    }
}
