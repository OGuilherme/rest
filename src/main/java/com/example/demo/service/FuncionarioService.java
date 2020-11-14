package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.FuncionarioDTO;

public interface FuncionarioService {
	
	public List<FuncionarioDTO> getAll() throws Exception;

	public List<FuncionarioDTO> setFuncionario(FuncionarioDTO funcionario) throws Exception;

	public List<FuncionarioDTO> deleteFuncionario(FuncionarioDTO funcionario) throws Exception;

}
