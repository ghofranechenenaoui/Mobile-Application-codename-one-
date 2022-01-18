/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.codename1.components.ImageViewer;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import entity.Enumerations;
import entity.Photo;
import com.semicolon.javavichuploaderapi.Uploader;
import com.mycompany.myapp.MyApplication;
import static com.mycompany.myapp.MyApplication.theme;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Elyes
 */
public class PhotoService {
    private Photo photo;
    private List<Photo> photos;
    private static PhotoService instance;
    
    public static PhotoService getInstance(){
        if (instance == null)
            instance = new PhotoService();
        return instance;
    }
    private PhotoService(){}
    
    public Photo getPhoto(int photoId){
        ConnectionRequest con = new ConnectionRequest();
        String url = "http://localhost/project2/web/app_dev.php/portfolio/getPhoto/"+photoId;
        con.setUrl(url);
        con.addResponseListener((e) -> {
            try {
                String str = new String(con.getResponseData());
                JSONParser j = new JSONParser();
                
                Map<String, Object> photoMap = j.parseJSON(new CharArrayReader(str.toCharArray()));
                if(photoMap.isEmpty()){
                    photo = null;
                }else{
                    photo = parsePhoto(photoMap);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return photo;
    }
    
    public List<Photo> getRegularPhotos(int userId){
        ConnectionRequest con = new ConnectionRequest();
        String url = "http://localhost/project2/web/app_dev.php/portfolio/getPhotos/"+userId;
        con.setUrl(url);
        con.addResponseListener((e) -> {
            try {
                String str = new String(con.getResponseData());
                photos = new ArrayList<>();
                JSONParser j = new JSONParser();
                
                Map<String, Object> likeMap = j.parseJSON(new CharArrayReader(str.toCharArray()));
                List<Map<String, Object>> likeList = (List<Map<String, Object>>) likeMap.get("root");
                if(likeList != null){
                    for(Map<String, Object> map : likeList){
                        photos.add(parsePhoto(map));
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return photos;
    }
    
    public Photo getProfilePhoto(int userId){
        ConnectionRequest con = new ConnectionRequest();
        String url = "http://localhost/project2/web/app_dev.php/portfolio/getProfilePhoto/"+userId;
        con.setUrl(url);
        con.addResponseListener((e) -> {
            try {
                String str = new String(con.getResponseData());
                JSONParser j = new JSONParser();
                Map<String, Object> photoMap = j.parseJSON(new CharArrayReader(str.toCharArray()));
                
                if(photoMap.isEmpty()){
                    photo = null;
                }else{
                    photo = parsePhoto(photoMap);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
       
        NetworkManager.getInstance().addToQueueAndWait(con);
        return photo;
    }
    
    public Photo getCoverPhoto(int userId){
        ConnectionRequest con = new ConnectionRequest();
        String url = "http://localhost/project2/web/app_dev.php/portfolio/getCoverPhoto/"+userId;
        con.setUrl(url);
        con.addResponseListener((e) -> {
            try {
                String str = new String(con.getResponseData());
                JSONParser j = new JSONParser();
                Map<String, Object> photoMap = j.parseJSON(new CharArrayReader(str.toCharArray()));
                
                if(photoMap.isEmpty()){
                    photo = null;
                }else{
                    photo = parsePhoto(photoMap);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
/*        con.addExceptionListener((e) -> {
            photo = null;
        });*/
        NetworkManager.getInstance().addToQueueAndWait(con);
        return photo;
    }
    
    public Photo addPhoto(String filePath){
        try {
            Photo p = new Photo("BaseBundle", "imageFile", "http://localhost/project2/web/app_dev.php/portfolio/uploadPhoto", filePath, MyApplication.MemberId);
            Uploader.upload(p);
            p.setType(Enumerations.PhotoType.REGULAR);
            return p;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    private Photo parsePhoto(Map<String, Object> photoMap){
        Photo p = new Photo();
        p.setId(((Double)photoMap.get("id")).intValue());
        p.setPhotoUri((String)photoMap.get("image"));
        p.setUpdateDate(new Date((((Double)((Map<String, Object>)photoMap.get("date")).get("timestamp")).longValue()*1000)));
        p.setType(Enumerations.PhotoType.values()[((Double)photoMap.get("type")).intValue()]);
        p.setUserId(((Double)((Map<String, Object>)photoMap.get("user")).get("id")).intValue());
        return p;
    }
    
    public void deletePhoto(int photoId){
        ConnectionRequest con = new ConnectionRequest();
        String url = "http://localhost/project2/web/app_dev.php/portfolio/deletePhoto/"+photoId;
        con.setUrl(url);
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
    public void setAsProfilePhoto(int photoId){
        ConnectionRequest con = new ConnectionRequest();
        String url = "http://localhost/project2/web/app_dev.php/portfolio/setAsProfilePhoto/"+photoId;
        con.setUrl(url);
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
    public void setAsCoverPhoto(int photoId){
        ConnectionRequest con = new ConnectionRequest();
        String url = "http://localhost/project2/web/app_dev.php/portfolio/setAsCoverPhoto/"+photoId;
        con.setUrl(url);
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
    public ImageViewer EmakeImageViewer(String url){
        ImageViewer img = new ImageViewer();
        EncodedImage encodedImage = EncodedImage.createFromImage(theme.getImage("round.png"),false);
	URLImage uRLImage;
	uRLImage = URLImage.createToStorage(encodedImage, url.substring(20), "http://localhost" + url);
	uRLImage = URLImage.createToStorage(encodedImage, url.substring(20), "http://localhost" + url);
        img.setImage(uRLImage);
        return img;
    }
    
    public Label EmakeImageViewerBig(String url){
        EncodedImage encodedImage = EncodedImage.createFromImage(theme.getImage("loading_post.png"),false);
	URLImage uRLImage;
	uRLImage = URLImage.createToStorage(encodedImage, (new Random()).nextInt()+"", "http://localhost" + url);
	//uRLImage = URLImage.createToStorage(encodedImage, url.substring(20), "http://localhost" + url);
        Label img = new Label(uRLImage);
        return img;
    }
}
