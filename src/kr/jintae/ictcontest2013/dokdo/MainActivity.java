package kr.jintae.ictcontest2013.dokdo;

import android.app.ActionBar;
import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements OnTouchListener,
		OnDragListener, OnClickListener {
	private ImageView ivAct0, ivAct1, ivAct2, ivAct3, ivAct4, ivAct5, ivMy;
	private TextView tvAct0, tvAct1, tvAct2, tvAct3, tvAct4, tvAct5, tvActMsg;
	private ImageButton btnStart;
	private String activityMsg;
	// �ؽ�Ʈ�䰡 �ۿ��� ��� �Ǿ��� �� ������� ���� �����ϱ� ���Ͽ� ���� ���Ǿ�� �並 ����ϰ� �ִٰ� ��������� ��
	private int previousViewId = R.id.ivAct11;
	private Intent callActivityIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		setContentView(R.layout.activity_main);
		
		
		ivAct0 = (ImageView) findViewById(R.id.ivAct00);
		ivAct1 = (ImageView) findViewById(R.id.ivAct11);
		ivAct2 = (ImageView) findViewById(R.id.ivAct22);
		ivAct3 = (ImageView) findViewById(R.id.ivAct33);
		ivAct4 = (ImageView) findViewById(R.id.ivAct44);
		ivAct5 = (ImageView) findViewById(R.id.ivAct55);
		ivMy = (ImageView) findViewById(R.id.ivMy);
		tvAct0 = (TextView) findViewById(R.id.tvAct00);
		tvAct1 = (TextView) findViewById(R.id.tvAct11);
		tvAct2 = (TextView) findViewById(R.id.tvAct22);
		tvAct3 = (TextView) findViewById(R.id.tvAct33);
		tvAct4 = (TextView) findViewById(R.id.tvAct44);
		tvAct5 = (TextView) findViewById(R.id.tvAct55);

		tvActMsg = (TextView) findViewById(R.id.tv_ActivityMsg);
		btnStart = (ImageButton) findViewById(R.id.btn_main_start);
		btnStart.setOnClickListener(this);

		ivMy.setOnTouchListener(this);
		// set drag listeners
		ivAct0.setOnDragListener(this);
		ivAct1.setOnDragListener(this);
		ivAct2.setOnDragListener(this);
		ivAct3.setOnDragListener(this);
		ivAct4.setOnDragListener(this);
		ivAct5.setOnDragListener(this);
		setMsg(previousViewId);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		startActivity(callActivityIntent);
	}

	private void setMsg(int targetViewID) {
		switch (targetViewID) {
		case R.id.ivAct00:
			// ���� ���� ����(����) tvAct00
			// TextView tvAct0 = (TextView) findViewById(R.id.tvAct00);
			activityMsg = getResources().getString(R.string.act1_history_description); 
			callActivityIntent = new Intent(MainActivity.this,
					Activity_History.class);
			break;
		case R.id.ivAct11:
			// ���������� (���)tvAct11
			// TextView tvAct1 = (TextView) findViewById(R.id.tvAct11);
			activityMsg = getResources().getString(R.string.act0_mypage_description);
			callActivityIntent = new Intent(MainActivity.this,
					Activity_MyPage.class);
			break;
		case R.id.ivAct22:
			// ������� ����(������) tvAct22
			// TextView tvAct2 = (TextView) findViewById(R.id.tvAct22);
			activityMsg =getResources().getString(R.string.act2_world_description); 
			callActivityIntent = new Intent(MainActivity.this,
					Activity_World.class);
			break;
		case R.id.ivAct33:
			// ���� ��级(����) tvAtc33
			// TextView tvAct3 = (TextView) findViewById(R.id.tvAct33);
			activityMsg = getResources().getString(R.string.act4_quiz_description); 
			callActivityIntent = new Intent(MainActivity.this,
					Activity_Quiz.class);
			break;
		case R.id.ivAct44:
			// ���� �׸�����(�� �Ʒ�) tvAct44
			// TextView tvAct4 = (TextView) findViewById(R.id.tvAct44);
			activityMsg = getResources().getString(R.string.act3_matching_card_description); 
			callActivityIntent = new Intent(MainActivity.this,
					Activity_MatchCard.class);
			break;
		case R.id.ivAct55:
			// ���� �׸�����(�� �Ʒ�) tvAct55
			// TextView tvAct4 = (TextView) findViewById(R.id.tvAct44);
			activityMsg = getResources().getString(R.string.act5_nature_description); 
			callActivityIntent = new Intent(MainActivity.this,
					Activity_MatchCard.class);
			break;
			
		}
		tvActMsg.setText(activityMsg);
	}

	private void setTextViewAlpha(int targetViewID, float alpha) {
		switch (targetViewID) {
		case R.id.ivAct00:
			// ���� ���� ����(����) tvAct00
			// TextView tvAct0 = (TextView) findViewById(R.id.tvAct00);
			tvAct0.setAlpha(alpha);
			break;
		case R.id.ivAct11:
			// ���������� (���)tvAct11
			// TextView tvAct1 = (TextView) findViewById(R.id.tvAct11);
			tvAct1.setAlpha(alpha);
			break;
		case R.id.ivAct22:
			// ������� ����(������) tvAct22
			// TextView tvAct2 = (TextView) findViewById(R.id.tvAct22);
			tvAct2.setAlpha(alpha);
			break;
		case R.id.ivAct33:
			// ���� ��级(����) tvAtc33
			// TextView tvAct3 = (TextView) findViewById(R.id.tvAct33);
			tvAct3.setAlpha(alpha);
			break;
		case R.id.ivAct44:
			// ���� �׸�����(�� �Ʒ�) tvAct44
			// TextView tvAct4 = (TextView) findViewById(R.id.tvAct44);
			tvAct4.setAlpha(alpha);
			break;
		case R.id.ivAct55:
			// ���� �׸�����(�� �Ʒ�) tvAct55
			// TextView tvAct4 = (TextView) findViewById(R.id.tvAct44);
			tvAct5.setAlpha(alpha);
			break;
		}
	}

	// private int exitedViewId = 0;

	@Override
	public boolean onDrag(View v, DragEvent event) {
		switch (event.getAction()) {
		case DragEvent.ACTION_DRAG_STARTED:
			// no action necessary
			break;
		case DragEvent.ACTION_DRAG_ENTERED:
			v.setAlpha((float) 1.0);
			setTextViewAlpha(v.getId(), (float) 1.0);
			break;
		case DragEvent.ACTION_DRAG_EXITED:
			// exitedViewId = v.getId();
			v.setAlpha((float) 0.3);
			if (previousViewId != v.getId()) {
				setTextViewAlpha(v.getId(), (float) 0.3);
			}
			// no action necessary
			break;
		case DragEvent.ACTION_DROP:
			tvAct0.setAlpha((float) 0.3);
			tvAct1.setAlpha((float) 0.3);
			tvAct2.setAlpha((float) 0.3);
			tvAct3.setAlpha((float) 0.3);
			tvAct4.setAlpha((float) 0.3);
			tvAct5.setAlpha((float) 0.3);
			setTextViewAlpha(v.getId(), (float) 1.0);

			previousViewId = v.getId();
			View view = (View) event.getLocalState();
			ViewGroup owner = (ViewGroup) view.getParent();
			owner.removeView(view);
			RelativeLayout container = (RelativeLayout) v.getParent();
			view.setLayoutParams(v.getLayoutParams());
			container.addView(view);
			view.setVisibility(View.VISIBLE);

			setMsg(previousViewId);

			break;
		case DragEvent.ACTION_DRAG_ENDED:
			if (event.getResult()) {
			} else {
			}
			break;
		default:
			break;
		}
		return true;
	}

	@Override
	public boolean onTouch(View view, MotionEvent motionEvent) {
		if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
			// setup drag
			ClipData data = ClipData.newPlainText("", "");
			DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
			// start dragging the item touched
			view.startDrag(data, shadowBuilder, view, 0);
			// view.setVisibility(View.INVISIBLE);

			return true;
		} else {

			return false;
		}
	}

}

