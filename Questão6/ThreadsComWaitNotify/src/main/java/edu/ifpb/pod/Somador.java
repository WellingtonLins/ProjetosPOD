package edu.ifpb.pod;

/**
 * @Date 02/10/2016
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
public class Somador {

    private boolean flag;
    private int x;
    private int y;

    public Somador() {
        this.flag = true;
        this.x = 0;
        this.y = 0;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public synchronized int getX() {
        while (flag == false) {
            try {

                wait();
            } catch (InterruptedException e) {
            }
        }
        this.flag = false;
        notifyAll();
        return x;
    }

    public synchronized void setX(int x) {
        while (flag == true) {
     
        this.x = x;
        this.flag = true;

        notifyAll();

        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public synchronized void sum() {

        while (this.flag == true) {

            this.flag = false;

            setX(getY() + 1);
            setY(getX() + 1);

            this.flag = true;

        }
    }
}