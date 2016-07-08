package com.contacts.ui.adapter.category;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.contacts.contacts.R;
import com.contacts.db.models.specialities.SubSpeciality;

import java.util.List;

/**
 * Created by pkonwar on 6/28/2016.
 */
public class CategoryListAdapter extends ArrayAdapter<SubSpeciality> {

    private Context context;
    private List<SubSpeciality> subSpecialityList;

    public CategoryListAdapter(Context context, int resource, List<SubSpeciality> subSpecialityList) {
        super(context, resource, subSpecialityList);
        this.context = context;
        this.subSpecialityList = subSpecialityList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);

        SubSpeciality subSpeciality = subSpecialityList.get(position);

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.adapter_category_list, null);

        ImageView categoryImage = (ImageView) view.findViewById(R.id.categoryImageImageview);
        TextView categoryTextview = (TextView) view.findViewById(R.id.categoryNameText);

        //Image is present for a category
        if(subSpeciality.getImageBlob() != null) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(subSpeciality.getImageBlob(), 0, subSpeciality.getImageBlob().length);
            categoryImage.setImageBitmap(bitmap);
        } else {
            categoryImage.setImageResource(R.drawable.screen_shot);
        }

        categoryTextview.setText(subSpeciality.getSubSpeciality());
        return view;
    }
}
