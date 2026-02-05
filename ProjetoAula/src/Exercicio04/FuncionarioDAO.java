/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio04;

/**
 *
 * @author svitorz
 */
public class FuncionarioDAO {
    public String mostrarFuncionario(FuncionarioDTO dto) {
        return "Os dados gravados são:\nNome: "+ dto.getNome() + 
                "\nLogradouro: " + dto.getLogradouro() +
                "\nBairro: " + dto.getBairro() +
                "\nCidade: " + dto.getCidade() +
                "\nEstado: " + dto.getEstado() +
                "\nCEP: " + dto.getCep() +
                "\nCPF: " +dto.getCpf() +
                "\nRG: " + dto.getRg() +
                "\nNumero:" + dto.getNum();
                        
    }
}
