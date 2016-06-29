package com.contacts.contacts.ui.adapter.category;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.contacts.contacts.R;
import com.contacts.db.beans.CategoriesBean;

import java.util.List;

/**
 * Created by pkonwar on 6/28/2016.
 */
public class CategoryListAdapter extends ArrayAdapter<CategoriesBean> {

    private Context context;
    private List<CategoriesBean> categories;

    public CategoryListAdapter(Context context, int resource, List<CategoriesBean> categories) {
        super(context, resource, categories);
        this.context = context;
        this.categories = categories;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);

        CategoriesBean category = categories.get(position);

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.adapter_category_list, null);

        ImageView categoryImage = (ImageView) view.findViewById(R.id.categoryImageImageview);
        TextView categoryTextview = (TextView) view.findViewById(R.id.categoryNameText);

        categoryImage.setImageResource(category.getCategoryImage());
        categoryTextview.setText(category.getCategoryName());
        return view;
    }
}
