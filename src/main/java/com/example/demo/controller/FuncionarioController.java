package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FuncionarioDTO;
import com.example.demo.service.FuncionarioService;

@RestController("api/funcionario/")
public class FuncionarioController {

	@Autowired
	private FuncionarioService service;

	@GetMapping()
	public List<FuncionarioDTO> consultaFuncionario() throws Exception {
		try {
			List<FuncionarioDTO> funcionarios = service.getAll();
			return funcionarios;
		} catch (Exception e) {
			throw new Exception("Exception message: ", e);
		}
	}

	@PostMapping()
	public List<FuncionarioDTO> incluirAlterarFuncionario(@RequestParam FuncionarioDTO funcionario) throws Exception {
		try {
			List<FuncionarioDTO> funcionarios = service.setFuncionario(funcionario);
			return funcionarios;
		} catch (Exception e) {
			throw new Exception("Exception message: ", e);
		}
	}

	@DeleteMapping()
	public List<FuncionarioDTO> excluirFuncionario(@RequestParam FuncionarioDTO funcionario) throws Exception {
		try {
			List<FuncionarioDTO> funcionarios = service.deleteFuncionario(funcionario);
			return funcionarios;
		} catch (Exception e) {
			throw new Exception("Exception message: ", e);
		}
	}

}
