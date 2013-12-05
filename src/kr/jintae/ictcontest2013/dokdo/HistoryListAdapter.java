package kr.jintae.ictcontest2013.dokdo;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HistoryListAdapter extends BaseAdapter {
	Context maincon;
	LayoutInflater Inflater;
	ArrayList<HashMap<String, String>> arSrc;
	int layout;

	public HistoryListAdapter(Context context, int alayout,
			ArrayList<HashMap<String, String>> aarSrc) {
		maincon = context;
		Inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		arSrc = aarSrc;
		layout = alayout;
	}

	public int getCount() {
		return arSrc.size();
	}

	public HashMap<String, String> getItem(int position) {
		return arSrc.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		final int pos = position;
		if (convertView == null) {
			convertView = Inflater.inflate(layout, parent, false);
		}
		convertView.setTag(position);
		convertView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final RelativeLayout rl = (RelativeLayout) View.inflate(
						maincon, R.layout.history_item_detail, null);
				TextView tvPopupTitile = (TextView) rl
						.findViewById(R.id.tvPopupTitle);
				tvPopupTitile.setText(arSrc.get(pos).get("HistoryYear") + " | "
						+ arSrc.get(pos).get("HistoryTitle"));
				ImageView ivPopupImage = (ImageView) rl
						.findViewById(R.id.ivPopupDetailPicture);

				String resName = "@drawable/"
						+ arSrc.get(pos).get("HistoryPicture");
				String packName = maincon.getPackageName(); // 패키지명
				int resID = maincon.getResources().getIdentifier(resName,
						"drawable", packName);
				ivPopupImage.setImageResource(resID);

				AlertDialog.Builder historyPopup = new AlertDialog.Builder(
						maincon);
				historyPopup.setView(rl);
				historyPopup.setNegativeButton("닫        기",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub

							}
						});
				historyPopup.show();
			}
		});
		// convertView.setOnTouchListener(new OnTouchListener() {
		// @Override
		// public boolean onTouch(View v, MotionEvent event) {
		// return true;
		// }
		//
		// });
		HashMap<String, String> ci = getItem(position);
		if (ci != null) {

			TextView tvYear = (TextView) convertView
					.findViewById(R.id.tv_history_year);
			tvYear.setText(arSrc.get(position).get("HistoryYear") + " | ");

			TextView tvTitle = (TextView) convertView
					.findViewById(R.id.tv_history_title);
			tvTitle.setText(arSrc.get(position).get("HistoryTitle"));

			TextView tvDescription = (TextView) convertView
					.findViewById(R.id.tv_history_description);
			tvDescription
					.setText(arSrc.get(position).get("HistoryDiscription"));

		}
		return convertView;
	}

}
