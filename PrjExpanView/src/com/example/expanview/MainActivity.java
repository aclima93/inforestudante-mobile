package com.example.expanview;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.ExpandableListView;


public class MainActivity extends Activity {
	final static int drwChild[] = {R.drawable.ic_horario_unselected, R.drawable.ic_horario_selected};

	// more efficient than HashMap for mapping integers to objects
	SparseArray<Group> groups = new SparseArray<Group>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
		createData();
		ExpandableListView listView = (ExpandableListView) findViewById(R.id.listView);
		ExpandAdapterActivity adapter = new ExpandAdapterActivity(this, groups);
		listView.setAdapter(adapter);
	}

	public void createData() { 
  		Child child = null;
		Group group1 = new Group("Próximas Aulas", Color.DKGRAY, Color.WHITE, 0);
	  	for (int i = 0; i < 5; i++) {
            if(i % 2 != 0) child = new Child("Aula " + i, Color.WHITE, Color.DKGRAY, drwChild[0]);
	  		else child = new Child ("Aula " + i, Color.DKGRAY, Color.WHITE, drwChild[1]);
 	  		group1.children.add(child);
  		}
	  	groups.append(0, group1);

	  	Group group2 = new Group("Notificações", Color.WHITE, Color.DKGRAY, 0);
	  	for (int i = 0; i < 5; i++) {
            if(i % 2 != 0) child = new Child("Notificação " + i, Color.WHITE, Color.DKGRAY, drwChild[0]);
            else child = new Child ("Notificação " + i, Color.DKGRAY, Color.WHITE, drwChild[1]);
 	  		group2.children.add(child);
  		}
	  	groups.append(1, group2);

	  	Group group3 = new Group("Materiais de Apoio", Color.DKGRAY, Color.WHITE, 0);
	  	for (int i = 0; i < 5; i++) {
            if(i % 2 != 0) child = new Child("Material " + i, Color.WHITE, Color.DKGRAY, drwChild[0]);
            else child = new Child ("Material " + i, Color.DKGRAY, Color.WHITE, drwChild[1]);
 	  		group3.children.add(child);
  		}
	  	groups.append(2, group3);
	}
}

