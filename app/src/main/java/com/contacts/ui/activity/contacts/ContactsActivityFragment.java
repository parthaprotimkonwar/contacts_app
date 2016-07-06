package com.contacts.ui.activity.contacts;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.contacts.contacts.R;
import com.contacts.ui.adapter.contacts.ContactListAdapter;
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

        ContactsBean contactsBean5 = new ContactsBean("Raman Raghav", R.drawable.profile, 200, 9900065578L, 4);
        ContactsBean contactsBean6 = new ContactsBean("Sheena Bora", R.drawable.sheena_bora, 300, 9900065578L, 2);
        ContactsBean contactsBean7 = new ContactsBean("Robin Jacob", R.drawable.robin_lacob, 400, 9900065578L, 3);
        ContactsBean contactsBean8 = new ContactsBean("Rumili Tagore", R.drawable.rumil_tagore, 100, 9900065578L, 1);

        ContactsBean contactsBean9 = new ContactsBean("Raman Raghav", R.drawable.profile, 200, 9900065578L, 4);
        ContactsBean contactsBean10 = new ContactsBean("Sheena Bora", R.drawable.sheena_bora, 300, 9900065578L, 2);
        ContactsBean contactsBean11 = new ContactsBean("Robin Jacob", R.drawable.robin_lacob, 400, 9900065578L, 3);
        ContactsBean contactsBean12 = new ContactsBean("Rumili Tagore", R.drawable.rumil_tagore, 100, 9900065578L, 1);

        ContactsBean contactsBean13 = new ContactsBean("Raman Raghav", R.drawable.profile, 200, 9900065578L, 4);
        ContactsBean contactsBean14 = new ContactsBean("Sheena Bora", R.drawable.sheena_bora, 300, 9900065578L, 2);
        ContactsBean contactsBean15 = new ContactsBean("Robin Jacob", R.drawable.robin_lacob, 400, 9900065578L, 3);
        ContactsBean contactsBean16 = new ContactsBean("Rumili Tagore", R.drawable.rumil_tagore, 100, 9900065578L, 1);

        contactsBeanList.add(contactsBean1);
        contactsBeanList.add(contactsBean2);
        contactsBeanList.add(contactsBean3);
        contactsBeanList.add(contactsBean4);

        contactsBeanList.add(contactsBean5);
        contactsBeanList.add(contactsBean6);
        contactsBeanList.add(contactsBean7);
        contactsBeanList.add(contactsBean8);

        contactsBeanList.add(contactsBean16);
        contactsBeanList.add(contactsBean9);
        contactsBeanList.add(contactsBean10);
        contactsBeanList.add(contactsBean11);

        contactsBeanList.add(contactsBean12);
        contactsBeanList.add(contactsBean13);
        contactsBeanList.add(contactsBean14);
        contactsBeanList.add(contactsBean15);

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
