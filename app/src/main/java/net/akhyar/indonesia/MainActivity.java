package net.akhyar.indonesia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import net.akhyar.indonesia.model.Sila;
import net.akhyar.indonesia.model.SilaAdapter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;

/**
 * @author akhyar
 */
public class MainActivity extends BaseActivity {

    @InjectView(R.id.list)
    ListView mList;
    @Inject
    SilaAdapter mSilaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        mList.addHeaderView(getLayoutInflater().inflate(R.layout.header, null));
        mList.setAdapter(mSilaAdapter);
    }

    @OnItemClick(R.id.list)
    public void goToSila(int pos) {
        Sila sila = mSilaAdapter.getItem(pos - mList.getHeaderViewsCount());

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("title", sila.getText());
        intent.putExtra("points", sila.getPoints());
        intent.putExtra("imageResId", sila.getImageResId());
        startActivity(intent);
    }
}
