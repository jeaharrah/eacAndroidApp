package com.example.jeaha.navigationdrawer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

//
/*RecyclerView.Adapter
 * RecyclerView.ItemViewHolder
 * */
public class BizAdapter extends RecyclerView.Adapter<BizAdapter.ItemViewHolder> {

    private Context mCtxt;
    private List<Item> itemList;

    public BizAdapter(Context mCtxt, List<Item> itemList) {
        this.mCtxt = mCtxt;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtxt);
        View view = inflater.inflate(R.layout.list_layout, null);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.textViewTitle.setText(item.getTitle());
        holder.textViewDesc.setText(item.getShortDesc());
        holder.textViewLocation.setText(String.valueOf(item.getLocation()));
        holder.textViewTime.setText(String.valueOf(item.getTime()));
        holder.textViewMonth.setText(String.valueOf(item.getMonth()));
        holder.textViewDate.setText(String.valueOf(item.getDate()));


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView positionGuide;
        TextView textViewTitle, textViewDesc, textViewLocation, textViewTime, textViewMonth, textViewDate, textViewWeekday;


        public ItemViewHolder(View itemView) {
            super(itemView);

            positionGuide = itemView.findViewById(R.id.photoCell);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewLocation = itemView.findViewById(R.id.textViewLocation);
            textViewTime = itemView.findViewById(R.id.textViewTime);
            textViewMonth = itemView.findViewById(R.id.textViewMonth);
            textViewDate = itemView.findViewById(R.id.textViewBigDateNum);
            textViewWeekday = itemView.findViewById(R.id.textViewWeekday);


        }
    }

}
