package com.android2ee.cours.tp2.gui3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class TP2CoursIHM4Activity extends Activity {
	/**
	 * The button chocolate
	 */
	Button btnChocolate;
	/**
	 * The button Hug
	 */
	Button btnHug;
	/**
	 * The Button Santa
	 */
	Button btnSanta;
	/**
	 * The checkBox Chocolate
	 */
	CheckBox chbChocoloate;
	/**
	 * The TextView
	 */
	TextView txtView;
	/**
	 * The SeekBar
	 */
	SeekBar seekBar;
	/**
	 * The string that describe the seekBar state
	 */
	String strSeekBarState;
	/**
	 * The string that describe the radioGroup state
	 */
	String strRadioGroupState;
	/**
	 * The string that describe the checkBox state
	 */
	String strCheckBoxState;

	/******************************************************************************************/
	/** Constructors **************************************************************************/
	/******************************************************************************************/

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// instanciate Components
		btnChocolate = (Button) findViewById(R.id.chocolate);
		btnHug = (Button) findViewById(R.id.hug);
		btnSanta = (Button) findViewById(R.id.santaclaus);
		chbChocoloate = (CheckBox) findViewById(R.id.checkchocolate);
		seekBar = (SeekBar) findViewById(R.id.seek);
		txtView = (TextView) findViewById(R.id.txvText);
		// mise en place des listeners sur les boutons
		btnChocolate.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				buttonUpdate(getString(R.string.chocolate));
			}
		});
		btnHug.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				buttonUpdate(getString(R.string.hug));
			}
		});
		btnSanta.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				buttonUpdate(getString(R.string.santaclaus));
			}
		});
		// mise en place du listener sur la checkBox
		chbChocoloate.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				checkBoxUpdate(isChecked);
			}
		});
		// mise en place du listener sur la seekbar
		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				// unused
				seekBarUpdate(progress);
			}

			public void onStartTrackingTouch(SeekBar seekBar) {
				// unused
			}

			public void onStopTrackingTouch(SeekBar seekBar) {
				// do something
				seekBar.getProgress();
			}
		});

	}

	/******************************************************************************************/
	/** Methods **************************************************************************/
	/******************************************************************************************/
	/**
	 * Update the string that describe the radioGroup state
	 * 
	 * @param ButtonName
	 */
	private void buttonUpdate(String ButtonName) {
		strRadioGroupState = String.format(getString(R.string.radiogroupstate), ButtonName);
		updateTextView();
	}

	/**
	 * Update the string that describe the checkBox state
	 * 
	 * @param isChecked
	 */
	private void checkBoxUpdate(Boolean isChecked) {
		strCheckBoxState = String.format(getString(R.string.checkboxstate), isChecked);
		updateTextView();
	}

	/**
	 * Update the string that describe the seekbar state
	 * 
	 * @param isChecked
	 */
	private void seekBarUpdate(Integer value) {

		strSeekBarState = String.format(getString(R.string.seekbarstate), value);
		updateTextView();
	}

	/**
	 * Update the textView
	 */
	private void updateTextView() {
		txtView.setText(strRadioGroupState + "\r\n" + strCheckBoxState + "\r\n" + strSeekBarState);
	}
}