package com.contacts.contacts.ui.activity.category;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import com.contacts.contacts.R;
import com.contacts.contacts.ui.adapter.category.CategoryListAdapter;
import com.contacts.contacts.ui.activity.contacts.ContactsActivity;
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
        CategoriesBean categoriesBean1 = new CategoriesBean(R.drawable.category_babies_160, "Babies");
        CategoriesBean categoriesBean2 = new CategoriesBean(R.drawable.category_other_160, "Other");
        CategoriesBean categoriesBean3 = new CategoriesBean(R.drawable.code_160x160, "Code");
        CategoriesBean categoriesBean4 = new CategoriesBean(R.drawable.dragon_160x160, "Dragon");

        CategoriesBean categoriesBean5 = new CategoriesBean(R.drawable.category_babies_160, "Babies");
        CategoriesBean categoriesBean6 = new CategoriesBean(R.drawable.category_other_160, "Other");
        CategoriesBean categoriesBean7 = new CategoriesBean(R.drawable.code_160x160, "Code");
        CategoriesBean categoriesBean8 = new CategoriesBean(R.drawable.dragon_160x160, "Dragon");

        CategoriesBean categoriesBean9 = new CategoriesBean(R.drawable.category_babies_160, "Babies");
        CategoriesBean categoriesBean10 = new CategoriesBean(R.drawable.category_other_160, "Other");
        CategoriesBean categoriesBean11 = new CategoriesBean(R.drawable.code_160x160, "Code");
        CategoriesBean categoriesBean12 = new CategoriesBean(R.drawable.dragon_160x160, "Dragon");

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
