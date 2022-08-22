package br.com.uniamerica.handleapi.entity;

import br.com.uniamerica.handleapi.service.FuncionarioService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FuncionarioTest {

    //** Teste de nome do Funcionario **//
    @Test
    public void isNomeNotNull() {
        Funcionario funcionario = new Funcionario();
        FuncionarioService funcionarioService = new FuncionarioService();

        funcionario.setNome("ass");
        assertTrue(funcionarioService.isNomeNotNull(funcionario));
    }

    @Test
    public void isNomeCaracter() {
        Funcionario funcionario = new Funcionario();
        FuncionarioService funcionarioService = new FuncionarioService();

        funcionario.setNome("sdad");
        assertTrue(funcionarioService.isNomeCaracter(funcionario));
    }
    //****//

    //** Teste de telefone do Funcionario **//
    @Test
    public void isTelefoneMaior(){
        Funcionario funcionario = new Funcionario();
        FuncionarioService funcionarioService = new FuncionarioService();

        funcionario.setTelefone("12345678912");
        assertTrue(funcionarioService.isTelefoneMenor(funcionario));
    }

    @Test
    public void isTelefoneNotNull(){
        Funcionario funcionario = new Funcionario();
        FuncionarioService funcionarioService = new FuncionarioService();

        funcionario.setTelefone("SDA");
        assertTrue(funcionarioService.isTelefoneNotNull(funcionario));
    }

    @Test
    public void isTelefoneCaracter() {
        Funcionario funcionario = new Funcionario();
        FuncionarioService funcionarioService = new FuncionarioService();

        funcionario.setTelefone("sad");
        assertTrue(funcionarioService.isTelefoneCaracter(funcionario));
    }

    @Test
    public void isTelefoneNumber() {
        Funcionario funcionario = new Funcionario();
        FuncionarioService funcionarioService = new FuncionarioService();

        funcionario.setTelefone("222");
        assertTrue(funcionarioService.isTelefoneNumber(funcionario));
    }
    //****//

    //** Teste de salario do Funcionario **//

    @Test
    public void isSalarioNotNull(){
        Funcionario funcionario = new Funcionario();
        FuncionarioService funcionarioService = new FuncionarioService();

        funcionario.setTelefone("SDA");
        assertTrue(funcionarioService.isSalarioNotNull(funcionario));
    }

    @Test
    public void isSalarioCaracter() {
        Funcionario funcionario = new Funcionario();
        FuncionarioService funcionarioService = new FuncionarioService();

        funcionario.setTelefone("sad");
        assertTrue(funcionarioService.isSalarioCaracter(funcionario));
    }

    @Test
    public void isSalarioNegativo() {
        Funcionario funcionario = new Funcionario();
        FuncionarioService funcionarioService = new FuncionarioService();

        funcionario.setSalario(2333.0);
        assertTrue(funcionarioService.isSalarioNegativo(funcionario));
    }

    //** Teste de CPF do Funcionario **//

    //Testa se CPF nao e null
    @Test
    public void isCpfNotNull() {
        Funcionario funcionario = new Funcionario();
        FuncionarioService funcionarioService = new FuncionarioService();

        funcionario.setCpf("as");
        assertTrue(funcionarioService.isCpfNotNull(funcionario));
    }

    //****//

    //Testa se CPF tem 11 caracter especial
    @Test
    public void isCpfMenor() {
        Funcionario funcionario = new Funcionario();
        FuncionarioService funcionarioService = new FuncionarioService();

        funcionario.setCpf("12349567892");
        assertTrue(funcionarioService.isCpfMenor(funcionario));
    }

    //Testa se CPF tem caracter especial
    @Test
    public void isCpfCaracter() {
        Funcionario funcionario = new Funcionario();
        FuncionarioService funcionarioService = new FuncionarioService();

        funcionario.setCpf("222222222222!");
        assertTrue(funcionarioService.isCpfCaracter(funcionario));
    }

    //** Teste de dataDeAdmissao **//

   /* @Test
    public void isDataAdmissaoNotNull() {
        Funcionario funcionario = new Funcionario();
        FuncionarioService funcionarioService = new FuncionarioService();

        funcionario.setDataAdmissao("");
        assertTrue(funcionarioService.isDataAdmissaoNotNull(funcionario));
    }*/

    @Test
    public void isDataMaior() {
        Funcionario funcionario = new Funcionario();
        FuncionarioService funcionarioService = new FuncionarioService();

        funcionario.setDataAdmissao(LocalDate.now().plusDays(5));
        assertTrue(funcionarioService.isDataMaior(funcionario));
    }


    @Test
    public void finalDeSemana() {
        Funcionario funcionario = new Funcionario();
        FuncionarioService funcionarioService = new FuncionarioService();

        funcionario.setDataAdmissao(LocalDate.now().plusDays(4));
        assertTrue(funcionarioService.finalDeSemana(funcionario));
    }








}
