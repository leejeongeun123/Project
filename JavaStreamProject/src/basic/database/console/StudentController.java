package basic.database.console;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StudentController implements Initializable {
	Connection conn = ConnectionDB.getDB();
	@FXML TableView<Student> tableView;
	//loginBtn=로그인 버튼
	@FXML Button pepleAdd, loginBtn;
	@FXML TextField txtId;
	@FXML PasswordField txtPwd;
	
	ObservableList<Student> list;
	ObservableList<Student> mlist;
	Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		list = FXCollections.observableArrayList();
		mlist = FXCollections.observableArrayList();
		//회원가입 버튼(pepleAdd) 눌렀을 경우 이벤트 정의
		
		
		//아이디,비번 입력후 로그인 버튼 눌렀을 경우 이벤트 정의
		loginBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				mlist = getMemberList();
				
				for(int i=0; i<mlist.size(); i++) {//start for1
					if(mlist.get(i).getId().equals(txtId.getText()) && mlist.get(i).getPassword().equals(txtPwd.getText())) {//start if1
						System.out.println("접속되었습니다.");
						Stage stage = new Stage(StageStyle.UTILITY);
						stage.initModality(Modality.WINDOW_MODAL);
						stage.initOwner(primaryStage);
						try {
							Parent parent= FXMLLoader.load(getClass().getResource("list.fxml"));
							Scene s = new Scene(parent);
							stage.setScene(s);
							stage.show();
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}	//end if1		
				}//end for1
			
				
		 }
			
		});
	
	
		
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
	}//end init
	
	//회원 테이블 조회
	private ObservableList<Student> getMemberList() {
		String sql = "select * "
				+ "\n"+"from dongschool";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Student stu = new Student(rs.getString("id"), 
										  rs.getString("password"),
										  rs.getString("name"),
										  rs.getString("phone"),
										  rs.getString("email"));
			
				list.add(stu);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}	
	
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
	
	
		
	
}
