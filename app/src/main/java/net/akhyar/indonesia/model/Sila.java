package net.akhyar.indonesia.model;

import android.content.Context;

import net.akhyar.indonesia.Application;
import net.akhyar.indonesia.R;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @author akhyar
 */
public class Sila {

    @Inject
    Context context;

    private int id;
    private int imageResId;
    private String text;
    private String[] points;

    public Sila(int id, int imageResId, int pointsArrayResId, String text) {
        this.id = id;
        this.imageResId = imageResId;
        this.text = text;

        Application.inject(this);
        points = context.getResources().getStringArray(pointsArrayResId);
    }

    public static List<Sila> getAll() {
        List<Sila> silaList = new ArrayList<Sila>();
        silaList.add(new Sila(1, R.drawable.sila1, R.array.butir1, "Ketuhanan yang maha esa"));
        silaList.add(new Sila(2, R.drawable.sila2, R.array.butir2, "Kemanusiaan yang adil dan beradab"));
        silaList.add(new Sila(3, R.drawable.sila3, R.array.butir3, "Persatuan Indonesia"));
        silaList.add(new Sila(4, R.drawable.sila4, R.array.butir4, "Kerakyatan yang dipimpin oleh hikmat, kebijaksanaan dalam permusyawaratan/perwakilan"));
        silaList.add(new Sila(5, R.drawable.sila5, R.array.butir5, "Keadilan sosial bagi seluruh rakyat Indonesia"));

        return silaList;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getPoints() {
        return points;
    }

}
