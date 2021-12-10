package baitap.moveablePoint;

public class MoveablePoint extends Point {
    private float xSpeed;
    private float ySpeed;

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint() {
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float x, float y) {
        this.xSpeed = x;
        this.ySpeed = y;
    }

    public float[] getSpeed() {
        float[] xy = new float[2];
        xy[0] = this.xSpeed;
        xy[1] = this.ySpeed;
        return xy;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Speed(x,y) = " + "(" +
                getxSpeed() + ", " +
                getySpeed() + ")";
    }

    public MoveablePoint move() {
        float x = super.getX();
        float y = super.getY();
        x += xSpeed;
        y += ySpeed;
        super.setX(x);
        super.setY(y);
        return this;
    }
}
