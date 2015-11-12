package map.karen.com.materialdesignui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import map.karen.com.materialdesignui.R;

/**
 * Created by baikun on 2014/12/5.
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder>{

    private String[] mList;
    private boolean mWaterfalls;
    private List<Integer> mItemHeight;

    public RecycleAdapter(Context contexts,boolean waterfalls) {
        super();
        this.mList = contexts.getResources().getStringArray(R.array.AZ_array);
        this.mWaterfalls=waterfalls;
        this.mItemHeight = new ArrayList<>();
        for (int i = 0; i < mList.length; i++) {
            mItemHeight.add((int) (Math.random() * 300) + 100);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = View.inflate(viewGroup.getContext(), R.layout.adapter_recycle, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        if(mWaterfalls){
            ViewGroup.LayoutParams mLayoutParams = viewHolder.mTextView.getLayoutParams();
            mLayoutParams.height = mItemHeight.get(i);
            viewHolder.mTextView.setLayoutParams(mLayoutParams);
        }
        viewHolder.mTextView.setText(mList[i]);


    }

    @Override
    public int getItemCount() {
        return mList.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.id_textview);
        }
    }
}
