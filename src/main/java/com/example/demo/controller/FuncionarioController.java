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

@RestController(value="api/funcionario/")
public class FuncionarioController {

	@Autowired
	private FuncionarioService service;

	@GetMapping(value="getAll", produces="application/json")
	public List<FuncionarioDTO> consultaFuncionario() throws Exception {
		try {
			List<FuncionarioDTO> funcionarios = service.getAll();
			return funcionarios;
		} catch (Exception e) {
			throw new Exception("Exception message: ", e);
		}
	}
	
	@GetMapping(value="getByParam",produces="application/json")
	public List<FuncionarioDTO> consultaFuncionario(@RequestParam FuncionarioDTO funcionario) throws Exception {
		try {
			List<FuncionarioDTO> funcionarios = service.getByParam(funcionario);
			return funcionarios;
		} catch (Exception e) {
			throw new Exception("Exception message: ", e);
		}
	}

	@PostMapping(value="save", produces="application/json")
	public List<FuncionarioDTO> incluirAlterarFuncionario(@RequestParam FuncionarioDTO funcionario) throws Exception {
		try {
			List<FuncionarioDTO> funcionarios = service.setFuncionario(funcionario);
			return funcionarios;
		} catch (Exception e) {
			throw new Exception("Exception message: ", e);
		}
	}

	@DeleteMapping(value="delete", produces="application/json")
	public List<FuncionarioDTO> excluirFuncionario(@RequestParam FuncionarioDTO funcionario) throws Exception {
		try {
			List<FuncionarioDTO> funcionarios = service.deleteFuncionario(funcionario);
			return funcionarios;
		} catch (Exception e) {
			throw new Exception("Exception message: ", e);
		}
	}

}
