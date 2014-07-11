package net.akhyar.indonesia;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import net.akhyar.indonesia.model.PointAdapter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author akhyar
 */
public class DetailActivity extends BaseActivity {

    @InjectView(R.id.list)
    ListView mList;
    @Inject
    PointAdapter mPointAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.inject(this);

        String title = getIntent().getStringExtra("title");
        setTitle(title);

        String[] points = getIntent().getStringArrayExtra("points");
        mPointAdapter.setPoints(points);

        int imageResId = getIntent().getIntExtra("imageResId", 0);
        View header = getLayoutInflater().inflate(R.layout.header, null);
        ImageView imageView = (ImageView) header.findViewById(R.id.image);
        imageView.setImageResource(imageResId);

        mList.addHeaderView(header);
        mList.setAdapter(mPointAdapter);
    }
}
