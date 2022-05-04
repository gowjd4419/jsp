package kr.co.hf.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.ServerPreparedQueryTestcaseGenerator;

public interface IComService {
	void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
