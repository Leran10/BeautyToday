package model;

/**
 * Created by qingzhi on 12/9/2017.
 */

public class bag {

    private int id;
    private String color;
    private String pattern;
    private String material;
    private String style;
    private String size;
    private byte[] image;



    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public String getPattern(){
        return pattern;
    }
    public void setPattern(String pattern){
        this.pattern = pattern;
    }
    public String getMaterial(){
        return material;
    }
    public void setMaterial(String material){
        this.material = material;
    }
    public String getStyle(){
        return style;
    }
    public void setStyle(String style){
        this.style = style;
    }
    public String getSize(){
        return size;
    }
    public void setSize(String style){
        this.size = size;
    }
    public byte[] getImage(){ return image;}
    public void setImage(byte[] image){this.image = image;}
}

