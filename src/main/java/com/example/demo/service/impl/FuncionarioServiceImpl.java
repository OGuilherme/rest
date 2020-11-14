package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.FuncionarioDTO;
import com.example.demo.service.FuncionarioService;
import com.example.demo.utils.Utils;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
	
	@Autowired
	private Utils utils;
	
	@Override
	public List<FuncionarioDTO> getAll() throws Exception {
		List<FuncionarioDTO> funcionarios = utils.getListaFuncionarios();
		return funcionarios;
	}

	@Override
	public List<FuncionarioDTO> setFuncionario(FuncionarioDTO funcionario) throws Exception {
		List<FuncionarioDTO> funcionarios = utils.setListaFuncionarios(funcionario);
		return funcionarios;
	}

	@Override
	public List<FuncionarioDTO> deleteFuncionario(FuncionarioDTO funcionario) throws Exception {
		List<FuncionarioDTO> funcionarios = utils.deleteListaFuncionarios(funcionario);
		return funcionarios;
	}

	@Override
	public List<FuncionarioDTO> getByParam(FuncionarioDTO funcionario) throws Exception {
		List<FuncionarioDTO> funcionarios = utils.getFuncionariosByParam(funcionario);
		return funcionarios;
	}
	
}
