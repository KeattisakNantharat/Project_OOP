package application;

import java.io.IOException;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Controller {
	//หน้าล็อกอิน
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private Parent root;
	@FXML
	private Label login;
	@FXML
	private Label UsernameText;
	@FXML
	private Label PasswordText;
	@FXML
	private TextField UsernameField;
	@FXML
	private PasswordField PasswordField;
	
	//หน้ายูเซอร์1
	@FXML
	private ImageView myImage;
	@FXML
	private TextField UserScene1;
	@FXML
	private TextField UserScene2;
	@FXML
	private TextField UserScene3;
	
	
	
	
	
	
	//ปุ้มกลับไปยังหน้าล๊อกอิน
	@FXML
	public void nextLogin(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("loginScene.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
	//ปุ่มล๊อคอินไปยังหน้าUserหรือAdmin
	@FXML
	public void next(ActionEvent e) throws IOException {
		try{
			String username = UsernameField.getText();
			String password = PasswordField.getText();

		if ( username.equals("User") && password.equals("123")){
			Parent root = FXMLLoader.load(getClass().getResource("UserScene1.fxml"));
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}else if (username.equals("Admin") && password.equals("987")){
			Parent root = FXMLLoader.load(getClass().getResource("AdminScene1.fxml"));
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}catch(Exception E) {
		System.out.println(E);
	}
		
	}
	
	
	
	//ปุ่มกดอัพโหลดรูป
	@FXML
	public void buttonUpload(ActionEvent e) {
		Stage primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		 FileChooser fileChooser = new FileChooser();
		 fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"));
		 File selectedFile = fileChooser.showOpenDialog(primaryStage);
         
		 if (selectedFile != null) {
             try {
                 // คัดลอกไฟล์รูปภาพไปยังโฟลเดอร์ที่ต้องการ
                 File destinationFile = new File("C:\\Users\\tharat\\eclipse-workspace\\Project_Oop\\src\\application\\" + selectedFile.getName());  // กำหนดที่อยู่ในการบันทึกไฟล์
                 copyFile(selectedFile, destinationFile);
                 
                 // โหลดและแสดงรูปที่อัพโหลด
                 Image image = new Image(new FileInputStream(destinationFile));
                 myImage.setImage(image);
             } catch (IOException ex) {
                 ex.printStackTrace();
             }
	 }
	}
    private void copyFile(File source, File destination) throws IOException {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
        }
    }
    
    
    //ปุ่มกดส่งข้อมูลหน้ายูเซอร์1
}

