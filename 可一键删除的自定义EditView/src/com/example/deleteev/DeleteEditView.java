package com.example.deleteev;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class DeleteEditView extends RelativeLayout {

	private EditText et;
	private ImageView iv_delete;

	public DeleteEditView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		LayoutInflater.from(context).inflate(R.layout.deleteeditview, this,true);
		
		et = (EditText) findViewById(R.id.et);
		iv_delete = (ImageView) findViewById(R.id.iv_delete);
		iv_delete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				et.setText("");
				
			}
		});
		et.addTextChangedListener(new TextWatcher() {

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				//当editview上有内容时,删除图标显示出来
				if(start+after != 0){
					iv_delete.setVisibility(View.VISIBLE);
				}else{
					iv_delete.setVisibility(View.INVISIBLE);
				}
				
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				
			}

			@Override
			public void afterTextChanged(Editable s) {
				
			}
			
		});
	}

	public DeleteEditView(Context context) {
		this(context, null);
	}
}
