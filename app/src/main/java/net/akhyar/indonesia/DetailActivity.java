package net.akhyar.indonesia;

import android.os.Bundle;
import android.view.MenuItem;
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();

        overridePendingTransition(R.anim.abc_slide_in_top, R.anim.abc_slide_out_bottom);
    }
}
