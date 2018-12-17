package promob.gospace.Aventure_solo.Accelerometer;

public class Planete {
    enum  Type { LUNE, METEORITE, TERRE };

    private Type mType = null;

    private float coordX;
    private float coordY;

    private float tailleX;
    private float tailleY;

    private float randomx1 = (float) (Math.random()*(0.8f));
    private float randomy1;
    //private float randomy1 = (float) (Math.random()*0.5f)+0.2f;

    private void setRandomx1(){

        randomx1 = (float) (Math.random()*0.8f);

    }

    private void setRandomy1(){

        randomy1 = (float) (Math.random()*0.7f);

    }

    public float getRandomx1(){

        return randomx1;

    }

    public float getRandomy1(){

        return randomy1;

    }

    public void setCoordX(float x){
        coordX = x;
    }

    public float getCoordX(){
        return coordX;
    }

    public void setCoordY(float y){
        coordY = y;
    }

    public float getCoordY(){
        return coordY;
    }

    public void setTailleX(float x){
        tailleX = x;
    }

    public float getTailleX(){
        return tailleX;
    }

    public void setTailleY(float y){
        tailleY = y;
    }

    public float getTailleY(){
        return tailleY;
    }







    public Type getType() {
        return mType;
    }

    public String getStringType() {
        return mType.toString();
    }

    public void reset(){

        this.setRandomx1();

    }


    public Planete(Type pType, float y) {
        this.mType = pType;
        this.randomy1 = y;
    }

    public Planete(Type pType) {
        this.mType = pType;
    }
}
