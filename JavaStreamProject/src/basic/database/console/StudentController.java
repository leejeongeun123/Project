package basic.database.console;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StudentController implements Initializable {
	Connection conn = ConnectionDB.getDB();
	@FXML
	TableView<Student> tableView;
	@FXML
	Button pepleAdd, loginBtn;
	
	ObservableList<Student> list;
	ObservableList<login> list2;
	Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		list = FXCollections.observableArrayList();
		//회원가입 버튼(pepleAdd) 눌렀을 경우 이벤트 정의
		
		loginBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				//리스트하고 이정은이 해야될꺼 - Login();
			
				
		 }
		});
//		loginBtn.setOnAction(E->{
//			Stage st = new Stage(StageStyle.UTILITY);
//			st.initModality(Modality.WINDOW_MODAL);
//			st.initOwner(primaryStage);
//			
//			});
//			
	
		
		pepleAdd.setOnAction(event ->{
			Stage stage = new Stage(StageStyle.UTILITY);
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(primaryStage);
			
			try {
				Parent parent=FXMLLoader.load(getClass().getResource("peopleAdd.fxml")); //회원가입창
				Scene s = new Scene(parent);
				stage.setTitle("회원가입화면 ٩(･ิᴗ･ิ๑)۶ ");
				stage.setScene(s);
				stage.show();
				
				Button btnStudentAdd = (Button) parent.lookup("#btnStudentAdd");
				btnStudentAdd.setOnAction(new EventHandler<ActionEvent>() {//회원정보를 입력하고 가입하기 버튼을눌렀을때 이벤트에 대한 정의
					@Override
					public void handle(ActionEvent event) {
						TextField Id = (TextField) parent.lookup("#Id");
						PasswordField Pwd = (PasswordField) parent.lookup("#Pwd");
						TextField Name = (TextField) parent.lookup("#Name");
						TextField Phone = (TextField) parent.lookup("#Phone");
						TextField Email = (TextField) parent.lookup("#Email");
						
						Student stu = new Student(Id.getText(), 
								Pwd.getText(), 
								Name.getText(), 
								Phone.getText(), 
								Email.getText());
						
						list.add(stu);
						insertStudent(stu);
						
						stage.close();
					}
				});
				
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}			
		});  //end 회원가입
			
//		Popup popup = new Popup();
//		Parent parent = FXMLLoader.load(getClass().getResource("popup.fxml"));
//		 HBox root = loader.load();
//		ImageView imageview = (ImageView) parent.lookup("#imgMessage");
//		imageview.setImage(new Image(getClass().getResource(null).
				
		
		
	}//end init
		
	
	public void insertStudent(Student stu) {
		String sql = "insert into DONGSCHOOL values(?,?,?,?,?)";
			System.out.println(sql);
		
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, stu.getId());
			psmt.setString(2, stu.getPassword());
			psmt.setString(3, stu.getName());
			psmt.setString(4, stu.getPhone());
			psmt.setString(5, stu.getEmail());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void Login(Student stu) throws Exception{
		if(stu.getId().equals("id") && stu.getPassword().equals("password")) {
			loginBtn.setText("Login success");
			Stage primaryStage = new Stage();
			Parent login = FXMLLoader.load(getClass().getResource("login.fxml"));
			Scene scene = new Scene(login);
			primaryStage.setScene(scene);
			primaryStage.show();
		
		}
//		} else {
//			setText("Login Failed");
//		}
	}
		
	
}
