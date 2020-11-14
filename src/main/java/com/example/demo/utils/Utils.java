package com.example.demo.utils;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import com.example.demo.DemoApplication;
import com.example.demo.dto.FuncionarioDTO;

@Component
public class Utils {

	@Value("${pathFuncionario}")
	private String path;

	public List<FuncionarioDTO> getListaFuncionarios() throws Exception {
		List<FuncionarioDTO> funcionarios = new ArrayList<FuncionarioDTO>();
		try {
			Scanner myReader = new Scanner(new File(path));
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
	
	public static void main(String[] args) throws Exception {
		setListaFuncionarios(new FuncionarioDTO());
	}

	public static List<FuncionarioDTO> setListaFuncionarios(FuncionarioDTO funcionario) throws Exception {
		String path = "C:\\Users\\olive\\Desktop\\bd.txt";
		try {
			Scanner sc = new Scanner(new File(path));
			StringBuffer buffer = new StringBuffer();
			while (sc.hasNextLine()) {
				buffer.append(sc.nextLine() + System.lineSeparator());
				System.out.println(buffer);
				
			}
			String fileContents = buffer.toString();
			sc.close();
			String oldLine = "15/04/2017;Dev Jr;85235708709;Aaron Aaberg;AP;8965.30;ATIVO";
			String newLine = "15/04/2017;Dev Jr;85235708709;Aaron Aaberg;AP;8965.30;INATIVO";
			fileContents = fileContents.replaceAll(oldLine, newLine);
			FileWriter writer = new FileWriter(path);
			writer.append(fileContents);
			writer.flush();

		} catch (Exception e) {
			throw new Exception("Exception message");
		}
		List<FuncionarioDTO> funcionarios = null;
		return funcionarios;
	}

	public List<FuncionarioDTO> deleteListaFuncionarios(FuncionarioDTO funcionario) throws Exception {
		try {
			Scanner sc = new Scanner(new File(path));
			StringBuffer buffer = new StringBuffer();
			while (sc.hasNextLine()) {
				buffer.append(sc.nextLine() + System.lineSeparator());
			}
			String fileContents = buffer.toString();
			System.out.println("Contents of the file: " + fileContents);
			sc.close();
			String oldLine = "No preconditions and no impediments. Simply Easy Learning!";
			String newLine = "Enjoy the free content";
			fileContents = fileContents.replaceAll(oldLine, newLine);
			FileWriter writer = new FileWriter(path);
			System.out.println("");
			System.out.println("new data: " + fileContents);
			writer.append(fileContents);
			writer.flush();

		} catch (Exception e) {
			throw new Exception("Exception message");
		}
		List<FuncionarioDTO> funcionarios = getListaFuncionarios();
		return funcionarios;
	}

}
