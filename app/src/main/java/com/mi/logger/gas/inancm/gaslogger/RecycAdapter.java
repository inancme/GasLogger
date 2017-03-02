package com.mi.logger.gas.inancm.gaslogger;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.View;
import java.util.List;

/**
 * Created by metinin on 02.03.2017.
 */

public class RecycAdapter extends RecyclerView.Adapter<RecycAdapter.ViewHolder> {
    //private String[] mDataset;
    private List<GasLog> gasLogList;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mileage, volume, money;
        public ViewHolder(View v) {
            super(v);
            mileage = (TextView) v.findViewById(R.id.mileage);
            volume = (TextView) v.findViewById(R.id.volume);
            money = (TextView) v.findViewById(R.id.money);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public RecycAdapter(List<GasLog> gl) {
        this.gasLogList = gl;
    }


    @Override
    public RecycAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemView =  LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.gas_log_row, parent, false);
        // set the view's size, margins, paddings and layout parameters
        //...
        ViewHolder vh = new ViewHolder(itemView);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecycAdapter.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        GasLog gl = gasLogList.get(position);
        holder.mileage.setText(gl.getMileage());
        holder.volume.setText(gl.getVolume());
        holder.money.setText(gl.getMoney());
    }


    @Override
    public int getItemCount() {
        return gasLogList.size();
    }
}
