package entity;

import com.semicolon.entity.BasePhoto;


public class Photo extends BasePhoto{

    private Enumerations.PhotoType type;
    private int userId;
    
    public Photo(String bundlePath, String fileFieldName, String serviceUrl, String photoUri, int userId) {
        super(bundlePath, fileFieldName, serviceUrl, photoUri);
        this.userId = userId;
    }
    
    public Photo(){}
    
    public Photo(int userId){
        this.userId = userId;
    }

    public Enumerations.PhotoType getType() {
        return type;
    }

    public void setType(Enumerations.PhotoType type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return super.toString()+" Photo{" + "type=" + type + ", userId=" + userId + "}\n";
    }
    
}
