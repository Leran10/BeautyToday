package model;

import android.widget.ImageButton;

/**
 * Created by qingzhi on 12/10/2017.
 */

public class ItemObject {

    private byte[] coatPh;

    private byte[] dressPh;
    private byte[] skirtPh;
    private byte[] trousersPh;
    private byte[] bootsPh;
    private byte[] bagPh;

    public ItemObject(byte[] coatPh,byte[] dressPh,byte[] skirtPh,byte[] trousersPh,byte[] bootsPh,byte[] bagPh) {
        this.coatPh = coatPh;
        this.dressPh = dressPh;
        this.skirtPh = skirtPh;
        this.trousersPh = trousersPh;
        this.bootsPh = bootsPh;
        this.bagPh = bagPh;
    }

    public byte[] getCoatPh() {
        return coatPh;
    }

    public void setCoatPh(byte[] coatPh) {
        this.coatPh = coatPh;
    }

    public byte[] getSkirtPh() {
        return skirtPh;
    }

    public void setSkirtPh(byte[] skirtPh) {
        this.skirtPh = skirtPh;
    }

    public byte[] getTrousersPh() {
        return trousersPh;
    }

    public void setTrousersPh(byte[] trousersPh) {
        this.trousersPh = trousersPh;
    }

    public byte[] getDressPh() {
        return dressPh;
    }

    public void setDressPh(byte[] dressPh) {
        this.dressPh = dressPh;
    }

    public byte[] getBootsPh() {
        return bootsPh;
    }

    public void setBootsPh(byte[] bootsPh) {
        this.bootsPh = bootsPh;
    }

    public byte[] getBagPh() {
        return bagPh;
    }

    public void setBagPh(byte[] bagPh) {
        this.bagPh = bagPh;
    }

    public int getPhotoById() {
        return 0;
    }
}
