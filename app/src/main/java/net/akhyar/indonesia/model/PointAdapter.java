package net.akhyar.indonesia.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import net.akhyar.indonesia.R;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author akhyar
 */
public class PointAdapter extends BaseAdapter {

    @Inject
    Context context;

    private String[] points;

    public String[] getPoints() {
        return points;
    }

    public void setPoints(String[] points) {
        this.points = points;
    }

    @Override
    public int getCount() {
        return points.length;
    }

    @Override
    public String getItem(int position) {
        return points[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_point, null);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.mText1.setText((position + 1) + ".");
        holder.mText2.setText(getItem(position));

        return convertView;
    }

    public class Holder {
        @InjectView(R.id.text1)
        TextView mText1;
        @InjectView(R.id.text2)
        TextView mText2;

        Holder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
