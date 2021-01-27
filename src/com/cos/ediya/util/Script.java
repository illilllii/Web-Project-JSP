package com.cos.ediya.util;

<<<<<<< HEAD
=======
import java.io.IOException;
>>>>>>> 6a4435463485f1f8955206b6a8396867ca00b163
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Script {
<<<<<<< HEAD
	public static void responseData(HttpServletResponse response, String jsonData) {
=======
	
public static void responseData(HttpServletResponse response, String jsonData) {
		
>>>>>>> 6a4435463485f1f8955206b6a8396867ca00b163
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(jsonData);
			out.flush(); // 버퍼 비우기
<<<<<<< HEAD
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
=======
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
>>>>>>> 6a4435463485f1f8955206b6a8396867ca00b163
	public static void back(HttpServletResponse response, String msg) {
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("<script>");
<<<<<<< HEAD
			out.println("alert('"+ msg +"');");
			out.println("history.back();");
			out.println("</script>");
			out.flush(); // 버퍼 비우기
		} catch(Exception e) {
			e.printStackTrace();
			
=======
			out.println("alert('" + msg + "');");
			out.println("history.back();"); // window가 가지고 있다.
			out.println("</script>");
			out.flush(); // 버퍼 비우기
		} catch (Exception e) {
			e.printStackTrace();
>>>>>>> 6a4435463485f1f8955206b6a8396867ca00b163
		}
	}
}
