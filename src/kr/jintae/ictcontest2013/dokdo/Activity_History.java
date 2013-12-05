package kr.jintae.ictcontest2013.dokdo;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class Activity_History extends Activity {

	private static final int NUM_OF_HISTORY = 8;
	private ArrayList<HashMap<String, String>> historyArrayList = new ArrayList<HashMap<String, String>>();

	private ListView historyList;
	private HistoryListAdapter mHistoryListAdapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_history);
		historyList = (ListView) findViewById(R.id.list);
		historyArrayList = getHistoryArrayList();
		mHistoryListAdapter = new HistoryListAdapter(this,
				R.layout.history_item, historyArrayList);
		historyList.setAdapter(mHistoryListAdapter);

		ActionBar actionBar = getActionBar();
		actionBar.show();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setTitle(R.string.act1_history);
	}

	private ArrayList<HashMap<String, String>> getHistoryArrayList() {
		ArrayList<HashMap<String, String>> tmpHistoryArrayList = new ArrayList<HashMap<String, String>>();

		int[] historyList = new int[NUM_OF_HISTORY];
		historyList[0] = R.array.h1145;
		historyList[1] = R.array.h1454;
		historyList[2] = R.array.h1531;
		historyList[3] = R.array.h1667;
		historyList[4] = R.array.h1696;
		historyList[5] = R.array.h1808;
		historyList[6] = R.array.h1870;
		historyList[7] = R.array.h1877;
		for (int i = 0; i < NUM_OF_HISTORY; i++) {
			HashMap<String, String> _Item = new HashMap<String, String>();
			CharSequence[] tmpCS = getResources().getTextArray(historyList[i]);
			_Item.put("HistoryYear", tmpCS[0].toString());
			_Item.put("HistoryTitle", tmpCS[1].toString());
			_Item.put("HistoryDiscription", tmpCS[2].toString());
			_Item.put("HistoryPicture", tmpCS[3].toString());
			tmpHistoryArrayList.add(_Item);
		}
		return tmpHistoryArrayList;
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			break;

		default:
			return false;
		}
		return true;
	}
}
