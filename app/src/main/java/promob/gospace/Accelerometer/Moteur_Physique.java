package promob.gospace.Accelerometer;

import android.app.Service;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import java.util.ArrayList;
import java.util.List;

class Moteur_Physique {

    private Fusee fusee = null;

    public void setFusee(Fusee fusee) {
        this.fusee = fusee;
        this.fusee.reset();
    }

    // Les planetes
    private List<Planete> planetes = null;

    private Main_Activity_Accelerometer mActivity = null;

    private SensorManager mManager = null;
    private Sensor mAccelerometre = null;

    SensorEventListener mSensorEventListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent pEvent) {
            float x = pEvent.values[0];
            float y = pEvent.values[1];

            //Log.i("DEBUG", x + "/////" + y);

            if (fusee != null) {
                // On met à jour les coordonnées de la fusee
                fusee.putXAndY(x, y);

                // Pour toutes les planetes
                for (Planete planete : planetes) {

                    float milieuX = (fusee.getX() + fusee.getX() + fusee.getFusee_largeur())/2;
                    float milieuY = (fusee.getY() + fusee.getY() +  fusee.getFusee_hauteur())/2;

                    //Log.i(planete.getStringType(),  String.valueOf(planete.getCoordX()) + " < " + milieuX + " < " + String.valueOf(planete.getCoordX()+ planete.getTailleX()));
                    //Log.i(planete.getStringType(),  String.valueOf(planete.getCoordY()) + " < " + milieuY + " < " + String.valueOf(planete.getCoordY() + planete.getTailleY()));


                    if(  (planete.getCoordX() < milieuX) && (planete.getCoordX() + planete.getTailleX() > milieuX)
                            && (planete.getCoordY() < milieuY) && (planete.getCoordY() + planete.getTailleY() > milieuY) ){

                        // On agit différement en fonction du type de planete
                        switch (planete.getType()) {
                            case METEORITE:
                                mActivity.showDialog(Main_Activity_Accelerometer.DEFEAT_DIALOG);
                                break;

                            case LUNE:
                                mActivity.showDialog(Main_Activity_Accelerometer.VICTORY_DIALOG);
                                break;
                        }
                        break;

                    }

                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor pSensor, int pAccuracy) {

        }
    };

    public Moteur_Physique(Main_Activity_Accelerometer pView) {
        mActivity = pView;
        mManager = (SensorManager) mActivity.getBaseContext().getSystemService(Service.SENSOR_SERVICE);
        mAccelerometre = mManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    // Remet à zéro l'emplacement de la fusee
    public void reset() {
        fusee.reset();

        for (Planete planete : planetes) {

            planete.reset();

        }

    }

    // Arrête le capteur
    public void stop() {
        mManager.unregisterListener(mSensorEventListener, mAccelerometre);
    }

    // Redémarre le capteur
    public void resume() {
        mManager.registerListener(mSensorEventListener, mAccelerometre, SensorManager.SENSOR_DELAY_GAME);
    }

    // Construit le jeu
    public List<Planete> create_game() {

        planetes = new ArrayList<>();

        planetes.add(new Planete(Planete.Type.METEORITE));
        planetes.add(new Planete(Planete.Type.METEORITE));
        planetes.add(new Planete(Planete.Type.METEORITE));
        planetes.add(new Planete(Planete.Type.METEORITE));





        planetes.add(new Planete(Planete.Type.LUNE));
        planetes.add(new Planete(Planete.Type.TERRE));

        return planetes;
    }

}