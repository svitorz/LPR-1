/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio04;

/**
 *
 * @author svitorz
 */
public class FuncionarioCTR {
    FuncionarioDAO dao = new FuncionarioDAO();
    public String mostrarFuncionario(FuncionarioDTO dto){
        return dao.mostrarFuncionario(dto);
    }
}
