package EX;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatExample {
//날짜를 원하는 형식으로 출력
	public static void main(String[] args) {
		Date no = new Date();
		
		SimpleDateFormat sd = new SimpleDateFormat("aHH:mm\nyyyy년 MM월 dd일 \n 오늘은E요일 \n 올해의 D번재날");
		System.out.println(sd.format(no));
		
		
		String message = "회원ID : {0} \n회원이름 : {1}\n회원전화 : {2}";
//		String result = MessageFormat.format(message, id, name, tel);
	}
}
