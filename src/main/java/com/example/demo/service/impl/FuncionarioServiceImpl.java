package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.FuncionarioDTO;
import com.example.demo.service.FuncionarioService;
import com.example.demo.utils.Utils;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
	
	@Override
	public List<FuncionarioDTO> getAll() throws Exception {
		List<FuncionarioDTO> funcionarios = Utils.getListaFuncionarios();
		return funcionarios;
	}

	@Override
	public List<FuncionarioDTO> setFuncionario(FuncionarioDTO funcionario) throws Exception {
		List<FuncionarioDTO> funcionarios = Utils.setListaFuncionarios();
		return funcionarios;
	}

	@Override
	public List<FuncionarioDTO> deleteFuncionario(FuncionarioDTO funcionario) throws Exception {
		List<FuncionarioDTO> funcionarios = Utils.deleteListaFuncionarios();
		return funcionarios;
	}
	
}
