package model;

/**
 * Created by qingzhi on 12/7/2017.
 */

public class coat {

    private int id;
    private String color;
    private String pattern;
    private String material;
    private String style;
    private String sleeves;
    private String length;


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
    public String getSleeves(){
        return sleeves;
    }
    public void setSleeves(String sleeves){
        this.sleeves = sleeves;
    }
    public String getLength(){
        return length;
    }
    public void setLength(String length){
        this.length = length;
    }
}
