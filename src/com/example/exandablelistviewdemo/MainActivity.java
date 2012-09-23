package com.example.exandablelistviewdemo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnChildClickListener, OnGroupClickListener{

	private ArrayList<ExpandListGroup> groups = new ArrayList<ExpandListGroup>();
	private ArrayList<ExpandListChild> childs;
	private ExpandableListView mExpandableListView;
	private MyAdapter adapter;
	private int CHILD_LIMIT = 2, GROUP_LIMIT = 15;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mExpandableListView = (ExpandableListView) findViewById(R.id.ExpList);
        adapter = new MyAdapter(fillData(), this);
        mExpandableListView.setAdapter(adapter);
        mExpandableListView.setOnChildClickListener(this);
        mExpandableListView.setOnGroupClickListener(this);
    }
    
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
    		String parent_value = ((ExpandListGroup)adapter.getGroup(groupPosition)).getName();
    		String child_value = ((ExpandListChild)adapter.getChild(groupPosition, childPosition)).getName();
    		Toast.makeText(MainActivity.this, parent_value+" "+child_value, Toast.LENGTH_LONG).show();
		return false;
	}
    
    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
    	Toast.makeText(MainActivity.this, ((ExpandListGroup)adapter.getGroup(groupPosition)).getName(), Toast.LENGTH_LONG).show();
		return false;
	}
    
    /**
     *
     *  Returns the data with Groups and Childs
     * 
     **/
    private ArrayList<ExpandListGroup> fillData() {
    	
    	for (int i = 1; i <= GROUP_LIMIT; i++) {
    		// initializing child ArrayList
    		childs = new ArrayList<ExpandListChild>();
    		
    		if(i % 2 == 0)
    			CHILD_LIMIT = 1;
    		else
    			CHILD_LIMIT = 2;
    			
    		for (int j = 1; j <= CHILD_LIMIT; j++) {
    	    	ExpandListChild child = new ExpandListChild();
    	    	child.setName("Child "+j);
    	    	childs.add(child);
			}
    		// setting values to Group POJO Class
    		ExpandListGroup group = new ExpandListGroup();
    		group.setName("Group "+i);
    		
    		// adding child to Group POJO Class
    		group.setChildItems(childs);
    		
    		// adding group to groups ArrayList
    		groups.add(group);
		}
		return groups;
	}
}
