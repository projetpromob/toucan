package promob.gospace.Accelerometer;

import android.app.Service;
import android.graphics.RectF;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

class Moteur_Physique {

    private String reponse;

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

    public Moteur_Physique(Main_Activity_Accelerometer pView, String rep) {
        mActivity = pView;
        mManager = (SensorManager) mActivity.getBaseContext().getSystemService(Service.SENSOR_SERVICE);
        mAccelerometre = mManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        reponse = rep;
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

        if(reponse.equals("facile")){

            planetes.add(new Planete(Planete.Type.METEORITE,0.3f));
            planetes.add(new Planete(Planete.Type.METEORITE,0.45f));
            planetes.add(new Planete(Planete.Type.METEORITE,0.6f));
            planetes.add(new Planete(Planete.Type.METEORITE,0.75f));



        }else if (reponse.equals("difficile")) {

            planetes.add(new Planete(Planete.Type.METEORITE,0.3f));
            planetes.add(new Planete(Planete.Type.METEORITE,0.45f));
            planetes.add(new Planete(Planete.Type.METEORITE,0.6f));
            planetes.add(new Planete(Planete.Type.METEORITE,0.75f));
            planetes.add(new Planete(Planete.Type.METEORITE,0.3f));
            planetes.add(new Planete(Planete.Type.METEORITE,0.45f));
            planetes.add(new Planete(Planete.Type.METEORITE,0.6f));
            planetes.add(new Planete(Planete.Type.METEORITE,0.75f));

        } else {

            planetes.add(new Planete(Planete.Type.METEORITE,0.3f));
            planetes.add(new Planete(Planete.Type.METEORITE,0.45f));
            planetes.add(new Planete(Planete.Type.METEORITE,0.6f));
            planetes.add(new Planete(Planete.Type.METEORITE,0.75f));
            planetes.add(new Planete(Planete.Type.METEORITE,0.3f));
            planetes.add(new Planete(Planete.Type.METEORITE,0.45f));
            planetes.add(new Planete(Planete.Type.METEORITE,0.6f));
            planetes.add(new Planete(Planete.Type.METEORITE,0.75f));
            planetes.add(new Planete(Planete.Type.METEORITE,0.4f));
            planetes.add(new Planete(Planete.Type.METEORITE,0.5f));
            planetes.add(new Planete(Planete.Type.METEORITE,0.8f));
            planetes.add(new Planete(Planete.Type.METEORITE,0.68f));
            planetes.add(new Planete(Planete.Type.METEORITE,0.2f));
            planetes.add(new Planete(Planete.Type.METEORITE,0.25f));
            planetes.add(new Planete(Planete.Type.METEORITE,0.23f));
            planetes.add(new Planete(Planete.Type.METEORITE,0.34f));

        }

        planetes.add(new Planete(Planete.Type.LUNE));
        planetes.add(new Planete(Planete.Type.TERRE));

        return planetes;
    }

}