package com.ags.annada.skylark;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Annada on 20/10/2015.
 */
public class SetAdapter extends RecyclerView.Adapter<SetAdapter.SetViewHolder>{
    private static final String TAG = SetAdapter.class.getSimpleName();

    private List<SetInfo> mSetInfoList;

    public SetAdapter(List<SetInfo> setInfoList){
        this.mSetInfoList = setInfoList;
    }

    @Override
    public SetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);

        return new SetViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(SetViewHolder holder, int position) {
        SetInfo setInfo = mSetInfoList.get(position);
        //holder.mIVimage.setText(setInfo.name);
        holder.mTVtitle.setText(setInfo.title);
    }

    @Override
    public int getItemCount() {
        return mSetInfoList.size();
    }

    public static class SetViewHolder extends RecyclerView.ViewHolder {
        //protected ImageView mIVimage;
        protected TextView mTVtitle;

        public SetViewHolder(View v) {
            super(v);
            //mIVimage = (ImageView) v.findViewById(R.id.image);
            mTVtitle = (TextView) v.findViewById(R.id.title);
        }
    }
}
