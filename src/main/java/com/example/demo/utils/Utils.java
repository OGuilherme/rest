package com.example.demo.utils;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.example.demo.dto.FuncionarioDTO;

@Component
public class Utils {
	
	public static List<FuncionarioDTO> getListaFuncionarios() throws Exception {
		String path = "C:\\Users\\olive\\Desktop\\bd.txt";
		List<FuncionarioDTO> funcionarios = new ArrayList<FuncionarioDTO>();
		try {
			File myObj = new File(path);
			Scanner myReader = new Scanner(myObj);
			myReader.nextLine();
			while (myReader.hasNextLine()) {
				myReader.nextLine();
				String[] data = myReader.nextLine().split(";");
				FuncionarioDTO funcionario = new FuncionarioDTO();
				funcionario.setDataCadastro(data[0]);
				funcionario.setCargo(data[1]);
				funcionario.setCpf(data[2]);
				funcionario.setNome(data[3]);
				funcionario.setUfNascimento(data[4]);
				funcionario.setSalario(new BigDecimal(data[5]));
				funcionario.setStatus(data[6]);
				funcionarios.add(funcionario);
			}
			myReader.close();
		} catch (Exception e) {
			throw new Exception("Exception message");
		}
		return funcionarios;
	}

	public static List<FuncionarioDTO> setListaFuncionarios() {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<FuncionarioDTO> deleteListaFuncionarios() {
		// TODO Auto-generated method stub
		return null;
	}

}
