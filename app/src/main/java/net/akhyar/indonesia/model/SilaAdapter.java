package net.akhyar.indonesia.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import net.akhyar.indonesia.Application;
import net.akhyar.indonesia.R;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author akhyar
 */
public class SilaAdapter extends BaseAdapter {

    @Inject
    Context context;

    private List<Sila> list;

    public SilaAdapter() {
        this.list = Sila.getAll();
        Application.inject(this);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Sila getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_sila, null);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        Sila sila = getItem(position);
        holder.mText1.setText(sila.getText());
        holder.mImage.setImageResource(sila.getImageResId());
        return convertView;
    }

    public class Holder {
        @InjectView(R.id.image)
        ImageView mImage;
        @InjectView(R.id.text1)
        TextView mText1;

        Holder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
