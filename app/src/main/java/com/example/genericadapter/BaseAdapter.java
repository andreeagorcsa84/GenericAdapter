package com.example.genericadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BaseAdapter<T1, T2 extends ViewDataBinding> extends RecyclerView.Adapter<BaseAdapter.BaseViewHolder> {

    private List<T1> list;
    private final Context context;
    private LayoutInflater inflater;

    @LayoutRes
    private int layout;
    private BindView<T2> bindView;

    // adapter constructor
    public BaseAdapter(Context context, @LayoutRes int layout) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        list = new ArrayList<>();
    }


    @Override
    public BaseAdapter.BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(layout, parent, false);
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
           bindView.onBindViewHolder((T2)holder.getBinding(), position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface BindView<T2> {
        void onBindViewHolder(T2 b, int position);
    }

    // ViewHolder class
    public static class BaseViewHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding b;

        public BaseViewHolder(View itemView) {
            super(itemView);
            b = DataBindingUtil.bind(itemView);
        }

        // getter method for View
        public ViewDataBinding getBinding() {
            return b;
        }
    }
}
