package com.contacts.ui.activity.category;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.contacts.contacts.R;
import com.contacts.ui.adapter.category.CategoryListAdapter;
import com.contacts.ui.activity.contacts.ContactsActivity;
import com.contacts.db.beans.CategoriesBean;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class CategoriesActivityFragment extends Fragment {

    List<CategoriesBean> categoriesBeen = null;
    public CategoriesActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        categoriesBeen = new ArrayList<>();
        CategoriesBean categoriesBean1 = new CategoriesBean(R.drawable.icon_appliances, "Applicances");
        CategoriesBean categoriesBean2 = new CategoriesBean(R.drawable.icon_books, "Books");
        CategoriesBean categoriesBean3 = new CategoriesBean(R.drawable.icon_clothing, "Clothing");
        CategoriesBean categoriesBean4 = new CategoriesBean(R.drawable.icon_electronics, "Electronics");

        CategoriesBean categoriesBean5 = new CategoriesBean(R.drawable.icon_furniture, "Furniture");
        CategoriesBean categoriesBean6 = new CategoriesBean(R.drawable.icon_health, "Health");
        CategoriesBean categoriesBean7 = new CategoriesBean(R.drawable.icon_books, "Books");
        //CategoriesBean categoriesBean7 = new CategoriesBean(R.drawable.icon_jewellery, "Jewellery");
        CategoriesBean categoriesBean8 = new CategoriesBean(R.drawable.icon_sports, "Sports");

        CategoriesBean categoriesBean9 = new CategoriesBean(R.drawable.icon_appliances, "Applicances");
        CategoriesBean categoriesBean10 = new CategoriesBean(R.drawable.icon_books, "Books");
        CategoriesBean categoriesBean11 = new CategoriesBean(R.drawable.icon_clothing, "Clothing");
        CategoriesBean categoriesBean12 = new CategoriesBean(R.drawable.icon_electronics, "Electronics");

        CategoriesBean categoriesBean13 = new CategoriesBean(R.drawable.icon_furniture, "Furniture");
        CategoriesBean categoriesBean14 = new CategoriesBean(R.drawable.icon_health, "Health");
        CategoriesBean categoriesBean15 = new CategoriesBean(R.drawable.icon_books, "Books");
        //CategoriesBean categoriesBean7 = new CategoriesBean(R.drawable.icon_jewellery, "Jewellery");
        CategoriesBean categoriesBean16 = new CategoriesBean(R.drawable.icon_sports, "Sports");

        categoriesBeen.add(categoriesBean1);
        categoriesBeen.add(categoriesBean2);
        categoriesBeen.add(categoriesBean3);
        categoriesBeen.add(categoriesBean4);

        categoriesBeen.add(categoriesBean5);
        categoriesBeen.add(categoriesBean6);
        categoriesBeen.add(categoriesBean7);
        categoriesBeen.add(categoriesBean8);
        categoriesBeen.add(categoriesBean9);
        categoriesBeen.add(categoriesBean10);
        categoriesBeen.add(categoriesBean11);
        categoriesBeen.add(categoriesBean12);

        categoriesBeen.add(categoriesBean13);
        categoriesBeen.add(categoriesBean14);
        categoriesBeen.add(categoriesBean15);
        categoriesBeen.add(categoriesBean16);

        return inflater.inflate(R.layout.fragment_categories, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        CategoryListAdapter coursesListAdapter = new CategoryListAdapter(getActivity(), R.layout.adapter_category_list, categoriesBeen);

        GridView gridView = (GridView) getView().findViewById(R.id.categoriesGridView);
        gridView.setAdapter(coursesListAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ContactsActivity.class);
                startActivity(intent);
            }
        });
    }
}