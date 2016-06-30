package com.contacts.contacts.ui.activity.contacts;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.contacts.contacts.R;
import com.contacts.contacts.ui.adapter.category.CategoryListAdapter;
import com.contacts.contacts.ui.adapter.contacts.ContactListAdapter;
import com.contacts.db.beans.ContactsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ContactsActivityFragment extends Fragment {

    List<ContactsBean> contactsBeanList;

    public ContactsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        contactsBeanList = new ArrayList<>();
        ContactsBean contactsBean1 = new ContactsBean("Raman Raghav", R.drawable.profile, 200, 9900065578L, 4);
        ContactsBean contactsBean2 = new ContactsBean("Sheena Bora", R.drawable.sheena_bora, 300, 9900065578L, 2);
        ContactsBean contactsBean3 = new ContactsBean("Robin Jacob", R.drawable.robin_lacob, 400, 9900065578L, 3);
        ContactsBean contactsBean4 = new ContactsBean("Rumili Tagore", R.drawable.rumil_tagore, 100, 9900065578L, 1);

        contactsBeanList.add(contactsBean1);
        contactsBeanList.add(contactsBean2);
        contactsBeanList.add(contactsBean3);
        contactsBeanList.add(contactsBean4);
        return inflater.inflate(R.layout.fragment_contacts, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ContactListAdapter contactListAdapter = new ContactListAdapter(getActivity(), R.layout.adapter_contacts_lists, contactsBeanList);
        ListView contactsListView = (ListView) getView().findViewById(R.id.contactsListView);
        contactsListView.setAdapter(contactListAdapter);
    }
}
