package com.example.demo.utils;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
				String line = myReader.nextLine();
				funcionarios.add(getFuncionario(line));
			}
			myReader.close();
		} catch (Exception e) {
			throw new Exception("Exception message");
		}
		return funcionarios;
	}

	public List<FuncionarioDTO> setListaFuncionarios(FuncionarioDTO funcionario) throws Exception {
		String linhaAntiga = "";
		String novaLinha = getNovaLinha(funcionario);
		try {
			Scanner sc = new Scanner(new File(path));
			StringBuffer buffer = new StringBuffer();
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				buffer.append(line + System.lineSeparator());
				if (line.contains(funcionario.getCpf())) {
					linhaAntiga = line;
				}
			}
			String fileContents = buffer.toString();
			sc.close();
			fileContents = fileContents.replaceAll(linhaAntiga, novaLinha);
			@SuppressWarnings("resource")
			FileWriter writer = new FileWriter(path);
			writer.append(fileContents);
			writer.flush();

		} catch (Exception e) {
			throw new Exception("Exception message");
		}
		List<FuncionarioDTO> funcionarios = getListaFuncionarios();
		return funcionarios;
	}

	private String getNovaLinha(FuncionarioDTO funcionario) {
		String novaLinha = funcionario.getDataCadastro() + ";" + funcionario.getCargo() + ";" + funcionario.getCpf()
				+ ";" + funcionario.getNome() + ";"+funcionario.getUfNascimento() +";"+funcionario.getSalario() +";"+funcionario.getStatus();
		return novaLinha;
	}

	public List<FuncionarioDTO> deleteListaFuncionarios(FuncionarioDTO funcionario) throws Exception {
		funcionario.setStatus("INATIVO");
		return setListaFuncionarios(funcionario);
	}

	public List<FuncionarioDTO> getFuncionariosByParam(FuncionarioDTO funcionarioParam) throws Exception {
		List<FuncionarioDTO> funcionarios = new ArrayList<FuncionarioDTO>();
		try {
			Scanner myReader = new Scanner(new File(path));
			myReader.nextLine();
			while (myReader.hasNextLine()) {
				myReader.nextLine();
				String line = myReader.nextLine();
				if(line.contains(funcionarioParam.getCargo())) {
					funcionarios.add(getFuncionario(line));
				}else if(line.contains(funcionarioParam.getDataCadastro())) {
					funcionarios.add(getFuncionario(line));
				}else if(line.contains(funcionarioParam.getCpf())) {
					funcionarios.add(getFuncionario(line));
				}else if(line.contains(funcionarioParam.getNome())) {
					funcionarios.add(getFuncionario(line));
				}else if(line.contains(funcionarioParam.getUfNascimento())) {
					funcionarios.add(getFuncionario(line));
				}else if(line.contains(funcionarioParam.getSalario().toString())) {
					funcionarios.add(getFuncionario(line));
				}else if(line.contains(funcionarioParam.getStatus())) {
					funcionarios.add(getFuncionario(line));
				}
			}
			myReader.close();
		} catch (Exception e) {
			throw new Exception("Exception message");
		}
		return funcionarios;
	}

	private FuncionarioDTO getFuncionario(String line) {
		String[] data = line.split(";");
		FuncionarioDTO funcionario = new FuncionarioDTO();
		funcionario.setDataCadastro(data[0]);
		funcionario.setCargo(data[1]);
		funcionario.setCpf(data[2]);
		funcionario.setNome(data[3]);
		funcionario.setUfNascimento(data[4]);
		funcionario.setSalario(new BigDecimal(data[5]));
		funcionario.setStatus(data[6]);
		return funcionario;
	}

}
