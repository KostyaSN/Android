package com.test.lesson4.Adapterss;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.lesson4.Models.Summa;
import com.test.lesson4.R;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class SummaAdepter extends RecyclerView.Adapter<SummaAdepter.SummaHolder> {

    private List<Summa> mList;
    private ItemClickListener mItemClickListener;

    public void setmItemClickListener(ItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public SummaAdepter(List<Summa> list) {
        mList = list;
    }

    public void addItems(List<Summa> list){
        mList = list;
        notifyDataSetChanged();
    }
    @Override
    public SummaHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.summ_adapter, parent, false);

        SummaHolder summaHolder = new SummaHolder(view);
        //возвращяем обработанные данные
        return summaHolder;
    }

    @Override
    public void onBindViewHolder(SummaHolder holder, int position) {

        final Summa summa = mList.get(position);

        holder.summa.setText(String.valueOf(summa.getSumma()));

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.US);
        String stringDate = sdf.format(summa.getDate());


        holder.date.setText(stringDate);
        holder.name.setText(summa.getName());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mItemClickListener != null){
                    mItemClickListener.onClick(summa);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        //сокращенный варианта if/else
        return mList == null ? 0: mList.size();
    }

    public static class SummaHolder extends RecyclerView.ViewHolder{
        CardView cv;
        View view;
        TextView summa;
        TextView date;
        TextView name;

        public SummaHolder(View itemView) {

            super(itemView);

            view = itemView;
            cv = (CardView)itemView.findViewById(R.id.cv);
            summa = (TextView) itemView.findViewById(R.id.tv_summa);
            date = (TextView) itemView.findViewById(R.id.tv_date);
            name = (TextView) itemView.findViewById(R.id.tv_name);

        }
    }

    public interface ItemClickListener{
        void onClick(Summa summa);

    }

}
