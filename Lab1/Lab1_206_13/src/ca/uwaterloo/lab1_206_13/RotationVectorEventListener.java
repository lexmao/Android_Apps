package ca.uwaterloo.lab1_206_13;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

public class RotationVectorEventListener implements SensorEventListener {

	TextView output;
	float[] record = new float[3];
	
	public RotationVectorEventListener (TextView outputView){
		output = outputView;
	}
	
	@Override
	public void onSensorChanged(SensorEvent event) {
		if(event.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR) {
			max(event.values);
			output.setText(String.format("Rotation vector on x, y, z axis:\n(%,5.2f, %,5.2f, %,5.2f) "
					+ "\nMaximum record value:\n(%,6.2f, %,6.2f, %,6.2f)\n\n", 
					event.values[0], event.values[1], event.values[2], record[0], record[1], record[2]));
		}
	
		
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub

	}

	private void max(float[] current){
		if (record[0]*record[0] + record[1]*record[1] + record[2]*record[2] < 
				current[0]*current[0] + current[1]*current[1] + current[2]*current[2]){
			record[0] = current[0];
			record[1] = current[1];
			record[2] = current[2];
		}
	}

}