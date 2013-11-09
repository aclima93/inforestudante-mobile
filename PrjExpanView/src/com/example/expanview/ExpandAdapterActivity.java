package com.example.expanview;

import android.app.Activity;
import android.graphics.Typeface;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.widget.Toast;

public class ExpandAdapterActivity extends BaseExpandableListAdapter {

	  private final SparseArray<Group> groups;
	  public LayoutInflater inflater;
	  public Activity activity;

	  public ExpandAdapterActivity(Activity act, SparseArray<Group> groups) {
		  activity = act;
		  this.groups = groups;
		  inflater = act.getLayoutInflater();
	  } 

	  @Override
	  public Object getChild(int groupPosition, int childPosition) {
		  return groups.get(groupPosition).children.get(childPosition);
	  }

	  @Override
	  public long getChildId(int groupPosition, int childPosition) {
		  return 0;
	  }

	  @Override
	  public View getChildView(int groupPosition, final int childPosition,
			  							boolean isLastChild, View convertView, ViewGroup parent) {
		  Child child = (Child) getChild(groupPosition, childPosition);
		  final String childName = child.string;
		  TextView text = null;
		  if (convertView == null) {
			  convertView = inflater.inflate(R.layout.listrow_details, null);
		  }
		  text = (TextView) convertView.findViewById(R.id.textView1);
		  text.setText(childName);
		  text.setTypeface(Typeface.SERIF);
		  text.setTextSize(25);   //20 -> 25
		  text.setBackgroundColor(child.backGroundColor);
		  text.setTextColor(child.fontColor);
		  text.setEms(20000);
		  text.setCompoundDrawablesWithIntrinsicBounds(child.drwLeft, 0, 0, 0);
		  convertView.setOnClickListener(new OnClickListener() {
		      @Override
		      public void onClick(View v) {
		    	  Toast.makeText(activity, childName,
				  Toast.LENGTH_SHORT).show();
		      }
		  });
		  return convertView;
	  }

	  @Override
	  public int getChildrenCount(int groupPosition) {
		  return groups.get(groupPosition).children.size();
	  }

	  @Override
	  public Object getGroup(int groupPosition) {
		  return groups.get(groupPosition);
	  }

	  @Override
	  public int getGroupCount() {
		  return groups.size();
	  }

	  @Override
	  public void onGroupCollapsed(int groupPosition) {
		  super.onGroupCollapsed(groupPosition);
	  }

	  @Override
	  public void onGroupExpanded(int groupPosition) {
		  super.onGroupExpanded(groupPosition);
	  }

	  @Override
	  public long getGroupId(int groupPosition) {
		  return 0;
	  }

	  @Override
	  public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		  if (convertView == null) {
			  convertView = inflater.inflate(R.layout.listrow_group, null);
		  }
		  Group group = (Group) getGroup(groupPosition);
		  ((CheckedTextView) convertView).setText(group.string);
		  ((CheckedTextView) convertView).setTextSize(25);
		  convertView.setBackgroundColor(group.backGroundColor);
		  ((CheckedTextView) convertView).setTextColor(group.fontColor);
		  ((CheckedTextView) convertView).setCompoundDrawablesWithIntrinsicBounds(group.drwLeft, 0, 0, 0);
		  ((CheckedTextView) convertView).setChecked(isExpanded);
		  return convertView;
	  }

	  @Override
	  public boolean hasStableIds() {
		  return false;
	  }

	  @Override
	  public boolean isChildSelectable(int groupPosition, int childPosition) {
		  return false;
	  }
	} 